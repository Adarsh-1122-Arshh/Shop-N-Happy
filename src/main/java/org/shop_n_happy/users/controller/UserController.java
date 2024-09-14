package org.shop_n_happy.users.controller;

import org.shop_n_happy.users.model.User;
import org.shop_n_happy.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping( path = "/signup", method = RequestMethod.POST)
    public User createUser(@RequestBody  User user){
        System.out.println("----- in controller signup --- ");
        User u = userService.createUser(user);
        return u;

    }
    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public User userSignIn(@RequestBody User UserSignIn){
        return userService.userSignIn(UserSignIn);
    }
}
