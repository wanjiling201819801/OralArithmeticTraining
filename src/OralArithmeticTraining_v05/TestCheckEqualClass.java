package OralArithmeticTraining_v05;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.*;
import java.util.Scanner;
//检测习题册中是否有重复算式
//0 1 2
//1 3 2
//0 1 2

public class TestCheckEqualClass {
    public static void main(String[] args) {
        TestCheckEqual();
    }

    public static void TestCheckEqual(){
        //i加入习题集的题目数量  equ[]待检测加入的算式  equSet[][]习题集
        int equ[] = new int[4];
        int  equSet[][] =new int[4][5];
        int res;
        Scanner in = new Scanner(System.in);
        System.out.println("输入算式：符号 左操作数 右操作数");
        for(int i=0;i<5;i++){
            //输入算式
            for (int k = 0; k <3; k++) {
                equ[k]=in.nextInt();
            }
            if(equ[0]==ADD_SIGN){
                res = equ[1]+equ[2];
            }else{
                res = equ[1]-equ[2];
            }
            //检验重复性
            boolean flag = true;
            //待检测加入的算式equ 和 前面的所有算式equSet[][j] 进行比较
            for(int j=i-1;j>=0;j--) { //-1 0 1
                //如果两个算式的结果相等，可能算式一样
                if( res == equSet[3][j] ) {
                    //两个操作数 和 运算符 一样
                    if(((equ[1]==equSet[1][j]&&equ[2]==equSet[2][j])||(equ[1]==equSet[2][j]&&equ[2]==equSet[1][j]))&&equ[0]==equSet[0][j]){
                        flag = false;
                    }
                }
            }
            if(flag == true) {
                for (int k = 0; k < 4; k++) {//0 1 2 3
                    equSet[k][i] = equ[k];
                }
            }else{
                System.out.println("该算式是重复的");
            }
        }
    }

}
