import java.io.*;

public class B1543 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		
		int cnt =0;
		while(s.length()>0) {
			if(s.startsWith(p)) {
				cnt++;
				s =s.substring(p.length());
			}else {
				s = s.substring(1); 
			}
		}
		System.out.println(cnt);
	}
}