import java.util.*;
public class Merge {
    public static void merge(int[] x1, int[] x2){
        int i, j, k;
        i = j = k = 0;
    }
    
    public void mergeSortRecursive(int l, int h){
        if(l < h){
            int mid = (l + h) / 2;
            mergeSortRecursive(l, mid);
            mergeSortRecursive(mid + 1, h);
            
        }
    }
}
