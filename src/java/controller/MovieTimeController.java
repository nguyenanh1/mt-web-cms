/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String time = req.getParameter("time");
        System.out.println(time);
        int partdate = CommonUtils.converPartDate(req.getParameter("date"));
    }

}
