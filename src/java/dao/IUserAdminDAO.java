/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.UserAdmin;

/**
 *
 * @author Asus
 */
public interface IUserAdminDAO {
    int save(UserAdmin userAdmin);
    int update(UserAdmin userAdmin);
    int delete(UserAdmin userADmin);
    List<UserAdmin> getAllUserAdmin();
    UserAdmin findUserAdmin(String username);
    UserAdmin findById(Integer id);
}
