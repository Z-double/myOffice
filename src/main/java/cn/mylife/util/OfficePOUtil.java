/*
package cn.mylife.util;

*/
/**
 * Created by yzz on 2017/11/2.
 *//*

public class OfficePOUtil {
    private static final ILog log = LogFactory.getInstance().getLog(OfficePOUtil.class);
    private IManager manager;

    public OfficePOUtil() {
    }

    public OfficePOUtil(IManager manager) {
        this.manager = manager;
    }

    public void updatePOProperty(Object o, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.update(o);
            this.getManager().commit();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public <T extends IManagedObject> T updatePO(T o, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.update(o);
            this.getManager().commit();
            o.setManager(manager);
            return o;
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public void updateByHql(String hql, Map params,String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
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
            this.getManager().commit();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     * 保存PO相关的扩展属性
     *
     * @param o
     * @param msg
     * @throws Exception
     *//*

    public void savePOExtProperty(Object o, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.save(o);
            this.getManager().commit();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public <T extends IManagedObject> T savePO(T o, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.save(o);
            this.getManager().commit();
            o.setManager(manager);
            return o;
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public Object getObjectById(Class clazz, long id) {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            return session.get(clazz, id);
        } catch (Exception e) {
            log.error("根据id获取对象异常");
            return null;
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }
    public Object getObjectById(Class clazz, int id) {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            return session.get(clazz, id);
        } catch (Exception e) {
            log.error("根据id获取对象异常");
            return null;
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }

    */
/**
     * 根据hql语句删除po对象 约定hql参数以id命名
     *
     * @param sql hql删除语句
     * @param id po的id
     * @param msg 删除错误的提示信息
     * @throws Exception
     *//*

    public void deletePOByHql(String sql, long id, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) this.getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.createQuery(sql).setLong(
                    "id", id).executeUpdate();
            this.getManager().commit();
            session.clear();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     * 通过session删除对象
     *
     * @param o 待删除的对象
     * @param msg 删除错时的异常信息
     * @return
     * @throws Exception
     *//*

    public void deletePOBySession(Object o, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) this.getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            session.delete(o);
            this.getManager().commit();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     * 根据hql来查询一个对象
     * @param hql
     * @param params
     * @param errorMsg
     * @return
     * @throws MobileManager
     *//*

    public Object queryObjectByHql(String hql, Map<String, Object> params, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
            return query.uniqueResult();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }
    */
/**
     * 根据hql来查询一个对象
     * @param hql
     * @param params
     * @param errorMsg
     * @return
     * @throws MobileManager
     *//*

    public Object queryObjectByHql(String hql, Map<String, Object> params, boolean cache, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
            if(cache) {
                query.setCacheable(true);
            }
            return query.uniqueResult();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public Object queryObjectByHql(String hql, String errorMsg)throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            Query query = session.createQuery(hql);
            return query.uniqueResult();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     * 根据hql来查询列表
     * @param hql
     * @param params
     * @param errorMsg
     * @return
     * @throws MobileManager
     *//*

    public List queryListByHql(String hql, Map<String, Object> params, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }
    public DeptMgr2 queryDeptMgr2ByHql(String hql, Map<String, Object> params, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
            return (DeptMgr2)query.uniqueResult();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }
    */
/**
     * 根据hql来查询列表
     * @param hql
     * @param params
     * @param errorMsg
     * @return
     * @throws MobileManager
     *//*

    public List queryListByHql(String hql, Map<String, Object> params, boolean cache, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
            if(cache) {
                query.setCacheable(true);
            }
            return query.list();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     * 根据hql来分页查询
     * @param hql
     * @param params
     * @param errorMsg
     * @param rowBeginIndex
     * @param rowCount
     * @return
     * @throws MobileManager
     *//*

    public List queryListByHql(String hql, Map<String, Object> params, String errorMsg,int rowBeginIndex, int rowCount) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
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
            query.setFirstResult(rowBeginIndex);
            query.setMaxResults(rowCount);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public List queryListByHql(String hql, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public List queryListByHql(String hql,String errorMsg,int rowBeginIndex, int rowCount) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            Query query = session.createQuery(hql);
            query.setFirstResult(rowBeginIndex);
            query.setMaxResults(rowCount);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    */
