package com.cyt.dao;

import com.cyt.entity.Emp;

import java.util.List;

/**
 * @author ${user}
 * @create 2019-11-21-11:02
 */
public interface EmpDao {

    List<Emp> selectAll();
}
