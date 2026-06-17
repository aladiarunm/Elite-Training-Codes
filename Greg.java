import java.util.*;

public class Greg{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        int[] nArr = new int[n];

        for(int i=0;i<n;i++){
            nArr[i] = scan.nextInt();
        }

        int[][] mArr = new int[m][3];

        for(int i=0;i<m;i++){
            mArr[i][0] = scan.nextInt();
            mArr[i][1] = scan.nextInt();
            mArr[i][2] = scan.nextInt();
        }

        int opDiff[] = new int[m+1];

        for(int i=0;i<k;i++){
            int l = scan.nextInt();
            int r = scan.nextInt();
            opDiff[l-1] +=1 ;
            opDiff[r] -=1;
        }
        for(int i=1;i<=m;i++){
            opDiff[i] += opDiff[i-1];
        }

        long eDiff[] = new long[n+1];

        for(int i=0;i<m;i++){
            int l = mArr[i][0];
            int r = mArr[i][1];
            eDiff[l-1] += ((long)mArr[i][2]*opDiff[i]);
            eDiff[r] -= ((long)mArr[i][2]*opDiff[i]);
        }
       
        for(int i=1;i<=n;i++){
            eDiff[i] += eDiff[i-1];
        }
       
        for(int i=0;i<n;i++){
            System.out.print(eDiff[i]+nArr[i] + "  ");
        }
    }
}