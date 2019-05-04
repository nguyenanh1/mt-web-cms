/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICategoryDAO;
import dao.IUserAdminDAO;
import daoimpl.CategoryDAO;
import daoimpl.UserAdminDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.CategoryUser;
import pojos.Category;
import pojos.UserAdmin;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class CategoryService {
    private static CategoryService instance;
    
    private ICategoryDAO mCategoryDAO;
    private IUserAdminDAO mAdminDAO;
    
    public static CategoryService getInstance(){
        if(instance == null){
            instance = new CategoryService();
        }
        return instance;
    }

    public CategoryService() {
        mCategoryDAO = CategoryDAO.getInstance();
        mAdminDAO = UserAdminDAO.getInsance();
    }
    
    public List<Category> getAllCate(){
        return mCategoryDAO.getAll();
    }
    
    public List<CategoryUser> getAllCateUser(){
        List<Category> mListCate = mCategoryDAO.getAll();
        List<CategoryUser> mList = new ArrayList<>();
        for(Category c: mListCate){
            CategoryUser categoryUser = new CategoryUser();
            categoryUser.setId(c.getId());
            categoryUser.setCategoryName(c.getName());
            categoryUser.setTimeCreate(CommonUtils.formatDate(c.getTimeCreate()));
            UserAdmin create = mAdminDAO.findById(c.getCreateBy());
            if(create!=null){
                categoryUser.setUserCreate(create.getDisplayName());
            }else{
                categoryUser.setUserCreate("");
            }
            categoryUser.setTimeUpdate(CommonUtils.formatDate(c.getTimeUpdate()));
            UserAdmin update = mAdminDAO.findById(c.getUpdateBy());
            if(update!=null){
                categoryUser.setUserUpdate(update.getDisplayName());
            }else{
                categoryUser.setUserUpdate("");
            }
            mList.add(categoryUser);
        }
        return mList;
    }
    
    public Category findById(Integer id){
       return mCategoryDAO.findById(id);
    }

    public int delete(int id) {
        Category cate = mCategoryDAO.findById(id);
        int delete = mCategoryDAO.delete(cate);
        return delete;
    }

    public int add(String name,Integer idUser) {
        Category category  = new Category();
        category.setName(name);
        Date date = new Date();
        category.setCreateBy(idUser);
        category.setUpdateBy(idUser);
        category.setTimeCreate(date);
        category.setTimeUpdate(date);
        int add = mCategoryDAO.add(category);
        return add;
    }

    public int update(int idUser, int id, String nameUpdate) {
        Category category = mCategoryDAO.findById(id);
        category.setName(nameUpdate);
        category.setTimeUpdate(new Date());
        category.setUpdateBy(idUser);
        int update = mCategoryDAO.edit(category);
        return update;
    }
}
