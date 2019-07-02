package com.gmail.yuramitryahin.services;

import com.gmail.yuramitryahin.repository.UserRepository;
import com.gmail.yuramitryahin.dto.UserDTO;
import com.gmail.yuramitryahin.dto.UsersDTO;
import com.gmail.yuramitryahin.entity.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {

        User user = userRepository.findByUsername("user");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        userRepository.save(user);

    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersDTO getAllUsers() {
        //TODO checking for an empty user list
        return new UsersDTO(userRepository.findAll());
    }

    public User findByUserLogin (UserDTO userDTO){
        //TODO check for user availability. password check
        return userRepository.findByUsername(userDTO.getUsername());
    }

    public void saveNewUser (User user){
        //TODO inform the user about the replay email
        try {
            userRepository.save(user);
        } catch (Exception ex){
            log.info("{Лог уже существует}");
        }

    }


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
