package etc;
import java.util.*;
public class Arithmetic {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
//	     System.out.println(sc.nextInt() + sc.nextInt()); //덧샘
//	     System.out.println(sc.nextInt()-sc.nextInt());   //뺄샘
//	     System.out.println(sc.nextInt() * sc.nextInt()); //곱샘
//	     System.out.println(sc.nextDouble() / sc.nextDouble()); //나눗샘(소수점까지) 
//	     int a = sc.nextInt();
//	     int b = sc.nextInt();
//	     int c = sc.nextInt();
//	     System.out.println((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+(a/b)+"\n"+(a%b)); //사측연산
	     
//	     --첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
//	     System.out.println( ((a+b)%c) +"\n"+ ((a%c)+(b%c))%c +"\n"+ (a*b)%c +"\n"+ ((a%c)*(b%c))%c); 
	     
	 /*    (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
					4  7  2   ---  (1)
				x   3  8  5   ---  (2)
				---------------
				 2  3  6  0    --- (3)	
			  3  7  7  6       --- (4)
		   1  4  1  6          --- (5)
		   --------------------
		   1  8  1  7  2  0    --- (6)    	

	     (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
	    */ 

		 int A = sc.nextInt();
		 String B = sc.next();
		 System.out.println(A * Integer.parseInt(B.substring(2))+"\n"+
				 			A * Integer.parseInt(B.substring(1,2))+"\n"+
				 			A * Integer.parseInt(B.substring(0,1))+"\n"+
				 			A * Integer.parseInt(B));
		 
	}
}
