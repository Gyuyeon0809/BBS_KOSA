package view;

import java.util.Scanner;

import dao.DetailViewDAO;
import dao.Session;
import dto.DetailViewDTO;
import dto.UserDTO;

public class BBSWriteView {
	
		public BBSWriteView() {
		
			DetailViewDAO ddao = new DetailViewDAO();
			Scanner sc = new Scanner(System.in);
			UserDTO loginUser1 = (UserDTO) Session.get("loginUser");
//		System.out.println(loginUser1.getName());
			
			System.out.println(loginUser1.username+"��"+"("+loginUser1.userid+")"+"�������!");
//		if (Session.get("loginUser") != null) {
			System.out.print("���� : ");
			String title = sc.next();
			System.out.print("���� : ");
			sc = new Scanner(System.in);
			String contents = sc.nextLine();
			DetailViewDTO ddto = new DetailViewDTO(loginUser1.username, title, contents); 
			if(ddao.write(ddto)) {
				System.out.println("���������� ����Ͽ����ϴ�.");
				
					System.out.println(ddao.road());
				
			}else {
				System.out.println("��Ͽ� �����߽��ϴ� �ٽ� �õ��� �ּ���...");
//			}
			}
		}
	}

