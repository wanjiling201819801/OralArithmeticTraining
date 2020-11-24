import java.util.Random;
import java.util.Scanner;

public class 测试 {
    public static int Max = 100;
    public static void main(String[] args) {
        //0 符号，1、2 前后两个操作数,3 正确答案结果,4 用户答案
        short[][] arr = new short[10][5];
        FormulaGeneration(arr);     //输入算式
        PrintProblemSet(arr);       //打印习题集
        AddSubCalUserInput(arr);    //加减法计算，存储用户答案
        PrintResults(arr);          //打印结果
    }
    //输入算式
    public static void FormulaInput(short num[]){
        Scanner in = new Scanner(System.in);
        try {
            num[0]=(short)in.nextInt(); //表示符号 0加 1减
            num[1]=(short)in.nextInt(); //操作数1
            num[2]=(short)in.nextInt(); //操作数2
        }catch (Exception e){
            System.out.println("输入数据非短整型");
        }
        while((num[1]>100||num[1]<-100||num[2]>100||num[2]<-101)){
            System.out.println("操作数不在-100到100之间");
            num[0]=(short)in.nextInt();
            num[1]=(short)in.nextInt();
            num[2]=(short)in.nextInt();
        }
        if(num[0]!=0&&num[0]!=1){
            System.out.println("操作符非法，不是0或1");
            num[0]=(short)in.nextInt();
            num[1]=(short)in.nextInt();
            num[2]=(short)in.nextInt();
        }
        //加法 和不超过100

            while(num[1]+num[2]>100&&num[0]==0){
                System.out.println("算式和不在100以内");
                num[0]=(short)in.nextInt();
                num[1]=(short)in.nextInt();
                num[2]=(short)in.nextInt();
            }
            //减法 差不能小于0
            while(num[1]-num[2]<0&&num[0]==1){
                System.out.println("算式差不能小于0");
                num[0]=(short)in.nextInt();
                num[1]=(short)in.nextInt();
                num[2]=(short)in.nextInt();
            }
        }

    public static void FormulaGeneration(short arr[][]){
        short num[] = new short[3];
        int fsub=0;
        int fadd=0;
        for (int i = 0; i < arr.length; i++){
            FormulaInput(num);
            //符号
            arr[i][0] = num[0];
            if(num[0]==0){
                fadd=1;
            }else{
                fsub=1;
            }
            //得到两个数
            arr[i][1]=num[1];
            arr[i][2]=num[2];
        }
        if(fadd==0){
            System.out.println("全部是减法");
            //重新生成习题集
            for (int i = 0; i < arr.length; i++){
                FormulaInput(num);
                //符号
                arr[i][0] = num[0];
                if(num[0]==0){
                    fadd=1;
                }else{
                    fsub=1;
                }
                //得到两个数
                arr[i][1]=num[1];
                arr[i][2]=num[2];
            }
        }else {
            System.out.println("全部是加法");
            //重新生成习题集
            for (int i = 0; i < arr.length; i++){
                FormulaInput(num);
                //符号
                arr[i][0] = num[0];
                if(num[0]==0){
                    fadd=1;
                }else{
                    fsub=1;
                }
                //得到两个数
                arr[i][1]=num[1];
                arr[i][2]=num[2];
            }
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

