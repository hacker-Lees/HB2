package com.lees.dao;

import com.lees.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface DeptDao {
    void insertDept(Dept dept);
    Dept selectDeptByDeptno(int deptno);
    List<Dept> selectAll();
}
