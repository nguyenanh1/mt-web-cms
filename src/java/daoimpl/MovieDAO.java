/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IMovieDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Movie;
import util.DAOUtil;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class MovieDAO implements IMovieDAO {

    private static MovieDAO instance;

    public static MovieDAO getInstance() {
        if (instance == null) {
            instance = new MovieDAO();
        }
        return instance;
    }

    @Override
    public int save(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(movie);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movie> getMovie() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            String hql = "FROM Movie m ORDER BY m.timeCreate DESC";
            Query q = session.createQuery(hql);
            List<Movie> list = q.list();
            trans.commit();
            return list;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(movie);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        }
    }

    @Override
    public Movie findMovieById(Integer id) {
       String hql = "FROM Movie m where m.id = :id";
       Map<String,Object> map = new HashMap<>();
       map.put("id", id);
       Movie movie = (Movie) DAOUtil.getObeject(hql, map);
       return movie;
    }

    @Override
    public Movie findMovieByName(String name) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction trans = session.beginTransaction();
//        try {
//            
//            Query q = session.createQuery(hql);
//            q.setParameter("name", name);
//            Movie movie = (Movie) q.uniqueResult();
//            trans.commit();
//            return movie;
//        } catch (Exception e) {
//            e.printStackTrace();
//            trans.rollback();
//            return null;
//        }
        String hql = "FROM Movie m where m.name = :name";
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        Movie movie = (Movie) DAOUtil.getObeject(hql, map);
        return movie;
    }

    @Override
    public List<Movie> getMovieIsShowing(Integer partdate) {
        String hql = "From Movie m where m.partTime<= :partdate and m.status = 1";
        Map<String,Object> map = new HashMap<>();
        map.put("partdate",partdate);
        return DAOUtil.getList(hql, map);
    }
}
