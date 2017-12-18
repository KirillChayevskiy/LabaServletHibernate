package main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper;

import main.java.by.bsuir.pms413802.Chayevskiy.entity.Relation;
import main.java.by.bsuir.pms413802.Chayevskiy.service.RelationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RelationHelper {

    public static void listRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RelationService service = new RelationService();
        List<Relation> listRelation = service.getAll();
        request.setAttribute("listRelation", listRelation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RelationList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        int tariffID = Integer.parseInt(request.getParameter("tariffID"));

        Relation relation = new Relation();
        relation.setId(id);
        relation.setUserID(userID);
        relation.setTariffID(tariffID);

        RelationService relationService = new RelationService();
        relationService.update(relation);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        RelationService relationService = new RelationService();
        Relation relation = relationService.getById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("RelationForm.jsp");
        request.setAttribute("relation", relation);
        dispatcher.forward(request, response);
    }

    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("RelationForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        int tariffID = Integer.parseInt(request.getParameter("tariffID"));

        Relation relation = new Relation();
        relation.setUserID(userID);
        relation.setTariffID(tariffID);
        RelationService relationService = new RelationService();
        relationService.add(relation);
        response.sendRedirect("list");
    }

    public static void deleteRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        RelationService relationService = new RelationService();
        Relation relation = relationService.getById(id);
        relationService.remove(relation);
        response.sendRedirect("list");
    }
}