package com.aurora.account.service;

import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;
import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    boolean verifyPassword(TempUser tmp,User user);
    
    public List<User>getAll();
}
