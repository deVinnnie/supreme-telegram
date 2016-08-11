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

/**
 * Created by VCLBB37 on 11/08/2016.
 */
@WebServlet(name = "/MedalServlet", urlPatterns = "/MedalServlet")
public class MedalServlet extends HttpServlet {

    @PersistenceContext
    private EntityManager em;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello World---------------------------");
        String country = request.getParameter("country");
        String sport = request.getParameter("sport");
        String medal = request.getParameter("medal");

        TypedQuery query = em.createQuery("select p from Country p where p.name =:name ", Country.class);
        query.setParameter("name",country);

   /* try {
        Country c = (Country) query.getSingleResult();
    }*/

        Medaille med = new Medaille(MedailleType.valueOf(medal.toUpperCase()),sport);

        /*if (!rs.next()){
            //ResultSet is empty
        }

        if(c!=null){
            c.addMedal(med);
            em.persist(c);
        }else{*/
            Country c = new Country(country);
            c.addMedal(med);

            em.persist(c);
        /*}*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Hello");
    }
}
