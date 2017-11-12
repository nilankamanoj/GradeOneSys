
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
            add("");//addpasspupil     7
            add("");//assignapplicant  8
        }};

        this.navlist.set(active,"\"current\"");

        navbar="";
        navbar+="<header id=\"header\" class=\"alt\">                                            "+
                "        <h1 id=\"logo\"><a href=\"welcome\">Home</a></h1>                       "+
                "        <nav id=\"nav\">                                                        "+
                "            <ul>                                                                "+
                "               <li class="+navlist.get(0)+"><a href=\"welcome\">Welcome</a></li>";


        if(occupation.trim().equals("data entry")){
           navbar+="<li class="+navlist.get(2)+"><a href='addapplication'>Add application</a></li>";
            navbar+="<li class="+navlist.get(5)+"><a href='addschool'>Add School</a></li>";
            navbar+="<li class="+navlist.get(6)+"><a href='addparent'>Add Parent</a></li>";
            navbar+="<li class="+navlist.get(7)+"><a href='addpastpupil'>Add Past Pupil</a></li>";
            navbar+="<li class="+navlist.get(8)+"><a href='assignapplicant'>Assign app</a></li>";
        }
        if(occupation.trim().equals("admin")){
           navbar+="<li class="+navlist.get(1)+"><a href='registration' >Add user</a></li>";
           navbar+="<li class="+navlist.get(3)+"><a href='viewusers'>View Users</a></li>";
        }


        navbar+="      <li class=\"submenu\">                                                                  "+
                "            <a href=\"#\">&nbsp;Hi&nbsp;"+user.getUsername()+"&nbsp;</a>                            "+
                "                <ul>                                                                          "+
                "                    <li><a href=\"profile\">View Profile</a></li>                             "+
                "                    <li><a href=\"changepass\">Change Password</a></li>                       "+
                "                    <li><a onclick=\"document.forms['logoutForm'].submit()\">Sign Out</a></li>"+
                "                </ul>                                                                         "+
                "            </li>                                                                             "+
                "        </ul>                                                                                 "+
                "    </nav>                                                                                    "+
                "</header>                                                                                     ";
        return navbar;
    }
    
    public String getProfile(){
        String profile="";
        profile+="<p><b>User Name : </b>"+" "+user.getUsername()+"<br><b>Occupation : </b>"+" "+occupation+"<p>";
        return profile;
    }

    public String get404(){
        return "<div class=\"inner\">                                                              "+
                "  <header>                                                                         "+
                "     <h2>Error!</h2>                                                               "+
                "  </header>                                                                        "+
                "  <p>Requested Page Unavailable</p>                                                "+
                "  <footer>                                                                         "+
                "      <ul class=\"buttons vertical\">                                              "+
                "         <li><a href=\"welcome\" class=\"button fit scrolly\">Go Back Home</a></li>"+
                "      </ul>                                                                        "+
                "  </footer>                                                                        "+
                "</div>                                                                             ";
    }
    public String get403(){
        return "<div class=\"inner\">                                                              "+
                "  <header>                                                                         "+
                "     <h2>Error!</h2>                                                               "+
                "  </header>                                                                        "+
                "  <p>You Haven't Access to Requested Page</p>                                      "+
                "  <footer>                                                                         "+
                "      <ul class=\"buttons vertical\">                                              "+
                "         <li><a href=\"welcome\" class=\"button fit scrolly\">Go Back Home</a></li>"+
                "      </ul>                                                                        "+
                "  </footer>                                                                        "+
                "</div>                                                                             ";
    }
    
    
    
}
