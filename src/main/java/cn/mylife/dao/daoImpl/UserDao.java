package cn.mylife.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cn.mylife.entity.Employee;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yzz on 2017/8/10.
 */
public class UserDao  extends BaseDao<Employee> {
   /* @Resource
    private SessionFactory sessionFactory;
    public List<Employee> getAll(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Employee";
        List<Employee> employees =  session.createQuery(hql).list();
        return  employees;
    }*/
}
