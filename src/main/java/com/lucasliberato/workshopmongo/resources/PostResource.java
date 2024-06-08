package com.lucasliberato.workshopmongo.resources;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.dto.UserDTO;
import com.lucasliberato.workshopmongo.services.PostService;
import com.lucasliberato.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findByPost(id);
        return ResponseEntity.ok().body(post);
    }


}
