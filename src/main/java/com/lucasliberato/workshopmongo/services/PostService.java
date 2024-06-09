package com.lucasliberato.workshopmongo.services;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.repository.PostRepository;
import com.lucasliberato.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date maxDate, Date minDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, maxDate, minDate);
    }
}
