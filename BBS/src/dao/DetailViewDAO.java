package dao;

import java.util.HashSet;

import dto.DetailViewDTO;

public class DetailViewDAO {
	DBConnection conn = null;

	public DetailViewDAO() {
		conn = new DBConnection("Detail.txt");
	}
	public boolean write(DetailViewDTO ddto) {
		return conn.insert(ddto.toString());
	}
	public HashSet<String> road() {
		HashSet<String> list = conn.select();
		return list;
	}
	
}
