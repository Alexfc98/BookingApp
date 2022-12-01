package com.Backend.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Users.Exceptions.RecordNotFoundException;
import com.Backend.Users.Model.User;
import com.Backend.Users.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        User entity = service.getUserById(id);

        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User myItem){
        User created = service.createUser(myItem);
        return new ResponseEntity<User>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> UpdateUser(@RequestBody User myItem)
            throws RecordNotFoundException {
        User updated = service.UpdateUser(myItem);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.ACCEPTED;
    }
}
