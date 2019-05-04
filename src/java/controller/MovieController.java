/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CodeDefine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import service.MovieService;
import util.CommonUtils;

/**
 *
 * @author Asus
 */
@WebServlet("/MovieController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class MovieController extends HttpServlet {

    private MovieService movie;

    public static final String SAVE_DIRECTORY = "uploadDir";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "add":
                    addMovie(req, resp);
                    break;
                case "get":
                    break;
                case "del":
                    break;
                case "edit":
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "add":
                    addMovie(req, resp);
                    break;
                case "get":
                    break;
                case "del":
                    break;
                case "edit":
                    break;
                default:
                    break;
            }
        }
    }

    private void addMovie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int old = Integer.parseInt(req.getParameter("old"));
        String datestart = req.getParameter("datestart");
        int dateConvert = CommonUtils.converPartDate(datestart);
        int time = Integer.parseInt(req.getParameter("time"));
        List<Integer> mCates = new ArrayList<>();
        for (String s : req.getParameterValues("cate")) {
            int cate = Integer.parseInt(s);
            mCates.add(cate);
        }
        String director = req.getParameter("director");
        String actor = req.getParameter("actor");
        String trailer = req.getParameter("trailer");
        String contain = req.getParameter("contain");
        List<String> mListPartS = new ArrayList<>();
        try {
            String appPath = "C:\\xampp\\htdocs\\img";
            appPath = appPath.replace('\\', '/');

            // Thư mục để save file tải lên.
            String fullSavePath = null;
            if (appPath.endsWith("/")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "/" + SAVE_DIRECTORY;
            }

            // Tạo thư mục nếu nó không tồn tại.
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            // Danh mục các phần đã upload lên (Có thể là nhiều file).
            for (Part part : req.getParts()) {
                String fileName = extractFileName(part);
             
                if (fileName != null && fileName.length() > 0) {
                    String filePath = fullSavePath + File.separator + fileName;
                    String file = "img/"+SAVE_DIRECTORY+"/"+fileName;
                    System.out.println("Write attachment to file: " + filePath);
                    // Ghi vào file.
                    mListPartS.add(file);
                    part.write(filePath);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String thumb = mListPartS.get(0);
        String imageUrl = mListPartS.get(1);
        int id = Integer.parseInt(req.getSession().getAttribute(CodeDefine.USER_ID).toString());
        int save = MovieService.getInstance().add(name, old, dateConvert, time, mCates, director, actor, trailer, thumb, imageUrl, contain,id);
        if(save == 1){
            resp.sendRedirect(req.getContextPath()+"/add-movie?alert=sucsses");
        }else{
            resp.sendRedirect(req.getContextPath()+"/add-movie?alert=fail");
        }
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

}
