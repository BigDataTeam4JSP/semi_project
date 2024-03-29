package com.javalec.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.command.Command;
import com.javalec.command.aProcuctQtyUpdate;
import com.javalec.command.aProductDetailCommand;
import com.javalec.command.aProductImgUpdateCommand;
import com.javalec.command.aProductInsertCommand;
import com.javalec.command.aProductListCommand;
import com.javalec.command.cartCommand;
import com.javalec.command.detailCommand;
import com.javalec.command.idCheckCommand;
import com.javalec.command.loginCommand;
import com.javalec.command.productListCommand;
import com.javalec.command.purchaseListCommnad;
import com.javalec.command.purchaseinsert;
import com.javalec.command.signupCommand;
import com.javalec.command.userInfoCommand;
/* ----------------------------------------
 *  Description : 화면과 기능 분리해주는 컨트롤러
 *  Date        : 2024.01.27- 2024.01.30
 *  Author      : 김수진
 * ----------------------------------------
 */
/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response); // actionDo method로 보냄
		System.out.println("doGet"); // get방식으로 들어왔을 때 확인
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
		System.out.println("doPost"); // get방식으로 들어왔을 때 확인
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");

		// Session 만들기, Controller 맨 위에서 정의 해줘야 함!!
		HttpSession session = request.getSession();

		Command command = null;
		String viewPage = null;

		String uri = request.getRequestURI();
		// System.out.println(uri); // /MVCBoard/list.do 라고 뜸
		String conPath = request.getContextPath();
		// System.out.println(conPath); // /MVCBoard 라고 뜸
		String com = uri.substring(conPath.length());
		System.out.println(com); // /list.do라고 뜸(이걸로 페이지를 판단)

		switch (com) {
		case ("/loginStart.do"):
			viewPage = "login_view.jsp";
			break;
		case ("/login.do"):
			command = new loginCommand();
			command.execute(request, response);
			String loginID = (String) session.getAttribute("loginID");
			System.out.println("loginID : " + loginID);

			if (loginID != null) {
				if (loginID.equals("admin")) {	// admin으로 로그인 시 관리자 상품리스트로 이동. by 수진
					viewPage = "aProductList.do";
				} else {						// 사용자로 로그인 시 사용자 상품리스트로 이동. by 수진
					viewPage = "productList.do";
					// viewPage = "userInfo.do";
				}
			} else {							// 로그인 실패시 로그인 페이지로 이동.
				viewPage = "login_view.jsp";
			}
			break;
		case ("/userInfo.do"):					// 사용자 정보 보기.
			command = new userInfoCommand();
			command.execute(request, response);
			viewPage = "userInfo.jsp";
			break;
		case ("/logout.do"):					// 로그아웃.
			session.invalidate();
			viewPage = "login_view.jsp";
			break;
		case ("/productList.do"):
			command = new productListCommand();
			command.execute(request, response);
			viewPage = "productList_view.jsp";
			break;
		case ("/detail.do"):
			command = new detailCommand();
			command.execute(request, response);
			viewPage = "detail_view.jsp";
			break;
		case ("/cart.do"):
			command = new cartCommand();
			command.execute(request, response);
			viewPage = "cart_view.jsp";
			break;
		case ("/purchaseinsert.do"):
			command = new purchaseinsert();
			command.execute(request, response);
			viewPage = "purchaseList.do";
			break;
		case ("/purchaseList.do"):
			command = new purchaseListCommnad();
			command.execute(request, response);
			viewPage = "purchaseList_view.jsp";
			break;
		case ("/signupStart.do"):		// 회원가입 페이지로 이동.
			viewPage = "sign_view.jsp";
			break;
		case ("/signup.do"):			// 회원가입 수행.
			command = new signupCommand();
			command.execute(request, response);
			response.sendRedirect("loginStart.do");
			break;
		case ("/checkid.do"):			// 회원가입시 아이디 중복체크
			command = new idCheckCommand();
			command.execute(request, response);
			viewPage = "sign_view.jsp";
//			response.sendRedirect("signupStart.do");
			break;
		case ("/aProductList.do"):
			command = new aProductListCommand();
			command.execute(request, response);
			viewPage = "aProductList_view.jsp";
			break;
		case ("/aProductDetail.do"):
			command = new aProductDetailCommand();
			command.execute(request, response);
			viewPage = "aProductDetail_view.jsp";
			break;
		case ("/aProductInsert_view.do"):
			viewPage = "aProductInsert_view.jsp";
			break;
		case ("/aProductInsert.do"):
			command = new aProductInsertCommand();
			command.execute(request, response);
			viewPage = "aProductList.do";
			break;
		case ("/aProcuctUpdate.do"):
			command = new aProcuctQtyUpdate();
			command.execute(request, response);
			viewPage = "aProductList.do";
			break;
		case ("/imageUpdate_view.do"):
			viewPage = "aProductupdateimg.jsp";
			break;
		case ("/imageUpdate.do"):
			command = new aProductImgUpdateCommand();
			command.execute(request, response);
			viewPage = "aProductList.do";
			break;
		default:
			break;
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}

	} // actionDo()

}
