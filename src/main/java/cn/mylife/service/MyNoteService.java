package cn.mylife.service;

import cn.mylife.dao.daoImpl.MyNoteDao;
import cn.mylife.entity.Mynote;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yzz on 2017/11/2.
 */
@Service
public class MyNoteService {
    @Resource
    private MyNoteDao myNoteDao;

    public  void saveMynote(Mynote Mynote){
        myNoteDao.save(Mynote);
    }
    public List<Mynote> listMyNote(){
        List<Mynote> mynotes= myNoteDao.findByHQL("From Mynote where 1=1");
        return mynotes;
    }
}
