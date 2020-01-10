package com.unicom.smartcity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liukai
 */
@Configuration
public class RestTemplateConfig extends RestTemplate {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
