import java.util.Random;

public class AddSubOperation {
    public static void main(String[] args) {
        short a=0,b=0,ch=0;
        char c='+';
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            a = (short)random.nextInt(101);
            b = (short)random.nextInt(101);
            ch = (short)random.nextInt(2);
            if(ch==1){
                c='+';
            }else{
                c='-';
            }
            System.out.println("NO."+(i+1)+":\t"+a+c+b+"=");
        }
    }
}
