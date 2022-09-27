package com.codegym.demoajax.controller;

import com.codegym.demoajax.model.AppUser;
import com.codegym.demoajax.model.Customer;
import com.codegym.demoajax.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class AppUserController {
    @Autowired
    IUserService userService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<AppUser>> listUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable Long id){
        Optional<AppUser> appUserOptional= userService.findById(id);
        userService.remove(id);
        return new ResponseEntity<>(appUserOptional.get(), HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser){
        return new ResponseEntity<>(userService.save(appUser), HttpStatus.CREATED);
    }

}
