package dao;


import java.util.HashSet;

import dto.BBSTableDTO;

public class BBSTableDAO {
	DBConnection conn = null;

	public BBSTableDAO() {
		conn = new DBConnection("BBSTable.txt");
	}
	public boolean write(BBSTableDTO newBBSDTO) {
		return conn.insert(newBBSDTO.toString());
	}
	public HashSet<String> road() {
		HashSet<String> list = conn.select();
		return list;
	}
	
	
}
