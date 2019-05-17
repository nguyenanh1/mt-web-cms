/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ITransactionDAO;
import dao.ITransactionDetailDAO;
import daoimpl.DetailTransactionDAO;
import daoimpl.TransactionDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojos.DetailTransaction;
import pojos.Transaction;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
public class TransactionService {
    private ITransactionDAO mTransactionDAO;
    
    private ITransactionDetailDAO mTransactionDetailDAO;
    
    
    private TransactionService() {
        mTransactionDAO = TransactionDAO.getInstance();
        mTransactionDetailDAO = new DetailTransactionDAO();
                
    }
    
    private static TransactionService instance;
    
    public static TransactionService getInstance(){
        if(instance ==null){
            instance = new TransactionService();
        }
        return instance;
    }
    
    public Integer getReport(long time){
        Date dateStart = new Date(time);
        dateStart.setHours(0);
        dateStart.setMinutes(0);
        Date dateFrom = new Date(time);
        dateFrom.setHours(23);
        dateFrom.setMinutes(59);
        List<Transaction> mList = mTransactionDAO.getTrans(dateStart, dateFrom);
        int tong = 0;
        for(Transaction t: mList){
            List<DetailTransaction> m2 = mTransactionDetailDAO.getList(t.getId());
            tong = tong +m2.size();
        }
        return tong;
    }
    
    public static void main(String[] args) {
        System.out.println(TransactionService.getInstance().getReport((new Date()).getTime()-24 * 60 * 60 * 1000));
    }
}
