package view;

import java.util.Scanner;

import dao.UserDAO;

public class LoginView {

	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		System.out.print("���̵� : ");
		String user_id = sc.next();
		System.out.print("��й�ȣ : ");
		String user_pw = sc.next();
		if(udao.login(user_id, user_pw)) {
			new MainView();
		}else {
			System.out.println("�α��� ����/�ٽýõ����ּ���");
		}
		
	}
	
}
