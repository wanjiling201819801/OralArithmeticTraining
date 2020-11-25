package OralArithmeticTraining_v05;

import java.util.Random;
import java.util.Scanner;

public class OralArithmeticTraining_v05 {
    public static int Max = 50;      //习题集算式数量
    public static int ADD_SIGN = 0;  //加法对应的整型
    public static int SUB_SIGN = 1;  //减法对应的整型
    public static int OPMAX = 6;     //二维数组中一位数组的个数 0 符号，1 左操作数, 2 右操作数，3 正确答案, 4 用户答案, 5 判断结果（0错误 1正确）
    public static double RATIO = 0.7;//加减法比例
    public static int STRLEN = 15;   //算式间距
    public static int COLNUM = 4;

    public static void main(String[] args) {
        int[][] equSet = new int[OPMAX][Max];
        //生成习题集
        CreateExercise(equSet);
        //计算
        CalculateRes(equSet);
        //判断对错
        JudgeUserRes(equSet);
        //显示答案
        ShowAns(equSet);
        //结果分析 返回正确的数量
        AnalyRes(equSet);

    }

    //生成符号 加减法的比例确定
    public static int Operator(){
        //加减法的比例确定
        int addRatio = (int)( (double)Max * RATIO );

        Random random = new Random();
        //按比例计算 加法算式的数量
        int allRandom = random.nextInt(Max);
        //控制生成符号的比例
        if(allRandom < addRatio){
            return ADD_SIGN;
        }else{
            return SUB_SIGN;
        }
    }

    //生成操作数 范围[0,Max]
    public static int GetOperands(){
        Random random = new Random();
        //return (random.nextInt(2*Max+1)-Max); //操作数范围 [-Max,Max]
        int op = random.nextInt(2*Max+1);
        while(checkOperands(op)==false){
            op = random.nextInt(2*Max+1);
        }
        return op;
    }

    //为检验获得操作数确实在[0,100]之间
    public static boolean checkOperands(int op){
        return op <= 100 && op >= 0;
    }

    //生成算式
    public static void GenerateEquations(int[] equ){
        int op = Operator();

        //加法 和不超过100
        if(op==ADD_SIGN){
            AddEquation(equ);
        }

        //减法 差不小于0
        if(op==SUB_SIGN){
            SubEquation(equ);
        }

        equ[0]=op;
    }

    //生成加法算式
    public static void AddEquation(int[] equ){

        int leftOperand = GetOperands();
        int rightOperand = GetOperands();
        int res=0;

        //加法 和不超过100
        while(leftOperand+rightOperand>100){
            leftOperand = GetOperands();
            rightOperand = GetOperands();
        }
        res = leftOperand + rightOperand;

        equ[1]=leftOperand;
        equ[2]=rightOperand;
        equ[3]=res;
    }

    //生成减法算式
    public static void SubEquation(int[] equ){

        int leftOperand = GetOperands();
        int rightOperand = GetOperands();
        int res=0;

        //减法 差不小于0
        while(leftOperand-rightOperand<0){
            leftOperand = GetOperands();
            rightOperand = GetOperands();
        }
        res = leftOperand - rightOperand;

        //通过数组传递参数
        equ[1]=leftOperand;
        equ[2]=rightOperand;
        equ[3]=res;
    }

    //打印习题集
    public static void PrintExercise(int[][] equSet){
        System.out.println("口算练习题");
        char op='+';
        for (int i = 0; i < Max; i++) {
            if(equSet[0][i]==ADD_SIGN){
                op='+';
            }
            if(equSet[0][i]==SUB_SIGN){
                op='-';
            }
            //System.out.print("No."+(i+1)+": "+equSet[1][i]+op+equSet[2][i]+"=\t");
            //if((i+1)%COLNUM==0){
            //    System.out.println();
            //}
            String equStr = "No."+(i+1)+": "+equSet[1][i]+op+equSet[2][i]+"=";
            while(equStr.length()<=STRLEN){
                equStr += " ";
            }
            System.out.print(equStr);
            if((i+1)%COLNUM==0){
                System.out.println();
            }
        }
    }

    //生成习题集
    public static void CreateExercise(int[][] equSet){
        int[] equ = new int[OPMAX];

        for(int i=0; i<Max; i++) {
            //生成算式
            GenerateEquations(equ);
            boolean flag=false;
            if(CheckEqual(i,equ,equSet)==false) {
                i--;
                continue;
            }else {
                //将算式加入习题集
                for (int k = 0; k < 4 ; k++) {//0 1 2 3
                    equSet[k][i]=equ[k];
                }
            }
        }
        //打印习题集
        PrintExercise(equSet);
    }

    //检查重复算式
    public static boolean CheckEqual(int i, int[] equ, int[][] equSet){
        //i 加入习题集的题目数量  equ[]待检测加入的算式  equSet[][]习题集
        int op = equ[0];
        int leftOperand = equ[1];
        int rightOperand = equ[2];
        int res = equ[3];

        boolean flag = false;
        //当前预生成的算式equ 和 前面的所有算式equSet[][j] 进行比较
        for(int j=i-1;j>=0;j--) { //-1 0 1
            //如果两个算式的结果相等，可能算式一样
            if( res == equSet[3][j] ) {
                //两个操作数 和 运算符 一样
                if(((leftOperand==equSet[1][j]&&rightOperand==equSet[2][j])||(leftOperand==equSet[2][j]&&rightOperand==equSet[1][j]))&&op==equSet[0][j]){
                    return false;
                }
            }
        }
        return true;
    }

    //用户输入计算结果
    public static void CalculateRes(int[][] equSet){
        Scanner userIn = new Scanner(System.in);
        for (int i = 0; i < Max; i++) {
            //equSet[4][i] = userIn.nextInt();
        }
    }

    //判断并打印结果
    public static void JudgeUserRes(int[][] equSet){
        for (int i = 0; i < Max; i++) {
            if(equSet[3][i]==equSet[4][i]){
                equSet[5][i] = 1; //正确
            }else{
                equSet[5][i] = 0; //错误
            }
        }
    }

    //显示答案
    public static void ShowAns(int[][] equSet){
        System.out.println("\n********************************************************************");
        System.out.println("用户参考答案");
        for (int i = 0; i < Max; i++) {
            String ansStr = "No."+(i+1)+": "+equSet[3][i];
            while(ansStr.length()<=STRLEN){
                ansStr += " ";
            }
            System.out.print(ansStr);
            if((i+1)%COLNUM==0){
                System.out.println();
            }
        }
    }

    //结果分析 返回正确的数量
    public static int AnalyRes(int[][] equSet){
        int correct = 0;
        for (int i = 0; i < Max; i++) {
            correct +=  equSet[5][i];
        }
        return correct;
    }

}
