package sample.data.redis.service;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:47
 */
public interface RedisService {

    void set(Object key, Object value);

    <T> T get(Object key, Class<T> clazz);

    void setWithTimeout(Object key, Object value, long timeout, TimeUnit timeunit);

    void delete(Object key);


}