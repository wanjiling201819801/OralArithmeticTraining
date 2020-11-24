import java.util.Random;
import java.util.Scanner;

public class OralArithmeticTraining_v01 {
    public static void main(String[] args) {
        //0 符号，1、2 前后两个操作数,3 正确答案结果,4 用户答案
        short[][] arr = new short[50][5];

        FormulaGeneration(arr);     //随机生成算式
        ProblemSetGeneration(arr);  //生成习题集
        AddSubCalUserInput(arr);    //加减法计算，存储用户答案
        PrintResults(arr);          //打印结果
    }
    //随机生成算式
    public static void FormulaGeneration(short arr[][]){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            ///生成‘+’、‘-’符号
            arr[i][0] = (short)random.nextInt(2);
            //产生100以内的随机数
            arr[i][1] = (short)random.nextInt(101);
            arr[i][2] = (short)random.nextInt(101);
        }
    }
    //生成习题集
    public static void ProblemSetGeneration(short arr[][]){
        char o = '+';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0]==0){
                o = '+';
                //存储正确答案
                arr[i][3] = (short)(arr[i][1] + arr[i][2]);
            }else{
                o = '-';
                arr[i][3] = (short)(arr[i][1] - arr[i][2]);
            }
            //显示习题
            System.out.println("No."+(i+1)+":\t"+arr[i][1]+o+arr[i][2]+"=");
        }
    }
    //加减法计算，存储用户答案
    public static void AddSubCalUserInput(short arr[][]){
        Scanner sin = new Scanner(System.in);
        for (int i = 0; i <arr.length; i++) {
            arr[i][4] = (short)sin.nextInt();
        }
    }
    //打印结果
    public static void PrintResults(short arr[][]){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i][4] == arr[i][3]  ){
                System.out.println("结果正确");
            }else{
                System.out.println("结果错误");
            }
        }
    }
}
