/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IMovieCategoryDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Moviecategory;
import util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class MovieCategoryDAO implements IMovieCategoryDAO {

    private static MovieCategoryDAO instance;

    public static MovieCategoryDAO getInstance() {
        if (instance == null) {
            instance = new MovieCategoryDAO();
        }
        return instance;
    }

    @Override
    public int add(Moviecategory item) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(item);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();;
            trans.rollback();
            return 0;
        }
    }

    @Override
    public int edit(Moviecategory item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Moviecategory item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Moviecategory> findAllMovieCate(int idMovie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
