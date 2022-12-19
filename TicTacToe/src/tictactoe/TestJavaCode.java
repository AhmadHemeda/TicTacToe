package testjavacode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJavaCode {

//    String passwordRegex = "[0-9]+";

    public static void main(String[] args) {
//        TestJavaCode test = new TestJavaCode();
//
//        System.out.println("".matches(test.passwordRegex));
//        System.out.println("1".matches(test.passwordRegex));
//        System.out.println("1a".matches(test.passwordRegex));
//        System.out.println("a1".matches(test.passwordRegex));
        
        String email = "hemeda17@hamada.com";
        
        System.out.println(isEmailValid(email));
    }
    
    public static boolean isEmailValid(String email) {
        
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher emailMatches = emailPattern.matcher(email);
        
        return emailMatches.find();
    }
}
