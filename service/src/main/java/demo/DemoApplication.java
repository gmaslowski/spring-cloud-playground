package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class DemoApplication {

    @Value("${welcome.message}")
    private String welcomeMessage;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return format(welcomeMessage, name);
    }
}
