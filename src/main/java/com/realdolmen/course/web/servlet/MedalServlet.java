package com.realdolmen.course.web.servlet;

import com.realdolmen.course.domain.Country;
import com.realdolmen.course.domain.Medaille;
import com.realdolmen.course.domain.MedailleType;
import com.realdolmen.course.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VCLBB37 on 11/08/2016.
 */
@WebServlet(name = "/MedalServlet", urlPatterns = "/MedalServlet")
public class MedalServlet extends HttpServlet {


    List<Country> countries = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello World---------------------------");
        String country = request.getParameter("country");
        String sport = request.getParameter("sport");
        String medal = request.getParameter("medal");


   /* try {
        Country c = (Country) query.getSingleResult();
    }*/

        Medaille med = new Medaille(MedailleType.valueOf(medal.toUpperCase()),sport);

        Country c = new Country(country);
        c.addMedal(med);
        countries.add(c);


        response.getWriter().write("New Medal Added!");



        /*}*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Hello");
        request.setAttribute("countries", countries);

        //request.getRequestDispatcher()...
    }
}
