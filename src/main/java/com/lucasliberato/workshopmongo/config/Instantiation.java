package com.lucasliberato.workshopmongo.config;

import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.AccessType;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "nNQpX@example.com");
        User alex = new User(null, "Alex Green", "fHk7c@example.com");
        User bob = new User(null, "Bob Grey", "bZkP3@example.com");

        List<User> list  = List.of(maria, alex, bob);

        userRepository.saveAll(list);
    }
}
