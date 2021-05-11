/**
 * 二分查找法
 */
public class MidSelection {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

        System.out.println(searchNum(arr, 1));
    }
    public static Boolean searchNum(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if(target>arr[mid]){
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else{
                return true;
            }
        }
        return arr[left]==target;
    }
}
