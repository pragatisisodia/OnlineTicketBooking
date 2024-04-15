package com.example.OnlineTicketBooking.Controller;

import com.example.OnlineTicketBooking.Repository.UserRepository;
import com.example.OnlineTicketBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

@DeleteMapping("delete_user/{user_id}")
public String delete_user(@PathVariable int user_id)
{
    return userService.delete_user(user_id);

}





}
