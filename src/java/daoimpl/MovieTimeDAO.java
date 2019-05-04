/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IMovieTimeDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Movietime;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Movietime movietime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Movietime movietime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
