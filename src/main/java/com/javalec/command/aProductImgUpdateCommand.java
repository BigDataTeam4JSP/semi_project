package com.javalec.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.Dao.aProduct_Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class aProductImgUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int pid = (int) session.getAttribute("ID");
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/img");
		// Users/sori/Desktop/SORI/tj_study/JSP/jspProject/SemiProject/src/main/webapp/img

		int sizeLimit = 100 * 1024 * 1024; // 100MB 제한

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "UTF-8",
					new DefaultFileRenamePolicy());
			String filename = multi.getOriginalFileName("file");
			System.out.println(filename);
			
			aProduct_Dao dao = new aProduct_Dao();
			dao.updateImg(pid, filename);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
