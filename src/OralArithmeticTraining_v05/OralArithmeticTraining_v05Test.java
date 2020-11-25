package OralArithmeticTraining_v05;

public class OralArithmeticTraining_v05Test {
    public static int Max = 50;      //习题集算式数量
    public static int ADD_SIGN = 0;  //加法对应的整型
    public static int SUB_SIGN = 1;  //减法对应的整型
    public static int OPMAX = 6;
    //二维数组中一位数组的个数
    // 0 符号，1 左操作数, 2 右操作数，3 正确答案, 4 用户答案, 5 判断结果（0错误 1正确）
    public static double RATIO = 0.7;//加减法比例
    public static int STRLEN = 15;   //算式间距
    public static int COLNUM = 4;    //显示习题的列数

    public static void main(String[] args) {
        int[][] equSet = new int[OPMAX][Max];
        int[] equ = new int[OPMAX];

        //测试操作符
        TestOperatorClass operatorClass = new TestOperatorClass();
        // operatorClass.TestOperator();


        //测试操作数
//        TestGetOperands();
        //测试生成的算式是否合法
//        TestGenerateEquations(equ);
//        //测试生成的加法算式是否合法
//        TestAddEquation();
//        //测试生成的减法算式是否合法
//        TestSubEquation();
//        //测试打印习题册格式是否正确
//        TestPrintExercise();
//        //测试生成的习题集
//        TestCreateExercise(equSet);
//        TestCalculateRes(equSet);
//        //判断对错
//        TestJudgeUserRes(equSet);
//        //显示答案
//        TestShowAns(equSet);
//        //结果分析 返回正确的数量
//        TestAnalyRes(equSet);
    }



}

