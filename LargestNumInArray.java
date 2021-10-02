public class Largest_Num_In_Array {
    int LargestNum (int [] arr){
        if (arr == null)
        return 0;
        int largest = arr[0];
        for (int i=1; i<arr.length; i++){
            if (largest<arr[i])
                largest = arr[i];
        }
        return largest;
    }

    public static void main(String[] args) {

        int [] arr = new int[]{1, 2,6,69,8,90};
        Largest_Num_In_Array lnm = new Largest_Num_In_Array();
        System.out.println(lnm.LargestNum(arr));
    }

}
