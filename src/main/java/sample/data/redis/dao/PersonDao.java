package sample.data.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import sample.data.redis.bean.Person;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:47
 */
@Repository
public class PersonDao {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void save(Person person){
        valOps.set(person.getId(), person);
    }

    public Person get(String id){
        return (Person) valOps.get(id);
    }
}