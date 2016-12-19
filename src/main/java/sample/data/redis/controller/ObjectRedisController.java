package sample.data.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.data.redis.bean.Person;
import sample.data.redis.service.RedisService;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:43
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ObjectRedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("setObject")
    public String setDataToRedis(String id, String name, Integer age) {
        try {
            Person person = new Person();
            person.setId(id);
            person.setAge(age);
            person.setName(name);
            redisService.set(id, person);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "redis connection error";
        }
    }

    @GetMapping("getObject")
    public Person getDataFromRedis(String id) throws Exception {
        try {
            return redisService.get(id, Person.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("redis服务down了");
        }
    }

    @DeleteMapping("deleteObject")
    public String deleteObject(String id) {
        redisService.delete(id);
        return "delete success";
    }
}
