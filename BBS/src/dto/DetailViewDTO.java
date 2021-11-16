package dto;



public class DetailViewDTO {
	
	String user_name;
	String title;
	String contents;
	

	public DetailViewDTO(String user_name, String title, String contents) {
		this.user_name = user_name;
		this.title = title;
		this.contents = contents;
		
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return user_name+"\t"+title+"\t"+contents+"\t";
	}
	
}
