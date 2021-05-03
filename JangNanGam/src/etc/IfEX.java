package etc;
import java.util.*;
public class IfEX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
			A가 B보다 큰 경우에는 '>'를 출력한다.
			A가 B보다 작은 경우에는 '<'를 출력한다.
			A와 B가 같은 경우에는 '=='를 출력한다.
		 */
//		int A = sc.nextInt(), B = sc.nextInt();
//		if(A>B) System.out.println(">");
//		else if(A<B) System.out.println("<");
//		else System.out.println("==");
		
		/* 
		 * 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
		 */
//		int a = sc.nextInt();
//		if(a>=90&&a<=100) System.out.println("A");
//		else if(a>=80&&a<90) System.out.println("B");
//		else if(a>=70&&a<80) System.out.println("C");
//		else if(a>=60&&a<70)System.out.println("D");
//		else System.out.println("F");
	
		/*
		  연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
		  윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
		  예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
		*/
//		int a = sc.nextInt();
//		if((a%4==0 && a%100!=0) || (a%4==0 && a%400==0)) System.out.println("1");
//		else System.out.println("0");
		
		/*
		 * 좌표가 (12, 5)인 점 A는 x좌표와 y좌표가 모두 양수이므로 제1사분면에 속한다. 점 B는 x좌표가 음수이고 y좌표가 양수이므로 제2사분면에 속한다.
		 * 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오. 단, x좌표와 y좌표는 모두 양수나 음수라고 가정한다. 
		 */
//		int x = sc.nextInt(), y = sc.nextInt();
//		if(x>0&&y>0) System.out.println("1");
//		else if(x<0&&y>0) System.out.println("2");
//		else if(x>0&&y<0) System.out.println("4");
//		else System.out.println("3");
		
		/*
		 * 시간 계산하기 
		 * 입력값(시(HH),분(mm) 에서 45분전
		 */
	/*	int h = sc.nextInt(), m = sc.nextInt();
		if(h == 0) h = 24;
		int s = (h*3600) +  (m*60) - 2700;
		m = s%3600/60;
		h = s/3600;
		System.out.println();
		System.out.println(h+"\n"+m);
	*/
		int h = sc.nextInt(), m = sc.nextInt();
		if(m < 45) {
			h--;
			m = 60-(45-m);
			if(h<0) h = 23;
			System.out.println(h+" "+m);
		} else System.out.println(h+" "+(m-45));  
		
	}
}
