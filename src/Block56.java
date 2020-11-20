import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class Block56 {

    public static void encrypt(String str)
    {
        String res = "";
        char first = str.charAt(0);
        res+=(int)first;
        res+=" ";
        for (int i=1; i<str.length(); i++)
        {
            char next=str.charAt(i);
            res+=(int)next-first;
            res+=" ";
            first=next;
        }
        System.out.println(res);
    }

    public static void decrypt(String str)
    {
        String res = "";
        String[] code = str.split(" ");
        int letter=Integer.parseInt(code[0]);
        res+=(char)letter;
        for (int i=1; i<code.length; i++)
        {
            letter+=Integer.parseInt(code[i]);
            res+=(char)(letter);
        }
        System.out.println(res);
    }

    public static void canMove(String f, String p, String d)
    {
        boolean res = false;
        char startLetter = p.charAt(0);
        int startNumber = Integer.parseInt(String.valueOf(p.charAt(1)));
        char finLetter = d.charAt(0);
        int finNumber = Integer.parseInt(String.valueOf(d.charAt(1)));
        if (startLetter == finLetter && startNumber == finNumber) res=false;
        switch (f){
            //одну вперед
            case "Pawn":
            {
                if (startLetter==finLetter && startNumber==2 && finNumber==4) res=true;
                if (startLetter==finLetter && startNumber==(finNumber-1)) res=true;
            }
            //сначала два, потом один, буквой г
            case "Knight":
            {
                if ((Math.abs(startLetter-finLetter)==2 && Math.abs(startNumber-finNumber)==1)
                        ||(Math.abs(startLetter-finLetter)==1 && Math.abs(startNumber-finNumber)==2)) res=true;
            }
            //по диагонали, буквы и цифры одинаковые
            case "Bishop":
            {
                if (Math.abs(startLetter-finLetter)==Math.abs(startNumber-finNumber)) res=true;
            }
            //либо одинаковые цифры, либо буквы
            case "Rook":
            {
                if ((startLetter==finLetter && startNumber!=finNumber) || (startLetter!=finLetter && startNumber==finNumber)) res=true;
            }
            //слон плюс ладья
            case "Queen":
            {
                if ((startLetter==finLetter && startNumber!=finNumber) || (startLetter!=finLetter && startNumber==finNumber)) res=true;
                if (Math.abs(startLetter-finLetter)==Math.abs(startNumber-finNumber)) res=true;
            }
            //вокруг себя в радиусе 1
            case "King":
            {
                if (Math.abs(startLetter-finLetter)<2 && Math.abs(startNumber-finNumber)<2) res=true;
            }
        }
        System.out.println(res);
    }

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
        else {
            char check = code.charAt(code.length() - 1); //посл цифра
            code = code.substring(0, code.length() - 1); //шаг1. убираем посл цифру из номера карты
            code = new StringBuilder(code).reverse().toString(); //шаг2. переворачиваем
            StringBuilder doubleCode = new StringBuilder();
            //шаг 3. удваиваем числа на нечетных местах
            for (int i = 0; i < code.length(); i++) {
                if (i % 2 == 0) {
                    int val = Integer.parseInt(String.valueOf(code.charAt(i))) * 2;
                    if (val > 9) val = val / 10 + val % 10;
                    doubleCode.append(val);
                } else doubleCode.append(code.charAt(i));
            }
            int sum = 0;
            //шаг 4. складываем все цифры
            for (int i = 0; i < doubleCode.length(); i++) {
                sum += Integer.parseInt(String.valueOf(doubleCode.charAt(i)));
            }
            //шаг 5. вычитаем из 10 последнюю цифру суммы
            sum = 10 - sum % 10;
            if (check == Integer.toString(sum).charAt(0)) System.out.println("true");
            else System.out.println("false");
        }
    }

    public static void numToEng(int n)
    {
        if (n==0) System.out.println("zero");
        int[] digits = {n/100,(n/10)%10,n%10};
        String[] singleDigitNum = {"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        String[] ten = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety"};
        String[] hundred = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        String res = "";
        if (digits[0]>0) res+=singleDigitNum[digits[0]] + " hundred";
        if (digits[1]==1)
        {
            if (res.length()>0) res+=" ";
            res+=hundred[digits[2]];
            System.out.println(res);
        }
        else if (digits[1]>1)
        {
            if (res.length()>0) res+=" ";
            res+=ten[digits[1]];
        }
        if (digits[2]>0)
        {
            if (res.length()>0) res+=" ";
            res+=singleDigitNum[digits[2]];
        }
        System.out.println(res);
    }

    public static void numToRus(int n)
    {
        if (n == 0) System.out.println("ноль");
        int[] digits = {n/100,(n/10)%10,n%10};
        String[] singleDigitNum = {"ноль", "один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять"};
        String[] hundred = {"ноль", "сто", "двести", "триста", "четыреста",
                "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] ten = {"ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
                "семьдесят", "восемьдесят", "девяносто"};
        String[] tens = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
                "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать"};
        String res="";
        if (digits[0]>0) res+=hundred[digits[0]];
        if (digits[1]==1)
        {
            if (res.length()>0) res+=" ";
            res+=tens[digits[2]];
            System.out.println(res);
        }
        else if (digits[1]>1)
        {
            if (res.length()>0) res+=" ";
            res+=ten[digits[1]];
        }
        if (digits[2]>0)
        {
            if (res.length()>0) res+=" ";
            res+=singleDigitNum[digits[2]];
        }
        System.out.println(res);
    }

    public static void getSha256Hash(String hash) throws NoSuchAlgorithmException {
        byte[] code;
        MessageDigest md = MessageDigest.getInstance("SHA-256"); //объект для преобразования в дайджест
        code = md.digest(hash.getBytes(StandardCharsets.UTF_8)); //передем данные и создаем дайджест
        BigInteger num = new BigInteger(1, code);
        //форматируем в вид 16ной цифры
        StringBuilder res = new StringBuilder(num.toString(16));
        while (res.length()<32) res.insert(0, '0');
        System.out.println(res.toString());
    }

    public static void correctTitle(String title)
    {
        title=title.toLowerCase();
        //разделяем слова
        String[] w=title.split(" ");
        for (int i=0; i<w.length; i++)
        {
            //если не and the of in то пишем с заглавной буквы
            if (!(w[i].contentEquals("and") || w[i].contentEquals("of")
                    || w[i].contentEquals("the") || w[i].contentEquals("in")))
            {
                String newW=w[i].substring(0,1).toUpperCase()+w[i].substring(1);
                w[i]=newW;
            }
        }
        System.out.println(String.join(" ", w));
    }

    public static void hexLattice(int n)
    {
        
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Задание 1. Введите сообщение:");
        String str = sc1.nextLine();
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') decrypt(str);
        else encrypt(str);
        ///////////////////////////////////////
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Задание 2. Введите фигуру, ее позицию и цель: ");
        String f = sc2.next();
        String p = sc2.next();
        String d = sc2.next();
        canMove(f,p,d);
        ///////////////////////////////////////
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
        System.out.println("Задание 6. Введите номер карты:");
        String code = sc6.next();
        validateCard(code);
        ////////////////////////////////////////
        Scanner sc7  = new Scanner(System.in);
        System.out.println("Задание 7. Введите число:");
        int n = sc7.nextInt();
        numToEng(n);
        numToRus(n);
        ////////////////////////////////////////
        Scanner sc8  = new Scanner(System.in);
        System.out.println("Задание 8. Возвращение безопасного хэша, введите строку:");
        String hash = sc8.next();
        getSha256Hash(hash);
        ////////////////////////////////////////
        Scanner sc9  = new Scanner(System.in);
        System.out.println("Задание 9. Правильная запись титула.");
        System.out.println("Введите титул из Игры Престолов:");
        String title = sc9.nextLine();
        correctTitle(title);
        ////////////////////////////////////////
        Scanner sc10 = new Scanner(System.in);
        System.out.println("Задание 10. Центрированное шестиугольное число.");
        System.out.println("Введите число:");
        int hex = sc10.nextInt();
        hexLattice(hex);
    }

}
