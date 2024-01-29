package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;
import com.javalec.Dto.aProduct_Dto;


public class aProductListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		aProduct_Dao dao = new aProduct_Dao();
		ArrayList<aProduct_Dto> dtos = dao.list();
		
		request.setAttribute("list", dtos);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
