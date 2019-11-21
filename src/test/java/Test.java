import com.cyt.entity.Emp;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;
import org.junit.After;
import org.junit.Before;

import java.util.List;


public class Test {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void before(){
        sessionFactory=new Configuration().configure().buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }


    @org.junit.Test
    public void test() {

        //6.1执行查询（查询单个数据）
        Emp emp1 = session.get(Emp.class, 30);
        System.out.println("emp1="+emp1);
        //提交事务，将session关闭
        /*transaction.commit();
        session.close();
        session=sessionFactory.openSession();
        transaction= session.beginTransaction();*/
        //6.2执行查询 get(要查询的实体类型，参数)   单个查询
        Emp emp = session.get(Emp.class, 30);
        System.out.println("emp="+emp);
        //6.3查询单个    hql语句
        Query query = session.createQuery("from Emp where id=30");
        Object o = query.uniqueResult();
        System.out.println("o="+o);



        //6.4查询全部
        Query query1 = session.createQuery("from Emp");
        List<Emp> list = query1.list();
        for (Emp emp2 :list) {
            System.out.println("emp2="+emp2);
        }
        //6.5查询全部
        SQLQuery sqlQuery=session.createSQLQuery("select * from emp");
        sqlQuery.addEntity(Emp.class);
        List<Emp> list1 = sqlQuery.list();
        for (Emp emp2 :list1) {
            System.out.println("emp2="+emp2);
        }


    }


    /**
     * 增加
     */
    @org.junit.Test
    public void insert(){
        Emp emp=new Emp();
        emp.setEname("koko");
        emp.setEpwd("123");
        emp.setEmoney("666666");
        session.save(emp);
        System.out.println("emp="+emp);

    }


    /**
     * 删除: 先查询，在删除
     */
    @org.junit.Test
    public void delete(){
        Emp emp = session.load(Emp.class, 22);
        if (emp!=null){
            session.delete(emp);
        }
    }


    /**
     * 修改：先查询，在修改
     */
    @org.junit.Test
    public void update(){
        Emp emp = session.load(Emp.class, 32);
        emp.setEname("koko");
        session.update(emp);
    }


    /**
     * saveOrUpdate: 新增或修改
     */
    @org.junit.Test
    public void testSaveOrUpdate(){
        Emp emp = new Emp();
        emp.setEname("lang");
        session.saveOrUpdate(emp);
    }


   @After
    public void after(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}