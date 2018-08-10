package com.hlj.common.todo;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-25.
 */

/**
 * @author wangzhigang
 * @since 2018.03.12
 * @Description: redis实现的分布式锁。
 *
 *               利用redis单线程的特点，采用redis.setnx()和redis.getSet()方法实现加锁操作和锁的竞争。
 *               用userId作为key,过期时间作为值，2倍过期时间作为redis key的过期时间。
 *
 *               当调用lock()方法时，先调用redis.setnx()操作，如果之前没有key，则上锁成功；
 *
 *               否则进行锁的竞争，调用redis.getSet()操作。如果之前的值过期，则获得锁；否则没有获得锁。
 *               当多个实例进行锁的竞争时，redis的value和过期时间会被竞争失败的线程写入和刷新，不过并不影响获得锁的实例，也不会拿到锁。
 *
 *               这里利用值是过期时间和redis的过期时间，避免死锁和提高redis利用率。
 */
public class RedisLock {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);
//
//    private static final long INVALID_REDIS_VALUE = -1;
//
//    private String redisKey;
//    private int lockExpireTime; // 单位是秒
//    private int redisKeyExpireTime; // 单位是秒
//    private JedisCluster jedisCluster;
//
//    private static String generateLockRedisKey(long userId) {
//        return userId + "";
//    }
//
//    private static final int REDIS_LOCK_TERM_SECONDS = 10; // redislock逻辑过期时间是60秒
//
//    public RedisLock(long userId) {
//        this(generateLockRedisKey(userId), REDIS_LOCK_TERM_SECONDS, RedisUtil.getJedis());
//    }
//
//    public RedisLock(String redisKey, int lockExpireTime, JedisCluster jedisCluster) {
//        super();
//        this.redisKey = redisKey;
//        this.lockExpireTime = lockExpireTime;
//        this.redisKeyExpireTime = lockExpireTime * 2;
//        this.jedisCluster = jedisCluster;
//
//        if (!arguValidCheck(this.redisKeyExpireTime, this.jedisCluster)) {
//            throw new RuntimeException("wrong init redis lock");
//        }
//    }
//
//    private boolean arguValidCheck(int redisKeyExpireTime, JedisCluster jedisCluster) {
//        return redisKeyExpireTime > 0 && jedisCluster != null;
//    }
//
//    public boolean lock() {
//        if (StringUtils.isBlank(redisKey) || lockExpireTime <= 0) {
//            return false;
//        }
//        try {
//            long expectExpireTime = System.currentTimeMillis() + lockExpireTime * 1000L;
//            String redisValueStr = String.valueOf(expectExpireTime);
//            long rc = jedisCluster.setnx(redisKey, redisValueStr);
//            if (rc == 1) {
//                // redis之前没有值，获得锁
//                jedisCluster.expire(redisKey, redisKeyExpireTime);
//                LOGGER.debug("Get lock, set expire time, redisKey={}, lockExpireTime={}, redisKeyExpireTime={}", redisKey, lockExpireTime,
//                        redisKeyExpireTime);
//                return true;
//            }
//
//            PointsMallUtils.perfCounterForAlert(PointsMallPerfCounter.REDIS_LOCK_COMPETITION);
//            LOGGER.error("Lock competition, lock={}", toString());
//
//            // 之前有值，判断值是否超时。
//            String oldValue = jedisCluster.getSet(redisKey, redisValueStr);
//            jedisCluster.expire(redisKey, redisKeyExpireTime);
//
//            if (StringUtils.isBlank(oldValue)) {
//                // 之前获得锁的线程主动删除锁，或者该锁的ttl过期了。
//                LOGGER.debug("Get lock, set expire time, redisKey={}, lockExpireTime={}, redisKeyExpireTime={}", redisKey, lockExpireTime,
//                        redisKeyExpireTime);
//                return true;
//            }
//
//            long currentRedisExpireTime = NumberUtils.toLong(oldValue, INVALID_REDIS_VALUE);
//            if (INVALID_REDIS_VALUE == currentRedisExpireTime) {
//                LOGGER.error("Error redis op, lock={}, oldValue={}, currentValue={}", toString(), oldValue, redisValueStr);
//                return false;
//            }
//
//            if (currentRedisExpireTime >= System.currentTimeMillis()) {
//                LOGGER.debug("Lock by other. currentRedisExpireTime={}", currentRedisExpireTime);
//                return false;
//            } else {
//                LOGGER.debug("Get lock, set expire time, redisKey={}, lockExpireTime={}, redisKeyExpireTime={}", redisKey, lockExpireTime,
//                        redisKeyExpireTime);
//                return true;
//            }
//        } catch (Exception e) {
//            LOGGER.error("error in lock, lock={}", toString(), e);
//        }
//        return false;
//    }
//
//    public void unlock() {
//        if (StringUtils.isBlank(redisKey) || lockExpireTime <= 0) {
//            return;
//        }
//        try {
//            String currentValue = jedisCluster.get(redisKey);
//            long currentRedisExpireTime = NumberUtils.toLong(currentValue, INVALID_REDIS_VALUE);
//            long now = System.currentTimeMillis();
//            if (currentRedisExpireTime >= now) {
//                // 已获得的锁未过期。
//                LOGGER.debug("Unlock, redisKey={}, currentRedisExpireTime={}, now={}", redisKey, currentRedisExpireTime, now);
//
//                /**
//                 * 如果删除redisKey，代表unlock()方法作为真正的解锁方式。
//                 * 如果不删除redisKey，代表以过期时间作为真正的解锁方式。
//                 *
//                 * 2018.03.17 目前，前端的按钮如果点击多次是发送多次请求。
//                 *
//                 * 如果采用删除redisKey的方式，可能会导致本想兑换一个，结果由于误触发多次请求而兑换多次。
//                 *
//                 * 以规避麻烦最为考虑基本点，采用"以过期时间作为真正的解锁方式"。 此时，
//                 *
//                 * (1)锁住期间该用户无法兑换，直到redisKey过期；
//                 * (2)如果锁住期间，用户有发起一次兑换请求，会刷新redisKey。
//                 */
//                // jedisCluster.del(redisKey);
//            } else {
//                // !!!已获得的锁过期。此时不能随意删除key，因为可能是其他的实例由于锁的过期而获得的新锁。
//            }
//        } catch (Exception e) {
//            LOGGER.error("error in lock, lock={}", toString(), e);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "RedisLock [redisKey=" + redisKey + ", lockExpireTime=" + lockExpireTime + ", redisKeyExpireTime=" + redisKeyExpireTime
//                + "]";
//    }
}
