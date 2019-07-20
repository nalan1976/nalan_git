package practise;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        String temp = word.toLowerCase();

        for (int i = 0; i <  temp.length() / 2; i++){
            if (temp.charAt(i) != temp.charAt(temp.length() - i - 1))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("DDeleveledd"));
        System.out.println(Palindrome.isPalindrome("Deleveledd"));
        System.out.println(Palindrome.isPalindrome("DDeleveled"));
    }
}
