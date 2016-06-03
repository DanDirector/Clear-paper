package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by в on 03.06.2016.
 */
public class ServletBublic extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getSession().getAttribute("Bublic") == null){
            List<String> list = new ArrayList();
            request.getSession().setAttribute("Bublic", list);
        }
        String s =(String) request.getParameter("Bublic");
        List<String> stringList = (List) request.getSession().getAttribute("Bublic");
        stringList.add(s);
        response.sendRedirect("index.jsp");
    }


}
