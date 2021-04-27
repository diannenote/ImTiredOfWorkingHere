package etc;
import java.util.*;
public class NextInt {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	 /*  System.out.println(sc.nextInt() + sc.nextInt()); //덧샘
	     System.out.println(sc.nextInt()-sc.nextInt());   //뺄샘
	     System.out.println(sc.nextInt() * sc.nextInt()); //곱샘
	     System.out.println(sc.nextDouble() / sc.nextDouble()); //나눗샘(소수점까지) */
	     int a = sc.nextInt();
	     int b = sc.nextInt();
	     System.out.println((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+(a/b)+"\n"+(a%b)); //사측연산
	}
}
