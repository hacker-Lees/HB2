package com.lees.service;

import com.lees.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface DeptService {
    void AddDept(Dept dept);
    Dept finsDeptByDeptno(int deptno);
    List<Dept> findAll();
}
