package com.mybatis.courses.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
@ApplicationPath("/rest")
public class JerseyConfiguration extends ResourceConfig {
	
    public JerseyConfiguration() {
        packages("com.mybatis.courses.controllers");
        register(CorsFilter.class);

    }

}
