package dao;

import java.util.HashSet;

import dto.UserDTO;

public class UserDAO {
	DBConnection conn = null;
	
	public UserDAO() {
		conn = new DBConnection("Usertable.txt");
	}

	public boolean join(UserDTO newUser) {
		return conn.insert(newUser.toString());
		
	}

	public boolean checkId(String userid) {
		HashSet<String> rs = conn.select(0,userid);
		
		return rs.size() == 0;
	}

	public boolean login(String user_id, String user_pw) {
		HashSet<String> rs = conn.select(0,user_id);
		for (String line : rs) {
			if(line.split("\t")[1].equals(user_pw)) {
				
				Session.put("loginUser", new UserDTO(line.split("\t")));
				return true;
			}
		}
		return false;
	}
}
