
import java.util.Scanner;

public class TicTacToe {
  static String[] board = new String[9];
  static String turn = "X";
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    initializeBoard();
    System.out.println("================================");
        System.out.println("   Welcome to Tic-Tac-Toe!");
        System.out.println("================================");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");
        System.out.println();
        printBoard();
        String winner = null;
        int moveCount = 0;
        while(winner==null&& moveCount<9){
          System.out.println();
           System.out.print(turn + "'s turn. Enter a slot number (1-9): ");
            int numInput;
            try {
              numInput = scan.nextInt();
              if(numInput<1 || numInput>9){
                System.out.println("❌ Invalid! Enter a number between 1-9.");
                    continue;
              }
              if(board[numInput-1].equals(String.valueOf(numInput))){
                board[numInput-1] = turn;
                moveCount++;
                printBoard();
                winner = checkWinner();
                if(winner == null){
                  turn = turn.equals("X") ? "O" : "X";
                }
              }else{
                System.out.println("❌ Slot already taken! Choose another.");
                
              }
              } catch(Exception e){
                System.out.println("❌ Invalid input! Enter a valid number.");
                scan.next();
              }
            }
             System.out.println();
        System.out.println("================================");
        
        if (winner != null) {
            // Someone won!
            System.out.println("   🎉 " + winner + " WINS! 🎉");
        } else {
            // All 9 slots filled, no winner
            System.out.println("   🤝 GAME DRAW! 🤝");
        }
        
        System.out.println("================================");
        
        // Close scanner to prevent resource leak
        scan.close();
    }
        
    static void initializeBoard(){
      for(int i=0;i<9;i++){
        board[i] = String.valueOf(i+1);
      }
    }
    static void printBoard() {
        System.out.println("      |---|---|---|");
        System.out.println("      | " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("      |-----------|");
        System.out.println("      | " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("      |-----------|");
        System.out.println("      | " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("      |---|---|---|");
    }
    static String checkWinner() {
        
        // All 8 possible ways to win
        // Each array contains 3 positions that form a line
        int[][] winCombinations = {
            {0, 1, 2}, // Top row:    positions 0, 1, 2
            {3, 4, 5}, // Middle row: positions 3, 4, 5
            {6, 7, 8}, // Bottom row: positions 6, 7, 8
            {0, 3, 6}, // Left column:   positions 0, 3, 6
            {1, 4, 7}, // Middle column: positions 1, 4, 7
            {2, 5, 8}, // Right column:  positions 2, 5, 8
            {0, 4, 8}, // Diagonal \:    positions 0, 4, 8
            {2, 4, 6}  // Diagonal /:    positions 2, 4, 6
        };
        
        // Check each winning combination
        for (int[] combination : winCombinations) {
            
            // Combine the 3 positions into one string
            // Example: if positions are "X", "X", "X" → "XXX"
            String line = board[combination[0]] + 
                         board[combination[1]] + 
                         board[combination[2]];
            
            // Check if all three are X
            if (line.equals("XXX")) {
                return "X"; // X wins!
            } 
            // Check if all three are O
            else if (line.equals("OOO")) {
                return "O"; // O wins!
            }
        }
        
        // No winning combination found
        return null;
    }
}
    
    
    
      
  
