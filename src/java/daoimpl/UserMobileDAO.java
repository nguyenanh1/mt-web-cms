/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IUserMobileDAO;
import java.util.List;
import pojos.User;
import util.DAOUtil;

/**
 *
 * @author Asus
 */
public class UserMobileDAO implements IUserMobileDAO {
    private static UserMobileDAO instance;
    
    private UserMobileDAO(){
    }
    
    public static UserMobileDAO getInstance(){
        if(instance==null){
            instance = new UserMobileDAO();
        }
        return instance;
    }
    
    @Override
    public int save(User u) {
        int save = DAOUtil.save(u);
        return save;
    }

    @Override
    public int update(User u) {
        int update = DAOUtil.update(u);
        return update;
    }

    @Override
    public int delete(User u) {
        int delete = DAOUtil.delete(u);
        return delete;
    }

    @Override
    public List<User> findAll() {
        String hql = "From User";
        List<User> mList = DAOUtil.getList(hql);
        return mList;
    }

}
