package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.aProduct_Dao;
import com.javalec.Dto.aProduct_Dto;

public class aProductDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int pid = Integer.parseInt(request.getParameter("pId"));
		
		aProduct_Dao dao = new aProduct_Dao();
		ArrayList<aProduct_Dto> dtos = dao.spec(pid);
		request.setAttribute("spec", dtos);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("NAME",dtos.get(0).getpName());
		session.setAttribute("COLOR",dtos.get(0).getpColor());
		session.setAttribute("PRICE",dtos.get(0).getpPrice());
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
