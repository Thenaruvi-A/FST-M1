user1 = input("Enter player 1's name: ")
user2 = input("Enter player 2's name: ")

while True:
    user1_answer = input(user1 + ", do you want to choose rock, paper or scissors? ").upper()
    user2_answer = input(user2 + ", do you want to choose rock, paper or scissors? ").upper()

    if user1_answer == user2_answer:
        print("It is a draw")
    elif user1_answer == 'ROCK':
        if user2_answer == 'SCISSORS':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif user1_answer == 'SCISSORS':
        if user2_answer == 'PAPER':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif user1_answer == 'PAPER':
        if user2_answer == 'ROCK':
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Enter a valid choice")

    repeat_game = input("Do you wish to play again? Yes/No: ").capitalize()

    if repeat_game == 'Yes':
        pass
    elif repeat_game == 'No':
        print("Thank you for playing!")
        raise SystemExit
    else:
        print("Invalid command. Exiting now!")
        raise SystemExit