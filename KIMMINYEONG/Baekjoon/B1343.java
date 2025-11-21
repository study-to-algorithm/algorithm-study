import java.util.*;
// 그리디

public class B1343{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        s = s.replace("XXXX","AAAA"); // XXXX를 AAAA로 바꿈
        s = s.replace("XX","BB"); // XX를 BB로 바꿈

        if(s.contains("X")){
            System.out.println(-1);
        } else{
            System.out.println(s);
        }


    }
}