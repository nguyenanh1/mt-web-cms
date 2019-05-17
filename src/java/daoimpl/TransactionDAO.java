/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ITransactionDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pojos.Transaction;
import util.CommonUtils;
import util.DAOUtil;

/**
 *
 * @author Asus
 */
public class TransactionDAO implements ITransactionDAO{
    private static TransactionDAO instance;
    private TransactionDAO(){
        
    }
    
    public static TransactionDAO getInstance(){
        if(instance ==null){
            instance = new TransactionDAO();
        }
        return instance;
    }
    
    @Override
    public  List<Transaction> getTrans(Date start, Date from) {
        String hql = "From Transaction t where t.time >= :start and t.time<= :from";
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("start",start);
        map.put("from", from);
        List<Transaction> mList = DAOUtil.getList(hql, map);
        return mList;
    }
    
    public static void main(String[] args) {
    }
}
