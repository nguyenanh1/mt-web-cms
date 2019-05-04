/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IUserMobileDAO;
import daoimpl.UserMobileDAO;
import java.util.List;
import pojos.User;

/**
 *
 * @author Asus
 */
public class UserMobileService {
    private static UserMobileService instance;
    
    private IUserMobileDAO mobileDAO; 
    
    private UserMobileService(){
        mobileDAO = UserMobileDAO.getInstance();
    }
    
    public static UserMobileService getInstance(){
        if(instance==null){
            instance = new UserMobileService();
        }
        return instance;
    }
    
    public List<User> getAll(){
        return mobileDAO.findAll();
    }
    
    public Integer numUserMobile(){
        return getAll().size();
    }
}
