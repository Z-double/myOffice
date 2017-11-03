package cn.mylife.controller;

import cn.mylife.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.mylife.entity.Employee;
import java.util.List;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ModelAndView saveUser() {
        Employee user = new Employee();
        user.setId(1);
        user.setFirstName("test2452");
        userService.save(user);
        ModelAndView view = new ModelAndView("/jsp/testPage.jsp");
        System.out.println("-- 访问成功 !@!!!!--!!!!!!");
        return view;
    }

    @RequestMapping(value = "getAllEmployees",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll(){
       List<Employee> users =  userService.getAll();
       return users;
    }

}