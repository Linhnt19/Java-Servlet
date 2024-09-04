package com.example.assignment.controller.admin;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/video",
        "/add_user2",
        "/delete_user2",
        "/update_user2",
        "/quay_ve2"
})
public class VideoServlet extends HttpServlet {
    VideoService svV = new VideoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url =req.getRequestURI();
        if (url.contains("/add_user2")){
            req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req,resp);
        }else if(url.contains("/delete_user2")){
            String id =req.getParameter("id");
            svV.deleteById(id);
            resp.sendRedirect("video");
            return;
        }else if(url.contains("/update_user2")){
            String id =req.getParameter("id");
            Video v = svV.findById(id);
            req.setAttribute("Video",v);
            req.getRequestDispatcher("/view/bai2/formUpDate.jsp").forward(req,resp);
        }else if(url.contains("/quay_ve2")){
            req.setAttribute("list",svV.findAll());
            req.setAttribute("listSize",svV.findAll().size());
            req.getRequestDispatcher("/view/bai2/giaoDien.jsp").forward(req,resp);
        }
        req.setAttribute("list",svV.findAll());
        req.setAttribute("listSize",svV.findAll().size());
        req.getRequestDispatcher("/view/bai2/giaoDien.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();
        String id =req.getParameter("id");
        video.setId(id);
        String title =req.getParameter("title");
        video.setTitle(title);
        video.setDescription(req.getParameter("description"));
        String poster =req.getParameter("poster");
        video.setPoster(poster);
        Boolean active = req.getParameter("active")!=null;
        video.setActive(active);
        boolean error =false;
        if (video.getId().isEmpty()){
            req.setAttribute("errorId","Id khong trong");
            error =true;
        }
        if (video.getTitle().isEmpty()){
            req.setAttribute("errorTitle","Title khong trong");
            error =true;
        }
        if (video.getPoster().isEmpty()){
            req.setAttribute("errorPoster","Poster khong trong");
            error =true;
        }
        if (req.getRequestURI().contains("/update_user2")){
//            if(title==null||title.trim().isEmpty()){
//                req.setAttribute("error2", "Title khong duoc trong");
//                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
//                req.getRequestDispatcher("/view/bai2/formUpDate.jsp").forward(req, resp);
//                return;
//            }else if(poster==null||poster.trim().isEmpty()){
//                req.setAttribute("error3", "Poster khong duoc trong");
//                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
//                req.getRequestDispatcher("/view/bai2/formUpDate.jsp").forward(req, resp);
//                return;
//            }
            if (error){
                req.getRequestDispatcher("/view/bai2/formUpDate.jsp").forward(req, resp);
            }else
            svV.update2(video);
        }else if(req.getRequestURI().contains("/add_user2")){
            if (svV.isExists(id)) {
                req.setAttribute("error", "ID đã tồn tại. Vui lòng nhập ID khác.");
                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
                req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req, resp);
            }
            if (error){
                req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req, resp);
            }else
//            else if(id==null||id.trim().isEmpty()){
//                req.setAttribute("error1", "Id khong duoc trong");
//                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
//                req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req, resp);
//                return;
//            }
//            else if(title==null||title.trim().isEmpty()){
//                req.setAttribute("error2", "Title khong duoc trong");
//                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
//                req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req, resp);
//                return;
//            }else if(poster==null||poster.trim().isEmpty()){
//                req.setAttribute("error3", "Poster khong duoc trong");
//                req.setAttribute("video", video); // Truyền video đã nhập lại cho form
//                req.getRequestDispatcher("/view/bai2/formAdd.jsp").forward(req, resp);
//                return;
//            }
            svV.add2(video);
        }

        resp.sendRedirect("video");
    }
}
