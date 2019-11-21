package com.cyt.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author ${user}
 * @create 2019-11-21-11:05
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    static {
        sessionFactory=new Configuration().configure().buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }


    public static Session getSession() {
        return session;
    }


    public static Query getQuery(String hql){
        return session.createQuery(hql);
    }

    public static void closeSession() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
