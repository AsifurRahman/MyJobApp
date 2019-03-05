package com.arinc.myjobapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user){
        return repository.save(user);
    }

    public List<User> userList() {
        return repository.findAll();
    }

    public User findById(Integer Id){
        return repository.findOne(Id);
    }

    public void deleteById(Integer Id){
         repository.delete(Id);
    }


}
