package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.productList_Dao;
import com.javalec.Dao.purchaseList_Dao;
import com.javalec.Dto.productList_Dto;
import com.javalec.Dto.purchaseList_Dto;

public class purchaseListCommnad implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 purchaseList_Dao dao = new purchaseList_Dao();
		 ArrayList<purchaseList_Dto> dtos = dao.spec("ccc");
		 		 					
		 request.setAttribute("pList", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
