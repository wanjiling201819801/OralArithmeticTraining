package OralArithmeticTraining_v05;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.*;

//测试操作数生成比例 0.7
public class TestOperatorClass {
        public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            TestOperator();
        }
    }
    //测试操作数生成比例 0.7
    public static void TestOperator(){
        int addnum = 0;
        double ratio;
        for (int i = 0; i < Max; i++) {
            int op = OralArithmeticTraining_v05.Operator();
            //System.out.print(op+" ");//操作符的合法性 只有0，1
            if(op==ADD_SIGN){
                addnum++;
            }
        }
        ratio = (double) addnum/(double)Max;
        System.out.println("加法个数:"+addnum+"\t总数:"+Max+"\t加减算式的比例:"+ratio);
    }
}
