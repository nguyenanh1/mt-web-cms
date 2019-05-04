/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CodeDefine;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public abstract class BaseController extends HttpServlet{
    protected void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession();
        if(session.getAttribute(CodeDefine.TOKEN)==null || session.getAttribute(CodeDefine.USER_ID)==null){
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
