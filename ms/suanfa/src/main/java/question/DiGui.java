package question;

/**
 * 递归问题
 * 获取一个数组中的最大值
 */
public class DiGui {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int L, int R) {
        //L.....R中间没有数
        if(L==R) return arr[L];
        //L.....R中间不止一个数
        int mid=L+((R-L)>>1);
        int leftMax=process(arr,L,mid);
        int rightMax=process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
}
