package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dto.detail_Dto;

public class purchaseinsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		session.getAttribute("qty");
		session.getAttribute("size");
		System.out.println(session.getAttribute("qty"));
		System.out.println(session.getAttribute("size"));
		
		(ArrayList<detail_Dto>) session.getAttribute("detailSession");
		System.out.println(session.getAttribute("detailSession"));
		

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
