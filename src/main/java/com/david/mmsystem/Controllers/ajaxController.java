package com.david.mmsystem.Controllers;

import com.david.mmsystem.Hibernate.Entity.Users;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ajaxController {

    @RequestMapping(value = "/home")
    public String get() {
        return "body2";
    }

    @ModelAttribute("user")
    public Users getUsers() {
        return new Users();
    }
 

    @RequestMapping(value = "/submitForm.web", method = RequestMethod.POST)
    @ResponseBody
    public Users submittedFromData(@RequestBody Users user, HttpServletRequest request) {
        System.out.println(user.getName());
        System.out.println(request.getParameter("name"));
        return user;
    }

}
