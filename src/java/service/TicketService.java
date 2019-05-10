/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IRoomDetailDAO;
import dao.ITicketDAO;
import dao.IUserAdminDAO;
import daoimpl.RoomDetailDAO;
import daoimpl.TicketDAO;
import daoimpl.UserAdminDAO;
import java.util.ArrayList;
import java.util.List;
import model.TicketMapping;
import pojos.Ticket;
import pojos.UserAdmin;
import pojos.ZoomDetail;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class TicketService {
    private static TicketService instance;
    
    private ITicketDAO mTicketDao;
    private IUserAdminDAO mAdminDAO;
    private IRoomDetailDAO mZoomDetail;
    
    public static TicketService getInstance(){
        if(instance==null){
            instance = new TicketService();
        }
        return instance;
    }
    
    private TicketService(){
        mTicketDao = TicketDAO.getInstance();
        mAdminDAO = UserAdminDAO.getInsance();
        mZoomDetail = RoomDetailDAO.getInstance();
    }
    
    public List<TicketMapping> getListTicketByMovietTime(int idMovieTime){
        List<Ticket> mList = mTicketDao.findListTicket(idMovieTime);
        List<TicketMapping> mMapping = new ArrayList<>();
        for(Ticket temp : mList){
            TicketMapping t = new TicketMapping();
            t.setId(temp.getIdTicket());
            t.setStatus(temp.getStatus());
            t.setPrice(CommonUtils.decimalFormat(temp.getPrice()));
            ZoomDetail zd = mZoomDetail.findById(temp.getIdZoomDetail());
            String position = "Vị trí: "+zd.getPostion()+" ,Hàng: "+zd.getRow()+" ,Cột: "+zd.getCol();
            t.setPosition(position);
            UserAdmin creater = mAdminDAO.findById(temp.getCreateBy());
            t.setCreateBy(creater.getDisplayName());
            t.setTimeCreate(CommonUtils.formatDate(temp.getTimeCreate()));
            UserAdmin updater = mAdminDAO.findById(temp.getUpdateBy());
            t.setUpdateBy(updater.getDisplayName());
            t.setTimeUpdate(CommonUtils.formatDate(temp.getTimeUpdate()));
            mMapping.add(t);
        }
        return mMapping;
    }
}
