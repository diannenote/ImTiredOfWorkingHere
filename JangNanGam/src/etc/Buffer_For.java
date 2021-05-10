package etc;

import java.io.*;
import java.util.*;

public class Buffer_For {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//빠른 A+B
/*
		StringTokenizer sk;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			sk = new StringTokenizer(br.readLine()," ");
			bw.write(Integer.parseInt(sk.nextToken()) + Integer.parseInt(sk.nextToken())+"\n");
			
		}
		
		br.close();
		bw.flush();
		bw.close();
 */
		// 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
/*	
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			bw.write(i+"\n");
		}
		bw.close();
*/		
		// 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
/*		
		int n = Integer.parseInt(br.readLine());
		for(int i=n; i>0; i--) {
			bw.write(i+"\n");
		}
		bw.close();
*/
//		각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
/*		
		StringTokenizer sk;
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			sk = new StringTokenizer(br.readLine()," ");
			int re = Integer.parseInt(sk.nextToken()) + Integer.parseInt(sk.nextToken());
			bw.write("Case #"+i+": "+re+"\n");
			
		}
		bw.close();
*/
//		"Case #x: A + B = C" 형식으로 출력
		int T = Integer.parseInt(br.readLine());
		StringTokenizer sk;
        for(int i=0;i<T;i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());

            bw.write(String.format("Case #%d: %d + %d = %d\n",i+1,a,b,a+b));
        }
        bw.close();
	}
}
