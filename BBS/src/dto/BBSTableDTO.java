package dto;

public class BBSTableDTO {
	int num;
	String writer;
	String title;
	String views;
	
	

	public BBSTableDTO(int num, String writer, String title, String views) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.views = views;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return	num+"\t"+writer+"\t"+title+"\t"+views;
	}
}
