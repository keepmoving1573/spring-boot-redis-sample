package sample.data.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:04
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valueOperations;

    @RequestMapping("/")
    public String helloworld(){
        return "Hello world!";
    }

    @GetMapping("set")
    public Object setDataToRedis(String key, String value) {
        if (!this.stringRedisTemplate.hasKey(key)) {
            valueOperations.set(key, value);
        }
        System.out.println("set data: key=" + key + ", value=" + valueOperations.get(key));
        return "success";
    }

    @GetMapping("get")
    public Object getDataFromRedis(String key) {
        if (this.stringRedisTemplate.hasKey(key)) {
            String value = valueOperations.get(key);
            System.out.println("found key " + key + ", value=" + valueOperations.get(key));
            return value;
        } else {
          return "faild";
        }
    }


}
