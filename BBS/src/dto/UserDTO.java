package dto;

public class UserDTO {
	public String userid;
	public String userpw;
	public String username;
	public int userage;
	public String phonenum;
	
	
	public UserDTO() {
		
	}
	public UserDTO(String userid, String userpw, String username, int userage, String phonenum) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userage = userage;
		this.phonenum = phonenum;
	}






	
	public UserDTO(String[] datas) {

		this.userid = datas[0];
		this.userpw = datas[1];
		this.username = datas[2];
		this.userage = Integer.parseInt(datas[3]);
		this.phonenum = datas[4];
	}
	
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userid+"\t"+userpw+"\t"+username+"\t"+userage+"\t"+phonenum;
	}
	
}
