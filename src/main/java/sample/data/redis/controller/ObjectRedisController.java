package sample.data.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Object setDataToRedis(String id, String name, Integer age) {
        Person person=new Person(id,name,age);
        redisService.set(id, person);
        return "success";
    }

    @GetMapping("getObject")
    public Object getDataFromRedis(String id) {
        return redisService.get(id);
    }
}
