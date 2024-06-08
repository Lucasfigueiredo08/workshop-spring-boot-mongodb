package com.lucasliberato.workshopmongo.repository;

import com.lucasliberato.workshopmongo.domain.Post;
import com.lucasliberato.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
