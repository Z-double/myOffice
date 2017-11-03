package cn.mylife.controller;

import cn.mylife.entity.Mynote;
import cn.mylife.service.MyNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yzz on 2017/11/2.
 */
@Controller
@RequestMapping(value = "/_web/mynote")
public class MyNoteController {
    @Resource
    private MyNoteService myNoteService;
    @RequestMapping(value = "addMyNote.rst",method = RequestMethod.GET)
    public void addMyNote(){
        Mynote aa = new Mynote();
        aa.setCreateuser("user1");
        aa.setNotetitle("购物");
        myNoteService.saveMynote(aa);
    }
    @RequestMapping(value = "getAllNote.rst",method = RequestMethod.GET)
    public void getAllNote(){
        List<Mynote> mynotes = myNoteService.listMyNote();
        for (Mynote mynote :mynotes){
            System.out.print(mynote);
        }
    }
}
