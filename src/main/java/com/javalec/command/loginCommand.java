package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.Login_Dao;
/* ----------------------------------------
 *  Description : 로그인 성공하면 세션에 로그인ID정보 입력.
 *  Date        : 2024.01.27- 2024.01.30
 *  Author      : 김수진
 * ----------------------------------------
 */
public class loginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		HttpSession session = request.getSession();
		
		Login_Dao dao = new Login_Dao();
		
		if(dao.checkLogin(id, pw)) {	// 로그인 성공 시 세션에 아이디값을 넣어줌.
			session.setAttribute("loginID", id);
		}
		request.setAttribute("id", id);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
