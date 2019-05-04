/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import antlr.CommonAST;
import dao.IMovieTimeDAO;
import dao.IRoomDAO;
import dao.IRoomDetailDAO;
import dao.IUserAdminDAO;
import daoimpl.MovieTimeDAO;
import daoimpl.RoomDAO;
import daoimpl.RoomDetailDAO;
import daoimpl.UserAdminDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.RoomUser;
import pojos.Room;
import pojos.UserAdmin;
import pojos.ZoomDetail;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class RoomService {
    public final static int SUCCESS  = 0;
    public final static int NOT_DEL_HAVE_MOVIE_TIME = 1;
    public final static int NOT_DEL = 2;
    private static RoomService instance;
    
    private IRoomDAO mRoomDAO;
    
    private IRoomDetailDAO mRoomDetailDAo;
    
    private IUserAdminDAO mAdminDAO;
    
    private IMovieTimeDAO movieTimeDAO;
    
    private RoomService(){
        mRoomDAO = RoomDAO.getInstance();
        mRoomDetailDAo = RoomDetailDAO.getInstance();
        mAdminDAO = UserAdminDAO.getInsance();
        movieTimeDAO = MovieTimeDAO.getInstance();
    }
    
    public static RoomService getInstance(){
        if(instance==null){
            instance = new RoomService();
        }
        return instance;
    }
    
    public int add(String name,int row,int col,int idCreater){
        Room r = new Room();
        r.setNameRoom(name);
        r.setNumRow(row);
        r.setNumCol(col);
        Date current = new Date();
        r.setTimeCreate(current);
        r.setTimeUpdate(current);
        r.setCreateBy(idCreater);
        r.setUpdateBy(idCreater);
        mRoomDAO.save(r);
        int postion = 1;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                ZoomDetail zoomDetail = new ZoomDetail();
                zoomDetail.setRow(i);
                zoomDetail.setCol(j);
                zoomDetail.setPostion(postion);
                postion++;
                zoomDetail.setType(1);
                zoomDetail.setRoom(r.getIdRoom());
                mRoomDetailDAo.save(zoomDetail);
            }
        }
        return r.getIdRoom();
    }
    
    public Room getRoomById(Integer id){
        return mRoomDAO.findRoomById(id);
    }
    
    public List<Room> getAll(){
        return mRoomDAO.findAllRoom();
    }
    
    public List<RoomUser> findAll(){
        List<Room> mListRoom = mRoomDAO.findAllRoom();
        List<RoomUser> mList = new ArrayList<>();
        for(Room room: mListRoom){
            RoomUser mRoomUser = new RoomUser();
            mRoomUser.setIdRoom(room.getIdRoom());
            mRoomUser.setNameRoom(room.getNameRoom());
            mRoomUser.setNumCol(room.getNumCol());
            mRoomUser.setNumRow(room.getNumRow());
            mRoomUser.setTimeCreate(CommonUtils.formatDate(room.getTimeCreate()));
            mRoomUser.setTimeUpdate(CommonUtils.formatDate(room.getTimeUpdate()));
            UserAdmin userCreate = mAdminDAO.findById(room.getCreateBy());
            if(userCreate!=null){
                mRoomUser.setCreateBy(userCreate.getDisplayName());
            }else{
                mRoomUser.setCreateBy("");
            }
            UserAdmin userUpdater = mAdminDAO.findById(room.getUpdateBy());
            if(userUpdater!=null){
                mRoomUser.setUpdateBy(userUpdater.getDisplayName());
            }else{
                mRoomUser.setUpdateBy("");
            }
            mList.add(mRoomUser);
        }
        return mList;
    }
    
    public Integer numRoom(){
        return findAll().size();
    }
    
    public List<ZoomDetail> findAllZoomDetailFindByIdRoom(Integer idRoom){
        return mRoomDetailDAo.findAllByIdRoom(idRoom);
    }

    public int delete(Integer idRoom) {
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");
        String datepartS = mFormat.format(new Date());
        Integer datepart = Integer.parseInt(datepartS);
        if(movieTimeDAO.findByIdRoom(idRoom, datepart)!=null&&!movieTimeDAO.findByIdRoom(idRoom, datepart).isEmpty()){
            System.out.println(movieTimeDAO.findByIdRoom(idRoom, datepart).size());
            return NOT_DEL_HAVE_MOVIE_TIME;
        }else{
            Room room = mRoomDAO.findRoomById(idRoom);
            int del = mRoomDAO.delete(room);
            List<ZoomDetail> mList = mRoomDetailDAo.findAllByIdRoom(idRoom);
            if(del==1){
                for(ZoomDetail z:mList){
                    mRoomDetailDAo.delete(z);
                }
                return SUCCESS;
            }else{
                return NOT_DEL;
            }
        }
    }
}
