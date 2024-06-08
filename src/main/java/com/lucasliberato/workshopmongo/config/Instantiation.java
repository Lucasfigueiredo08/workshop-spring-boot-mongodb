package com.lucasliberato.workshopmongo.config;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.repository.PostRepository;
import com.lucasliberato.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.AccessType;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "nNQpX@example.com");
        User alex = new User(null, "Alex Green", "fHk7c@example.com");
        User bob = new User(null, "Bob Grey", "bZkP3@example.com");

        List<User> list  = List.of(maria, alex, bob);

        var post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Joinville, Abraços", maria);
        var post2 = new Post(null, sdf.parse("08/06/2024"), "Bom dia", "O sou já nasceu lá na fazendinha!", maria);



        userRepository.saveAll(list);
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
