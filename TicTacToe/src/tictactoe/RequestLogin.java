
package tictactoe;


public class RequestLogin {



    public static boolean checkLoginValidation(String username, String password) {
        boolean valid;

        if (username != null && password != null) {
            valid = true;
        } else {
            valid = false;
        }
        
        return valid;
    }

}


