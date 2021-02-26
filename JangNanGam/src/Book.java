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


	private void returnBook() throws Exception {
		System.out.println("-----반납-------");
		System.out.println("반납할 도서 고유번호> ");
		String bNo = sc.next();
		for(Book book:bookList) {
			
			if(bNo.equals(book.no) && book.available == false) {
				System.out.println("고유번호 > " + book.no);
				System.out.println("isAvailable> " + book.available);
				
			} else if (bNo.equals(book.no) && book.available) {
				System.out.println("고유번호 > " + book.no + "  도서명>" + book.title + "  는(은) 반납할수 있는 도서가 아닙니다." );
				System.out.println("!!반납할 도서 고유번호를 다시 입력해 주세요!!");
				returnBook();
			} else {
				System.out.println("일치하는 도서가 없습니다.");
				System.out.println("1. 메인으로 2. 반납할 도서 다시 등록 > ");
				String input =  sc.next();
				if(input.equals("1")) {
					showBook();
				} else if(input.equals("2")) {
					returnBook();
				} else {
					System.out.println("입력이 잘못되었습니다. 메인으로 이동합니다.");
					showBook();
				}
			}
			
		}
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
				System.out.println("고유번호: " + book.getNo() + "\t" + "책이름: " + book.getTitle() + "\t" + "지은이: "+ book.getAuthor() + "\t" + 
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
			System.out.print("1.메인화면  2.다시검색 > ");
			String  input = sc.next();
			if(input.equals("1")) {
				showBook();
			} else if(input.equals("2")) {
				searchAgain("search");
			} else {
				System.out.println("입력이 잘못 되었습니다. 메인으로 돌아갑니다");
				showBook();
			}
		} else {
			showBook();
		}
	}
	

	private void insertBook() throws Exception {
		Book book = new Book();
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
			System.out.println("등록에 실패 했습니다. 다시 등록 해주세요");
			insertBook();
		}
	}
	
	private void updateBook() throws Exception {
		System.out.println("수정할 도서 고유번호> ");
		String input = sc.next();
		int cnt = 0;
		for(Book book:bookList) {
			if(input.equals(book.no)) {
				cnt ++;
				System.out.println("===== 수정할 정보 선택 =====");
				System.out.println("1. 도서명  2. 저자명  3. 장르 > ");
				String num = sc.next();
				switch (num) {
				case "1": {
					System.out.println("변경할 도서명 > ");
					String cTitle = sc.next();
					System.out.println("도서명을 『" + book.title + "』 에서 『" + cTitle + "』로 변경 하시겠습니까?(Y/N) > ");
					String YN = sc.next();
					if(YN.toUpperCase().equals("Y")) {
						book.setTitle(cTitle);
						System.out.println("◆◆ 도서명이 변경 되었습니다. ◆◆");
						showBook();
					} else {
						System.out.println("//정보가 변경되지 않았습니다.//");
						showBook();
					}
					
				}
				case "2": {
					System.out.println("변경할 저자명 > ");
					String cAuthor = sc.next();
					System.out.println("저자명을 『" + book.author + "』 에서 『" + cAuthor + "』로 변경 하시겠습니까?(Y/N) > ");
					String YN = sc.next();
					if(YN.toUpperCase().equals("Y")) {
						book.setAuthor(cAuthor);
						System.out.println("◆◆ 저자명이 변경 되었습니다. ◆◆");
						showBook();
					} else {
						System.out.println("//정보가 변경되지 않았습니다.//");
						showBook();
					}

				}
				case "3": {
					System.out.println("변경할 장르 > ");
					String cGanre = sc.next();
					System.out.println("장르를 『" + book.ganre + "』 에서 『" + cGanre + "』로 변경 하시겠습니까?(Y/N) > ");
					String YN = sc.next();
					if(YN.toUpperCase().equals("Y")) {
						book.setGanre(cGanre);
						System.out.println("◆◆ 장르가 변경 되었습니다. ◆◆");
						showBook();
					} else {
						System.out.println("//정보가 변경되지 않았습니다.//");
						showBook();
					}

				}

				default:
					System.out.println("입력값이 잘못되었습니다. 다시 처음부터 입력해주세요");
					showBook();
				}
			} else {
				System.out.println("일치하는 정보가 없습니다.");
				System.out.println("1.메인으로 2.도서정보수정 >");
				String num2 = sc.next();
				if(num2.equals("1")) {
					showBook();
				} else if(num2.equals("2")) {
					updateBook();
				} else {
					System.out.println("잘못 입력 되었습니다. 메인으로 이동합니다.");
					showBook();
				}
			}
		}
		if(cnt == 0) {
			System.out.println("일치하는 정보가 없습니다.");
			showBook();
		}
		
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
