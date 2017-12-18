package main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper;

import main.java.by.bsuir.pms413802.Chayevskiy.entity.Tariff;
import main.java.by.bsuir.pms413802.Chayevskiy.service.TariffService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TariffHelper {
    public static void listTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        TariffService service = new TariffService();
        List<Tariff> listTariff = service.getAll();
        request.setAttribute("listTariff", listTariff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Tariff tariff = new Tariff();
        tariff.setId(id);
        tariff.setName(name);

        TariffService tariffService = new TariffService();
        tariffService.update(tariff);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TariffService tariffService = new TariffService();
        Tariff tariff = tariffService.getById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffForm.jsp");
        request.setAttribute("tariff", tariff);
        dispatcher.forward(request, response);
    }

    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");

        Tariff tariff = new Tariff();
        tariff.setName(name);
        TariffService tariffService = new TariffService();
        tariffService.add(tariff);
        response.sendRedirect("list");
    }

    public static void deleteTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TariffService tariffService = new TariffService();
        Tariff tariff = tariffService.getById(id);
        tariffService.remove(tariff);
        response.sendRedirect("list");
    }
}
