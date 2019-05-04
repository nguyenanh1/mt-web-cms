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
import service.RoomService;

/**
 *
 * @author Asus
 */
@WebServlet("/RoomController")
public class RoomController extends BaseController {

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
            case "update":
                break;
            case "del":
                delete(req,resp);
                break;
        }
    }
    
    private void add(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        String name = req.getParameter("name");
        int row = Integer.parseInt(req.getParameter("row"));
        int col = Integer.parseInt(req.getParameter("col"));
        int idCreater = Integer.parseInt(req.getSession().getAttribute(CodeDefine.USER_ID).toString());
        Integer id = RoomService.getInstance().add(name, row, col, idCreater);
        if(null!=id){
            resp.sendRedirect(req.getContextPath()+"/room-detail?id="+id);
        }else{
            resp.sendError(404);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if(id!=null){
            Integer del = RoomService.getInstance().delete(id);
            switch(del){
                case RoomService.SUCCESS:
                    resp.sendRedirect(req.getContextPath()+"/room?mess=success");
                    break;
                case RoomService.NOT_DEL:
                    resp.sendRedirect(req.getContextPath()+"/room?mess=fail");
                    break;
                case RoomService.NOT_DEL_HAVE_MOVIE_TIME:
                    resp.sendRedirect(req.getContextPath()+"/room?mess=havetime");
                    break;
            }
        }else{
            resp.sendError(404);
        }
    }
}
