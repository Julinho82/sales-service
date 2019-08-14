package com.dh.fullstack.project.salesservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julio Daviu
 */

@Configuration
public class SalesProperties {

    @Value("${employee.age}")
    private Integer permitAge;

    public Integer getPermitAge() {
        return permitAge;
    }
}
