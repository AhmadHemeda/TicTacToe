
package tictactoe;


public class CounterTwoPlayers {
    public static void main(String[] args){
       System.out.println(java.time.LocalDate.now());
    
    }
    private static  int counterPlayer1=0;
    private static  int counterPlayer2=0;
    
    public static int getCounterPlayer1() {
        return counterPlayer1;
    }

    public static void setCounterPlayer1(int counterPlayer1) {
        CounterTwoPlayers.counterPlayer1 = counterPlayer1;
    }

    public static int getCounterPlayer2() {
        return counterPlayer2;
    }

    public static void setCounterPlayer2(int counterPlayer2) {
        CounterTwoPlayers.counterPlayer2 = counterPlayer2;
    }
    
    
}
