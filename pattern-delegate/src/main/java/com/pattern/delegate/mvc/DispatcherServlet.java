package com.pattern.delegate.mvc;

import com.pattern.delegate.mvc.controller.MemberController;
import com.pattern.delegate.mvc.controller.OrderController;
import com.pattern.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成调度：将用户不同请求转成不同的java逻辑
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求的地址
        String uri = req.getRequestURI();
        //获取参数
        String mid = req.getParameter("mid");
        //委派
        if("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        } else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        } else if("logOut".equals(uri)){
            new SystemController().logOut();
        } else {
            resp.getWriter().write("4o4 Not Found");
        }
    }
}
