package tictactoe;

public class RequestSignUp {

    public static boolean CheckSignValidation(String name, String mail, String pass, String confPass) {
        boolean valid;
        if (name != null && mail != null && pass != null && confPass != null) {
            valid = true;

        } else {
            valid = false;

        }
        return valid;
    }

    public static boolean CheckPasswordValidation(String pass, String confPass) {
        boolean valid;
        if (pass.equals(confPass)) {
            valid = true;

        } else {
            valid = false;

        }
        return valid;
    }
    
    

}
