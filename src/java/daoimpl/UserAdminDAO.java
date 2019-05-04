/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IUserAdminDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.UserAdmin;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class UserAdminDAO implements IUserAdminDAO {

    private static UserAdminDAO instance;

    public static final UserAdminDAO getInsance() {
        if (instance == null) {
            instance = new UserAdminDAO();
        }
        return instance;
    }

    @Override
    public int save(UserAdmin userAdmin) {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(userAdmin);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(UserAdmin userAdmin) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(userAdmin);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(UserAdmin userADmin) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.delete(userADmin);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<UserAdmin> getAllUserAdmin() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM UserAdmin";
            Query q = session.createQuery(hql);
            List<UserAdmin> mList = q.list();
            trans.commit();
            return mList;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserAdmin findUserAdmin(String username) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM UserAdmin u where u.username = :username";
            Query q = session.createQuery(hql);
            q.setParameter("username", username);
            UserAdmin u = (UserAdmin) q.uniqueResult();
            trans.commit();
            return u;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserAdmin findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM UserAdmin u where u.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            UserAdmin u = (UserAdmin) q.uniqueResult();
            trans.commit();
            return u;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
//        UserAdminDAO userAdminDao = UserAdminDAO.getInsance();
//        UserAdmin userAdmin = userAdminDao.findUserAdmin("systemad");
//        System.out.println(userAdmin.getPassword());
    }

}
