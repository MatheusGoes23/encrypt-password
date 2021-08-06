package com.matheusgoes23.encrypt.password.service;

import com.matheusgoes23.encrypt.password.data.UserDetailData;
import com.matheusgoes23.encrypt.password.model.UserModel;
import com.matheusgoes23.encrypt.password.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserModel> optionalUser = userRepository.findByLogin(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User [" + username + "] not found");
        }

        return new UserDetailData(optionalUser);
    }
}
