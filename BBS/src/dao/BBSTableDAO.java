package dao;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public void list() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("BBSTable.txt"));
		while(true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}else {
				System.out.println(line);
			}
		}
	}
	
	
}
