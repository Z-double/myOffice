package cn.mylife.dao.daoImpl;

import cn.mylife.entity.Mynote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzz on 2017/11/2.
 */
@Repository("MyNoteDao")
public class MyNoteDao extends BaseDao<Mynote>{

   /* public List<Mynote> findByHQL(String hql, Object... params){
        List<Mynote> mynotes = new ArrayList<Mynote>();
        BaseDao baseDao = new BaseDao<>();
        mynotes = baseDao.findByHQL(hql);
        return mynotes;
    }*/
}
