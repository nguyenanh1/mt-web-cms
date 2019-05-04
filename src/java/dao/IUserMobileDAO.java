/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.User;

/**
 *
 * @author Asus
 */
public interface IUserMobileDAO {
    int save(User u);
    int update(User u);
    int delete(User u);
    List<User> findAll();
}
