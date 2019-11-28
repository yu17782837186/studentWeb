package com.ning.servlet;

import com.ning.pojo.Log;
import com.ning.service.LogService;
import com.ning.service.impl.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private LogService logService = new LogServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        Log log = new Log();
//        log.setAccIn(request.getParameter("accin"));
//        log.setAccOut(request.getParameter("accout"));
//        log.setMoney(Double.parseDouble(request.getParameter("money")));
//        int index = logService.ins(log);
//        if (index > 0) {
//            response.sendRedirect("/opensessioninview/success.jsp");
//        }else {
//            response.sendRedirect("/opensessioninview/error.jsp");
//        }
        request.setCharacterEncoding("utf-8");
        Log log = new Log();
        log.setAccIn(request.getParameter("accout"));
        log.setAccOut(request.getParameter("accin"));
        log.setMoney(Double.parseDouble(request.getParameter("money")));
        int index = logService.ins(log);
        if(index>0){
            response.sendRedirect("/opensessioninview/success.jsp");
        }else{
            response.sendRedirect("/opensessioninview/error.jsp");
        }
    }
}
