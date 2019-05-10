/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Movietime;
import pojos.UserAdmin;

/**
 *
 * @author Asus
 */
public class DAOUtil {


    public static int save (Object object){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.save(object);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int update (Object object){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.update(object);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int delete (Object object){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.delete(object);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }
    
    public static Object getObject(String hql) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            Query q = s.createQuery(hql);
            Object o = q.uniqueResult();
            trans.commit();
            return o;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public static Object getObeject(String hql, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans = s.beginTransaction();
            try {
                Query q = s.createQuery(hql);
                map.forEach((key, value) -> {
                    q.setParameter(key, value);
                });
                Object o = q.uniqueResult();
                trans.commit();
                return o;
            } catch (Exception e) {
                trans.rollback();
                e.printStackTrace();
                return null;
            }
        } else {
            return getObject(hql);
        }
    }

    public static List getList(String hql) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            Query q = s.createQuery(hql);
            List list = q.list();
            trans.commit();
            return list;
        } catch (Exception e) {
            trans.rollback();
            return null;
        }
    }

    public static List getList(String hql, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans = s.beginTransaction();
            try {
                Query q = s.createQuery(hql);
                map.forEach((key, value) -> {
                    q.setParameter(key, value);
                });
                List list = q.list();
                trans.commit();
                return list;
            } catch (Exception e) {
                trans.rollback();
                e.printStackTrace();
                return null;
            }
        } else {
            return getList(hql);
        }
    }
    
//    public static List<Class<?>> getList(String hql,Class<?> cls){
//        s = HibernateUtil.getSessionFactory().getCurrentSession();
//        trans = s.beginTransaction();
//        try{
//            Query q = s.createQuery(hql);
//            List<cls> list = (List<cls>)q.list();
//            trans.commit();
//            return list;
//        }catch(Exception e){
//            trans.rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }


}
