package org.example.realproject.service;

import org.example.realproject.domain.User;
import org.example.realproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(User user) {
        if (!user.getPassword().equals(user.getPassword())) throw new RuntimeException("비밀번호가 일치하지 않습니다");
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.insert(user);
        userMapper.insertAuthority(user.getId(), "ROLE_USER");
    }

    public Long findUserIdByUsername(String username){
        return userMapper.findUserIdByUsername(username);
    }

}
