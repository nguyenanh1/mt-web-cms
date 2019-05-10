/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IUserAdminDAO;
import daoimpl.UserAdminDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.UserAdminMapping;
import pojos.UserAdmin;
import util.CommonUtils;
import util.CustomToken;

/**
 *
 * @author Asus
 */
public class UserService {

    //DANG NHAP
    public final static String LOGIN_USER_NOT_FOUND = "LOGIN_USER_NOT_FOUND";
    public final static String LOGIN_PASSWORD_WRONG = "LOGIN_PASSWORD_WRONG";
    public final static String LOGIN_IN_OTHER_DEVICE = "LOGIN_IN_OTHER_DEVICE";
    //CREATE ACCOUNT
    public final static String CREATE_ACCOUNT_SUCCSESS = "CREATE_ACCOUNT_SUCCSESS";
    public final static String CREATE_ACCOUNT_USER_CREATED = "CREATE_ACCOUNT_USER_CREATED";
    public final static String CREATE_ACCOUNT_FAIL = "CREATE_ACCOUNT_FAIL";

    private static UserService instance;

    private IUserAdminDAO mUserDAO;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public UserService() {
        mUserDAO = UserAdminDAO.getInsance();
    }

    public String login(String username, String password) {
        UserAdmin userAdmin = mUserDAO.findUserAdmin(username);
        if (userAdmin != null) {
            if (userAdmin.getPassword().equals(password)) {
                if (userAdmin.getToken() != null && !userAdmin.getToken().isEmpty()) {
                    CustomToken mToken = new CustomToken(userAdmin.getToken());
                    System.out.println(mToken.getToken());
                    if (!mToken.tokenTimeout()) {
                        return LOGIN_IN_OTHER_DEVICE;
                    } else {
                        CustomToken mTokenNew = new CustomToken(userAdmin.getId(), userAdmin.getUsername(), userAdmin.getRole(), System.currentTimeMillis(), CommonUtils.timeout);
                        userAdmin.setLastLogin(new Date());
                        userAdmin.setToken(mTokenNew.getToken());
                        mUserDAO.update(userAdmin);
                        return mTokenNew.getToken();
                    }
                } else {
                    CustomToken mToken = new CustomToken(userAdmin.getId(), userAdmin.getUsername(), userAdmin.getRole(), System.currentTimeMillis(), CommonUtils.timeout);
                    userAdmin.setToken(mToken.getToken());
                    mUserDAO.update(userAdmin);
                    return mToken.getToken();
                }
            } else {
                return LOGIN_PASSWORD_WRONG;
            }
        } else {
            return LOGIN_USER_NOT_FOUND;
        }
    }

    public int logout(int id) {
        UserAdmin userAdmin = mUserDAO.findById(id);
        userAdmin.setToken("");
        int update = mUserDAO.update(userAdmin);
        return update;
    }

    public boolean checkToken(Integer id, String token) {
        UserAdmin userAdmin = mUserDAO.findById(id);
        if (userAdmin.getToken().equals(token)) {
            return true;
        }
        return false;
    }

    public UserAdmin findByUser(String username) {
        UserAdmin userAdmin = mUserDAO.findUserAdmin(username);
        return userAdmin;
    }
    
    public Integer numUserAdmin(){
        return mUserDAO.getAllUserAdmin().size();
    }

    public List<UserAdminMapping> getAll() {
        List<UserAdmin> mListNoMap = mUserDAO.getAllUserAdmin();
        List<UserAdminMapping> mList = new ArrayList<>();
        if (mListNoMap != null && !mListNoMap.isEmpty()) {
            mListNoMap.stream().map((temp) -> {
                UserAdminMapping userAdmin = new UserAdminMapping();
                userAdmin.setId(temp.getId());
                userAdmin.setUsername(temp.getUsername());
                userAdmin.setName(temp.getName());
                userAdmin.setLastName(temp.getLastName());
                if(temp.getLastLogin()!=null){
                    userAdmin.setLastLogin(CommonUtils.formatDate(temp.getLastLogin()));
                }else{
                    userAdmin.setLastLogin("");
                }
                
                userAdmin.setPassword(temp.getPassword());
                userAdmin.setDisplayName(temp.getDisplayName());
                if(temp.getCreateTime()!=null){
                    userAdmin.setCreateTime(CommonUtils.formatDate(temp.getCreateTime()));
                }else{
                    userAdmin.setCreateTime("");
                }
                if(temp.getUpdateTime()!=null){
                    userAdmin.setUpdateTime(CommonUtils.formatDate(temp.getUpdateTime()));
                }else{
                    userAdmin.setUpdateTime("");
                }
                if (temp.getRole() == 1) {
                    userAdmin.setRole("Hệ thống");
                } else if (temp.getRole() == 2) {
                    userAdmin.setRole("Quản trị viên");
                } else {
                    userAdmin.setRole("Quản lý");
                }

                userAdmin.setToken(temp.getToken());
                UserAdmin temp1 = mUserDAO.findById(temp.getCreatBy());
                UserAdmin temp2 = mUserDAO.findById(temp.getUpdateBy());
                userAdmin.setUpdateBy(temp1.getDisplayName());
                userAdmin.setCreatBy(temp2.getDisplayName());
                return userAdmin;
            }).forEachOrdered((userAdmin) -> {
                mList.add(userAdmin);
            });
        }
        return mList;
    }

    public String createAccount(String username, String password, String name, String lastName, int role, int idCreater) {
        UserAdmin userAdmin = mUserDAO.findUserAdmin(username);
        if (userAdmin != null) {
            return CREATE_ACCOUNT_USER_CREATED;
        } else {
            UserAdmin newAdmin = new UserAdmin();
            newAdmin.setUsername(username);
            newAdmin.setPassword(password);
            newAdmin.setName(name);
            newAdmin.setLastName(lastName);
            newAdmin.setDisplayName(name + " " + lastName);
            newAdmin.setRole(role);
            Date currentTime = new Date();
            newAdmin.setCreateTime(currentTime);
            newAdmin.setUpdateTime(currentTime);
            newAdmin.setCreatBy(idCreater);
            newAdmin.setUpdateBy(idCreater);
            int add = mUserDAO.save(newAdmin);
            if (add == 1) {
                return CREATE_ACCOUNT_SUCCSESS;
            } else {
                return CREATE_ACCOUNT_FAIL;
            }
        }
    }
}
