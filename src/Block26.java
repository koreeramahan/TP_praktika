import java.util.Scanner;

public class Block26 {
    static void repeat(){}
    static void differenceMaxMin(int[] array,int n){
        int min=array[0]; int max=array[0];
        for (int i=0;i<n;i++)
        {
            if (min>array[i]) min=array[i];
            if (max<array[i]) max=array[i];
        }
        System.out.println("Наименьшее значение: "+min);
        System.out.println("Наибольшее значение: "+max);
        System.out.println("Разница между max и min значениями: " + (max-min));
    }
    static void isAvgWhole(){}
    static void cumulativeSum() {}
    static void getDecimalPlaces() {}
    static void fibonacci(){}
    static void isValid(){}
    static void isStrangePair(){}
    static void isPrefix(){}
    static void isSuffix(){}
    static void boxSeq(){}

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        /////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Введите количество чисел в массиве");
        int n = sc.nextInt();
        int[] array = new int [n];
        for (int i=0; i < n; i++) {
            System.out.println("Введите число "+(i+1));
            array[i]=sc.nextInt();
        }
        differenceMaxMin(array,n);
    }
}


