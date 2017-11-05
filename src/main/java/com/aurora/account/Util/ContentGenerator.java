
package com.aurora.account.Util;
import com.aurora.account.model.User;
import com.aurora.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//${contextPath}
@Service
public class ContentGenerator {
     private String occupation;
     @Autowired
     private UserRepository userRepository;
     private User user;
     private String navbar;
     private String pathUrl;
     

    public void setGen(String UserName){
    this.user=userRepository.findByUsername(UserName);
    this.occupation = user.getOccupation();
    this.pathUrl="GradeOneSys-1.0-SNAPSHOT";
        
    }
    
    public String getNavbar(){
        navbar="";
        navbar+="<div id='navbar' class='navbar-collapse collapse'><ul class='nav navbar-nav'><li><a href='welcome'>Home</a></li>";
        if(occupation.trim().equals("data entry")){
           navbar+="<li><a href='addapplication'>Add application</a></li>";
        }
        if(occupation.trim().equals("admin")){
           navbar+="<li><a href='registration'>Add user</a></li>";
        }
        navbar+="</ul>";
        return navbar;
    }
    
    public String getProfile(){
        String profile="";
        profile+="<p><b>User Name : </b>"+" "+user.getUsername()+"<br><b>Occupation : </b>"+" "+occupation+"<p>";
        return profile;
    }
    
    
    
}
