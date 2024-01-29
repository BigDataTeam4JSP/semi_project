package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.Signup_Dao;

public class signupCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		String name = (String)request.getParameter("name");
		String tel = (String)request.getParameter("tel");
		
		Signup_Dao dao = new Signup_Dao();
		dao.updateID(id, pw, name, tel);
		

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
