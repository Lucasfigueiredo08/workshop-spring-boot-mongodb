package com.lucasliberato.workshopmongo.config;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.dto.AuthorDTO;
import com.lucasliberato.workshopmongo.dto.CommentDTO;
import com.lucasliberato.workshopmongo.repository.PostRepository;
import com.lucasliberato.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

        userRepository.saveAll(list);

        var post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Joinville, Abraços", new AuthorDTO(maria));
        var post2 = new Post(null, sdf.parse("08/06/2024"), "Bom dia", "O sou já nasceu lá na fazendinha!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2022"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Curte lá!", sdf.parse("21/03/2024"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um bom dia", sdf.parse("21/03/2023"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);





    }
}

