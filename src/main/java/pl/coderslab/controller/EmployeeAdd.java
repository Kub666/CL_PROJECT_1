package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee-add")
public class EmployeeAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/views/employee_add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String note = req.getParameter("note");
        double hourCost = Double.parseDouble(req.getParameter("hourCost"));

        Employee employee = new Employee();

        employee.setId(0);
        employee.setFirstName(firstName);
        employee.setName(name);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setNote(note);
        employee.setHourCost(hourCost);

        EmployeeDao.save(employee);

        resp.sendRedirect("/employees");
    }
}
