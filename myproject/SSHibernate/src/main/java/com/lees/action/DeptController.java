package com.lees.action;

import com.lees.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/27.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/add")
    public void addDept() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();

            Dept dept = new Dept();
            dept.setDeptno(10);
            dept.setDname("ACCOUNTING");
            dept.setLoc("NEWYORK");
            session.save(dept);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            tx = null;
            session.close();
        }
    }
}
