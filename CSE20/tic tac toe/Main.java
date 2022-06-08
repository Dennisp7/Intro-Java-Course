//Name: Dennis Perez
//Class : CPSC - 06 - 32002
//DennisPerezTicTacToe_Part3_2/FinalCode

import java.util.Scanner;
class Main {

  public static char board[] = {
                                                'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X'};

  public static char player = 'X';

  
  public static void main(String[] args) {
    System.out.println("\t");
    System.out.println("Welcome to the game of Tic Tac Toe!");
    System.out.println("\t"); 
    System.out.println("Instructions: "); 
   
    System.out.println("All positions are in order from 0 to 8, starting with the first box on the top left corner, and ending with 8 at the last box on the bottom right corner. " + " Position Example: " + "0 is the first box on the top left corner, " + "1 is the middle box on top row, " + "2 is the last box on the top right corner, so on and so forth. ");
    System.out.println("\t"); 
    
    
    System.out.println("The first player to make a diagnol, horizontal, or vertical line of Xs or Os, wins. If niether player makes a diagnol, horizontal, or vertical line of Xs or Os, then it is a draw. "); 
    
    showBoard();
    checkBoard();
    newBoard();
    play();
    checkBoard();

  }
  public static void showBoard() {
    System.out.println("\t" + board[0] + " | " + board[1] + " |" + board[2]);
    System.out.println("\t" + "——|———|——");
    System.out.println("\t" + board[3] + " | " + board[4] + " |" + board[5]);  
    System.out.println("\t" + "——|———|——");
    System.out.println("\t" + board[6] + " | " + board[7] + " |" + board[8]);  
  }
  public static char checkBoard(){
    char winner = ' ';
    if( board[0] == board[1] && board[1] == board[2] && board[0] == 'X' && board[1] == 'X' && board[2] == 'X') winner = 'X';
    if( board[0] == board[1] && board[1] == board[2] && board[0] == 'O' && board[1] == 'O' && board[2] == 'O') winner = 'O';
    if( board[3] == board[4] && board[4] == board[5] && board[3] == 'X' && board[4] == 'X' && board[5] == 'X') winner = 'X';
    if( board[3] == board[4] && board[4] == board[5] && board[3] == 'O' && board[4] == 'O' && board[5] == 'O') winner = 'O';
    if( board[6] == board[7] && board[7] == board[8] && board[6] == 'X' && board[7] == 'X' && board[8] == 'X') winner = 'X';
    if( board[6] == board[7] && board[7] == board[8] && board[6] == 'O' && board[7] == 'O' && board[8] == 'O') winner = 'O';


    if( board[0] == board[3] && board[3] == board[6] && board[0] == 'X' && board[3] == 'X' && board[6] == 'X') winner = 'X';
    if( board[0] == board[3] && board[3] == board[6] && board[0] == 'O' && board[3] == 'O' && board[6] == 'O') winner = 'O';
    if( board[1] == board[4] && board[4] == board[7] && board[1] == 'X' && board[4] == 'X' && board[7] == 'X') winner = 'X';
    if( board[1] == board[4] && board[4] == board[7] && board[1] == 'O' && board[4] == 'O' && board[7] == 'O') winner = 'O';
    if( board[2] == board[5] && board[5] == board[8] && board[2] == 'X' && board[5] == 'X' && board[8] == 'X') winner = 'X';
    if( board[2] == board[5] && board[5] == board[8] && board[2] == 'O' && board[5] == 'O' && board[8] == 'O') winner = 'O';

    if( board[0] == board[4] && board[4] == board[8] && board[0] == 'X' && board[4] == 'X' && board[8] == 'X') winner = 'X';
    if( board[0] == board[4] && board[4] == board[8] && board[0] == 'O' && board[4] == 'O' && board[8] == 'O') winner = 'O';
    if( board[2] == board[4] && board[4] == board[6] && board[2] == 'X' && board[4] == 'X' && board[6] == 'X') winner = 'X';
    if( board[2] == board[4] && board[4] == board[6] && board[2] == 'O' && board[4] == 'O' && board[6] == 'O') winner = 'O';

      if(winner == 'X')
        System.out.println("Winner is X");
      if(winner == 'O')
        System.out.println("Winner is O");

      if(winner == ' ')
        for(int i = 0; i < board.length; i++)
         if(board[i] == 'X' || board[i] == 'O'){
           if(i == 8) {
             winner = 'D'; 
            System.out.println("The example above is a draw. ");
            System.out.println("\t"); 
           }

          }
          return winner;
        

  }
  public static void newBoard(){
    for(int i = 0; i < board.length; i++){ 
    board[i] = ' ';
    }
  }
  public static boolean checkSpot(int position){
    if(position > 8) {System.out.println("no more than 8 positions. (0-8)"); return false;}

    if(board[position] == 'X' || board[position] == 'O') {System.out.println("Position is taken, move to another position"); 
    return true;
    }
    return false;
  }
   public static char getPlayer(){
     return player;
   }
  public static void nextPlayer() {
    for(int i= 0; i < board.length; i++){
      if(player == 'X') player = 'O';
      else if(player == 'O') player = 'X';

    }
  }
  public static void play() {
    int spot;
    char blank = ' ';
    System.out.println("Now lets try an actual match: ");
    
    System.out.println( "Player " + getPlayer() + " goes first and is the letter X ");
    System.out.println("\t");
    System.out.println("To choose a position, input a number from 0 through 8. ");
     
    do {
      showBoard();
      
      


      System.out.println(" \n\n Player " + getPlayer() + " choose a position.");

      boolean positionTaken = true;
      while(positionTaken){
      Scanner input = new Scanner(System.in);
      spot = input.nextInt();
      positionTaken = checkSpot(spot);
      if(positionTaken == false)
        board[spot] = getPlayer();
        
      }
       System.out.println("\t Good move! ");
       checkBoard();
       nextPlayer();


    }while(checkBoard() == blank);

    if(checkBoard() != blank);
      showBoard();


  }
}