package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.purchaseList_Dao;
import com.javalec.Dto.purchaseList_Dto;

/*
*----------------------------------------
*  Description : 내구매내역조회
*  Date        : 2024.1.30
*  Author      : TaewooKi
* ----------------------------------------
*/
public class purchaseListCommnad implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("loginID"); //login id 받기.

		 purchaseList_Dao dao = new purchaseList_Dao();
		 ArrayList<purchaseList_Dto> dtos = dao.spec(mId);
		 		 					
		 request.setAttribute("pList", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
