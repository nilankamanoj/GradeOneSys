package com.aurora.account.service;

import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    boolean verifyPassword(TempUser tmp,User user);
}
