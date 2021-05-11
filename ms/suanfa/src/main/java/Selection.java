

/**
 * 选择排序
 * 每一轮与后面所有的数进行比较 比后面大就进行交换
 */
public class Selection {
    public static void main(String[] args) {
        int [] arr={1,3,5,4,2,9,8,7};
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                minPos=arr[j]<arr[minPos]?j:minPos;
            }
            utils.swap(arr,i,minPos);
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
