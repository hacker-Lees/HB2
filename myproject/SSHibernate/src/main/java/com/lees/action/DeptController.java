package com.lees.action;

import com.lees.entity.Dept;
import com.lees.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
@Controller
@Transactional
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/showDepts")
    public ModelAndView showDepts() {
        List<Dept> depts = deptService.findAll();
        return new ModelAndView("/index.jsp", "depts", depts);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String addDept(Model model, Dept dept) {
        if (dept.getDname() != null) {
            deptService.AddDept(dept);
            List<Dept> depts = deptService.findAll();
            model.addAttribute("depts", depts);
            return "forward:/index.jsp";
        }else {
            String res="请输入要添加的部门信息";
            return "forward:/index.jsp";
        }
    }
}
