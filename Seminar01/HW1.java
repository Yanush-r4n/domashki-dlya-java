package Seminar01;

public class HW1 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        s = "  hello world  ";
        System.out.println(reverseWords(s));

        s = "a good   example";
        System.out.println(reverseWords(s));
    }

    /**
     * @apiNote Переворачивает порядок слов и избавляется от лишних пробелов
     * @param s Пользовательская строка
     * @return Возвращает строку с перевернутым порядком слов
     */
    public static String reverseWords(String s) {
        s = s.trim();

        int j = 0;
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                j = 0;
            } else {
                reversed.insert(j, s.charAt(i));
                j++;
            }

            if (j == 0 && i != s.length() - 1 && reversed.charAt(0) != ' ') {
                reversed.insert(0, ' ');
            }
        }

        return reversed.toString();
    }
}