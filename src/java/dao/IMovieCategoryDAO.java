/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.Moviecategory;

/**
 *
 * @author Asus
 */
public interface IMovieCategoryDAO {
   int add(Moviecategory item);
   int edit(Moviecategory item);
   int delete(Moviecategory item);
   List<Moviecategory> findAllMovieCate(int idMovie);
}
