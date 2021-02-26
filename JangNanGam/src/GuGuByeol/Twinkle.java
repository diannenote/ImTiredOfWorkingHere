/*
 * 1~9까지 숫자중 선택
 * 선택된 구구단의 결과값만큼 별찍기
 * 
 */

package GuGuByeol;

import java.util.Scanner;

public class Twinkle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력>> ");
		String input = sc.next();
		char val;
		boolean num = true;
		System.out.println(input + " DanByeol");
		sc.close();
		for(int i = 0; i < input.length(); i++) {
			val = input.charAt(i);
			num = Character.isDigit(val);
			if(!num) {
				System.out.println("숫자를 입력해 주세요");
				return;
			}
		}
		
		while (num) {
			if(input.equals("0") || input.length() > 1) {
				System.out.println("1~9 사이의 숫자를 입력해 주세요");
				return;
			}

			int inputNum =Integer.parseInt(input); 
			for (int i = 1; i < 10; i++) {
				for(int j = 0; j < inputNum * i; j++ ) {
					System.out.print("*");
				}
//				System.out.println("        "+input + "X" + i + "=" + inputNum * i);
				System.out.println("");
			}
			num = false;
		}
		
	}
}
