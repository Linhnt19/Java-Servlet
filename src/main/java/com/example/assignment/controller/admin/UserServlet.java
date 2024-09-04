package com.example.assignment.controller.admin;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import com.example.assignment.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/userAS",
        "/add_user",
        "/delete_user",
        "/update_user",
        "/quay_ve"

})
public class UserServlet extends HttpServlet {
    UserService svU = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url =req.getRequestURI();
        if (url.contains("/add_user")){
            req.getRequestDispatcher("/view/bai1/formAdd.jsp").forward(req,resp);
        }else if(url.contains("/delete_user")){
            String id =req.getParameter("id");
            svU.deleteByID(id);
            resp.sendRedirect("userAS");
            return;
        }else if(url.contains("/update_user")){
            String id =req.getParameter("id");
            User u = svU.findByID(id);
            req.setAttribute("User",u);
            req.getRequestDispatcher("/view/bai1/formUpDate.jsp").forward(req,resp);
        }else if(url.contains("/quay_ve")){
            req.setAttribute("list",svU.findAll());
            req.getRequestDispatcher("/view/bai1/giaoDien.jsp").forward(req,resp);
        }
        req.setAttribute("list",svU.findAll());
        req.getRequestDispatcher("/view/bai1/giaoDien.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String id =req.getParameter("id");
        user.setId(id);
        String email =req.getParameter("email");
        user.setEmail(email);
        user.setPassword(req.getParameter("password"));
        user.setFullname(req.getParameter("fullname"));
        Boolean admin =req.getParameter("admin")!=null;
        user.setAdmin(admin);
        boolean error =false;
        if (user.getId().isEmpty()){
            req.setAttribute("errorId","Id khong trong");
            error=true;
        }
        if (user.getEmail().isEmpty()){
            req.setAttribute("errorEmail","Email khong trong");
            error=true;
        }
        if (user.getFullname().isEmpty()){
            req.setAttribute("errorFullname","Fullname khong trong");
            error=true;
        }
        if (user.getPassword().isEmpty()){
            req.setAttribute("errorPassword","Password khong trong");
            error=true;
        }
        if (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")){
            req.setAttribute("errorPassword2","Độ dài lớn hơn hoặc bằng 6, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái");
            error=true;
        }
        if (req.getRequestURI().contains("/update_user")){
            if (error){
                req.getRequestDispatcher("/view/bai1/formUpDate.jsp").forward(req, resp);
            }else
            svU.update(user);
        }else if(req.getRequestURI().contains("/add_user")){
            if (svU.isExists(id)) {
                req.setAttribute("error3", "ID đã tồn tại. Vui lòng nhập ID khác.");
                req.setAttribute("user", user); // Truyền video đã nhập lại cho form
                req.getRequestDispatcher("/view/bai1/formAdd.jsp").forward(req, resp);
            }
            if (svU.isExists2(email)) {
                req.setAttribute("error2", "Email đã tồn tại. Vui lòng nhập Email khác.");
                req.setAttribute("user", user); // Truyền video đã nhập lại cho form
                req.getRequestDispatcher("/view/bai1/formAdd.jsp").forward(req, resp);
            }
            if (error){
                req.getRequestDispatcher("/view/bai1/formAdd.jsp").forward(req, resp);
            }else
            svU.add(user);
        }
        resp.sendRedirect("userAS");
    }
}