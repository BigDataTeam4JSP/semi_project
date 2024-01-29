package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.productList_Dao;
import com.javalec.Dto.productList_Dto;

public class productListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 productList_Dao dao = new productList_Dao();
		 ArrayList<productList_Dto> dtos = dao.list();
		 
		 System.out.println("오류확인");
					
		 request.setAttribute("list", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
