package OralArithmeticTraining_v05;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.*;
import java.util.Scanner;
//检测习题册中是否有重复算式
public class TestCheckEqualClass {
    public static void main(String[] args) {
        int[] equ = new int[]{1,4,3,0};
        int[][] subSet = new int[][]{{0,1,2,0},{1,3,2,0},{1,4,3,0},{0,8,9,0},{0,88,2,0}} ;
        for (int i = 0; i < 5; i++) {
            if(CheckEqual(equ, subSet[i])==true){
                System.out.println("与"+i+"没有重复的");
            }else{
                System.out.println("该算式是重复的");
                break;
            }
        }
    }
}
