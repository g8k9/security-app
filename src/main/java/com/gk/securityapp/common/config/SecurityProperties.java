package com.gk.securityapp.common.config;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("security")
@Data
@FieldDefaults(makeFinal = false)
public class SecurityProperties {
    JwtProperties jwt;

    @Data
    @FieldDefaults(makeFinal = false)
    public static class JwtProperties{
        Resource keyStore;
        String keyStorePassword;
        String keyPairAlias;
        String keyPairPassword;
    }
}
