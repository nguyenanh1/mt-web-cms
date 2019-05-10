/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IMovieTimeDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Movietime;
import util.DAOUtil;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class MovieTimeDAO implements IMovieTimeDAO{
    private static MovieTimeDAO instance;
    
    public static MovieTimeDAO getInstance(){
        if(instance==null){
            instance = new MovieTimeDAO();
        }
        return instance;
    }
    
    private MovieTimeDAO(){
        
    }
    
    @Override
    public int add(Movietime movietime) {
        return DAOUtil.save(movietime);
    }

    @Override
    public int update(Movietime movietime) {
         return DAOUtil.update(movietime);
    }

    @Override
    public int delete(Movietime movietime) {
        return DAOUtil.delete(movietime);
    }

    @Override
    public List<Movietime> findByIdRoom(Integer idRoom,Integer dateStart) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = s.beginTransaction();
        try {
            String hql = "From Movietime m where m.idRoom = :idRoom and m.dateStart> :dateStart";
            Query q = s.createQuery(hql);
            q.setParameter("idRoom", idRoom);
            q.setParameter("dateStart", dateStart);
            List<Movietime> movitTimes = q.list();
            trans.commit();
            return movitTimes;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }

    @Override
    public List<Movietime> checkMovieTime(Integer idRoom, Integer dateStart, Integer timeStart,Integer timeEnd) {
        String hql = "From Movietime m where m.idRoom = :idRoom and m.dateStart = :dateStart and m.timeStart>= :timeStart and m.timeStart< :timeEnd";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("idRoom", idRoom);
        map.put("dateStart", dateStart);
        map.put("timeStart", timeStart);
        map.put("timeEnd", timeEnd);
        List<Movietime> mMovieTimes = DAOUtil.getList(hql, map);
        return mMovieTimes;
    }

    @Override
    public List<Movietime> findAll() {
        String hql = "From Movietime m ORDER BY m.timeCreate DESC";
        List<Movietime> mMovieTime = DAOUtil.getList(hql);
        return mMovieTime;
    }

    @Override
    public List<Movietime> findByIdMovie(Integer idMovie, Integer dateStart) {
        String hql = "From Movietime m where m.idMovie = :idMovie and m.dateStart= :dateStart";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("idMovie", idMovie);
        map.put("dateStart", dateStart);
        List<Movietime> mMovieTimes = DAOUtil.getList(hql, map);
        return mMovieTimes;
    }

    @Override
    public Movietime findById(int idMovieTime) {
        String hql  = "From Movietime m where m.id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id", idMovieTime);
        Movietime m = (Movietime) DAOUtil.getObeject(hql, map);
        return m;
    }
    
}
