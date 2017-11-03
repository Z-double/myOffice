package cn.mylife.service.user.impl;

import cn.mylife.dao.daoImpl.BaseDao;
import org.springframework.stereotype.Service;
import cn.mylife.entity.Employee;
import cn.mylife.service.user.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<Employee> implements UserService{
    @Resource
    private BaseDao baseDao;
   /* public  void saveUser(Employee user){
            baseDao.save(user);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> aa =  baseDao.getAll(Employee.class);
        return aa;
    }

    @Override
    public void save(Employee employee) {

    }*/

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public Employee get(Serializable id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public void saveUser(Employee user) {

    }
}