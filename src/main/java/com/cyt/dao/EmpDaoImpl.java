package com.cyt.dao;

import com.cyt.entity.Emp;
import com.cyt.util.HibernateUtils;
import org.hibernate.Query;

import java.util.List;

/**
 * @author ${user}
 * @create 2019-11-21-11:03
 */
public class EmpDaoImpl implements EmpDao {

    public List<Emp> selectAll() {
        //1.创建hql语句
        String hql = "from Emp";
        //2.创建query对象
        Query query = HibernateUtils.getQuery(hql);
        //3.进行查询
        List<Emp> list = query.list();
        //4.关闭
        HibernateUtils.closeSession();
        return list;
    }
}
