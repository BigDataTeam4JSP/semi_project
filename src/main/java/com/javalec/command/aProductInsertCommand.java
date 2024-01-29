package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;

public class aProductInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String pname, pcolor, pprice, pcontent;

		pname = request.getParameter("name");
		pcolor = request.getParameter("color");
		pprice = request.getParameter("price");
		pcontent = request.getParameter("content");
		
		aProduct_Dao dao = new aProduct_Dao();
		
		dao.insertProduct(pname, pcolor, pprice, pcontent);
		dao.insertSpec(pname, pcolor, pprice);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}