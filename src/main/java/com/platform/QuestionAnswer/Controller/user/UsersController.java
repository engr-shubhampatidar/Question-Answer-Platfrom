package com.platform.QuestionAnswer.Controller.user;

import com.platform.QuestionAnswer.Model.user.Users;
import com.platform.QuestionAnswer.Service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsersController {
    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/users")
    List<Users> getUsers(){
        return usersService.getUsers();
    }

    @ResponseBody
    @PostMapping(path = "/users")
    Long postUsers(@RequestBody Users users){
        return usersService.postUsers(users);
    }

    @ResponseBody
    @PutMapping(path = "/users/{users_id}")
    void updateUsers(@PathVariable Long users_id,
                     @RequestBody Users users){
        usersService.updateUsers(users_id, users);
    }

    @DeleteMapping(path = "/users/{users_id}")
    void deleteUser(@PathVariable Long users_id){
        usersService.deleteUsers(users_id);
    }
}
