/**
 * 插入排序
 * 每一次都和前面所有的数进行比较（当前面没有数或者前面的数比自己小停止）
 */
public class Insertion {
    public static void main(String[] args) {
        int [] arr={1,3,5,4,2,9,10,8,7,6};
        int[] insertion = Insertion(arr);
        for (int i : insertion) {
            System.out.println(i);
        }
    }
    //i=0时候前面没有数 不做比较 i=1时 需要与0比 i=2 需要和 1和2比 i=3 需要和123比......
    public static int[] Insertion(int arr[]){
        for(int i =1;i<arr.length;i++){
            for(int j=i-1;j>0&&arr[j]>arr[j-1];j--){
                utils.swap(arr,j,j-1);
            }
        }
        return arr;
    }
}
