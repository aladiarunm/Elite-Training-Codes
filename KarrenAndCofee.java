import java.util.*;

public class KarrenAndCofee{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int q = scan.nextInt();

        int[] diff = new int[200002];

        for(int i=0;i<n;i++){
            int l = scan.nextInt();
            int r = scan.nextInt();

            diff[l] += 1;
            diff[r+1] -= 1;
        }

        for(int i=1;i<=200001;i++){
            diff[i] += diff[i-1];
        }

        int[] count = new int[200001];

        for(int i=1;i<200001;i++){
            if(diff[i]>=k) count[i] = (count[i-1]+1);
            else count[i] = count[i-1];
        }

        for(int i=0;i<q;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            System.out.println(count[b] - count[a-1]);
        }

    }
}