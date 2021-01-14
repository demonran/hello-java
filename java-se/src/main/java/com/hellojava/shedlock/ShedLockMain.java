package com.hellojava.shedlock;

import com.hellojava.shedlock.redislock.RedisLock;
import com.hellojava.shedlock.redislock.RedisTemplateLock;
import net.javacrumbs.shedlock.core.LockConfiguration;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SimpleLock;
import net.javacrumbs.shedlock.provider.redis.jedis.JedisLockProvider;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPool;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class ShedLockMain {

    public static void main(String[] args) throws InterruptedException {

//        redisLock();
//        redisLockThreadPool();
        redisTemplateLock();
//        shedLock();

    }

    private static void redisLock() throws InterruptedException {
        JedisPool pool = new JedisPool();
        Lock lock = new RedisLock(pool, "ShedLockMain");
        CountDownLatch countDownLatch = new CountDownLatch(100);
        IntStream.range(0,100).forEach(index -> new Thread(() -> {
            lock.lock();
            try {
                System.err.println(Thread.currentThread().getName() + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                System.out.println("unlock + " + Thread.currentThread().getName() + LocalTime.now());
                lock.unlock();
                countDownLatch.countDown();
            }

        }).start());

        countDownLatch.await();
    }

    private static void redisTemplateLock() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        StringRedisTemplate redisTemplate = new StringRedisTemplate(connectionFactory);

        Lock lock = new RedisTemplateLock(redisTemplate, "ShedLockMainThreadPool", Duration.ofSeconds(60));
        ExecutorService executorService = new ThreadPoolExecutor(10,
                10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        while (true) {
            executorService.execute(() -> {
                if (lock.tryLock()) {
                    try {
                        System.err.println(Thread.currentThread().getName() + LocalTime.now());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        System.out.println("unlock + " + Thread.currentThread().getName() + LocalTime.now());
                        lock.unlock();
                    }
                }
            });
        }
    }

    private static void redisLockThreadPool() throws InterruptedException {
        JedisPool pool = new JedisPool();
        Lock lock = new RedisLock(pool, "ShedLockMainThreadPool");
        ExecutorService executorService = new ThreadPoolExecutor(10,
                10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        while (true) {
            executorService.execute(() -> {
                if (lock.tryLock()) {
                    try {
                        System.err.println(Thread.currentThread().getName() + LocalTime.now());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        System.out.println("unlock + " + Thread.currentThread().getName() + LocalTime.now());
                        lock.unlock();
                    }
                }
            });
        }

    }

    private static void shedLock() {
        JedisPool pool = new JedisPool();
        LockProvider lockProvider = new JedisLockProvider(pool);
        ExecutorService executorService = new ThreadPoolExecutor(10,
                10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(0), new ThreadPoolExecutor.DiscardPolicy());

        while (true)
            executorService.submit(() -> {
            LockConfiguration configuration = new LockConfiguration("ShedLockMain", Instant.now().plus(Duration.ofSeconds(10)), Instant.now().plus(Duration.ofSeconds(10)));
            Optional<SimpleLock> lock = lockProvider.lock(configuration);
            if (lock.isPresent()) {
                System.out.println(Thread.currentThread().getName() + LocalTime.now());
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                lock.get().unlock();
            }else {
                System.out.println("it's locked");
            }

        });
    }

}
