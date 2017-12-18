package main.java.by.bsuir.pms413802.Chayevskiy.controllerHelper;

import main.java.by.bsuir.pms413802.Chayevskiy.entity.User;
import main.java.by.bsuir.pms413802.Chayevskiy.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserHelper {

    public static void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        UserService service = new UserService();
        List<User> listUser = service.getAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);

        UserService userService = new UserService();
        userService.update(user);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserService userService = new UserService();
        User user = userService.getById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }

    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        UserService userService = new UserService();
        userService.add(user);
        response.sendRedirect("list");
    }

    public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserService userService = new UserService();
        User user = userService.getById(id);
        userService.remove(user);
        response.sendRedirect("list");
    }
}