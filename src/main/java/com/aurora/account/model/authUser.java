/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurora.account.model;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author nilanka
 */
public class authUser extends User {
    private final String occupation;

    public String getOccupation() {
        return occupation;
    }
    
    public authUser(String username, String password, Collection<? extends GrantedAuthority> authorities,String occupation) {
        super(username, password, authorities);
        this.occupation = occupation;
    }
    
}
