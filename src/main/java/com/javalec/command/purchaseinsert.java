package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.purchaseinsert_Dao;
import com.javalec.Dto.detail_Dto;

public class purchaseinsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		detail_Dto dto = (detail_Dto)session.getAttribute("detailSession");
		
		String mid = (String) session.getAttribute("loginID");
		int pid = dto.getPid();
		String qty = (String)session.getAttribute("qty");
		System.out.println(qty);
		String size = (String)session.getAttribute("size");
		System.out.println(size);
//		System.out.println(session.getAttribute("qty"));
//		System.out.println(session.getAttribute("size"));
		
		purchaseinsert_Dao dao = new purchaseinsert_Dao();
		dao.purchaseInsert(mid, pid, qty, size);
		
		
		
		
		

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
