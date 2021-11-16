package dto;

public class BBSTableDTO {
	
	String writer;
	String title;
	String views;
	
	

	public BBSTableDTO(String writer, String title) {
		this.writer = writer;
		this.title = title;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		return	"\t"+writer+"\t"+title;
	}
}
