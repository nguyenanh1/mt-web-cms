/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import common.CodeDefine;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MovieService;
import service.TransactionService;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
@WebServlet("/home/report")
public class ReportAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jo = new JsonObject();
        long start = CommonUtils.parseLong(req.getParameter("start"));
        long from = CommonUtils.parseLong(req.getParameter("from"));
        JsonArray ja = new JsonArray();
        JsonObject jtestStart = new JsonObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while (start <= from) {
            JsonObject jtest = new JsonObject();
            jtest.addProperty("label", simpleDateFormat.format(new Date(start)));
            jtest.addProperty("value", TransactionService.getInstance().getReport(start));
            ja.add(jtest);
            start = start + 24 * 60 * 60 * 1000;
        }
        jo.addProperty("code", 0);
        jo.addProperty("message", "Ok");
        jo.add("data", ja);
        resp.getWriter().print(jo);
    }

}
