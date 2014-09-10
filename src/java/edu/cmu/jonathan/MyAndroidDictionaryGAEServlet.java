/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.jonathan;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "MyAndroidDictionaryGAEServlet", urlPatterns = {"/MyAndroidDictionaryGAEServlet"})
public class MyAndroidDictionaryGAEServlet extends HttpServlet {
    DictionaryModelUsingWS dictionaryModel = null;
    
     @Override
    public void init() {
        dictionaryModel = new DictionaryModelUsingWS();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the search parameter if it exists
        String search = request.getParameter("search");
        System.out.println("search; "+ search);
        RequestDispatcher view;
        // see if search parameter is present
        if(search != null) {
                 // use model to do the search and choose the result view
                 dictionaryModel.doWordSearch(search);
                 //HttpSession session = request.getSession();
                 //RequestDispatcher view;
                //view = request.getRequestDispatcher("result.jsp");  
                 view = request.getRequestDispatcher("response.jsp");  
                 if(dictionaryModel.getWordDefinition()!=null){
                     request.setAttribute("word", dictionaryModel.getWord());
                     request.setAttribute("wordDefinition", dictionaryModel.getWordDefinition());
                 }
                 else{
                     request.setAttribute("word", dictionaryModel.getWord());
                     request.setAttribute("wordDefinition", "invalid Word!");
                 }
                 
        }
        else{
                     
                 view = request.getRequestDispatcher("index.jsp");
                 //view = request.getRequestDispatcher("response.jsp"); 
                 request.setAttribute("word", dictionaryModel.getWord());
                  request.setAttribute("wordDefinition", "invalid Word!");
        }
     
        view.forward(request, response);
                 
        }

    }
