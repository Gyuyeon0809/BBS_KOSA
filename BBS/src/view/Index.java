package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("BBS ���α׷��Դϴ�. ���Ͻô� ����� ��ȣ�� �Է��Ͽ� �ּ���\n1. ȸ������\n2. �α���\n3. ������");
			int choice = sc.nextInt();
			if(choice == 1) {
				new Joinview();
			}else if(choice == 2) {
				new LoginView();
//				new LoginView();
			}else if(choice == 3) {
				System.out.println("�ȳ���������!");
				break;
			}
			
		}
	}
}
