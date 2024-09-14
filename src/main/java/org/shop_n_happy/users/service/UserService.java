package org.shop_n_happy.users.service;

import org.shop_n_happy.users.model.User;
import org.shop_n_happy.users.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
public User createUser(User user){
    User u = userRepo.createUser(user);
    return u;
}

    public User userSignIn(@RequestBody User UserSignIn){
        return userRepo.userSignIn(UserSignIn);
    }
}
