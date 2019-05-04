/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.Category;

/**
 *
 * @author Asus
 */
public interface ICategoryDAO {
    int add(Category category);
    int edit(Category category);
    int delete(Category category);
    List<Category> getAll();
    Category findById(Integer id);
    
}
