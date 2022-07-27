package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Payrollsystem")
public class Payrollsystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Connection con;
   PreparedStatement ps;
   
   @Override
public void init(ServletConfig config) throws ServletException {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystem", "root", "4455");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ps = con.prepareStatement("insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, request.getParameter("eName"));
			ps.setString(2, request.getParameter("empid"));
			ps.setString(3, request.getParameter("fathername"));
			ps.setString(4, request.getParameter("Address"));
			ps.setString(5, request.getParameter("Dept"));
			ps.setString(6, request.getParameter("BGro"));
			ps.setString(7, request.getParameter("BPay"));
			ps.setString(8, request.getParameter("HRA"));
			ps.setString(9, request.getParameter("Medical"));
			ps.setString(10, request.getParameter("Specallow"));
			ps.setString(11, request.getParameter("PFEmployer"));
			ps.setString(12, request.getParameter("GrossPay"));
			ps.setString(13, request.getParameter("PFEmployee"));
			ps.setString(14, request.getParameter("ESIDedu"));
			ps.setString(15, request.getParameter("NetPay"));
			ps.setString(16, request.getParameter("Acno"));
			ps.setString(17, request.getParameter("IFSC"));
			ps.setString(18, request.getParameter("Branch"));
			ps.executeUpdate();
			ps.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.print("You are Successfully ");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
