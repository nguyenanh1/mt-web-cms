/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CodeDefine;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MovieTimeService;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
@WebServlet("/MovieTimeController")
public class MovieTimeController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        xuLy(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        xuLy(req, resp);
    }

    private void xuLy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                add(req,resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int movie = Integer.parseInt(req.getParameter("movie"));
        int partdate = CommonUtils.converPartDate(req.getParameter("date"));
        int timestart = CommonUtils.convertTimeStart(req.getParameter("time"));
        int room = CommonUtils.parseInteger(req.getParameter("room"));
        int price = CommonUtils.parseInteger(req.getParameter("price"));
        int id = CommonUtils.parseInteger(req.getSession().getAttribute(CodeDefine.USER_ID).toString());
        int add = MovieTimeService.getIntance().add(movie,timestart,partdate,room,price,id);
        if(add==MovieTimeService.SUCCESS){
            resp.sendRedirect(req.getContextPath()+"/add-time?message=success");
        }else if(add ==MovieTimeService.FAIL){
            resp.sendRedirect(req.getContextPath()+"/add-time?message=fail");
        }else if(add == MovieTimeService.ZOOM_NOT_USED){
            String mess = "ZOOMNOTUSE";
            resp.sendRedirect(req.getContextPath()+"/add-time?message="+mess);
        }else if(add == MovieTimeService.MOVIE_TIME_EXIXTS){
            String mess = "MOVIETIMEEXIXTS";
            resp.sendRedirect(req.getContextPath()+"/add-time?message="+mess);
        }else if(add == MovieTimeService.ZOOM_NOT_EXIST){
            String mess = "ZOOMNOTEXIST";
            resp.sendRedirect(req.getContextPath()+"/add-time?message="+mess);
        }else if(add == MovieTimeService.MOVIE_NOT_EXIST){
            String mess = "MOVIENOTEXIST";
            resp.sendRedirect(req.getContextPath()+"/add-time?message="+mess);
        }
        
    }

}
