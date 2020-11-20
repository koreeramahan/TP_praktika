import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

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
        //складываем введенные числа
        for (int i:mas) sum+=i;
        //умножаем цифры числа, пока оно не станет <=9
        while (sum>9)
        {
            String sumStr = Integer.toString(sum);
            sum=1;
            for (int i=0; i<sumStr.length(); i++)
                sum*=Integer.parseInt(String.valueOf(sumStr.charAt(i)));
        }
        System.out.println(sum);
    }

    public static void sameVowelGroup(String words) {
        String[] strArr = words.split(" ");
        HashSet<Character> pattern = new HashSet<>(); //создает коллекцию, которая использует хеш-таблицу для хранения
        //добавляем в хэш все гласные первого слова
        for (int i=0; i<strArr[0].length(); i++) {
            char ch = strArr[0].charAt(i);
            if (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a')
                pattern.add(ch);
        }
        //находим слова с такими же гласными
        StringBuilder res = new StringBuilder(strArr[0]);
        for (int i=1; i<strArr.length; i++) {
            for (int j=0; j<strArr[i].length(); j++) {
                char ch=strArr[i].charAt(j);
                if (!pattern.contains(ch) && (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a')) break;
                if (j==strArr[i].length()-1) {
                    res.append(',');
                    res.append(strArr[i]);
                }
            }
        }
        System.out.println(res);
    }

    public static void validateCard(String code) {
        if (code.length()<14 || code.length()>19) System.out.println("false"); //длина карты
        char check = code.charAt(code.length()-1); //посл цифра
        code=code.substring(0, code.length()-1); //шаг1. убираем посл цифру из номера карты
        code=new StringBuilder(code).reverse().toString(); //шаг2. переворачиваем
        StringBuilder doubleCode=new StringBuilder();
        //шаг 3. удваиваем числа на нечетных местах
        for (int i=0; i<code.length(); i++)
        {
            if (i%2==0)
            {
                int val=Integer.parseInt(String.valueOf(code.charAt(i)))*2;
                if (val>9) val=val/10+val%10;
                doubleCode.append(val);
            }
            else doubleCode.append(code.charAt(i));
        }
        int sum=0;
        //шаг 4. складываем все цифры
        for (int i=0; i<doubleCode.length(); i++)
        {
            sum+=Integer.parseInt(String.valueOf(doubleCode.charAt(i)));
        }
        //шаг 5. вычитаем из 10 последнюю цифру суммы
        sum=10-sum%10;
        if (check==Integer.toString(sum).charAt(0)) System.out.println("true");
        else System.out.println("false");
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
        for (String s:strArr) mas.add(Integer.parseInt(s));
        sumDigProd(mas);
        ////////////////////////////////////////
        Scanner sc5  = new Scanner(System.in);
        System.out.println("Задание 5. Выводятся слова, в которых гласные такие же как в первом.");
        System.out.println("Введите последовательность слов:");
        String words = sc5.nextLine();
        sameVowelGroup(words);
        ////////////////////////////////////////
        Scanner sc6  = new Scanner(System.in);
        System.out.println("Введите номер карты:");
        String code = sc6.next();
        validateCard(code);
    }

}
