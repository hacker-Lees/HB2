package com.lees.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/22.
 */
@Entity
@NamedQuery(name = "queryEmps",query = "from Emp")
@Table(name = "tb_emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private Date hiredate;
    private float sal;
    private float comms;

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComms() {
        return comms;
    }

    public void setComms(float comms) {
        this.comms = comms;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp2{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", mgr='" + mgr + '\'' +
                ", sal=" + sal +
                ", comms=" + comms +
                '}';
    }
    ///////////////////////////////////////////////////
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deptno")
    private Dept dept;
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
