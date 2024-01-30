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

	    	// session 사용을 위한 코드
	        HttpSession session = request.getSession();
	        // pId 값 가져오기
	       int pid = (int)session.getAttribute("ID");
	       
	       // 내 컴퓨터에 저장되는 경로
	        String uploadPath = request.getSession().getServletContext().getRealPath("/img");
	        System.out.println(uploadPath);

	        // 사진 사이즈 저장
	        int sizeLimit = 100 * 1024 * 1024; // 100MB 제한

	        try {
	        	// MultipartRequest는 cos.jar 라이브러리에서 제공되는 클래스
	        	//request: 클라이언트로부터의 HTTP 요청 객체입니다.
	        	//uploadPath: 업로드된 파일이 저장될 서버의 실제 경로입니다.
	        	//sizeLimit: 업로드할 파일의 최대 크기 제한입니다.
	        	//"UTF-8": 요청 및 응답의 문자 인코딩을 설정합니다.
	        	//new DefaultFileRenamePolicy(): 파일명 중복 시 새로운 파일명을 생성하는 정책을 나타냅니다. 이 경우, 중복된 파일명이 있다면 파일명 뒤에 일련번호가 붙습니다.
	            MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
	            
	            //getFilesystemName("file"): file이라는 이름의 파일 필드에서 업로드된 파일의 시스템 파일명을 얻습니다.
	            String filename = multi.getFilesystemName("file");
	            
	            aProduct_Dao dao = new aProduct_Dao();
	            // 가져온 pId 사용, 파일 정보를 데이터베이스에 저장
	            dao.updateImg(pid, filename);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
	        // TODO Auto-generated method stub
	        return false;
	    }

	}
