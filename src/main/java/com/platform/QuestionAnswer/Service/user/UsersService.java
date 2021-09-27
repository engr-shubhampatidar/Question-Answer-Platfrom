package com.platform.QuestionAnswer.Service.user;

import com.platform.QuestionAnswer.Model.user.Users;
import com.platform.QuestionAnswer.Repositiory.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public Long postUsers(Users users) {
        usersRepository.save(users);
        return users.getUserId();
    }

    public void updateUsers(Long users_id, Users users) {
        Users users1 = usersRepository.findById(users_id).orElseThrow(() ->
                new IllegalStateException("User with id " + users_id + " not found !!"));
        if(users != null &&
                users.getUsers().length() > 0){
            users.setUsers(users.getUsers());
        }
    }

    public void deleteUsers(Long users_id) {
        usersRepository.deleteById(users_id);
    }
}
