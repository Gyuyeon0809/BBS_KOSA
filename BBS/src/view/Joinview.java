package view;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class Joinview {

	public Joinview() {
			Scanner sc = new Scanner(System.in);
			UserDAO udao = new UserDAO();
			System.out.print("���̵� : ");
			String userid = sc.next();
			String userpw = "";
		if(udao.checkId(userid)) {
			while(true) {
			System.out.print("��й�ȣ : ");
			userpw = sc.next();
			System.out.print("��й�ȣ Ȯ�� : ");
			String userpw_cheak = sc.next();
			if(userpw.equals(userpw_cheak)) {
				break;
				}else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ�Ȯ�����ּ���.");
				}
			}
			System.out.print("�̸� : ");
			String username = sc.next();
			System.out.print("���� : ");
			int age = sc.nextInt();
			System.out.print("�ڵ�����ȣ : ");
			String phonenum = sc.next();
			
			UserDTO newUser = new UserDTO(userid, userpw, username, age, phonenum);
			if(udao.join(newUser)) {
				System.out.println("ȸ������ ����!");
				System.out.println(newUser.username+"�� ������ ȯ���մϴ�~");
				
			}else {
				System.out.println("ȸ�����Խ���/�ٽýõ����ּ���");
			}
		}else {
			System.out.println("�ߺ��� ���̵��Դϴ� �ٽ� �õ��� �ּ���");
		}
	}

}
