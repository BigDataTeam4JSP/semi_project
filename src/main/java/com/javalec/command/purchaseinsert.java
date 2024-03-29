package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.purchaseinsert_Dao;
import com.javalec.Dto.detail_Dto;

public class purchaseinsert implements Command {
	/*
	 * ----------------------------------------
	 *  Description : 내구매내역페이지로 넘어가기 전 DB의 purchase Table에 insert
	 *  			  spec Table에 qty update
	 *  Date        : 2024.01.30
	 *  Author      : 원도현
	 * ----------------------------------------
	 */

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// session에 저장된 dto 값을 가져오기 위해 setting
		detail_Dto dto = (detail_Dto)session.getAttribute("detailSession");
		// session에서 loginID값을 가져옴
		String mid = (String) session.getAttribute("loginID");
		// session에서 dto의 pid값을 가져옴
		int pid = dto.getPid();
		// session에서 qty값을 가져옴
		String qty = (String)session.getAttribute("qty");
		// session에서 size값을 가져옴
		String size = (String)session.getAttribute("size");
		
		purchaseinsert_Dao dao = new purchaseinsert_Dao();
		// purchaseinsert_Dao에서 purchaseInsert method를 실행
		dao.purchaseInsert(mid, pid, qty, size);
		
		int pqty = Integer.parseInt(dto.getPqty());
		int cqty = Integer.parseInt(qty);
		int uqty = pqty - cqty;
		// purchaseinsert_Dao에서 specQtyUpdate method를 실행
		dao.specQtyUpdate(uqty, pid);
		
		

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
