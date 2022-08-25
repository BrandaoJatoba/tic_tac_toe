import os
import copy

global current_player


def clear_terminal():
    os.system('CLS')
    pass


def title_screen():
    print(" Jogo da Velha ou Tic Tac Toe \n")
    input("Please press the Enter key to proceed...")
    pass


def draw_board(board_local: list):
    board_drawing = copy.deepcopy(board_local)
    for index, item in enumerate(board_local):
        if board_local[index] == 0:
            board_drawing[index] = " "
        elif board_local[index] == 1:
            board_drawing[index] = "x"
        elif board_local[index] == 2:
            board_drawing[index] = "o"

    print(" "+board_drawing[0] + " | "+board_drawing[1] + " | "+board_drawing[2] + "\n")
    print(" ---------\n")
    print(" "+board_drawing[3] + " | "+board_drawing[4] + " | "+board_drawing[5] + "\n")
    print(" ---------\n")
    print(" "+board_drawing[6] + " | "+board_drawing[7] + " | "+board_drawing[8] + "\n")
    print()
    pass


def player_choice(board: list, player: int):

    choice = input("Player "+str(player)+",choose a space (1-9):")
    choice = int(choice) - 1
    updating_board = copy.deepcopy(board)
    updating_board[int(choice)] = player
    global current_player
    if player == 1:
        current_player = 2
    elif player == 2:
        current_player = 1
    return updating_board


def is_game_over(board: list):

    victory = 0

    # add tie condition

    for player in range(1, 3):
        if board[0] == player and board[1] == player and board[2] == player:
            victory = player
        if board[3] == player and board[4] == player and board[5] == player:
            victory = player
        if board[6] == player and board[7] == player and board[8] == player:
            victory = player
        if board[0] == player and board[3] == player and board[6] == player:
            victory = player
        if board[1] == player and board[4] == player and board[7] == player:
            victory = player
        if board[2] == player and board[5] == player and board[8] == player:
            victory = player
        if board[0] == player and board[4] == player and board[8] == player:
            victory = player
        if board[6] == player and board[4] == player and board[2] == player:
            victory = player
    return victory


def game_loop():
    title_screen()
    global current_player
    current_player = 1
    board = [0, 0, 0, 0, 0, 0, 0, 0, 0]
    game_state = 0
    while game_state == 0:
        clear_terminal()
        draw_board(board)
        board = player_choice(board, current_player)  # runs the choosing subroutine and updates board
        clear_terminal()
        draw_board(board)
        if is_game_over(board) != 0:
            victory_message = ["Error", "Player One has won!", "Player Two has won", "It's a TIE!"]
            message_code = int(is_game_over(board))
            print(victory_message[message_code])
            print("Quitting program now...")
            game_state = 1


if __name__ == '__main__':
    game_loop()
