import java.io.*;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class AddSubOperation {
    public static void main(String[] args) throws Exception {
        short num1=0,num2=0,op=0;
        char o='+';
        String[] strings= new String[55];
        int[] res = new int[55];
        Random random = new Random();
        for (int i = 0; i < 50; i++) {//随机生成50道题
            num1 = (short)random.nextInt(101);
            num2 = (short)random.nextInt(101);
            op = (short)random.nextInt(2);
            if(op==1){
                o='+';
            }else{
                o='-';
            }
            strings[i] = "NO."+(i+1)+":\t"+num1+o+num2+"="; //生成算式
            res[i] = num1 + num2; //存储正确答案
            //System.out.println(strings[i]);
        }

        //将所有生成的算式存入到文件中
        FileWriter fin = new FileWriter("formulaGeneration.txt");
        BufferedWriter bin = new BufferedWriter(fin);
        for (int i = 0; i <50 ; i++) {
            bin.write(strings[i]);  //逐行存入文件
            bin.newLine();
        }
        bin.close(); //必须要关闭，内容才能全部写进去

        //逐行取出每行的算式，显示出来等待用户输入结果，将用户结果和正确答案比较，给出评判
        FileReader fout = new FileReader("formulaGeneration.txt");
        BufferedReader bout = new BufferedReader(fout);
        for (int i = 0; i <50 ; i++) {
            //逐行取出并显示
            System.out.println(bout.readLine());
            //获取用户输入结果并作出判断
            Scanner sin = new Scanner(System.in);
            int resUser = sin.nextInt();
            if(resUser == res[i]){
                System.out.println("结果正确！");
            }else{
                System.out.println("结果错误！");
            }
        }
    }
}
