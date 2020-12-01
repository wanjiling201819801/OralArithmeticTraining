package OralArithmeticTraining_v05;
import java.util.Scanner;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.AddEquation;

//检查和小于等于100 超过一直输入，直到满足条件
public class TestAddEquationClass {

    public static void main(String[] args) {
        int[] equ = new int[4];
        TestAddEquation(equ);
        TestAddEquation();
    }

    public static void TestAddEquation(){
        Scanner in = new Scanner(System.in);
        System.out.println("输入 左操作数 右操作数 : ");
        int leftOperand = in.nextInt();
        int rightOperand = in.nextInt();

        //加法 和不超过100
        if(leftOperand+rightOperand<=100){
            System.out.println("加法算式和满足要求");
        }
        while(leftOperand+rightOperand>100){
            System.out.println("加法算式的操作数的和超过100");
            leftOperand = in.nextInt();
            rightOperand = in.nextInt();
        }
    }
    //测试二：对运算结果的检查
    public static void TestAddEquation(int[] equ){
        AddEquation(equ);
        //加法 和不超过100
        if(equ[1]+equ[2]<=100){
            System.out.println("加法算式和满足要求");
        }
        while(equ[1]+equ[2]>100){
            System.out.println("加法算式的操作数的和超过100");
        }
        System.out.println(equ[1]+"+"+equ[2]+"="+equ[3]);
    }
}
