/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Asus
 */
public class ReportService {
    private static ReportService instance;
   
    
    private ReportService(){
        
    }
    
    public static ReportService getInstance(){
        if(instance == null){
            instance = new ReportService();
        }
        return instance;
    }
    
    public List<Integer> getDoanhThu(){
        return null;
    }
}
