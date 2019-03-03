package com.devedores.demo.controller;

import com.devedores.demo.dto.UserDto;
import com.devedores.demo.models.User;
import com.devedores.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<UserDto> getById(@RequestParam("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.create(userDto));
    }

    @PostMapping("/importFromJsonPlaceHolder")
    public ResponseEntity<List<User>> importFromJsonPlaceHolder(@RequestBody List<User> users){
        return ResponseEntity.ok(service.importFromJsonPlaceHolder(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> edit(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(service.update(userDto, id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
