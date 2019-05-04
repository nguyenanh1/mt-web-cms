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

    public static String ip = "http://192.168.100.30/";

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
        int hh = Integer.parseInt(list[0]);
        int mm = Integer.parseInt(list[1]);
        return hh * 100 + mm;
    }

    public static String decimalFormat(Integer decimal){
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(decimal);
    }
}
