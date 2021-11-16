package view;


import java.io.IOException;
import java.util.Scanner;

import dao.BBSTableDAO;
import dao.Session;
import dto.UserDTO;

public class MainView {

	public MainView() {
		if(Session.get("loginUser") != null) {
			Scanner sc = new Scanner(System.in);
			BBSTableDAO bdao = new BBSTableDAO();
			UserDTO loginUser = (UserDTO) Session.get("loginUser");
			while (true) {
				System.out.println(loginUser.username+"��"+"("+loginUser.userid+")"+"�������!");
				System.out.println("�۸��\n��ȣ\t�۾���\t����\t������");
				BBSTableDAO tabledao = new BBSTableDAO();
				try {
					tabledao.list();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = sc.nextInt();
				if(i == 1) {
					
						new BBSWriteView();
					 
					
				}else {
					System.out.println("�ȳ���������");
					break;
				}
			}
//			System.out.println(bdao.road()); 	
			
		
		
		}else {
			System.out.println("�α����� �̿����ּ���!");
		}
	}
	
	
}
