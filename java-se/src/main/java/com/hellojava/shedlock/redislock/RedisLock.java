package com.hellojava.shedlock.redislock;

import net.javacrumbs.shedlock.support.LockException;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RedisLock implements Lock {

    private static final String KEY_PREFIX = "job-lock";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_EXPIRE_TIME_IN_MS = "PX";
    private static final int DEFAULT_LOCK_TIME = 60000;

    private final Pool<Jedis> pool;
    private final String name;

    boolean success =false;

    public RedisLock(Pool<Jedis> pool, String name) {
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void lock() {
        while (!tryLock()) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        if (!tryLock()) {
            throw new InterruptedException();
        }
    }

    @Override
    public boolean tryLock() {
        String key = buildKey(name);
        String value = Instant.now().toString();
        try (Jedis jedis = pool.getResource()) {
            String result = jedis.set(key, value, SET_IF_NOT_EXIST ,SET_EXPIRE_TIME_IN_MS, DEFAULT_LOCK_TIME);
            if ("OK".equals(result)) {
                System.out.println("ok:" + LocalTime.now());
                return true;
            }
//            if (!success) {
//                success = true;
//                return true;
//            }
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        long timeout = unit.toNanos(time);
        long deadline = System.nanoTime() + timeout;

        while (true) {
            timeout =  deadline - System.nanoTime();
            if (timeout <= 0) {
                return false;
            }
            if (tryLock()) {
                return true;
            }

        }
    }

    @Override
    public void unlock() {
        String key = buildKey(name);
        try (Jedis jedis = pool.getResource()) {
            jedis.del(key);
        } catch (Exception e) {
            throw new LockException("Can not remove node", e);
        }
        success = false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    static String buildKey(String lockName) {
        return String.format("%s:%s", KEY_PREFIX, lockName);
    }
}
