package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cartCommand implements Command {
	/*
	 * ----------------------------------------
	 *  Description : 상세페이지에서 가져온 size와 qty값을 session에 저장
	 *  Date        : 2024.01.30
	 *  Author      : 원도현
	 * ----------------------------------------
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// session 사용할 준비
		HttpSession session = request.getSession();

		// session에 size와 qty값을 저장
		session.setAttribute("size", request.getParameter("size"));
		session.setAttribute("qty", request.getParameter("qty"));

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}