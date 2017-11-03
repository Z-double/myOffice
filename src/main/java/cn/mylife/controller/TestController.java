package cn.mylife.controller;

import cn.mylife.entity.Employee;
import cn.mylife.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzz on 2017/8/7.
 */
@Controller
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping("save")
    public void save(){
        Employee user = new Employee();
        user.setId(2);
        user.setFirstName("test");
        user.setLastName("aa");
        user.setSalary(123);
        testService.saveUser(user);
        System.out.print("阿打发斯蒂芬");
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll() {
        System.out.print("!!!!!!!!!!!!!!!!!!!!!");
        List<Employee> aa = new ArrayList<Employee>();
       aa= testService.getAll();
       System.out.print("****************"+aa.toString());
       return aa;
    }
}
