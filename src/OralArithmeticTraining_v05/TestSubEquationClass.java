package OralArithmeticTraining_v05;

import java.util.Scanner;

//检查减法算式操作数的差大于等于0   小于0就一直输入，直到满足条件
public class TestSubEquationClass {

    public static void main(String[] args) {
        TestAddEquation();

    }
    public static void TestAddEquation(){
        Scanner in = new Scanner(System.in);
        System.out.println("输入 左操作数 右操作数 : ");
        int leftOperand = in.nextInt();
        int rightOperand = in.nextInt();

        //减法 差不小于0
        while(leftOperand-rightOperand<0){
            System.out.println("减法算式的操作数的需要大于等于0，请重新输入");
            leftOperand = in.nextInt();
            rightOperand = in.nextInt();
        }
    }

}
