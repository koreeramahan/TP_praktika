import java.util.Scanner;
import java.util.ArrayList;

public class Block56 {

    public static void canComplete(String not, String full)
    {
        int j = 0;
        for (int i = 0; i < full.length(); i++)
        {
            if (j >= not.length()) System.out.println("true");
            char ch = full.charAt(i);
            if (ch == not.charAt(j)) j++;
        }
        if (j == not.length()) System.out.println("true");
        else System.out.println("false");
    }

    public static void sumDigProd(ArrayList<Integer> mas)
    {
        int sum=0;
        for (int i:mas) sum+=i;
        while (sum>9)
        {
            String sumStr = Integer.toString(sum);
            sum=1;
            for (int i=0; i<sumStr.length(); i++)
                sum*=Integer.parseInt(String.valueOf(sumStr.charAt(i)));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Задание 3. Может ли быть завершена входная строка");
        System.out.println("Введите две строки:");
        String not = sc3.next();
        String full = sc3.next();
        canComplete(not, full);
        ///////////////////////////////////////
        Scanner sc4  = new Scanner(System.in);
        System.out.println("Задание 4. Введите числа:");
        String[] strArr = sc4.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>(strArr.length);
        for (int i=0; i<strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        sumDigProd(mas);
    }

}
