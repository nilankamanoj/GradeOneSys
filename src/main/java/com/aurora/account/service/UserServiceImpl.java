package com.aurora.account.service;

import com.aurora.account.model.Role;
import com.aurora.account.model.TempUser;
import com.aurora.account.model.User;
import com.aurora.account.repository.RoleRepository;
import com.aurora.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setRoles(new HashSet<>(roleRepository.findAll()));
      Set<Role> roleSet = new HashSet<Role>();
       String occupation = user.getOccupation();
       if(occupation.trim().equals("admin")){
           roleSet.add(roleRepository.findAll().get(0));
           roleSet.add(roleRepository.findAll().get(1));
           user.setRoles(roleSet);
       }
       else if(occupation.trim().equals("data entry")){
         roleSet.add(roleRepository.findAll().get(0));
          roleSet.add(roleRepository.findAll().get(2));
         user.setRoles(roleSet);
         
           
       }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public boolean verifyPassword(TempUser tmp,User user){
        return bCryptPasswordEncoder.matches(tmp.getOldPass(),user.getPassword());
    }
}