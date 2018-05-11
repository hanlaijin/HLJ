package com.hlj.thrift;

import com.facebook.swift.codec.ThriftField;
import com.hlj.common.dtos.thrift.CallbackFuture;
import org.springframework.stereotype.Service;

@Service
public class HljThriftService implements HljService.Async {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public CallbackFuture<String> ping() {
        CallbackFuture<String> result = new CallbackFuture<String>();
//        String value = (String) redisTemplate.opsForValue().get("key");
//        result.set(value);
        return result;
    }

    @Override
    public CallbackFuture<User> getUserFromDB(@ThriftField(value = 1, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) {
        CallbackFuture<User> result = new CallbackFuture<User>();

        return result;
    }

    @Override
    public CallbackFuture<String> getFromQueue(@ThriftField(value = 1, name = "key", requiredness = ThriftField.Requiredness.NONE) String key) {
        CallbackFuture<String> result = new CallbackFuture<String>();
//        String value = RedisUtil.getJedis().rpop(key);
//        result.set(value);
        return result;
    }

    @Override
    public CallbackFuture<Boolean> saveUserToRedis(@ThriftField(value = 1, name = "user", requiredness = ThriftField.Requiredness.NONE) User user) {
        CallbackFuture<Boolean> result = new CallbackFuture<Boolean>();

        return result;
    }

    @Override
    public CallbackFuture<User> getUserFromRedis(@ThriftField(value = 1, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) {
        CallbackFuture<User> result = new CallbackFuture<User>();

        return result;
    }
}