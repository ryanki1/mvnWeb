package com.alz.mvnWeb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class addressController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		AddressBean address = new AddressBean();
		
		address.address1	= "Herrenstrasse 48";
		address.address2	= "";
		address.address3	= "";
		address.city		= "Freiburg";
		address.postcode	= "79098";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addressBean.xhtml");
		req.setAttribute("address", address);
		dispatcher.forward(req,resp);
		
		
		String payload = new Gson().toJson(address);
		
		resp.setContentType("application/json");
		resp.getWriter().println(payload);
		
	}

}
