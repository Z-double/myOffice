package cn.mylife.dao.daoImpl;

import cn.mylife.entity.Mynote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import cn.mylife.entity.Employee;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yzz on 2017/8/7.
 */
@Repository("TestDao111")
public class TestDao extends BaseDao<Employee> {
  /*  @Resource
    private SessionFactory sessionFactory;
    *//**
     * gerCurrentSession 会自动关闭session，使用的是当前的session事务
     *
     * @return
     *//*
    public Session getSession() {
        //事务必须是开启的，否则获取不到
        return sessionFactory.getCurrentSession();
    }*/
    public void flush() {
        getSession().flush();
    }
    public void clear() {
        getSession().clear();
    }
    public void save(Employee employee){
        Session session = getSession();
        session.save(employee);
    }

    public List<Employee> getAll(Class<Employee> clazz) {
        System.out.print("dasgagadgadg**********");
        String hql = "from " + clazz.getName();
        Session session = getSession();
        return session.createQuery(hql).list();
    }
}
