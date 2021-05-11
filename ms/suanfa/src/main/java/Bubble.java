/**
 * 冒泡排序
 * 时间复杂度 n^2 最坏时间复杂度 n^2 最好时间复杂度 n 稳
 * 每次都是相邻两个数比较 1与2 2与3 .....第一轮下来最大值就到最后面
 */
public class Bubble {
    public static void main(String[] args) {
        int [] arr={1,3,5,4,2,9,10,8,7,6};
       for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1])utils.swap(arr,j,j+1);
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
