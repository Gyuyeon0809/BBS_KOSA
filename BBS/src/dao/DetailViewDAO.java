package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.zip.CheckedInputStream;

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
	public void list() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Detail.txt"));
		while(true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}else {
				System.out.println(line);
			}
		}
	}
	public boolean check(String listnum) {
		HashSet<String> rs = conn.select(0, listnum);
		return rs.size() > 0;
	} 
	
}
