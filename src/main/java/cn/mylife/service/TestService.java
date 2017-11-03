package cn.mylife.service;

import cn.mylife.entity.Employee;
import cn.mylife.dao.daoImpl.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yzz on 2017/8/7.
 */
@Service
public class TestService {
    @Resource
    private TestDao testDao;

    public  void saveUser(Employee user){
        testDao.save(user);
    }
    public List<Employee> getAll(){
        List<Employee> aa= testDao.getAll(Employee.class);
        return aa;
    }
}
