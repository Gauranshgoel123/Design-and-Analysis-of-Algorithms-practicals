import java.util.Scanner;

public class NameMatch {

    static boolean exactMatch(String a, String b) {
        return a.equals(b);
    }

    static boolean caseInsensitiveMatch(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(b.charAt(i))) return false;
        }
        return true;
    }

    static boolean substringMatch(String a, String b) {
        return a.contains(b) || b.contains(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first name: ");
        String a = scanner.nextLine();
        
        System.out.print("Enter the second name: ");
        String b = scanner.nextLine();
        
        if (exactMatch(a, b)) {
            System.out.println("The names are an exact match.");
        } else if (caseInsensitiveMatch(a, b)) {
            System.out.println("The names match (case-insensitive).");
        } else if (substringMatch(a, b)) {
            System.out.println("One name is a substring of the other.");
        } else {
            System.out.println("The names do not match.");
        }
        
        scanner.close();
    }
}
