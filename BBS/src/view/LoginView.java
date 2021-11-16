package view;

import java.util.Scanner;

import dao.UserDAO;

public class LoginView {

	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		System.out.print("아이디 : ");
		String user_id = sc.next();
		System.out.print("비밀번호 : ");
		String user_pw = sc.next();
		if(udao.login(user_id, user_pw)) {
			new MainView();
		}else {
			System.out.println("로그인 실패/다시시도해주세요");
		}
		
	}
	
}
