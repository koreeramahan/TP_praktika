import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Block66 {
    public static void bell(int n) {
        int[][] res = new int[n + 1][n + 1];
        res[0][0] = 1;
        //количество способов, которыми массив из n элементов может быть разбит на подмножества
        for (int i = 1; i <= n; i++) {
            res[i][0] = res[i - 1][i - 1];
            for (int j = 1; j <= i; j++) res[i][j] = res[i - 1][j - 1] + res[i][j - 1];
        }
        System.out.println(res[n][0]);
    }

    public static String translateWord(String str) {
        //если слово начинается с гласной
        if ("aoueiy".contains(str.substring(0, 1).toLowerCase())) return str + "yay";
        //если слово начинается с согласной
        else {
            //пока не дойдем до гласной
            while (!"aoueiy".contains(str.substring(0, 1).toLowerCase())) {
                //двигаем согласную в конец
                if (Character.isUpperCase(str.charAt(0)))
                    str = str.substring(1, 2).toUpperCase() + str.substring(2) + str.substring(0, 1).toLowerCase();
                else str = str.substring(1) + str.substring(0, 1);
            }
            //прибавляем ай на конце
            return str + "ay";
        }
    }

    public static void translateSentence(String sent) {
        //Pattern Matcher для работы с регулярными выражениями,
        // которые представлябт шаблон для поиска совпадений в строке
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher mat = pat.matcher(sent);
        int index = 0;
        while (mat.find()) {
            //ищем слово
            String word = mat.group();
            index = sent.indexOf(word, index);
            //преобразуем слово
            sent = sent.substring(0, index) + sent.substring(index).replaceFirst(word, translateWord(word));
        }
        System.out.println(sent);
    }

    public static void validColor(String col) {
        //создаем шаблон для поиска совпадений по строке
        String pattern = "rgb\\(\\d+,\\d+,\\d+\\)";
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(col);
        boolean res = true;
        //проверяем структуру
        if (!mat.find()) {
            pattern = "rgba\\(\\d+,\\d+,\\d+,(1|(0(\\.\\d+)?))\\)";
            pat = Pattern.compile(pattern);
            mat = pat.matcher(col);
            if (!mat.find()) res = false;
        }
        //проверяем, что диапазон от 0 до 255
        pattern = "\\d+";
        pat = Pattern.compile(pattern);
        mat = pat.matcher(col);
        for (int i = 0; i < 3; i++) {
            //проверяем каждое из трех чисел в скобке
            mat.find();
            int val = Integer.parseInt(mat.group(0));
            if (val < 0 || val > 255) res = false;
        }
        System.out.println(res);
    }

    public static void stripUrlParams(String url) {
        //передаем в процедуру с нулевым параметром
        System.out.println(stripUrlParams(url, new String[]{""}));
    }

    public static String stripUrlParams(String url, String[] block) {
        //удаляем дублирующие параметры запроса и параметры, указанные во втором аргументе
        HashSet<String> blockKeys = new HashSet<>(block.length);
        for (String val : block) blockKeys.add(val);
        //отделяем адрес от параметров
        String[] urlParts = url.split("\\?", 2);
        //если есть параметры
        if (urlParts.length > 1) {
            //берем параметр
            String[] params = urlParts[1].split("&");
            HashMap<String, String> map = new HashMap<>();
            //запоминаем его значение
            for (String param : params) {
                String[] paramParts = param.split("=", 2);
                //помещаем в коллекцию значение
                map.put(paramParts[0], paramParts[1]);
            }
            String res = urlParts[0] + "?";
            Set<String> keys = map.keySet();
            for (String key : keys) if (!blockKeys.contains(key)) res += key + "=" + map.get(key) + "&";
            return res.substring(0, res.length() - 1);
        } else return url;
    }

    public static void getHashTags(String tag) {
        //извлечь три самых длинных слова и вывести их хештегами
        //делим на слова предложение
        String[] words=tag.split(" |\\W ");
        //для хранения трех длинных слов
        ArrayList<String> res = new ArrayList<>(3);
        res.add("");
        res.add("");
        res.add("");
        for (String word:words)
        {
            //пока слова не закончатся перебираем
            if (!res.contains(word))
            {
                //если слово длиннее результата 3
                if (word.length() > res.get(2).length())
                {
                    //если слово длиннее результата 2
                    if (word.length() > res.get(1).length())
                    {
                        //если слово длиннее результата 1
                        if (word.length() > res.get(0).length())
                        {
                            res.set(2, res.get(1)); //2 рез записывается в 3
                            res.set(1, res.get(0)); //1 рез записывается во 2
                            res.set(0, word); //слово записывается в 1 рез
                        }
                        else
                        {
                            res.set(2, res.get(1)); //2 рез записывается в 3
                            res.set(1, word); //слово записывается во 2 рез
                        }
                    }
                    else res.set(2, word); //слово записывается в 3 рез
                }
            }
        }
        String result = "";
        Iterator<String> it = res.iterator();
        //выводим элементы, пока они закончатся
        while (it.hasNext())
        {
            String val = it.next();
            if (!val.equals("")) result+="#"+val.toLowerCase()+" ";
        }
        System.out.println(result);
    }

    public static void ulam(int u) {
        //наименьшее положительное число равное сумме двух разных чисел
        ArrayList<Integer> mas = new ArrayList<>(u);
        //обслуживание очереди по приоритету
        PriorityQueue<Integer> sumArr = new PriorityQueue<>();
        HashSet<Integer> hash = new HashSet<>();
        mas.add(1);
        mas.add(2);
        sumArr.add(mas.get(0)+mas.get(1));
        while (mas.size()<u)
        {
            int sum = sumArr.poll();
            for (int i : mas)
            {
                i += sum;
                //ищем разные наименьше числа
                if (!hash.contains(i))
                {
                    //складываем
                    if (!sumArr.contains(i)) sumArr.add(i);
                    else
                    {
                        sumArr.remove(i);
                        hash.add(i);
                    }
                }
            }
            mas.add(sum);
        }
        System.out.println(mas.get(u-1));
    }

    public static void longestNonrepeatingSubstring(String repeat){
        //вывести самую длинную неповторяющуся последовательность букв
        String longest="";
        String cur="";
        for (int i=0; i<repeat.length(); i++)
        {
            //если буквы разные, записываем
            if(!cur.contains(repeat.substring(i, i+1))) cur+=repeat.substring(i, i+1);
            else
            {
                //если новая последовательность длиннее
                if (cur.length()>longest.length()) longest=cur;
                cur="";
            }
        }
        if (cur.length()>longest.length()) longest=cur;
        System.out.println(longest);
    }

    public static void convertToRoman(int arab) {
        //преобразовать арабское число в римское
        Stack<String> res = new Stack<>();
        //проверяем, чтобы число было не больше 3999
        if (arab > 3999) System.out.println("false");
        else {
            for (int i=0; i<4&&arab>0; i++) {
                char a,b,c;
                switch (i) {
                    case 0:
                        a='I';
                        b='V';
                        c='X';
                        break;
                    case 1:
                        a='X';
                        b='L';
                        c='C';
                        break;
                    case 2:
                        a='C';
                        b='D';
                        c='M';
                        break;
                    default:
                        a='M';
                        b='M';
                        c='M';
                }
                //с помощью деления рассматриваем каждую цифру отдельно и выводим ее римское рпедставление
                switch (arab%10) {
                    case 1:
                        //помещаем в стек
                        res.push(Character.toString(a));
                        break;
                    case 2:
                        res.push(Character.toString(a) + Character.toString(a));
                        break;
                    case 3:
                        res.push(Character.toString(a) + Character.toString(a) + Character.toString(a));
                        break;
                    case 4:
                        res.push(Character.toString(a) + Character.toString(b));
                        break;
                    case 5:
                        res.push(Character.toString(b));
                        break;
                    case 6:
                        res.push(Character.toString(b) + Character.toString(a));
                        break;
                    case 7:
                        res.push(Character.toString(b) + Character.toString(a) + Character.toString(a));
                        break;
                    case 8:
                        res.push(Character.toString(b) + Character.toString(a) + Character.toString(a) + Character.toString(a));
                        break;
                    case 9:
                        res.push(Character.toString(a) + Character.toString(c));
                        break;
                }
                arab/=10;
            }
        }
        String str = "";
        while (res.size()>0) str+=res.pop(); //вытаскиваем из стека
        System.out.println(str);
    }

    public static void formula(String f) {
        //проверяем правильно ли написана формула
        boolean res=true;
        //убираем пробелы
        f=f.replace(" ", "");
        //делим на левую и правую часть для сравнения
        String[] eq = f.split("=");
        double val=0;
        //проверяем
        if (eq.length > 0) val=plusminus(eq[0]);
        for (int i = 1; i < eq.length; i++) if (val!=plusminus(eq[i])) res=false;
        System.out.println(res);
    }
    //проверяем операции сложения и вычитания
    public static double plusminus(String s)
    {
        double res=0;
        String curNum = "";
        if (!"+-".contains(s.substring(0, 1))) curNum="+";
        for (int i = 0; i < s.length(); i++)
        {
            if ("+-".contains(s.substring(i,i+1)))
            {
                if (curNum.length()>0) res+=multidiv(curNum);
                curNum=s.substring(i,i+1);
            }
            else curNum+=s.substring(i,i+1);
        }
        res+=multidiv(curNum);
        return res;
    }
    //проверяем оперции умножения и деления
    public static double multidiv(String s)
    {
        double res=1;
        String curNum = "";
        boolean multiplying = true;
        for (int i = 0; i < s.length(); i++)
        {
            if ("*/".contains(s.substring(i,i+1)))
            {
                if (curNum.length() > 0)
                {
                    if (multiplying) res*=Double.parseDouble(curNum);
                    else res/=Double.parseDouble(curNum);
                }
                curNum = "";
                multiplying = (s.charAt(i) == '*');
            }
            else curNum+=s.substring(i,i+1);
        }
        if (multiplying) res*=Double.parseDouble(curNum);
        else res/=Double.parseDouble(curNum);
        return res;
    }

    public static boolean palindromeDescendant(int p) {
        //проверяем является ли число палиндромом и его потомком
        String str = Integer.toString(p);
        while(true) {
            if (str.length() < 2) return false;
            //если число четное
            if (str.length() % 2 != 0) {
                //провряем является ли оно палиндромом
                if (str.substring(0, str.length() / 2).equals(new StringBuilder(str.substring(str.length() / 2 + 1)).reverse().toString()))
                    return true;
                else return false;
            }
            //смотрим потомков
            if (str.substring(0, str.length() / 2).equals(new StringBuilder(str.substring(str.length() / 2)).reverse().toString()))
                return true;
            else {
                String buff = "";
                for (int i = 0; i < str.length(); i += 2)
                    buff += Integer.toString(Integer.parseInt(Character.toString(str.charAt(i))) +
                            Integer.parseInt(Character.toString(str.charAt(i + 1))));
                str = buff;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Задание 1. Число Белла. Введите число:");
        int n = sc1.nextInt();
        bell(n);
        ///////////////////////////////////////
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Задание 2. Свинский латинский. Введите слово: ");
        String str = sc2.next();
        String res = translateWord(str);
        System.out.println (res);
        Scanner sc21 = new Scanner(System.in);
        System.out.println("Введите предложение: ");
        String sent = sc21.nextLine();
        translateSentence(sent);
        ///////////////////////////////////////
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Задание 3. RGB. Введите строку:");
        String col = sc3.next();
        validColor(col);
        ///////////////////////////////////////
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Задание 4. Введите URL:");
        System.out.println("Введите url:");
        String url = sc4.nextLine();
        String[] s = url.split(" ", 2);
        if (s.length == 1) stripUrlParams(url);
        else System.out.println(stripUrlParams(s[0], s[1].split(" ")));
        ////////////////////////////////////////
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Задание 5. Хештеги. Введите предложение:");
        String tag = sc5.nextLine();
        getHashTags(tag);
        ////////////////////////////////////////
        Scanner sc6 = new Scanner(System.in);
        System.out.println("Задание 6. Последовательность Улама. Введите число:");
        int u = sc6.nextInt();
        ulam(u);
        ////////////////////////////////////////
        Scanner sc7 = new Scanner(System.in);
        System.out.println("Задание 7. Самая длинная неповторяющаяся подстрока строки:");
        String repeat = sc7.next();
        longestNonrepeatingSubstring(repeat);
        ////////////////////////////////////////
        Scanner sc8 = new Scanner(System.in);
        System.out.println("Задание 8. Преобразование в римское число. Введите арабское число::");
        int arab = sc8.nextInt();
        convertToRoman(arab);
        ////////////////////////////////////////
        Scanner sc9 = new Scanner(System.in);
        System.out.println("Задание 9. Правильная ли формула. Введите формулу: ");
        String f = sc9.nextLine();
        formula(f);
        ////////////////////////////////////////
        Scanner sc10 = new Scanner(System.in);
        System.out.println("Задание 10. Число и его потомок - палиндромы. Введите число: ");
        int p = sc10.nextInt();
        System.out.println(palindromeDescendant(p));
    }
}
