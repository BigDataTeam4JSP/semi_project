package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;

public class aProcuctQtyUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("pid"));
		int size = Integer.parseInt(request.getParameter("psize"));
		int qty = Integer.parseInt(request.getParameter("pqty"));
		
		System.out.println(id+" " +size+" "+qty);
		
		aProduct_Dao dao = new aProduct_Dao();
		dao.update(id, size, qty);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
