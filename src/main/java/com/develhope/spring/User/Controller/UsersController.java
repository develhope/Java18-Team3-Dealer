package com.develhope.spring.User.Controller;

import com.develhope.spring.User.DTO.UsersDTO;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public Users createUsers(@RequestBody UsersDTO usersDTO){
        return userService.createUsers(usersDTO);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUsers(@PathVariable Long userId){
        userService.deleteUsersByID(userId);
    }

    @PutMapping("/updateUser/{userId}")
    public UsersDTO updateUser(@PathVariable Long userId, @RequestBody UsersDTO usersDTO){
        return userService.updateUser(userId, usersDTO);
    }

}
