package com.lees.dao.impl;

import com.lees.dao.DeptDao;
import com.lees.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@Repository
@Transactional
public class DeptDaoImpl implements DeptDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void insertDept(Dept dept) {
        getSession().save(dept);
    }

    public Dept selectDeptByDeptno(int deptno) {
        String hql = "from Dept d where deptno=:deptno";
        Query query = getSession().createQuery(hql).setParameter("deptno", deptno);
        Dept re = (Dept) query.uniqueResult();
        return re;
    }

    public List<Dept> selectAll() {
        String hql = "from Dept";
        Query query = getSession().createQuery(hql);
        List<Dept> list = query.list();
        return list;
    }
}
