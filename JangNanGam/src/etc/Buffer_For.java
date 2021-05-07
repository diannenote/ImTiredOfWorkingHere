package etc;

import java.io.*;
import java.util.*;

public class Buffer_For {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sk;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			sk = new StringTokenizer(br.readLine()," ");
			bw.write(Integer.parseInt(sk.nextToken()) + Integer.parseInt(sk.nextToken())+"\n");
			
		}
		
		br.close();
		bw.flush();
		bw.close();
	
	}
}
