
package tic.tac.toe;


public class OutRangeException extends Exception {

    public OutRangeException() {
        System.out.println("You must choose a number between 1 and 9 only!");
    }
    
}
