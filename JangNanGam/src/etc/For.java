package etc;
import java.util.*;

public class For {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 입력값의 단으로 구구단 출력
		 */
//		int a = sc.nextInt();
//		for(int i=1; i<=9;i++) {
//			System.out.println(a+" * "+i+" = "+a*i);
//		}
		/*
		 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 */
//		int T = sc.nextInt();
//		for(int i=0;i<T;i++) {
//			int a = sc.nextInt(), b = sc.nextInt();
//			System.out.println(a+b);
//		}
		/*
		 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
		 */
		int n = sc.nextInt();
		int a = 0;
		for(int i=1;i<=n;i++) {
			a+=i;
		}
		System.out.println(a);
		/*
		 * 다른 사람 풀이
		 * 
		   import java.util.Scanner;
		   import java.util.Stack;

			public class Main {
				int A;
				// int B[] = new int[1000];
				// int C[] = new int[1000];
				// 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
				
				public void inputData()  {
					Scanner sc = new Scanner(System.in);
					A = sc.nextInt();
					// for(int i = 0; i < A; i++) {
					// 	B[i] = sc.nextInt();
					// 	C[i] = sc.nextInt();
					// }
					//B = sc.nextInt();
					//C = sc.nextInt();
				}
				
				int solve() {
					int ans = 0;
					int result = 0;
					for(int i = 1; i <= A; i++) {
						result += i;
					}
					System.out.println(result);
					// System.out.println(a);
					// System.out.println(b);
					// System.out.println(c);
					// System.out.println(d);
					
					return ans;
				}
			
				public static void main(String[] args){
					Main m = new Main();
					int ans = 0;
			
					m.inputData();				//	입력 함수
					//	코드를 작성하세요
					ans = m.solve();
				
					//System.out.println(ans);	//	정답 출력
				}
			}
					 */
	}
}
