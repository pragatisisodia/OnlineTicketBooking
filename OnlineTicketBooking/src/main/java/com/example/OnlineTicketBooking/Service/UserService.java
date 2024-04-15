package com.example.OnlineTicketBooking.Service;

import com.example.OnlineTicketBooking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String delete_user(int user_id) {

        userRepository.deleteById(user_id);
        return "User Successfully deleted";
    }
}
