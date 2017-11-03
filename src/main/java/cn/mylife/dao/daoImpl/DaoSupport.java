package cn.mylife.dao.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.mylife.dao.IBaseDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("daoSupport")
public class DaoSupport implements IBaseDAO {

	/**
	 * 向DAO层注入SessionFactory
	 */
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */

	/**
	 * 获取当前工作的Session
	 */
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession()
	}

	public Object save(String str, Object obj) throws Exception {
		return this.getSession().save(str,obj);
	}
	
	/**
	 * 批量更新
	 * @param str
	 * @param objs
	 * @return
	 * @throws Exception
	 */
	public Object batchSave(String str, List objs )throws Exception{
		for (Object obj :objs){
			return this.getSession().save(obj);
		}
	}
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void update(String str, Object obj) throws Exception {
		this.getSession().update(str,obj);
	}

	/**
	 * 批量更新
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public void batchUpdate(String hql, Map params )throws Exception{
		//批量执行器
		Session session = this.getSession();
		try{
			Query query = session.createQuery(hql);
			String key = null;
			for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
				key = (String) iterator.next();
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				} else {
					query.setParameter(key, params.get(key));
				}
			}
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 批量更新
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object batchDelete(String str, List objs )throws Exception{
		return sqlSessionTemplate.delete(str, objs);
	}
	
	/**
	 * 删除对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}
	 
	/**
	 * 查找对象
	 * @param hql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String hql, Object obj) throws Exception {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		return query.uniqueResult();
	}

	/**
	 * 查找对象
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String hql,Map<String, Object> params) throws Exception {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		String key = null;
		for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
			key = (String) iterator.next();
			if(params.get(key) instanceof List){
				query.setParameterList(key, (List)params.get(key));
			} else {
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}
	
	public Object findForMap(String str, Object obj, String key, String value) throws Exception {
		return sqlSessionTemplate.selectMap(str, obj, key);
	}
	
}


