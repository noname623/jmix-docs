/*
 * Copyright 2022 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.company.demo.config;

import io.jmix.autoconfigure.authserver.AuthServerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile("custom-login-form")
//tag::class-header[]
//tag::whole-class[]
@EnableWebMvc
@Configuration
@Order(AuthServerAutoConfiguration.AuthorizationServerLoginPageConfiguration.ORDER + 10) // <1>
public class MyWebMvcConfigurer implements WebMvcConfigurer {
//end::class-header[]
    //tag::view-controllers[]
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/as-login").setViewName("my-as-login.html"); // <2>
    }
    //end::view-controllers[]
    //tag::resource-handlers[]
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/my-as-login/**")
                .addResourceLocations("classpath:/META-INF/resources/my-as-login/"); // <1>
    }
    //end::resource-handlers[]
    //tag::class-footer[]
}
//end::class-footer[]
//end::whole-class[]