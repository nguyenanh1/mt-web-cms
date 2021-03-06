/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillter;

import com.sun.net.httpserver.HttpServer;
import common.CodeDefine;
import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class DomainFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String servletPath = req.getServletPath();

        if (servletPath.equals("/login") || servletPath.equals("/LoginController")) {
            if (session.getAttribute(CodeDefine.TOKEN) == null) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            if (session.getAttribute(CodeDefine.TOKEN) == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                // Cho phép request được đi tiếp. (Vượt qua Filter này).
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }

}
