package com.validation.validation.controller;

import com.validation.validation.domain.User;
import com.validation.validation.dto.UserCreateDto;
import com.validation.validation.exception.UserNotFoundException;
import com.validation.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;
    public UserController(@Autowired UserService service){
        this.service = service;
    }

    /**+
     *
     * @param userRequest
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserCreateDto userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

}
