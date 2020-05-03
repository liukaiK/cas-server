package com.unicom.smartcity.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liukai
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private String loginUrl;

    private String logoutUrl;

}
