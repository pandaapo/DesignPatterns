package com.pattern.delegate.mvc;

import com.pattern.delegate.mvc.controller.MemberController;
import com.pattern.delegate.mvc.controller.OrderController;
import com.pattern.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    //工厂模式：初始化。单例模式：用容器handlerMapping保存url和method的关系。
    private List<Handler> handlerMapping = new ArrayList<Handler>();

    //初始化handlerMapping
    @Override
    public void init() throws ServletException {
        Class<?> memberControllerClass = MemberController.class;
        try {
            handlerMapping.add(new Handler().setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成调度：将用户不同请求转成不同的java逻辑
        doDispatch(req, resp);
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        //获取请求的地址
//        String uri = req.getRequestURI();
//        //获取参数
//        String mid = req.getParameter("mid");
//        //委派
//        if("getMemberById".equals(uri)){
//            new MemberController().getMemberById(mid);
//        } else if ("getOrderById".equals(uri)) {
//            new OrderController().getOrderById(mid);
//        } else if("logOut".equals(uri)){
//            new SystemController().logOut();
//        } else {
//            resp.getWriter().write("4o4 Not Found");
//        }
//    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求的地址
        String uri = req.getRequestURI();
        //策略
        Handler handler = null;
        for (Handler h : handlerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        try {
            Object obj = handler.getMethod().invoke(handler.getController(), req.getParameter("mid"));
            resp.getWriter().write(obj.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //内部类，把controller的映射关系设定好
    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        //改造set方法，方便其他地方书写时可以采用链式写法
        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