/**
     *
     * @param sql
     * @param id
     * @param msg
     * @throws MobileManager
     *//*

    public void deletePOByHql(String sql, Map params, String msg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) this.getManager().getCountedSessionMgr().openCountedTransactionalPM();
            getManager().beginTransaction();
            Query query = session.createQuery(sql);
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
            this.getManager().commit();
            session.clear();
        } catch (Exception e) {
            log.error(msg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
    }

    public List<Map<String,String>>  tongjiyp(String sql,List<String> param){

        HiberSession session = null;
        try {
            session = (HiberSession) this.getManager().getCountedSessionMgr().openCountedTransactionalPM();
            SQLQuery createSQLQuery = session.createSQLQuery(sql);
            for (int i = 0; i < param.size(); i++) {
                createSQLQuery.setString(i, param.get(i));
            }
            createSQLQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
            //执行查询
            List<Map<String,Object>> list = createSQLQuery.list();
            List<Map<String,String>> list2 = new ArrayList<Map<String,String>>();
            for (Map<String, Object> map : list) {
                Map<String, String> map2 = new HashMap<String, String>();
                map2.put("TYPENAME", (map.get("TYPENAME")==null?"":map.get("TYPENAME")).toString());
                map2.put("GOODSNAME", (map.get("GOODSNAME")==null?"":map.get("GOODSNAME")).toString());
                map2.put("SPECNAME", (map.get("SPECNAME")==null?"":map.get("SPECNAME")).toString());
                map2.put("COUNT", map.get("COUNT")==null?"0":map.get("COUNT").toString());
                list2.add(map2) ;
            }
            return list2;
        } catch (Exception e) {
            log.error( e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
        } finally {
            this.getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }
        return null;



    }
    */
/**
     * @return the manager
     *//*

    public YXManager getManager() {
        return (YXManager) manager;
    }

    */
/**
     * @param manager the manager to set
     *//*

    public void setManager(IManager manager) {
        this.manager = manager;
    }

    public TachePO loadTacheByCode(String hql, String code) {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            Query query = session.createQuery(hql);
            query.setString("code", code);
            return (TachePO) query.uniqueResult();
        } catch (Exception e) {
            log.error("根据code获取对象异常");
            return null;
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }

    public String queryObjectBySql(String sql, Map<String, Object> params,String errorMsg) throws YXException{
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            SQLQuery query = session.createSQLQuery(sql);
            String key = null;
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
                key = (String) iterator.next();
                if(params.get(key) instanceof List){
                    query.setParameterList(key, (List)params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
            return query.uniqueResult().toString();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }
    public List queryListBySql(String sql, Map<String, Object> params,String errorMsg) throws YXException{
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            SQLQuery query = session.createSQLQuery(sql);
            String key = null;
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
                key = (String) iterator.next();
                if(params.get(key) instanceof List){
                    query.setParameterList(key, (List)params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
            query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
            return query.list();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }

    public List<Map<String, Object>> findStudentPaymentCount(String sql,Map<String, Object> params, String errorMsg) throws YXException {
        HiberSession session = null;
        try {
            session = (HiberSession) getManager().getCountedSessionMgr().openCountedTransactionalPM();
            SQLQuery query = session.createSQLQuery(sql);
            String key = null;
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
                key = (String) iterator.next();
                if(params.get(key) instanceof List){
                    query.setParameterList(key, (List)params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
            query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
            return query.list();
        } catch (Exception e) {
            log.error(errorMsg, e);
            getManager().rollbackAndExCatch(this.getManager().getCountedSessionMgr(), e);
            throw new YXException(e);
        } finally {
            getManager().closeCountedSessionAndExCatch(this.getManager().getCountedSessionMgr());
        }

    }
}
*/
