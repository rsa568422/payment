package com.ntt.payment.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ntt.payment.infrastructure.mapper")
public class MapperTestConfig {
}
