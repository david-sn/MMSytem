package com.david.mmsystem.Controllers;

import com.david.mmsystem.Hibernate.Entity.Users;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembersController {

    @RequestMapping(value = "/")
    public String get2(Model M) {
        List<Users> list=new ArrayList<Users>();
        Users u1=new Users("r1", "asd", "email", "1", "", 1l, "as");
        Users u2=new Users("r2", "asd", "email", "2", "", 1l, "as");
        Users u3=new Users("r3", "asd", "email", "3", "", 1l, "as");
        Users u4=new Users("r4", "asd", "email", "4", "", 1l, "as");
         
        
        
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        M.addAttribute("k",list);
        
        return "MemberDetails";
    }

}
