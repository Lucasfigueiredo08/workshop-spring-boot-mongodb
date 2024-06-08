package com.lucasliberato.workshopmongo.services;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.dto.UserDTO;
import com.lucasliberato.workshopmongo.repository.PostRepository;
import com.lucasliberato.workshopmongo.repository.UserRepository;
import com.lucasliberato.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepository;
    public Post findByPost(String id){
        Post post = postRepository.findById(id).orElse(null);
        if (Objects.isNull(post)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }
}
