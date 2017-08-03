package com.david.mmsystem.Controllers;

import com.david.mmsystem.Hibernate.Entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MembersController {
List<Users> list = new ArrayList<Users>();
    @RequestMapping(value = "/")
    public String get2(Model M) {
        list.removeAll(list);
        
        Users u1 = new Users("r1", "asd", "email", "1", "", 1l, "as");
        Users u2 = new Users("r2", "asd", "email", "2", "", 1l, "as");
        Users u3 = new Users("r3", "asd", "email", "3", "", 1l, "as");
        Users u4 = new Users("r4", "asd", "email", "4", "", 1l, "as");

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        M.addAttribute("k", list);

        return "MemberDetails";
    }

    @RequestMapping(value = "/addmember", method = RequestMethod.POST)
    @ResponseBody
    public Users addMember(@RequestBody Users user,HttpServletRequest r) {
       list.add(user);
        System.out.println(r.getHeaderNames().nextElement());
       user.setName("000000000");
        return user;
    }

    @RequestMapping(value = "/updatemember", method = RequestMethod.POST)
    @ResponseBody
    public Users UpdateMember(@RequestBody Users user) {
        System.out.println(user.getName());
        System.out.println("Memeber Updated********");
        return user;
    }

    @RequestMapping(value = "/deletemember", method = RequestMethod.POST)
    @ResponseBody
    public Users DeleteMember(@RequestBody Users user) {
        System.out.println(user.getName());
        System.out.println("Memeber Deleted********");
        return user;
    }

    @RequestMapping(value = "/searchmember", method = RequestMethod.POST)
    @ResponseBody
    public List<Users> SearchMember(@RequestBody Users user) {
        System.out.println(user.getName());
        System.out.println("Memeber Deleted********");
        List<Users> list = new ArrayList<Users>();
        Users u1 = new Users("NEW1", "asd", "email", "1", "", 1l, "as");
        Users u2 = new Users("NEW", "asd", "email", "2", "", 1l, "as");
        Users u3 = new Users("NEW", "asd", "email", "3", "", 1l, "as");
        Users u4 = new Users("NEW", "asd", "email", "4", "", 1l, "as");

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        return list;

    }

}
