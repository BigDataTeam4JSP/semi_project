package com.javalec.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.Dao.aProduct_Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class aProductInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pname = request.getParameter("name");
		String pcolor = request.getParameter("color");
		String pprice = request.getParameter("price");
		String pcontent = request.getParameter("content");
		
		aProduct_Dao dao = new aProduct_Dao();
		dao.insertProduct(pname, pcolor, pprice,pcontent);
		dao.insertSpec(pname, pcolor, pprice);
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/img");
		
		System.out.println(uploadPath);
		
		int sizeLimit = 100*1024*1024;		//100MB 제한
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
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