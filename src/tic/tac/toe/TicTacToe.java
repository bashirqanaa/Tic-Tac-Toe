
package tic.tac.toe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        char Board [][] = {{' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}
        };
        
        boolean [] check = {false,false,false,false,false,false,false,false,false};
        String winner = "No one";
        
        System.out.println("Choose a box from 1-9");
        drawBoard(Board); // draws the baord
        Scanner scan = new Scanner(System.in);
        int pos;
        
        //The Game Body, keeps running untill there's a winner or no more spaces are left
        while (!areAllTrue(check)&& isWinner(Board)== false){
        
            try{
               do{
                  pos = scan.nextInt();
                  if (pos>9 || pos<=0){throw new OutRangeException();}  
                } while(check[pos-1]);

              // User Turn
              Board = pickBox(Board,"Player",pos);
              if(isWinner(Board)){winner="You!"; break;}
              check[pos-1] = true;
              System.out.println("Hmmm let me think!.......");
              Thread.sleep(1000);


              // CPU Turn
              do {
                 Random r = new Random();
                 pos = r.nextInt(9)+1;
              } while(check[pos-1] && !areAllTrue(check));

              Board = pickBox(Board," ",pos);
              if(isWinner(Board)){winner="CPU!"; break;}
              check[pos-1]= true;

              drawBoard(Board);
        }
        catch (OutRangeException e){
        }
        
    }
        drawBoard(Board);
        
        System.out.println("The winner is "+winner);
           
 }
    
    public static void drawBoard(char[][] Board){
        
         for (char [] row : Board){
            for (char r : row){
                System.out.print(r);
            }
            System.out.println();
        }
    }
    
    public static char[][] pickBox(char[][] Board, String turn,int pos){
        char symbol;
        if(turn.equals("Player")){symbol = 'X';}
        else symbol = 'O';
               
        switch(pos){
            case 1 -> Board [0][0] = symbol;
            case 2 -> Board [0][2] = symbol;
            case 3 -> Board [0][4] = symbol;
            case 4 -> Board [2][0] = symbol;
            case 5 -> Board [2][2] = symbol;
            case 6 -> Board [2][4] = symbol;
            case 7 -> Board [4][0] = symbol;
            case 8 -> Board [4][2] = symbol;
            case 9 -> Board [4][4] = symbol;
        }
    return Board;
    }
    
    public static boolean areAllTrue(boolean[] array){
      for(boolean b : array) if(!b) return false;
      return true;
    }
    
    public static boolean isWinner(char[][] Board){
      if (Board[0][0] == Board [0][2] && Board [0][2] == Board [0][4] && Board [0][4] != ' ' 
          ||
          Board[0][0] == Board [2][0] && Board [2][0] == Board [4][0] && Board [4][0] != ' '
          ||
          Board[4][0] == Board [4][2] && Board [4][2] == Board [4][4] && Board [4][4] != ' '
          ||
          Board[0][4] == Board [2][4] && Board [2][4] == Board [4][4] && Board [4][4] != ' '
          ||
          Board[0][0] == Board [2][2] && Board [2][2] == Board [4][4] && Board [4][4] != ' '
          ||
          Board[0][4] == Board [2][2] && Board [2][2] == Board [4][0] && Board [4][0] != ' '
          ||
          Board[0][2] == Board [2][2] && Board [2][2] == Board [4][2] && Board [4][2] != ' '
          ){ return true;}
      else{
        return false;  
      }
      
    }
    
}

     
    
  