package com.app.gloesports.service.impl;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.Users;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.UserService;
import com.app.gloesports.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.gloesports.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

// make this into a service layer for User entity
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper mapper;
    @Override
    public UserDto addUser(UserDto userDTO) {
        Users u = mapper.mapToUserEntity(userDTO);
        userRepository.save(u);
        return mapper.mapToUserDto(u);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<Users> u = userRepository.findById(userId);
        if(u.isEmpty())
            throw new ResourceNotFoundException("Get","getUserById",userId);
        return mapper.mapToUserDto(u.get());
    }
}
