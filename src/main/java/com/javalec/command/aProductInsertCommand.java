package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;

public class aProductInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// insert 화면에서 입력받은 정보들을 request.getParameter로 불러옴
		String pname = request.getParameter("name");
		String pcolor = request.getParameter("color");
		String pprice = request.getParameter("price");
		String pcontent = request.getParameter("content");
		
		aProduct_Dao dao = new aProduct_Dao();
		
		// 데이터 추가하는 메소드들을 출력하여 입력 받은 값들을 넣어주기
		dao.insertProduct(pname, pcolor, pprice, pcontent);
		dao.insertSpec(pname, pcolor, pprice);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}