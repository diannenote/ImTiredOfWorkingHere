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
//		for(int i =0; i<10; i++) {
//			Book book = new Book();
//			book.setNo(""+i);
//			book.setAuthor("작가");
//			book.setGanre("장르");
//			book.setTitle("제목" +i);
//			book.setAvailable(true);
//			bookList.add(book);
//		}
		
		System.out.println("===============================================================================");
		System.out.println("     1.도서검색 || 2.도서등록 || 3.도서정보수정 || 4.도서삭제 || 5.대출/반납하기 || 6.종료");	
		System.out.println("===============================================================================");
		System.out.print("숫자입력(1~6)>> ");
		String inputVal = sc.next();

		switch (inputVal) {
			case ("1"): {
				System.out.println("///////------------도서검색-------------/////");
				for(Book book:bookList) {
					boolean chk = book.isAvailable();
					String YN = "대출중";
					if(chk) {
						YN = "대출 가능";
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
				System.out.println("///////------------대출/반납하기-------------/////");
				System.out.print("1.대출 2.반납 > ");
				String input = sc.next();
				if(input.equals("1")) {
					rentalBook();
				} else if(input.equals("2")) {
					returnBook();
				} else {
					System.out.println("1이나 2중에 선택하여 입력해주세요");
					showBook();
				}
				break;
			}
			
			case ("6"): {
				System.out.println("///////------------종료-------------/////");
				sc.close();
				break;
			}

		default:
			throw new IllegalArgumentException("Unexpected value: " + inputVal);
		}
	}


	private void returnBook() {
		System.out.println("-----반납-------");
	}

	private void rentalBook() throws Exception {

		System.out.print("대출할 도서 번호 입력 >");
		String bookNo = sc.next();
		int cnt = 0;
		for(Book book:bookList) {
			boolean chk = book.isAvailable();
			String YN = "대출중-대출불가";
			if(chk) {
				YN = "대출 가능";
			}
			if(bookNo.equals(book.no) && chk) {
				System.out.print("고유번호: " + book.getNo() + "\t" + "책이름: " + book.getTitle() + "\t" + "지은이: "+ book.getAuthor() + "\t" + 
						"장르: " + book.getGanre() + "\t" + "대출가능여부: " + YN );
				System.out.print("위 도서를 대출하시겠습니까?(Y/N)");
				String yn = sc.next();
				if(yn.toUpperCase().equals("Y")) {
					book.available = false;
					System.out.println(" ★★★★★ 대출이 정상적으로 완료되었습니다. ★★★★★");
					showBook();
				} else {
					showBook();
				}
			} else {
				cnt ++;
			}
		}
		if(0 != cnt) {
			System.out.println("일치하는 도서정보가 없습니다.");
			rentalBook();
		}
	}

	private void searchBook(String keyword) throws Exception {
		int cnt = 0;
		for(Book book:bookList) {
			String CHK;
			if(book.available) {
				CHK = "대출가능";
			} else {
				CHK = "대출중";
			}
			if(keyword.equals(book.title)) {
				System.out.println(book.no + "\t" + book.title + "\t" + book.author + "\t" + book.ganre + "\t" + CHK);
				System.out.println("");
				cnt ++;
			}
		}
		if(cnt == 0) {
			System.out.println("일치하는 도서명이 없습니다.");
			searchAgain("search");
		} else {
			showBook();
		}
	}
	

	private void insertBook() throws Exception {
		Book book = new Book();
		int cnt = 0;
		System.out.print("도서 고유번호 > ");
		String bNo = sc.next();
		for(int i =0; i<bookList.size(); i++) {
			if(bNo.equals(bookList.get(i).no)) {
				System.out.println("중복되는 번호 입니다. 다시 입력해주세요");
				insertBook();
			}
		}
		
		book.setNo(bNo);
		System.out.print("도서명 > ");
		book.setTitle(sc.next());
		System.out.print("저자명 > ");
		book.setAuthor(sc.next());
		System.out.print("장르 > ");
		book.setGanre(sc.next());
		book.setAvailable(true);
		System.out.println("고유번호: " + book.getNo() + "\t 도서명: " + book.getTitle() + "\t 저자명: " + book.getAuthor() + "\t 장르: " + book.getGanre());
		System.out.println("입력하신 도서 정보가 맞습니까?(Y/N)");
		if(sc.next().toUpperCase().equals("Y")) {
			bookList.add(book);
			System.out.println("♥♥♥ 정상적으로 등록 완료 되었습니다. ♥♥♥");
			showBook();
		} else {
			insertBook();
		}
	}
	
	private void updateBook() {
		System.out.println("updateBook method in..");
		
	}
	
	private void deleteBook() throws Exception {
		System.out.print("삭제할 도서번호 >");
		String dTitle = sc.next();
		String CHK;
		int cnt = 0;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).available) {
				CHK = "가능";
			} else {
				CHK = "대출중-삭제불가";
			}

			while(dTitle.equals(bookList.get(i).no)) {
				cnt++;
				System.out.println(bookList.get(i).no + "\t" + bookList.get(i).title + "\t" + bookList.get(i).author + "\t" + bookList.get(i).ganre + "\t" + CHK);
				System.out.print("위 책을 삭제 하시겠습니까?(Y/N) >");
				String yn = sc.next();
				if(yn.toUpperCase().equals("Y")) {
					bookList.remove(i);
					System.out.println("◆◆◆◆◆ 삭제되었습니다. ◆◆◆◆◆ ");
					showBook();
				} else if(yn.toUpperCase().equals("N")) {
					showBook();
				} else {
					System.out.println("Y or N 입력해 주십시요");
					deleteBook();
				}
			}
		}
		if(cnt == 0) {
			System.out.println("일치하는 도서가 없습니다.");
			searchAgain("delete");
			
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
	
}
