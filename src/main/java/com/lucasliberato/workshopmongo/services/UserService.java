package com.lucasliberato.workshopmongo.services;

import com.lucasliberato.workshopmongo.domain.User;
import com.lucasliberato.workshopmongo.dto.UserDTO;
import com.lucasliberato.workshopmongo.repository.UserRepository;
import com.lucasliberato.workshopmongo.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id){
        User user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        return user;
    }

}
