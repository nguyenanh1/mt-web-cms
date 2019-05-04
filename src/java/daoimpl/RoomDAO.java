/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IRoomDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Room;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class RoomDAO implements IRoomDAO {

    private static RoomDAO instance;

    public static RoomDAO getInstance() {
        if (instance == null) {
            instance = new RoomDAO();
        }
        return instance;
    }

    @Override
    public int save(Room room) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(room);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int update(Room room) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(room);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Room room) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.delete(room);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public Room findRoomById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM Room r where r.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            Room r = (Room) q.uniqueResult();
            trans.commit();
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

    @Override
    public List<Room> findAllRoom() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM Room";
            Query q = session.createQuery(hql);
            List<Room> mListRoom = q.list();
            trans.commit();
            return mListRoom;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

}
