package com.example.apirest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        // via query param ex: http://localhost:8080/api/person/all?mediaType=xml
        /*configurer.favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                useRegisteredExtensionsOnly(false).
                defaultContentType(org.springframework.http.MediaType.APPLICATION_JSON).
                mediaType("xml", org.springframework.http.MediaType.APPLICATION_XML).
                mediaType("json", org.springframework.http.MediaType.APPLICATION_JSON);*/
        //via header param ex: http://localhost:8080/api/person/all
        //header: Accept: application/xml
            configurer.favorParameter(false).
                ignoreAcceptHeader(false).
                useRegisteredExtensionsOnly(false).
                defaultContentType(org.springframework.http.MediaType.APPLICATION_JSON).
                mediaType("xml", org.springframework.http.MediaType.APPLICATION_XML).
                mediaType("json", org.springframework.http.MediaType.APPLICATION_JSON);
    }
}
