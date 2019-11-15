public class Client {

    public static void main(String[] args) {
        //Assume both arrays are sorted from small to big
        //int[] a = {1,3,22,155,300,500};
        //int[] b = {0,9,18,500};
        int[] a = { 2, 3, 6, 7 , 8, 9};
        int[] b = { 1, 4};

        System.out.println(nthLargest(1, a, b));
    }

    private static int nthLargest(int n, int[] a, int[] b) {
        //Catch n that is smaller than 0 or larger than the size of both arrays
        if (n > a.length + b.length || n <= 0) throw new RuntimeException("n is out of bounds");
        //Start at n positions from the end of both arrays. If n is larger than the array, start at 0
        else return cut(n, a, b, (n < a.length) ? a.length - n : 0, (n < b.length) ? b.length - n : 0);
    }

    private static int cut(int n, int[] a, int[] b, int an, int bn) {
        System.out.println("step");
        //an is the index of n positions from the end of array a
        //bn is the index of n positions from the end of array b
        //Exit case for recursion (n is found)
        if (a.length - an + b.length - bn == n) {
            if (an >= a.length) return b[bn];
            else if (bn >= b.length) return a[an];
            //The nth largest integer will be the smallest of the two
            else return Math.min(a[an], b[bn]); //(a[an] < b[bn]) ? a[an] : b[bn]
        }
        //If a[an] <= b[bn] or b is "empty", then increment an and recurse
        //If b[bn] > a[an] or a is "empty", then increment bn and recurse
        if (an < a.length && (bn >= b.length || a[an] <= b[bn])) return cut(n, a, b, an + 1, bn);
        else return cut(n, a, b, an, bn + 1);
    }
}

