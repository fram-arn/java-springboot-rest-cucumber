package com.mitrais.more.api.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebAppConfiguration
@EnableWebMvc
public abstract class ParentSteps {

    @Autowired
    WebApplicationContext context;

}
