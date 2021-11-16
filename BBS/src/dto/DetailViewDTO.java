package dto;



public class DetailViewDTO {
	int num = 0;
	String user_name;
	String title;
	String contents;
	public DetailViewDTO(String user_name, String title, String contents) {
		num++;
		this.user_name = user_name;
		this.title = title;
		this.contents = contents;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return num+". "+"\t"+user_name+"\t"+title+"\t"+contents+"\t";
	}
	
}
