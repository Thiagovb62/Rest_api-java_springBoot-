package com.example.apirest.integrationstests.testcontainers;

import com.example.apirest.configs.TestConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startable;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.32")
                .withDatabaseName("test")
                .withUsername("test")
                .withPassword("test");
        private static void startContainer() {
            Startables.deepStart(Stream.of(mySQLContainer)).join();
        }
        private static Map<String,String> createConnectionConfiguration(){
            return Map.of(
                    "spring.datasource.url",mySQLContainer.getJdbcUrl(),
                    "spring.datasource.username",mySQLContainer.getUsername(),
                    "spring.datasource.password",mySQLContainer.getPassword());
        }
        @Override
        @SuppressWarnings("rawtypes")
        public void initialize(ConfigurableApplicationContext applicationContext){
            startContainer();
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            @SuppressWarnings("unchecked")
            MapPropertySource testcontainers = new MapPropertySource(
                    "testcontainers",(Map) createConnectionConfiguration());
            environment.getPropertySources().addFirst(testcontainers);
        }
    }
}
