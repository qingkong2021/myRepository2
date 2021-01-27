package com.qfedu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.bean.Housenumber;
import com.qfedu.bean.PageInfo;
import com.qfedu.service.HousenumberService;
import com.qfedu.service.impl.HousenumberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * maven创建web工程，并运行 用内置tomcat7插件
 */
@WebServlet("/pageQuery")
public class PageQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        System.out.println("currentPage : " + currentPage);
        if (null == currentPage) {
            //第一页
            currentPage = 1;
        }
        //传入service层
        HousenumberService housenumberService = new HousenumberServiceImpl();
        try {
            PageInfo<Housenumber> pageInfo = housenumberService.querylistByPage(currentPage);
            System.out.println("PageInfo : " + pageInfo);
            //jackson把java对象转换为json字符串，方便传递给浏览器
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr= objectMapper.writeValueAsString(pageInfo);
            resp.getWriter().write(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
