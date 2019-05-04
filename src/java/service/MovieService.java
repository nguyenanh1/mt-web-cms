/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IMovieCategoryDAO;
import dao.IMovieDAO;
import daoimpl.MovieCategoryDAO;
import daoimpl.MovieDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojos.Movie;
import pojos.Moviecategory;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class MovieService {

    private static MovieService instance;

    private IMovieDAO mMovieDAO;
    private IMovieCategoryDAO mMovieCateDAO;

    public static MovieService getInstance() {
        if (instance == null) {
            instance = new MovieService();
        }
        return instance;
    }

    private MovieService() {
        mMovieDAO = MovieDAO.getInstance();
        mMovieCateDAO = MovieCategoryDAO.getInstance();
    }

    public List<Movie> getAllMovie() {
        return mMovieDAO.getMovie();
    }
    
    public List<Movie> getListMovieIsShowing(){
        return mMovieDAO.getMovieIsShowing(CommonUtils.getPartDate(new Date()));
    }

    public Integer getSize(){
        return getListMovieIsShowing().size();
    }
    
    public int add(String name, int old, int datestart, int timestart, List<Integer> cates, String director, String actor, String trailer, String thumb, String image, String content, Integer id) {
        Movie m = new Movie();
        m.setStatus(1);
        m.setName(name);
        m.setOld(old);
        m.setPartTime(datestart);
        m.setTime(timestart);
        m.setDirector(director);
        m.setActor(actor);
        m.setTrailer(trailer);
        m.setThumb(thumb);
        m.setImageUrl(image);
        m.setContain(content);
        Date currentTime = new Date();
        m.setView(0L);
        m.setTimeCreate(currentTime);
        m.setCreateBy(id);
        m.setTimeUpdate(currentTime);
        m.setUpdateBy(id);
        int saveMovie = mMovieDAO.save(m);
        if (saveMovie == 1) {
            int idMovie = m.getId();
            for (Integer item : cates) {
                Moviecategory movieCate = new Moviecategory();
                movieCate.setIdMovie(idMovie);
                movieCate.setIdCategory(item);
                mMovieCateDAO.add(movieCate);
            }
            return 1;
        } else {
            return 0;
        }

    }
}
