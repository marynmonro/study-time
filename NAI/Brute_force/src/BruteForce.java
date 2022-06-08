import java.util.ArrayList;

public class BruteForce {

    private int k;
    private int n;
    private int[] masses;
    private int[] values;

    private ArrayList<Integer> indexes;

    public BruteForce(int k, int n, int[] masses, int[] values  ) {

        this.k = k;
        this.n = n;
        this.masses = masses;
        this.values = values;

        indexes = new ArrayList<>();
        // implementation(masses, values);

        System.out.println(getValue(masses, values, k, 0));
    }

//    private int iteracja = 1;
//    private double sum = 0.0;

    int[][] arr = new int[100][100];

    public int getValue(int[]masses, int[]items, int k, int itr){
        int wej, wyj;
        if ( k<=0 || itr==n ) return 0;

        if(arr[itr][k]>0) return arr[itr][k];

        if(masses[itr] < k){
            wej = getValue(masses, items, k-masses[itr], itr+1) + values[itr];
            wyj = getValue(masses, items, k, itr+1);
            arr[itr][k] = Math.max(wej, wyj);
        } else arr[itr][k] = getValue(masses, items, k, itr+1);
        return arr[itr][k];
    }

//    public void result(){
//        for ( int i = 0; i < n; i++ ){
//            int output = 0;
//
//            for ( int in : indexes ){
//                if ( i == in ) { output = 1; break; }
//            }
//            System.out.print(output);
//        }
//        System.out.println();
//
//        int sum = 0;
//        for ( int in : indexes ) {
//            sum += values[in];
//        }
//        System.out.println("\n"+ sum);
//
//
//
//    }


}
