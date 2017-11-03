package cn.mylife.dao.daoImpl;

import java.util.List;
import javax.annotation.Resource;
import cn.mylife.dao.IBaseDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * dao层基类，实现增，删，改，查等常用功能。
 *
 * @param <T>
 * @author zz
 * @version 0.0.1
 * @date 2015年5月6日 下午5:24:08
 */
@Repository("BaseDao")
public class BaseDao<T> implements IBaseDao<T>{

    private Class<T> clazz;

    /**
     * 通过构造方法指定DAO的具体实现类
     */
/*    public BaseDao() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        System.out.println("DAO的真实实现类是：" + this.clazz.getName());
    }*/

    /**
     * 向DAO层注入SessionFactory
     */
    @Resource
    private SessionFactory sessionFactory;

    /**
     * 获取当前工作的Session
     */
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        this.getSession().save(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void delete(int id) {
        this.getSession().delete(this.findById(id));
    }

    public T findById(int id) {
        return (T) this.getSession().get(this.clazz, id);
    }

    public List<T> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }


    @Override
    public T makePersitent(T entity) {
        return null;
    }

    @Override
    public void makeTransient(T entity) {

    }

    @Override
    public void makeTransientByIds(String sql) {

    }

    @Override
    public List<T> findByPage(String hql, int offset, int pageSize) {
        return null;
    }

    @Override
    public List<T> findByPage(String hql, Object value, int offset, int pageSize) {
        return null;
    }

    @Override
    public List<T> findByPage(String hql, Object[] values, int offset, int pageSize) {
        return null;
    }

    @Override
    public List findByPageSQL(String sql, int offset, int pageSize) {
        return null;
    }

    @Override
    public Integer getCount(String hql) {
        return null;
    }

    @Override
    public void updateObj(String hql, Object[] values) {

    }

    @Override
    public int deleteByPrimaryKey(int Id) {
        return 0;
    }
}