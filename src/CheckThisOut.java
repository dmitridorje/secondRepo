import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class CheckThisOut {
    public static void main(String[]args) {

        //Создаем строку, из которой нужно извлечь числа
        String myStr = "На сегодняшний день известно о 8 планетах, вращающихся вокруг Солнца, но все больше ученых" +
                " придерживаются мнения, что их может быть больше. Начиная с 1980-ых годов астрономы стали обнаруживать" +
                " экзопланеты, вращающиеся вокруг отдаленных звезд. Некоторые из них располагаются на расстоянии 27000" +
                " световых лет от Солнца, в то время как радиус Солнечной системы оценивает всего в 1 св. год.";

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(myStr);

        //Требуется найти число совпадений по шаблону, которое станет длиной создаваемого массива.
        //К сожалению, я смог «изобрести» только достаточно кривой способ, предложенный ниже.

        //Создаем копию нашего матчера.
        Matcher m2 = p.matcher(myStr);

        //Выполняем замену, на какой-либо редко используемый символ (понимаю, что это кривое решение),
        //выполняем деление строки по этому символу и присваиваем полученное значение переменной, которая станет
        //длиной массива (hence length – 1)
        char aChar = '\u0FC7';
        int numOfGroups = m2.replaceAll(Character.toString(aChar)).split(Character.toString(aChar), -1).length - 1;
        int[] arrayOfMatches = new int[numOfGroups];

        //Заполняем массив значениями, преобразованными из подстрок, найденных согласно шаблону.
        int i = 0;
        while(m.find()) {
            arrayOfMatches[i] = Integer.parseInt(m.group());
            i++;
        }
        System.out.println("Массив, включающий целые числа, найденные в исходной строке: " + Arrays.toString(arrayOfMatches));
    }
}