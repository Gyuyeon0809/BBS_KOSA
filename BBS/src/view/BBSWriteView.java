package view;

import java.io.IOException;
import java.util.Scanner;

import dao.BBSTableDAO;
import dao.DetailViewDAO;
import dao.Session;
import dto.BBSTableDTO;
import dto.DetailViewDTO;
import dto.UserDTO;

public class BBSWriteView {

	public BBSWriteView() {

		DetailViewDAO ddao = new DetailViewDAO();
		Scanner sc = new Scanner(System.in);
		UserDTO loginUser1 = (UserDTO) Session.get("loginUser");
//		System.out.println(loginUser1.getName());
		System.out.println(loginUser1.username + "님" + "(" + loginUser1.userid + ")" + "어서오세요!");
		if (Session.get("loginUser") != null) {
			System.out.print("제목 : ");
			String title = sc.next();
			System.out.print("내용 : ");
			sc = new Scanner(System.in);
			String contents = sc.nextLine();
			DetailViewDTO ddto = new DetailViewDTO(loginUser1.username, title, contents);
			
			if (ddao.write(ddto)) {
				System.out.println("정상적으로 등록하였습니다.");
				BBSTableDTO tableDTO = new BBSTableDTO(loginUser1.username, title);
				BBSTableDAO tbdao = new BBSTableDAO();
				tbdao.write(tableDTO);
				try {
					ddao.list();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("등록에 실패했습니다 다시 시도해 주세요...");
			}
		}
	}
}
