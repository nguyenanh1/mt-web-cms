/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ITicketDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TicketMapping;
import pojos.Ticket;
import util.CommonUtils;
import util.DAOUtil;

/**
 *
 * @author Asus
 */
public class TicketDAO implements ITicketDAO{

    private static TicketDAO instance;
    
    public static TicketDAO getInstance(){
        if(instance==null){
            instance = new TicketDAO();
        }
        return instance;
    }
    
    private TicketDAO(){
        
    }
    
    @Override
    public int save(Ticket ticket) {
        int save = DAOUtil.save(ticket);
        return save;
    }

    @Override
    public int update(Ticket ticket) {
        int update = DAOUtil.save(ticket);
        return update;
    }

    @Override
    public int delete(Ticket ticket) {
        int delete = DAOUtil.save(ticket);
        return delete;
    }

    @Override
    public List<Ticket> findListTicket(int movieTime) {
        String hql = "From Ticket t where t.idMovietime = :idMovietime";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idMovietime", movieTime);
        List<Ticket> mList = DAOUtil.getList(hql, map);
        return mList;
    }
    
}
