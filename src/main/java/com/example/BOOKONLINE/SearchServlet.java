package com.example.BOOKONLINE;

import com.example.BOOKONLINE.Utils.SongUtils;
import com.example.BOOKONLINE.model.Song;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/searchSong")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search").trim();
        List<Song> songs = SongUtils.loadSongs();
        PrintWriter write=response.getWriter();
        if (search.length()==0){
            request.setAttribute("songs", songs);
            request.getRequestDispatcher("showAll.jsp").forward(request,response);
        }
        else {
            List<Song> results = songs.stream().filter(s -> s.getTitle().equals(search)).collect(Collectors.toList());
            if (results.size() == 0) {

                request.getRequestDispatcher("search-error.jsp").forward(request, response);
            }
            else {

                request.setAttribute("song", results.get(0));
                request.getRequestDispatcher("searchResult.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}