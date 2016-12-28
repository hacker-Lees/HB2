package com.lees.service.impl;

import com.lees.dao.DeptDao;
import com.lees.entity.Dept;
import com.lees.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@Service

public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    public void AddDept(Dept dept) {
        deptDao.insertDept(dept);
    }

    public Dept finsDeptByDeptno(int deptno) {
        return deptDao.selectDeptByDeptno(deptno);
    }

    @Transactional
    public List<Dept> findAll() {
        return deptDao.selectAll();
    }
}
