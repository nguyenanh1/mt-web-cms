/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax;

import com.google.gson.JsonObject;
import common.CodeDefine;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MovieService;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
@WebServlet("/LockMovieAjax")
public class MovieAjax extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jo = new JsonObject();
        Integer id = CommonUtils.parseInteger(req.getParameter("id"));
        Integer idUser = CommonUtils.parseInteger(req.getSession().getAttribute(CodeDefine.USER_ID).toString());
        int locked = MovieService.getInstance().lock(id,idUser);
        System.out.println(locked);
        jo.addProperty("code", 0);
        jo.addProperty("message", locked);
        resp.getWriter().print(jo);
    }
    
}
