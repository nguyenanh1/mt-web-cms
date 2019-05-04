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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CategoryService;

/**
 *
 * @author Asus
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        int idUser = Integer.parseInt(session.getAttribute(CodeDefine.USER_ID).toString());
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "del":
                    int id = Integer.parseInt(req.getParameter("id"));
                    int delete = CategoryService.getInstance().delete(id);
                    if (delete == 1) {
                        resp.sendRedirect(req.getContextPath() + "/category?alert=sucsses");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/category?alert=fail");
                    }
                    break;
                
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        int idUser = Integer.parseInt(session.getAttribute(CodeDefine.USER_ID).toString());
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "add":
                    String name = req.getParameter("name");
                    int add = CategoryService.getInstance().add(name, idUser);
                    if (add == 1) {
                        resp.sendRedirect(req.getContextPath() + "/add-category?alert=sucsses");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/add-category?alert=fail&name=" + name);
                    }
                    break;
                case "update":
                    int id = Integer.parseInt(req.getParameter("id"));
                    String nameUpdate = req.getParameter("name");
                    int update = CategoryService.getInstance().update(idUser,id,nameUpdate);
                    if (update == 1) {
                        resp.sendRedirect(req.getContextPath() + "/edit-category?alert=sucsses&id="+id);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/edit-category?alert=fail&id=" + id+"$name="+nameUpdate);
                    }
                    break;
            }
        }
    }
}
