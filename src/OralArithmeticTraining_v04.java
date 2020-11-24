import java.util.Random;
import java.util.Scanner;

public class OralArithmeticTraining_v04 {
    public static int Max = 100;
    public static void main(String[] args) {
        //0 符号，1、2 前后两个操作数,3 正确答案结果,4 用户答案
        short[][] arr = new short[10][5];

        FormulaGeneration(arr);     //随机生成算式

        PrintProblemSet(arr);       //生成习题集

        AddSubCalUserInput(arr);    //加减法计算，存储用户答案

        PrintResults(arr);          //打印结果

    }
    //随机生成操作数（Max以内的数和负数）
    //[-Max,Max] = random(2*Max+1)-Max
    //正负数以及最大值都是可调的
    public static short OperandsRange(){
        Random random = new Random();
        return (short)(random.nextInt(2*Max+1)-Max);
    }
    //满足隐含条件的两个操作数
    public static void GetOperands(short ov,short num[]){
        short num1 = OperandsRange();
        short num2 = OperandsRange();
        //加法 和不超过100
        if(ov==0){
            while(num1+num2>100){
                num1 = OperandsRange();
                num2 = OperandsRange();
            }
        }else{
            //减法 差不能小于0
            while(num1-num2<0){
                num1 = OperandsRange();
                num2 = OperandsRange();
            }
        }
    }
    //生成符号
    public static short Operator(){
        Random random = new Random();
        short ratio = (short)random.nextInt(100);
        //控制生成符号的比例大约是 加：减=3：1
        if(ratio<75){
            return 0;
        }else{
            return 1;
        }
    }
    //生成算式
    public static void FormulaGeneration(short arr[][]){
        short num[] = new short[2];
        for (int i = 0; i < arr.length; i++){ // 0 1 2 3
            int flag = 1;       //标志是否重复，1表示没有重复
            //符号
            arr[i][0] = Operator();  // 1 0 0 0
            //得到没有重复的两个数
            GetOperands(arr[i][0],num); //1 2 3 4  3 4 5 2
            arr[i][1]=num[0];  // 1 2 3 4
            arr[i][2]=num[1];  // 3 4 5 2

            //判断是否重复
            {   flag =1;
                for (int j = 0; j < i; j++) {  // 0 1 2 3
                    //如果重复，重新获取
                    if(num[0]==arr[j][1]&&num[1]==arr[j][2]||num[0]==arr[j][2]&&num[1]==arr[j][1]){
                        GetOperands(arr[i][0],num); //1 2 3 4  3 4 5 2
                        arr[i][1]=num[0];  // 1 2 3 4
                        arr[i][2]=num[1];  // 3 4 5 2
                        flag=0;
                    }
                }
            }while (flag==0);
        }
    }

    //生成习题集
    public static void PrintProblemSet(short arr[][]){
        char o = '+';
        String str = null;
        for (int i = 0; i < arr.length; i++) {
            //存储正确答案
            if(arr[i][0]==0){
                o = '+';
                arr[i][3] = (short)(arr[i][1] + arr[i][2]);
            }else{
                o = '-';
                arr[i][3] = (short)(arr[i][1] - arr[i][2]);
            }
            //显示习题
            int j= i%3;
            if(arr[i][2]<0){
                str="No."+(i+1)+": "+arr[i][1]+o+"("+arr[i][2]+")=";
            }else{
                str="No."+(i+1)+": "+arr[i][1]+o+arr[i][2]+"=";
            }
            while(str.length()<25){
                str+=' ';
            }
            System.out.print(str);
            if(j==2){
                System.out.println();
            }
        }
        System.out.println();
    }
    //加减法计算，输入并存储用户答案
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
