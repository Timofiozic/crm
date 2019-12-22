package com.edu.crm.service;

import com.edu.crm.adapters.UserAdapter;
import com.edu.crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserService {

    private UserAdapter userAdapter;

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userAdapter.read(id);
    }

    @Autowired
    public void setUserAdapter(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }
}
