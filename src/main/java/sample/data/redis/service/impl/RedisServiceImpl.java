package sample.data.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import sample.data.redis.service.RedisService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/10/28 - 16:15
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    /**
     * 设置缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public void set(Object key, Object value) {
        valOps.set(key, value);
    }

    /**
     * 获取指定key的缓存
     *
     * @param key
     */
    public Object get(Object key) {
        Object value = valOps.get(key);
        return value;
    }

    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param timeout  过期时间
     * @param timeunit 时间单位
     */
    public void setWithTimeout(Object key, Object value, long timeout, TimeUnit timeunit) {
        valOps.set(key, value, timeout, timeunit);
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(Object key) {
        redisTemplate.delete(key);
    }

}
