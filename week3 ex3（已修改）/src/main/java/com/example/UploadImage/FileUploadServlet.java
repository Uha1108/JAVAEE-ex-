package com.example.UploadImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "FileUploadServlet", value = "/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Part part= request.getPart("image");
    part.write("/Users/apple/Desktop/a.png");
    response.sendRedirect("ok.html");
    }
}