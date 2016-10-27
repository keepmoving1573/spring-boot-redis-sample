package sample.data.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.data.redis.bean.Person;
import sample.data.redis.dao.PersonDao;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:43
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ObjectRedisController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("setObject")
    public Object setDataToRedis(String id, String name, Integer age) {
        Person person=new Person(id,name,age);
        personDao.save(person);
        return "success";
    }

    @GetMapping("getObject")
    public Object getDataFromRedis(String id) {
        return personDao.get(id);
    }
}
