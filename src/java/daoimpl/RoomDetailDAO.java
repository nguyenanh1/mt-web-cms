/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IRoomDetailDAO;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.ZoomDetail;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class RoomDetailDAO implements IRoomDetailDAO {

    private static RoomDetailDAO instance;

    public static RoomDetailDAO getInstance() {
        if (instance == null) {
            instance = new RoomDetailDAO();
        }
        return instance;
    }

    private RoomDetailDAO() {

    }

    @Override
    public int save(ZoomDetail zomDetail) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(zomDetail);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int update(ZoomDetail zomDetail) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(zomDetail);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int delete(ZoomDetail zomDetail) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.delete(zomDetail);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public ZoomDetail findById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM ZoomDetail zd where zd.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            ZoomDetail z = (ZoomDetail) q.uniqueResult();
            trans.commit();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

    @Override
    public List<ZoomDetail> findAllByIdRoom(int idRoom) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM ZoomDetail zd where zd.room = :idRoom";
            Query q = session.createQuery(hql);
            q.setParameter("idRoom", idRoom);
            List<ZoomDetail> zs = q.list();
            trans.commit();
            return zs;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

    @Override
    public List<ZoomDetail> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM ZoomDetail";
            Query q = session.createQuery(hql);
            List<ZoomDetail> zs = q.list();
            trans.commit();
            return zs;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

}
