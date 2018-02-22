package by.http.password.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.password.action.BaseAction;
import by.http.password.action.util.ActionManager;
import by.http.password.compaund.Compaund;

public class SimpleServlet extends HttpServlet{
	
	private String admin = "/admin.jsp";
	private String user = "/user.jsp";
	private String error = "/error.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		
//		String login = req.getParameter("login");
//		String name = req.getParameter("command");
//        int password = Integer.parseInt(req.getParameter("password"));
//		PrintWriter out = resp.getWriter();
//		
//		out.write("<body>Hello World</body>");
//		out.write("<br>Login:  " + login + "</br>");
//		out.write("<br>Password:  " + password + "</br>");
//		out.write("<br>Name Form:  " + name + "</br>");
//		System.out.println("DoGET");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}


	@Override
	public void destroy() {
		System.out.println("Destroy servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Initilization servlet");
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseAction action = ActionManager.determineAction(request.getParameter("command"));
		String page;
		try {
			page = action.chooseAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		String login = request.getParameter("login");
//		int password = Integer.parseInt(request.getParameter("password"));
//		PrintWriter out = response.getWriter();
//		out.println("Login:  " + login);
//		out.println("Password:  " + password);
//		String sql = "select role from userinf where login = ?";
//		RequestDispatcher dispatcher = null;
//		Compaund connection = new Compaund();
//		
//		try {
//			PreparedStatement st = connection.getConnection().prepareStatement(sql);
//			st.setString(1, login);
//			ResultSet result = st.executeQuery();
//			while(result.next()) {
//				String role = result.getString("role");
//				
//				 if(role.equals("admin")) {
//					 dispatcher = request.getRequestDispatcher(admin);
//					 dispatcher.forward(request, response);
//				 }else if(role.equals("user")) {
//					 dispatcher = request.getRequestDispatcher(user);
//					 dispatcher.forward(request, response);
//				 }else {
//					 dispatcher = request.getRequestDispatcher(error);
//					 dispatcher.forward(request, response);
//				 }
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	
}
