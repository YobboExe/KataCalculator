import java.security.spec.ECField;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner field = new Scanner(System.in);

        System.out.println("Введите математическое выражение: ");
        String input = field.nextLine();

        calc(input);
    }

    public static String calc(String input){
        // начало

        String[] numRim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] numAr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] symb = {"+", "-", "/", "*"};
        int [] arr = new int[7];


        try{
            try{
                String[] chList = input.split(" ");
                if(chList.length > 3) {
                    System.out.println("Должно быть 2 пробела");
                }
                else{
                        String num1 = chList[0];
                        String num2 = chList[2];

                        if(Arrays.asList(numAr).contains(num1) && Arrays.asList(numAr).contains(num2)){ //Числа одного типа Арабские
                            Integer n1 = Integer.valueOf(chList[0]);
                            Integer n2 = Integer.valueOf(chList[2]);
                            if(Arrays.asList(symb).contains(chList[1])){
                                switch(chList[1]){
                                case "+":
                                    System.out.println(n1 + n2);
                                    break;
                                case "-":
                                    System.out.println(n1 - n2);
                                    break;
                                case "*":
                                    System.out.println(n1 * n2);
                                    break;
                                case "/":
                                    System.out.println(n1 / n2);
                                    break;
                                default:
                                    return "Проверьте знак.";
                                }

                        }else {
                                System.out.println("Ошибка в знаке");
                            }
                        }
                        else if(Arrays.asList(numRim).contains(num1) && Arrays.asList(numRim).contains(num2)){ //Числа одного типа Римские
                            String r1 = chList[0];
                            int rn1 = Roman.valueOf(r1).ordinal();
                            String r2 = chList[2];
                            int rn2 = Roman.valueOf(r2).ordinal();
                                if(Arrays.asList(symb).contains(chList[1])){
                                    switch(chList[1]){
                                        case "+":
                                            int answer = rn1 + rn2 + 1;
                                            System.out.println(Roman.values()[answer]);
                                            break;
                                        case "-":
                                            int answer2 = rn1 - rn2 - 1;
                                            System.out.println(Roman.values()[answer2]);
                                            break;
                                        case "*":
                                            int answer3 = (rn1 + 1) * (rn2 + 1);
                                            System.out.println(Roman.values()[answer3 - 1]);
                                            break;
                                        case "/":
                                            int answer4 = (rn1 + 1) / (rn2 + 1);
                                            System.out.println(Roman.values()[answer4 - 1]);
                                            break;
                                        default:
                                            return "Проверьте знак.";
                                    }}
                                else{
                                        System.out.println("Ошибка в знаке");
                                    }

                        }
                        else{
                            System.out.println("Перепроверьте условие");
                        }
                    }
                    } catch (Exception e) {
                System.out.println("Problem");
                }
        } catch (NumberFormatException e) {
            System.out.println("Пустая строка");
        }

        return "Sup";
}}