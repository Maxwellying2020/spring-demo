package com.example.demo.busi;

import com.example.util.global.FilterConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
@Import(value = {
        FilterConfig.class
})
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.run(DemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
////            DefaultApplicationArguments  defaultApplicationArguments = new DefaultApplicationArguments(args);
////            Set<String> strings = defaultApplicationArguments.getOptionNames();
////            System.out.println(strings);
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//            System.out.println("**********************");
//        };
//    }

}
