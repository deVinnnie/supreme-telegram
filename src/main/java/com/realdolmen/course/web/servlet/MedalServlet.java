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


        if(country == null || country.equals("")){
            response.getWriter().write("Land mag niet leeg zijn!");
            return;
        }

        if(sport == null || sport.equals("")){
            response.getWriter().write("Sport mag niet leeg zijn!");
            return;
        }


   /* try {
        Country c = (Country) query.getSingleResult();
    }*/

        Medaille med = new Medaille(MedailleType.valueOf(medal.toUpperCase()),sport);

        Country c = new Country(country);

        boolean exists = false;

        for(Country co : countries){
            if(co.getName().equals(country)){
                c = co;
                exists = true;
                break;
            }
        }

        c.addMedal(med);
        if(!exists) {
            countries.add(c);
        }

        response.getWriter().write("New Medal Added!");

        System.out.println(countries.size());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().write("Hello");
        request.setAttribute("countries", countries);

        request.getRequestDispatcher("olympic.jsp").forward(request, response);
    }
}
