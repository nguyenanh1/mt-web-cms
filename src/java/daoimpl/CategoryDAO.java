/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ICategoryDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Category;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class CategoryDAO implements ICategoryDAO {

    private static CategoryDAO instatnce;

    public static CategoryDAO getInstance() {
        if (instatnce == null) {
            instatnce = new CategoryDAO();
        }
        return instatnce;
    }

    @Override
    public int add(Category category) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.save(category);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int edit(Category category) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.update(category);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Category category) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            s.delete(category);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public List<Category> getAll() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            String hql = "FROM Category c";
            Query q = s.createQuery(hql);
            List<Category> mList = q.list();
            trans.commit();
            return mList;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

    @Override
    public Category findById(Integer id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            String hql = "FROM Category c where c.id = :id";
            Query q = s.createQuery(hql);
            q.setInteger("id", id);
            Category category = (Category) q.uniqueResult();
            trans.commit();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

}
