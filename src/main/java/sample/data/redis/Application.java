package sample.data.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 21:58
 */
@SpringBootApplication(scanBasePackages = "sample.data.redis")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
