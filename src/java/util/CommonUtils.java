/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CommonUtils {

    public static String ip = "http://192.168.100.101/";

    public static int timeout = 1000 * 15 * 60;

    public static String convertDate(Integer partdate) {
        if (partdate != null) {
            int partday = partdate % 100;
            int partdaym = partdate / 100;
            int dd = partday;
            int parttmonth = partdaym % 100;
            int mm = parttmonth;
            int partyear = partdate / 10000;
            int yy = partyear;
            return dd + " Th" + mm + " " + yy;
        }
        return "";
    }
    
    public static String converTime(Integer time){
        if(time!=null){
            int hh= time/100;
            int mm = time%100;
            String hhS = String.valueOf(hh);
            String mmS = String.valueOf(mm);
            if(hh<10){
                hhS = "0"+hhS;
            }
            if(mm<10){
                mmS = "0"+mmS;
            }
            return hhS+":"+mmS;
        }
        return "";
    }

    public static Integer getPartDate(Date date) {
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");
        String sFromat = mFormat.format(date);
        try {
            Integer iFormat = Integer.parseInt(sFromat);
            return iFormat;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static String formatDate(Date date) {
        SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        if (date != null) {
            return mFormat.format(date);
        }
        return "";
    }

    public static int converPartDate(String datestart) {
        String[] list = datestart.split("-");

        String yyyy = list[0];

        String mm = list[1];

        String dd = list[2];

        int partdate;

        try {
            partdate = Integer.parseInt((yyyy + mm + dd));
        } catch (Exception e) {
            partdate = -1;
        }
        return partdate;
    }

    public static int convertTimeStart(String timestart) {
        String[] list = timestart.split(":");
        String hh = list[0];
        String mm = list[1];
        int timestartI = -1;
        try {
            timestartI = Integer.parseInt(hh + mm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timestartI;
    }

    public static Integer parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getTimeEnd(int timeStart, int duration) {
        int hh = timeStart / 100;
        int mm = timeStart % 100;
        int hourDuraion = duration/60;
        int minDuration = duration%60;
        
        hh = hh+hourDuraion;
        mm = mm+minDuration;
        return hh*100+mm;
    }

    public static String decimalFormat(Integer decimal){
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(decimal);
    }
    
    public static String getStatusTicket(int i){
        if(i==1){
            return "Ghế trống";
        }else if(i==2){
            return "Ghế đã bán";
        }else if(i==3){
            return "Ghế đang được chọn";
        }else{
            return null;
        }
    }
    
}
