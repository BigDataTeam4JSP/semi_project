package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.aProduct_Dao;
import com.javalec.Dto.aProduct_Dto;


public class aProductDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// List 화면에서 전달받은 값을 가진 pid 변수 생성하기
		int pid = Integer.parseInt(request.getParameter("pId"));
		
		// dao랑 dto 객체 생성
		aProduct_Dao dao = new aProduct_Dao();
		aProduct_Dto dto = new aProduct_Dto();
		
		// aProduct_dto 형식을 가진 arraylist 생성
		// dao의 spec 메소드를 호출하여 spec 정보 dtos에 추가
		ArrayList<aProduct_Dto> dtos = dao.spec(pid);
		
		// 데이터들이 저장된 arraylist detail 화면에 출력되도록 request.setAttribute
		request.setAttribute("spec", dtos);
		
		// dto에 사진 경로 불러오는 메소드 데이터 추가
		dto = dao.imgpath(pid);

		// 이름, 색상, 가격, 정보는 중복되기 때문에 0번째 데이터만 보냄
		request.setAttribute("NAME", dtos.get(0).getpName());
		request.setAttribute("COLOR", dtos.get(0).getpColor ());
		request.setAttribute("PRICE", dtos.get(0).getpPrice());
		request.setAttribute("CONTENT", dtos.get(0).getpContent());
		
		// 사진 경로는 arraylist에 있는 데이터를 불러오는 것이 아니기에 dto에서 불러와야함
		request.setAttribute("FILEPATH", dto.getPfilepath());
		
	}
	
	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
