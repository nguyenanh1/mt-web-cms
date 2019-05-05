/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IMovieDAO;
import dao.IMovieTimeDAO;
import dao.IRoomDAO;
import dao.IRoomDetailDAO;
import dao.ITicketDAO;
import daoimpl.MovieDAO;
import daoimpl.MovieTimeDAO;
import daoimpl.RoomDAO;
import daoimpl.RoomDetailDAO;
import daoimpl.TicketDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojos.Movie;
import pojos.Movietime;
import pojos.Room;
import pojos.Ticket;
import pojos.ZoomDetail;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class MovieTimeService {

    private static MovieTimeService instance;

    private IMovieTimeDAO mMovieTimeDAO;
    private IMovieDAO mMovieDAO;
    private IRoomDetailDAO mRoomDetailDAO;
    private IRoomDAO mRoomDAO;
    private ITicketDAO mTicketDAO;

    public static final Integer SUCCESS = 0;
    public static final Integer MOVIE_NOT_EXIST = 1;
    public static final Integer MOVIE_TIME_EXIXTS = 2;
    public static final Integer ZOOM_NOT_USED = 3;
    public static final Integer ZOOM_NOT_EXIST = 4;
    public static final Integer FAIL = 5;

    public static MovieTimeService getIntance() {
        if (instance == null) {
            instance = new MovieTimeService();
        }
        return instance;
    }

    private MovieTimeService() {
        mMovieTimeDAO = MovieTimeDAO.getInstance();
        mMovieDAO = MovieDAO.getInstance();
        mRoomDetailDAO = RoomDetailDAO.getInstance();
        mRoomDAO = RoomDAO.getInstance();
        mTicketDAO = TicketDAO.getInstance();
    }

    public int add(int movie, int time, int date, int room, int price, int idCreater) {
        Movie m = mMovieDAO.findMovieById(movie);
        if (m != null) {
            int timeEnd = CommonUtils.getTimeEnd(time, m.getTime());
            List<Movietime> movieTimes = mMovieTimeDAO.checkMovieTime(room, date, timeEnd, timeEnd);
            System.out.println(movieTimes.size());
            if (movieTimes != null && movieTimes.size() != 0) {
                return MOVIE_TIME_EXIXTS;
            } else {
                Room r = mRoomDAO.findRoomById(room);
                if (r != null) {
                    Movietime movieTime = new Movietime();
                    movieTime.setDateStart(date);
                    movieTime.setTimeStart(time);
                    Date currentTime = new Date();
                    movieTime.setTimeCreate(currentTime);
                    movieTime.setTimeUpdate(currentTime);
                    movieTime.setCreateBy(idCreater);
                    movieTime.setUpdateBy(idCreater);
                    movieTime.setPrice(price);
                    movieTime.setIdMovie(movie);
                    movieTime.setIdRoom(room);
                    mMovieTimeDAO.add(movieTime);
                    List<ZoomDetail> mListZoomDetail = mRoomDetailDAO.findAllByIdRoom(room);
                    if (mListZoomDetail == null || mListZoomDetail.isEmpty()) {
                        mMovieTimeDAO.delete(movieTime);
                        return ZOOM_NOT_USED;
                    }else{
                        List<Ticket> mListTicket = new ArrayList<>();
                        for(ZoomDetail zoomDetail: mListZoomDetail){
                            Ticket ticket = new Ticket();
                            ticket.setIdMovietime(movieTime.getId());
                            ticket.setStatus(1);
                            ticket.setTimeCreate(currentTime);
                            ticket.setTimeUpdate(currentTime);
                            ticket.setCreateBy(idCreater);
                            ticket.setUpdateBy(idCreater);
                            ticket.setIdZoomDetail(zoomDetail.getId());
                            if(zoomDetail.getType()==1){
                                ticket.setPrice(price);
                            }else{
                                ticket.setPrice(price*2);
                            }
                            int save = mTicketDAO.save(ticket);
                            if(save == 0){
                                break;
                            }else{
                                mListTicket.add(ticket);
                            }
                        }
                        if(mListZoomDetail.size()==mListTicket.size()){
                            return SUCCESS;
                        }else{
                            for(Ticket ticket:mListTicket){
                                mTicketDAO.delete(ticket);
                            }
                            mMovieTimeDAO.delete(movieTime);
                            return FAIL;
                        }
                    }
                } else {
                    return ZOOM_NOT_EXIST;
                }
            }
        } else {
            return MOVIE_NOT_EXIST;
        }
    }

}
