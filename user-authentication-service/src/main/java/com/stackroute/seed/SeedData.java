package com.stackroute.seed;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

@Component
@PropertySource("classpath:config.properties")
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    User user = new User();
    User user1 = new User();
    User user2 = new User();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        user.setEmailId(environment.getProperty("user.emailId"));
        user.setPassword(environment.getProperty("user.password"));
        user.setRole(environment.getProperty("user.role"));
        userRepository.save(user);

        user1.setEmailId(environment.getProperty("user1.emailId"));
        user1.setPassword(environment.getProperty("user1.password"));
        user1.setRole(environment.getProperty("user1.role"));
        userRepository.save(user1);

        user2.setEmailId(environment.getProperty("user2.emailId"));
        user2.setPassword(environment.getProperty("user2.password"));
        user2.setRole(environment.getProperty("user2.role"));
        userRepository.save(user2);
    }
}
