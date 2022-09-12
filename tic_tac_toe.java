/**
 * tic_tac_toe
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;

public class tic_tac_toe {
    
    static int current_player;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        game_loop();
<<<<<<< HEAD
        input.close();
=======
>>>>>>> 16f7441f9acc07f10a63c30ddc6d77f088aeada8
    }
     public static void clear_terminal(){
             try {
                if (System.getProperty("os.name").contains("Windows")) 
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear"); 
                } catch (IOException e) {
                
                e.printStackTrace();
            } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
         }
        
    public static void title_screen(){
        System.out.println(" Jogo da Velha (ou Tic Tac Toe [en]) \n");
    }

    public static void draw(ArrayList <String> board_local){
        ArrayList<String> board_drawing = new ArrayList<>();
        board_drawing = (ArrayList)board_local.clone();
        for (int i = 0; i < 9; i++){
            if (board_local.get(i).equals("0")){
                board_drawing.set(i, String.format("%d", i+1));
            } 
            if (board_local.get(i).equals("1")){
                board_drawing.set(i,"x");
            }
            if (board_local.get(i).equals("2")){
                board_drawing.set(i,"o");
            }
        }
        System.out.println(" "+board_drawing.get(0) + " | "+board_drawing.get(1) + " | "+board_drawing.get(2) + "\n");
        System.out.println(" ---------\n");
        System.out.println(" "+board_drawing.get(3) + " | "+board_drawing.get(4) + " | "+board_drawing.get(5) + "\n");
        System.out.println(" ---------\n");
        System.out.println(" "+board_drawing.get(6) + " | "+board_drawing.get(7) + " | "+board_drawing.get(8) + "\n");
        System.out.println();
    }


    public static ArrayList<String> get_player_choice(ArrayList <String> board, int player){

        
        int i = 0;
        int choice = 0;
        while (i == 0){
            System.out.println("Player "+ player + ",choose a space (1-9):");
            choice = input.nextInt();
            input.nextLine();
            choice = choice - 1;
            if (choice <0 || choice >9){ 
                System.out.println("Invalid input. Choose free position numbers 1 through 9");
                continue;
            }
            if (board.get(choice) != "0") {
                System.out.println("This position is ocupied. Choose again.");
                continue;
            } else {
                i=1;
            }
        }               
        board.set(choice, String.format("%d", player));
        
        if (player == 1){
            current_player = 2;
        }
        else if (player == 2){
            current_player = 1;
        }
        
        return board;
    }

    public static int is_game_over(ArrayList<String> board){
        // Code for Conditions: 
        // 0 = game still being played; 
        // 1 and 2 = Victory of player #1 and #2
        // 3 = tie
        int victory = 0;
        for (int player = 1; player < 3; player++){
            if (board.get(0).equals(String.format("%d", player)) && board.get(1).equals(String.format("%d", player)) && board.get(2).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(3).equals(String.format("%d", player)) && board.get(4).equals(String.format("%d", player)) && board.get(5).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(6).equals(String.format("%d", player)) && board.get(7).equals(String.format("%d", player)) && board.get(8).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(0).equals(String.format("%d", player)) && board.get(3).equals(String.format("%d", player)) && board.get(6).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(1).equals(String.format("%d", player)) && board.get(4).equals(String.format("%d", player)) && board.get(7).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(2).equals(String.format("%d", player)) && board.get(5).equals(String.format("%d", player)) && board.get(8).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(0).equals(String.format("%d", player)) && board.get(4).equals(String.format("%d", player)) && board.get(8).equals(String.format("%d", player))){
                victory = player;}
            if (board.get(6).equals(String.format("%d", player)) && board.get(4).equals(String.format("%d", player)) && board.get(2).equals(String.format("%d", player))){
                victory = player;}
        }
        if (victory == 0 && !board.contains("0")){return 3;}
        return victory;
        }

    public static void game_loop(){
        title_screen();
        tic_tac_toe.current_player = 1;
        ArrayList<String> board = new ArrayList<String>(Arrays.asList("0", "0", "0", "0", "0", "0", "0", "0", "0"));
        boolean game_is_running = true;
        while (game_is_running){
            clear_terminal();
            draw((ArrayList)board.clone());
            board = get_player_choice(board, current_player);  // runs the choosing subroutine and updates board
            clear_terminal();
            draw(board);
            if (is_game_over(board) != 0){
                ArrayList<String> victory_message = new ArrayList<String>(Arrays.asList("Error", "Player One has won!", "Player Two has won", "It's a TIE!"));
                int message_code = is_game_over(board);
                System.out.println(victory_message.get(message_code));
                System.out.println("Quitting program now...");
                game_is_running = false;                
            }
        }
    }
}