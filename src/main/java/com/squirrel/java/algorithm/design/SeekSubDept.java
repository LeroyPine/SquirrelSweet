package com.squirrel.java.algorithm.design;


import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找子部门
 *
 * @author luobaosong
 * @date 2022/11/15 11:26
 * @description
 **/
@Slf4j
public class SeekSubDept {


    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);

        List<Department> subDept = getSub(1, allDepartment);
        log.info("subDept:{}", JSON.toJSONString(subDept));
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * 要求：不能新增参数，不能增加static变量
     *
     * @param id            id
     * @param allDepartment 所有部门
     * @return {@link List}<{@link Department}>
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        // 寻找 pid = id 的部门
        // 首先获取当前id子部门，然后在获取子部门的子部门
        List<Department> departmentList = Lists.newArrayList();
        doSub(departmentList, id, allDepartment);
        return departmentList;
    }

    private static void doSub(List<Department> departmentList, int id, List<Department> allDepartment) {
        // 递归终止条件,获取不到pid为id的元素了
        for (Department department : allDepartment) {
            if (department.getPid() == id) {
                departmentList.add(department);
                doSub(departmentList, department.getId(), allDepartment);
            }
        }
    }

}
