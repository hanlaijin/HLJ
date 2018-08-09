package com.hlj.thrift;

import com.hlj.thrift.dao.TI;
import com.hlj.thrift.dao.TIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-18.
 */
@Controller
public class TestController {

    @Autowired
    private TIRepository tiRepository;

    @RequestMapping("/test")
    public
    @ResponseBody
    void searchUser() {
        int count = 0;
        List<TI> list = new LinkedList<>();
        for (int i = 0; i < 100000000; i++) {
            TI ti = new TI(i, i);
            list.add(ti);
            if (count++ == 10000) {
                System.out.println(i);
                count = 0;
                tiRepository.saveAll(list);
                list.clear();
            }
        }
    }

}