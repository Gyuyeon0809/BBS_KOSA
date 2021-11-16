package view;

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
				System.out.println(loginUser.username+"님"+"("+loginUser.userid+")"+"어서오세요!");
				System.out.println("글목록\n번호\t글쓴이\t제목\t읽은수");
				int i = sc.nextInt();
				if(i == 1) {
					new BBSWriteView();
				}else {
					System.out.println("안녕히가세요");
					break;
				}
			}
//			System.out.println(bdao.road()); 	
			
		
		
		}else {
			System.out.println("로그인후 이용해주세요!");
		}
	}
	
	
}
