package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.Signup_Dao;

public class idCheckCommand implements Command { 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String clientId = (String)request.getParameter("id");
		String serverId = "";
		
		Signup_Dao dao = new Signup_Dao();
		if(dao.checkID(clientId)) {	// 아이디가 이미 존재하면 false, 	존재하지 않으면 true
			dao.insertID(clientId);
			serverId = clientId;
		}
		request.setAttribute("clientId", clientId);
		request.setAttribute("serverId", serverId);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
