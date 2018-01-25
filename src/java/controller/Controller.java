/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ArticleFacade;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "Controller", urlPatterns = {"/"})
public class Controller extends HttpServlet {
@EJB 
private ArticleFacade articleFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("hello", "Привет");
        String command = request.getParameter("command");
        if("index".equals(command)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("article".equals(command)){
           request.getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response); 
        }else if("news".equals(command)){
           request.getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response); 
        }else if("addArticle".equals(command)){
           request.getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(request, response); 
        }else if("newArticle".equals(command)){
            String title = request.getParameter("title");
            String text = request.getParameter("text");
            Article newArticle = new Article(title,text);
            articleFacade.create(newArticle);
           request.getRequestDispatcher("index.jsp").forward(request, response); 
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
