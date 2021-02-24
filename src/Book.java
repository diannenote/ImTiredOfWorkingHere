import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);
	private String no;
	private String title;
	private String author;
	private String ganre;
	private boolean available;

	private ArrayList<Book> bookList = new ArrayList<Book>();

	public Book() {
		
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGanre() {
		return ganre;
	}
	public void setGanre(String ganre) {
		this.ganre = ganre;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void showBook() throws Exception {
		for(int i =0; i<10; i++) {
			Book book = new Book();
			book.setNo(" "+i + " ");
			book.setAuthor("작가");
			book.setGanre("장르");
			book.setTitle("제목"+ i);
			book.setAvailable(true);
			bookList.add(book);
		}
		System.out.println("===================================================================================");
		System.out.println("                  1.도서검색 || 2.도서등록 || 3.도서정보수정 || 4.도서삭제 || 5.종료");	
		System.out.println("===================================================================================");
		System.out.print("숫자입력(1~5)>> ");
		String inputVal = sc.next();
//		char temp;
//		if(Character.isDigit(temp)) {
//		}
		switch (inputVal) {
			case ("1"): {
				System.out.println("///////------------도서검색-------------/////");
				for(Book book:bookList) {
					boolean chk = book.isAvailable();
					String YN = "불가능";
					if(chk) {
						YN = "가능";
					}
					System.out.print("고유번호: " + book.getNo() + "\t" + "책이름: " + book.getTitle() + "\t" + "지은이: "+ book.getAuthor() + "\t" + 
							"장르: " + book.getGanre() + "\t" + "대출가능여부: " + YN );
					System.out.println("");
				}
				System.out.println("-----------------------------------------------");
				System.out.print("도서명으로 검색> ");
				String keyword = sc.next();
				searchBook(keyword);
				break;
			}
			case ("2"): {
				System.out.println("///////------------도서등록-------------/////");
				insertBook();
				break;
					}
			case ("3"): {
				System.out.println("///////------------도서정보수정-------------/////");
				updateBook();
				break;
			}
			
			case ("4"): {
				System.out.println("///////------------도서삭제-------------/////");
				deleteBook();
				break;
			}
			
			case ("5"): {
				System.out.println("///////------------종료-------------/////");
				break;
			}

		default:
			throw new IllegalArgumentException("Unexpected value: " + inputVal);
		}
	}


	private void searchBook(String keyword) throws Exception {
		boolean TF = false;
		for(Book book:bookList) {
			String CHK;
			if(book.available) {
				CHK = "대출가능";
			} else {
				CHK = "대출 불가능";
			}
			if(keyword.equals(book.title)) {
				System.out.println(book.no + "\t" + book.title + "\t" + book.author + "\t" + book.ganre + "\t" + CHK);
				System.out.println("");
				showBook();
			} else {
				TF = true;
			}
			
		}
		if(TF) {
			System.out.println("일치하는 도서명이 없습니다.");
			searchAgain("search");
		}
	}
	
	private void searchAgain(String type) throws Exception {
		if(type.equals("search")) {
			System.out.print("도서명을 입력하세요 >");
			String keyword = sc.next();
			searchBook(keyword);
		} else {
			deleteBook();
		}
	}

	private void insertBook() {
		System.out.println("insertBook method in..");
	}
	
	private void updateBook() {
		System.out.println("updateBook method in..");
		
	}
	
	private void deleteBook() throws Exception {
		System.out.print("삭제할 도서명 >");
		String dTitle = sc.next();
		boolean CHK = false;
		for(Book book:bookList) {
			if(dTitle.equals(book.title)) {
				
			} else {
				CHK = true;
			}
		}
		if(CHK) {
			System.out.println("일치하는 도서명이 없습니다.");
			searchAgain("delete");
			
		}
		
	}
}
