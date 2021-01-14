package com.hellojava.shedlock.redislock;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static org.springframework.data.redis.connection.RedisStringCommands.SetOption.SET_IF_ABSENT;

public class RedisTemplateLock implements Lock {

    private static final String KEY_PREFIX = "shed-lock";

    private final StringRedisTemplate redisTemplate;
    private final String name;
    private final Duration timeout;

    public RedisTemplateLock(StringRedisTemplate redisTemplate, String name, Duration timeout) {
        this.redisTemplate = redisTemplate;
        this.name = name;
        this.timeout = timeout;
    }

    @Override
    public void lock() {
        while (!tryLock()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        return redisTemplate.execute((connection -> connection.set(serialize(key), serialize(value),
                Expiration.seconds(10), SET_IF_ABSENT)), false);
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
        redisTemplate.delete(key);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private String buildKey(String lockName) {
        return String.format("%s:%s:%s", KEY_PREFIX, lockName, this.toString());
    }

    private byte[] serialize(String key) {
        return this.redisTemplate.getStringSerializer().serialize(key);
    }
}
