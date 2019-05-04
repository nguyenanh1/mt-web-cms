/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.Movie;

/**
 *
 * @author Asus
 */
public interface IMovieDAO {
    int save(Movie movie);
    int update(Movie movie);
    int delete(int id);
    List<Movie> getMovie();
    Movie findMovieById(Integer id);
    Movie findMovieByName(String name);
    List<Movie> getMovieIsShowing(Integer partdate);
}
