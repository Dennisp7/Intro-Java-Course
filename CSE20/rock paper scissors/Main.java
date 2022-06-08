//Name: Dennis Perez
//Class : CPSC - 06 - 32002
// DennisPerezHomework8

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int choice_player = getChoices();
    int choice_computer = getRandomHandSign();
    String winner = play(choice_computer, choice_player);
    showWinner(winner);
   // System.out.println(getChoices());
  }

  public static int getChoices(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Choices 1 - Rock, 2 - Paper, 3 - Scissors ");
    int choice = input.nextInt();
    if(choice < 1 || choice > 3) choice = 1; 
    input.close();
    return choice;

  }

  public static String getHandSign(int hand){
    if(hand == 1) return "Rock";
    if(hand == 2) return "Paper";
    if(hand == 3) return "Scissors";

    return "Rock";

  }
  public static int getRandomHandSign(){
    int handSign = 1 + (int)Math.floor(Math.random() * (4-1));
   // System.out.println("getRandomHandSign " + handSign);
    return handSign;
  }

  public static String play(int computer, int player) {
    String winner ="Draw ";
    if(computer == 2 && player == 1) winner = "Computer";
    if(computer == 1 && player == 2) winner = "Player";
    if(computer == 3 && player == 1) winner = "Player";
    if(computer == 2 && player == 3) winner = "Player";
    if(computer == 1 && player == 3) winner = "Computer";
    if(computer == 3 && player == 2) winner = "Computer";
    System.out.println("Player Choice: " + getHandSign(player) + ", " + "Computer Choice: " + getHandSign(computer));
    return winner;
  }
  public static void showWinner(String winner){

    System.out.println("Winner is: " + winner);
  }


}