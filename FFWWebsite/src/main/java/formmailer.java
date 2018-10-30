/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

/**
 *
 * @author klohf
 */
@WebServlet(urlPatterns = {"/formmailer"})
public class formmailer extends HttpServlet {
    private static final String GOOGLEMAILADRESSE = "...@gmail.com"; //Googlemailadresse nutzen um SMTP Server zu nutzen
    private static final String PASSWORD = ""; //Passwort für Googel um SMTP Server zu nutzen
    private static final String MAILADRESSE = "..."; //Mailadresse zu der die E-Mail gesendet werden soll

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formmailer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet formmailer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String betreff = request.getParameter("betreff");
        String nachricht = request.getParameter("nachricht");
        mailer(name, email, betreff, nachricht);
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
    private void mailer(String name, String email,String betreff, String nachricht) {
        Email mail = EmailBuilder.startingBlank()
                .from(name, email)
                .to("", MAILADRESSE)
                .withSubject(betreff)
                .withPlainText(nachricht)
                .buildEmail();
        getMailer().sendMail(mail);
    }
    private static Mailer getMailer () {
        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, GOOGLEMAILADRESSE, PASSWORD)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)                
                .buildMailer();
        return mailer;
    }

}
