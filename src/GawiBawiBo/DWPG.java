package GawiBawiBo;

import java.util.Scanner;

public class DWPG {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[1:가위   2:바위   3.보]");
		int user = sc.nextInt();
		int com = (int)(Math.random()*3)+1;
				
		game(user, com);
	}

	private static void game(int user, int com) {
		String userVal = null;
		switch (user) {
		case 1: {
			userVal = "가위";
			break;
		}
		case 2: {
			userVal = "바위";
			break;
		}
		case 3: {
			userVal = "보";
			break;
		}
		default:
			System.out.println("숫자 1,2,3 중 선택하여 입력해주시기바랍니다.");
			break;
		}
		
		
		String comVal =null;
		switch (com) {
		case 1: {
			comVal = "가위";
			break;
		}
		case 2: {
			comVal = "바위";
			break;
		}
		case 3: {
			comVal = "보";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + com);
		}
		System.out.println("-------------가위바위보!-------------");
		System.out.printf("[나: %s] VS [컴퓨터: %s]\n", userVal, comVal );
		if(user==com) {
			System.out.println("무승부!");
		} else if((user==1 && com==2) || (user==2 && com==3) || (user==3 && com==1)) {
			System.out.println("♨ 졌습니다. ㅠ_ㅠ ♨");
		} else {
			System.out.println("★☆★☆ 이겼습니다! ★☆★☆");
		}
	}
	
}
