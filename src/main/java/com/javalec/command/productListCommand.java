package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.productList_Dao;
import com.javalec.Dto.productList_Dto;

/*
*----------------------------------------
*  Description : 상폼목록조회
*  Date        : 2024.1.30
*  Author      : TaewooKi
* ----------------------------------------
*/
public class productListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 productList_Dao dao = new productList_Dao();
		 ArrayList<productList_Dto> dtos = dao.list();
		 							
		 request.setAttribute("list", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
