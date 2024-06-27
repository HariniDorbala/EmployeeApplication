package com.app.gloesports.controller;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles the user related requests
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // Add a user

    @PostMapping
    public ResponseEntity<UserDto> US1(@Valid @RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    //Get a user by userId
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> US2(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

}
