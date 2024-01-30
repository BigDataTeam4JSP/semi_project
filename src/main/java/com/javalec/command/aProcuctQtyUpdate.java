package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;

public class aProcuctQtyUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// 상품 등록 화면에서 사용자가 입력한 id,size,qty를 입력받아 변수를 생성
		int id = Integer.parseInt(request.getParameter("pid"));
		int size = Integer.parseInt(request.getParameter("psize"));
		int qty = Integer.parseInt(request.getParameter("pqty"));
		
		aProduct_Dao dao = new aProduct_Dao();
		// update 메소드에 파라미터를 추가하여 해당 제품에 재고 정보를 추가
		dao.update(id, size, qty);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
