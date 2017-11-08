
package com.aurora.account.Util;
import com.aurora.account.model.User;
import com.aurora.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//${contextPath}
@Service
public class ContentGenerator {
     private String occupation;
     @Autowired
     private UserRepository userRepository;
     private User user;
     private String navbar;
     private String pathUrl;
    private ArrayList<String> navlist;

     

    public void setGen(String UserName) {
        this.user = userRepository.findByUsername(UserName);
        this.occupation = user.getOccupation();
        this.pathUrl = "GradeOneSys-1.0-SNAPSHOT";


    }

    public String getNavbar(int active){
        this.navlist=new ArrayList<String>() {{
            add("");//welcome          0
            add("");//registration     1
            add("");//addapplication   2
            add("");//viewusers        3
            add("");//default          4
            add("");//addschool        5
            add("");//addparent        6
        }};

        this.navlist.set(active,"active");

        navbar="";
        navbar+="<div id='navbar' class='navbar-collapse collapse'><ul class='nav navbar-nav'><li class='"+navlist.get(0)+"'><a href='welcome'>Home</a></li>";
        if(occupation.trim().equals("data entry")){
           navbar+="<li class='"+navlist.get(2)+"'><a href='addapplication'>Add application</a></li>";
            navbar+="<li class='"+navlist.get(5)+"'><a href='addschool'>Add School</a></li>";
            navbar+="<li class='"+navlist.get(6)+"'><a href='addparent'>Add Parent</a></li>";
        }
        if(occupation.trim().equals("admin")){
           navbar+="<li class='"+navlist.get(1)+"'><a href='registration' >Add user</a></li>";
           navbar+="<li class='"+navlist.get(3)+"'><a href='viewusers'>View Users</a></li>";
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
