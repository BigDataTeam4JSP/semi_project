package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.detail_Dao;
import com.javalec.Dto.detail_Dto;

public class detailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * ----------------------------------------
		 *  Description : productList_view에서 물건을 클릭했을 때 상세보기 페이지를 띄워줌
		 *  Date        : 2024.01.30
		 *  Author      : 원도현
		 * ----------------------------------------
		 */
		
		HttpSession session = request.getSession();
		
		
		// pid 값을 가져와서 int값으로 변환
		int pid = Integer.parseInt(request.getParameter("pId"));
		// dao와 dto 준비
		detail_Dao dao = new detail_Dao();
		detail_Dto dto = dao.detail(pid);
		request.setAttribute("detail", dto);
		
		// session에 dto값을 저장
		session.setAttribute("detailSession", dto);
		
		
//		response.setContentType("image/jpeg");
//		try {
//			ServletOutputStream out=response.getOutputStream();
//			String filePath=request.getServletContext().getRealPath("/img/won.png");
//			FileInputStream fin = new FileInputStream(filePath);
//			request.setAttribute("filePath", filePath);
			
//			System.out.println("filePath = "+filePath);
			
//		    BufferedInputStream bin = new BufferedInputStream(fin);  
//		    BufferedOutputStream bout = new BufferedOutputStream(out);  
//
//		    int ch =0;
//		    while((ch=bin.read())!=-1) {  
//		    	bout.write(ch);  
//		    }
//		    
//			//파일 입력스트림 제거
//		    bin.close();  
//		    fin.close();  
//		    bout.close();  
//		    out.close();  
//
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
