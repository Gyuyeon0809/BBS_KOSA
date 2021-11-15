package view;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class Joinview {

	public Joinview() {
			Scanner sc = new Scanner(System.in);
			UserDAO udao = new UserDAO();
			System.out.print("아이디 : ");
			String userid = sc.next();
			String userpw = "";
		if(udao.checkId(userid)) {
			while(true) {
			System.out.print("비밀번호 : ");
			userpw = sc.next();
			System.out.print("비밀번호 확인 : ");
			String userpw_cheak = sc.next();
			if(userpw.equals(userpw_cheak)) {
				break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시확인해주세요.");
				}
			}
			System.out.print("이름 : ");
			String username = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("핸드폰번호 : ");
			String phonenum = sc.next();
			
			UserDTO newUser = new UserDTO(userid, userpw, username, age, phonenum);
			if(udao.join(newUser)) {
				System.out.println("회원가입 성공!");
				System.out.println(newUser.username+"님 가입을 환영합니다~");
				
			}else {
				System.out.println("회원가입실패/다시시도해주세요");
			}
		}else {
			System.out.println("중복된 아이디입니다 다시 시도해 주세요");
		}
	}

}
