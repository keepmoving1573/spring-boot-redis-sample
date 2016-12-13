package sample.data.redis.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    /*@Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;*/

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOps;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 设置缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public void set(String key, Object value) {
        valOps.set(key, JSON.toJSONString(value));
    }

    /**
     * 获取指定key的缓存
     *
     * @param key
     */
    public <T> T get(String key, Class<T> clazz) {
        Object value = JSON.parseObject((String) valOps.get(key), clazz);
        return (T) value;
    }

    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param timeout  过期时间
     * @param timeunit 时间单位
     */
    public void setWithTimeout(String key, Object value, long timeout, TimeUnit timeunit) {
        valOps.set(key, JSON.toJSONString(value), timeout, timeunit);
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
