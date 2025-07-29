user1 = input("Enter player 1's  name: ")
user2 = input("Enter player 2's  name: ")
	
user1_answer = input(user1 + ", do you want to choose rock, paper or scissors? ").upper()
user2_answer = input(user2 + ", do you want to choose rock, paper or scissors? ").upper()
if (user1_answer ==user2_answer) :
    print("it is a draw")
elif(user1_answer == 'SCISSORS'):
    if(user2_answer == 'PAPER'):
        print("Scissors wins!!")
elif(user1_answer == 'ROCK'):
    if(user2_answer == 'SCISSORS'):
        print("Rock wins!!")
elif(user1_answer == 'PAPER'):
    if(user2_answer == 'ROCK'):
        print("Paper wins!!")   
else:
    print("Enter a valid choice")           
