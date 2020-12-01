package OralArithmeticTraining_v05;

import java.util.Scanner;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.*;

//检测输入操作符(0 1)，能否生成对应的加减法算式
public class TestGenerateEquationsClass {
    public static void main(String[] args) {
        int[] equ = new int[4];
        Scanner in = new Scanner(System.in);
        System.out.println("输入算式的操作符:");
        for (int i = 0; i < 5; i++) {
            equ[0] = in.nextInt();
            TestGenerateEquations(equ);
        }

    }
    public static void TestGenerateEquations(int[] equ){

        //加法 和不超过100
        if(equ[0]==ADD_SIGN){
            AddEquation(equ);
            System.out.println(equ[1]+"+"+equ[2]+"="+equ[3]);
        }
        //减法 差不小于0
        if (equ[0]==SUB_SIGN){
            SubEquation(equ);
            System.out.println(equ[1]+"-"+equ[2]+"="+equ[3]);
        }

    }
}
