package OralArithmeticTraining_v05;

//测试操作数的合法性 [0,100]
//方法1 检查随机生成的操作数是否在[0,100]
//方法2 将随机生成改成手动输入非法和合法的操作数，查看checkOperands()方法结果

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.checkOperands;

public class TestGetOperandsClass {
    public static int Max = 50;      //习题集算式数量

    public static void main(String[] args) {
        TestGetOperands_one();
        TestGetOperands_two();
    }


    //方法1 检查随机生成的操作数是否在[0,100]
    public static void TestGetOperands_one(){
        int flag=0;
        for (int i = 0; i < Max; i++) {
            int operands = OralArithmeticTraining_v05.GetOperands();
            System.out.print( " "+operands);//操作符的合法性 只有0，1
            if(operands>100||operands<0){
                System.out.println("操作数非法，不在[0,100]范围内");
                flag=1;
            }
        }
        System.out.println();
        if(flag==0){
            System.out.println("随机生成的操作数都在[0,100]");
        }
    }

    //方法2 将随机生成改成手动输入非法和合法的操作数，查看checkOperands()方法结果
    public static void TestGetOperands_two(){

        for (int op = -2; op < 2; op++) { // -2 -1 0 1
            if (checkOperands(op)==false){
                System.out.println(op+"是非法数，"+"请重新赋值");
            }else{
                System.out.println(op+"在[0,100]之间");
            }
        }

        for (int op = 102; op > 98 ; op--) { // 102 101 100 99
            if (checkOperands(op)==false){
                System.out.println(op+"是非法数，"+"请重新赋值");
            }else{
                System.out.println(op+"在[0,100]之间");
            }
        }
    }
}
