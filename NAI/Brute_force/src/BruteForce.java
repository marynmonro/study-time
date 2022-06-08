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


//    public void implementation(int[]masses, int[]items) {
//
//        //double res = 0.0;
//        double previous = 0.0;
//        int index = 0;
//        int massa = 0;
//
//        for ( int i = 1; i <= n-iteracja; i++ ){
//            int m = masses[i-1];
//            //System.out.println(items[i-1] + " " + m);
//            double res = (double) items[i-1]/(double) m;
//            System.out.println("Wartosc dla przedmiotu " + i + " = " + res + ", mass: " + m);
//            if ( res > previous && (m+sum)<=k  ) {
//                previous = res;
//                index = i;
//                massa = m;
//            }
//        }
//
//        System.out.println("Iteracja: "+iteracja+", wartosc="+ previous+", index=" +index+" " + "\n");
//
//        if ( index !=0 ){
//            indexes.add(index);
//            System.out.println(indexes);
//
//            ArrayList<Integer> newmasses = new ArrayList<>(masses.length-1);
//            ArrayList<Integer> newitems = new ArrayList<>(items.length-1);
//
//            for ( int i = 1; i<=n-iteracja; i++ ){
//                if ( i != index ){
//                    newmasses.add(masses[i-1]);
//                    newitems.add(items[i-1]);
//                }
//            }
//
//            iteracja++;
//            sum += massa;
//            System.out.println("Sum" + sum + " " + k);
//            if ( sum <= k && index != 0 ){
//                implementation(newmasses.stream().mapToInt(i -> i).toArray(), newitems.stream().mapToInt(i -> i).toArray());
//            }
//        }
//
//
//    }

    public void result(){
        for ( int i = 0; i < n; i++ ){
            int output = 0;

            for ( int in : indexes ){
                if ( i == in ) { output = 1; break; }
            }
            System.out.print(output);
        }
        System.out.println();

        int sum = 0;
        for ( int in : indexes ) {
            sum += values[in];
        }
        System.out.println("\n"+ sum);



    }


}
