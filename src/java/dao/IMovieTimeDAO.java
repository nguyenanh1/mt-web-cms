/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.Movietime;

/**
 *
 * @author Asus
 */
public interface IMovieTimeDAO {
    int add(Movietime movietime);
    int update(Movietime movietime);
    int delete(Movietime movietime);
    Movietime findById(int idMovieTime);
    List<Movietime> findByIdRoom(Integer idRoom, Integer dateStart);
    List<Movietime> checkMovieTime(Integer idRoom, Integer dateStart, Integer timeStart, Integer timeEnd);
    List<Movietime> findAll();
    List<Movietime> findByIdMovie(Integer idMovie,Integer dateStart);
}
