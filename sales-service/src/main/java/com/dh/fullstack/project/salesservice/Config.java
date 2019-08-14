package com.dh.fullstack.project.salesservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julio Daviu
 */

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.dh.fullstack.project.salesservice")
@EnableFeignClients
public class Config {
}
