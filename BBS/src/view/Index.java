package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("BBS 프로그램입니다. 원하시는 기능의 번호를 입력하여 주세요\n1. 회원가입\n2. 로그인\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				new Joinview();
			}else if(choice == 2) {
				new LoginView();
//				new LoginView();
			}else if(choice == 3) {
				System.out.println("안녕히가세요!");
				break;
			}
			
		}
	}
}
