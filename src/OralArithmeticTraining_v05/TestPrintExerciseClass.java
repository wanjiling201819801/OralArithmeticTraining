package OralArithmeticTraining_v05;

import java.util.Scanner;

import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.Max;
import static OralArithmeticTraining_v05.OralArithmeticTraining_v05.PrintExercise;

public class TestPrintExerciseClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int equSet[][] = new int[3][Max];

        TestPrintExercise(equSet);
    }
    public static void TestPrintExercise(int equSet[][]){
        PrintExercise(equSet);
    }
}
