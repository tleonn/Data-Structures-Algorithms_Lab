public class mergeSort {
    static void MergeSort(int[] arr, int lo, int hi){
        int mid = arr.length / 2;
        if(lo >= hi){
            System.out.println(arr[mid]);
            return;
        }
        MergeSort(arr, lo, mid-1);
        MergeSort(arr, mid+1, hi);
    }

    static void merge(int[] arr, int i, int j){
        for(int k = 0; k < j; k++){
            if(arr[k] < arr[j]){
            continue;
        }else{
            int temp = arr[k];
            arr[k] = arr[j+k];
            arr[j+k] = temp;
            }

        }
    }
}