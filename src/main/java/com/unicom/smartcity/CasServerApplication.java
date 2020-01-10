package com.unicom.smartcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author liukai
 */
@EnableJpaAuditing
@SpringBootApplication
public class CasServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasServerApplication.class, args);
    }

}
