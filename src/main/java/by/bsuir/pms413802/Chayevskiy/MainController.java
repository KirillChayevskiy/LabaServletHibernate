package main.java.by.bsuir.pms413802.Chayevskiy;

import main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper.RelationHelper;
import main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper.TariffHelper;
import main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper.UserHelper;
import main.java.by.bsuir.pms413802.Chayevskiy.util.HibernateUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newUser":
                    UserHelper.showNewForm(request, response);

                    break;
                case "/insertUser":
                    UserHelper.insertUser(request, response);

                    break;
                case "/deleteUser":
                    UserHelper.deleteUser(request, response);

                    break;
                case "/editUser":
                    UserHelper.showEditForm(request, response);

                    break;
                case "/updateUser":
                    UserHelper.updateUser(request, response);

                    break;
                case "/newTariff":
                    TariffHelper.showNewForm(request, response);

                    break;
                case "/insertTariff":
                    TariffHelper.insertTariff(request, response);

                    break;
                case "/deleteTariff":
                    TariffHelper.deleteTariff(request, response);

                    break;
                case "/editTariff":
                    TariffHelper.showEditForm(request, response);

                    break;
                case "/updateTariff":
                    TariffHelper.updateTariff(request, response);

                    break;
                case "/listTariff":
                    TariffHelper.listTariff(request, response);

                    break;
                case "/newRelation":
                    RelationHelper.showNewForm(request, response);
                    break;
                case "/insertRelation":
                    RelationHelper.insertRelation(request, response);
                    break;
                case "/deleteRelation":
                    RelationHelper.deleteRelation(request, response);
                    break;
                case "/editRelation":
                    RelationHelper.showEditForm(request, response);
                    break;
                case "/updateRelation":
                    RelationHelper.updateRelation(request, response);
                    break;
                case "/listRelation":
                    RelationHelper.listRelation(request, response);
                    break;
                default:
                    UserHelper.listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
