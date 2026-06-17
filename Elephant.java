import java.util.*;

public class Elephant{

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int count=0;

        while(n!=0){
            if(n>=5) n-=5;
            else if(n>=4) n-=4;
            else if(n>=3) n-=3;
            else if(n>=2) n-=2;
            else n-=1;
            count++;
        }
        System.out.println(count);
    }
}