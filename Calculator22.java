import java.io.IOException;
import java.util.Scanner;

public class Calculator22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение от 1 до 10 состоящее из римских или арабских чисел(I,II,III,IV,V,VI,VII,VIII,IX,X):");
        Main main1 = new Main();
        System.out.println(main1.calc(sc.nextLine()));
    }
}
class  Main{
    static String expression;
    public static String calc (String input){
        expression = input;
        String result = null;
        String expressionNew = expression.replace(" ", "");
        String[] operands = expressionNew.split("[-,+,*,/]");
        if (operands.length == 1){
            try {
                throw new ArrayIndexOutOfBoundsException();
            }catch (ArrayIndexOutOfBoundsException e){
            result  = "Строка не является математической операцией!";

            }
            return result;
        }
        else if (operands.length !=2){
            try {
                throw new IOException();
            }catch (IOException e) {
                result = "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, - , * , /)!";
            }
            return result;
        }
        String op1 = operands[0];
        String op2 = operands[1];

        int index = 0;
        if (expression.contains("+")) {
            index = expression.indexOf('+');
        } else if (expression.contains("-")) {
            index = expression.indexOf('-');
        } else if (expression.contains("*")) {
            index = expression.indexOf('*');
        } else if (expression.contains("/")) {
            index = expression.indexOf('/');
        }
        String arabian = "1,2,3,4,5,6,7,8,9,10";
        String roman = "I,II,III,IV,V,VI,VII,VIII,IX,X";

        if (arabian.contains(op1) & arabian.contains(op2)) {
           result = arabian(operands[0], expression.charAt(index), operands[1]);
        } else if (roman.contains(op1) & roman.contains(op2)) {
           result = String.valueOf(roman(operands[0], expression.charAt(index), operands[1]));
        } else if ((arabian.contains(op1) & roman.contains(op2)) || (roman.contains(op1) & arabian.contains(op2))) {

            try {
                throw new IOException();
            }catch (IOException e){
                result = "Операция не может быть выполнена, т. к. используются разные системы исчисления!";
            }

        } else if (Integer.parseInt(op1)>10 || Integer.parseInt(op2)>10) {
            try {
                throw new IOException();
            }catch (IOException e){
                result = "Вы ввели число больше 10";
                return result;
            }
        }
        return result;
    }

    private static String roman(String operand, char charAt, String operand1) {
        String[] arab = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI","XVII", "XVIII",
                "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI","XXXII", "XXXIII","XXXIV",
                "XXXV", "XXXVI","XXXVII","XXXVIII","XXXIX","XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
                "LVII", "LVII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVII", "LXIX", "LXX", "LXXI", "LXXII",
                "LXXII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C","CI"};
        int romanArabian = 0;
        if (operand.equals("I")) {
            romanArabian = 1;
        } else if (operand.equals("II")) {
            romanArabian = 2;
        } else if (operand.equals("III")) {
            romanArabian = 3;
        } else if (operand.equals("IV")) {
            romanArabian = 4;
        } else if (operand.equals("V")) {
            romanArabian = 5;
        } else if (operand.equals("VI")) {
            romanArabian = 6;
        } else if (operand.equals("VII")) {
            romanArabian = 7;
        } else if (operand.equals("VIII")) {
            romanArabian = 8;
        } else if (operand.equals("IX")) {
            romanArabian = 9;
        } else if (operand.equals("X")) {
            romanArabian = 10;
        }
        int romanArabian2 = 0;
        if (operand1.equals("I")) {
            romanArabian2 = 1;
        } else if (operand1.equals("II")) {
            romanArabian2 = 2;
        } else if (operand1.equals("III")) {
            romanArabian2 = 3;
        } else if (operand1.equals("IV")) {
            romanArabian2 = 4;
        } else if (operand1.equals("V")) {
            romanArabian2 = 5;
        } else if (operand1.equals("VI")) {
            romanArabian2 = 6;
        } else if (operand1.equals("VII")) {
            romanArabian2 = 7;
        } else if (operand1.equals("VIII")) {
            romanArabian2 = 8;
        } else if (operand1.equals("IX")) {
            romanArabian2 = 9;
        } else if (operand1.equals("X")) {
            romanArabian2 = 10;
        }
        int otvet = 0;
        String result = null;
        if (charAt == '+') {
            otvet = romanArabian + romanArabian2;
            result = (arab[otvet-1]);
        } else if (charAt == '-') {
            if (romanArabian > romanArabian2) {
                otvet = romanArabian - romanArabian2;
                result = (arab[otvet-1]);
            }else if (romanArabian < romanArabian2) {
                try {
                    throw new ArithmeticException();
                }catch (ArithmeticException e){
                result = "В римской системе нет отрицательных чисел!";}
                return result;
            } else if ((romanArabian == romanArabian2)) {
                try {
                    throw new ArithmeticException();
                }catch (ArithmeticException e){
                result = ("В римских цифрах нет цифры 0 ! ");}
                return result;
            }

        } else if (charAt == '*') {
            otvet = romanArabian * romanArabian2;
            result = (arab[otvet-1]);
        } else if (charAt == '/') {
            otvet = romanArabian / romanArabian2;
            result = (arab[otvet-1]);
        }try {

        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println(arab[otvet - 1]);}
        return result;
    }

    private static String arabian(String operand, char charAt, String operand1) {
        int number1 = Integer.parseInt(operand);
        int number2 = Integer.parseInt(operand1);
        int result = 0;
        if (charAt == '+') {
            result = number1 + number2;
        } else if (charAt == '-') {
            result = number1 - number2;
        } else if (charAt == '*') {
            result = number1 * number2;
        } else if (charAt == '/') {
            try {
                result = number1 / number2;
            } catch (ArithmeticException exp) {
                System.out.println("Делить на ноль нельзя");

            }

        } else {
            System.out.println("Не поддерживаемая операция");
        }
        String resultNew = Integer.toString(result);
        return resultNew;
    }


}