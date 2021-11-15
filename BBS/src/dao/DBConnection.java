package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

public class DBConnection {
	String file;
	public DBConnection(String file) {
		this.file = file;
	}
	//받아온 데이터를 세팅되어있는 file에 그대로 입력해주는 메소드
	boolean insert(String data) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(data+"\r\n");
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("=======오류 발생 : DB 연결 실패=======");
			System.out.println(e);
			System.out.println("=================================");
		}
		return false;
	}
	//받아온 PK값에 해당하는 줄의 col번째 열을 newData로 수정하는 메소드
	boolean update(String key,int col,String newData) {
		String result = "";
		boolean check = false;
		try {
			BufferedReader br =  new BufferedReader(new FileReader(file));
			while(true) {
				String line = br.readLine();
				if(line ==null) {
					break;
				}
				String[] datas=line.split("\t");
				if(datas[0].equals(key)) {
					result+=datas[0];
					for (int i = 1; i < datas.length; i++) {
						if(i==col) {
							result+="\t"+newData;
							check = true;
						}else {
							result+="\t"+datas[i];
						}
					}
					result+="\r\n";
				}else {
					result+=line+"\r\n";
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("======오류 발생 : DB 파일 오류======");
			System.out.println(e);
			System.out.println("===============================");
		} catch (IOException e) {
			System.out.println("======오류 발생 : DB 연결 실패======");
			System.out.println(e);
			System.out.println("===============================");
		}	
		if(check) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(result);
				bw.close();
			} catch (IOException e) {
				System.out.println("======오류 발생 : DB 연결 실패======");
				System.out.println(e);
				System.out.println("===============================");
			}
		}
		return check;
	}
	//각 줄을 구별해주는 PK값 하나를 받아와서 그 PK에 해당하는 줄을 통째로 삭제
	boolean delete(String key) {
		String result = "";
		boolean check = false;
		try {
			BufferedReader br =  new BufferedReader(new FileReader(file));
			while(true) {
				String line = br.readLine();
				if(line ==null) {
					break;
				}
				String[] datas=line.split("\t");
				if(datas[0].equals(key)) {
					check = true;				
				}else {
					result+=line+"\r\n";
				}
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("======오류 발생 : DB 파일 오류======");
			System.out.println(e);
			System.out.println("===============================");
		} catch (IOException e) {
			System.out.println("======오류 발생 : DB 연결 실패======");
			System.out.println(e);
			System.out.println("===============================");
		}	
		if(check) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(result);
				bw.close();
			} catch (IOException e) {
				System.out.println("======오류 발생 : DB 연결 실패======");
				System.out.println(e);
				System.out.println("===============================");
			}
		}
		return check;
	}
	//"file" 안에 있는 모든 정보 검색
	HashSet<String> select() {
		HashSet<String> resultSet = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				resultSet.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("======오류 발생 : DB 파일 오류======");
			System.out.println(e);
			System.out.println("===============================");
		} catch (IOException e) {
			System.out.println("======오류 발생 : DB 연결 실패======");
			System.out.println(e);
			System.out.println("===============================");
		}	
		return resultSet;
	}
	//넘긴 col번째의 열에 검색하려는 data가 있다면, 그 data가 포함되어 있는 한줄 통째로
	//HashSet에 추가해서 돌려주는 메소드
	HashSet<String> select(int col,String data) {
		HashSet<String> resultSet = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				String[] datas = line.split("\t");
				if(datas[col].equals(data)) {
					resultSet.add(line);//apple	abcd1234	김사과	10	01012341234	서울시 강남구 역삼동
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("======오류 발생 : DB 파일 오류======");
			System.out.println(e);
			System.out.println("===============================");
		} catch (IOException e) {
			System.out.println("======오류 발생 : DB 연결 실패======");
			System.out.println(e);
			System.out.println("===============================");
		}	
		return resultSet;
	}
	//현재 파일의 가장 마지막 pk(각 줄을 구별하기 위한 고유한 값) 리턴
	String lastPK() {
		String pk = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				pk=line.split("\t")[0];
			}
		} catch (FileNotFoundException e) {
			System.out.println("======오류 발생 : DB 파일 오류======");
			System.out.println(e);
			System.out.println("===============================");
		} catch (IOException e) {
			System.out.println("======오류 발생 : DB 연결 실패======");
			System.out.println(e);
			System.out.println("===============================");
		}
		return pk;
	}
}
