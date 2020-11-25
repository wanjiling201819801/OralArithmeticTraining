package OralArithmeticTraining_v05;

import java.util.Scanner;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.*;

//检查和小于等于100 超过一直输入，直到满足条件
public class TestAddEquationClass {

    public static void main(String[] args) {
        TestAddEquation();
    }
    public static void TestAddEquation(){
        Scanner in = new Scanner(System.in);
        System.out.println("输入 左操作数 右操作数 : ");
        int leftOperand = in.nextInt();
        int rightOperand = in.nextInt();

        //加法 和不超过100
        while(leftOperand+rightOperand>100){
            System.out.println("加法算式的操作数的和超过100，重新输入");
            leftOperand = in.nextInt();
            rightOperand = in.nextInt();
        }
    }

}
