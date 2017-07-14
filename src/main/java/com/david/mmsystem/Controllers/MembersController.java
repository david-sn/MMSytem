package com.david.mmsystem.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MembersController {

    @RequestMapping(value = "/a")
    public String get2() {

        return "MemberDetails";
    }
 

}
