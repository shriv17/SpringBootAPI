package springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springBoot.api.ServerInteraction;

/**
 * Created by Administrator on 5/5/2017.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = ServerInteraction.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
