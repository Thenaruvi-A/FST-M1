	
number = (input("Input a number: "))
if (number.isdigit()):
    number=int(number)
    for i in range(1,11):
        print(number, ' * ', i, ' = ', number*i)
else:
    print("Invalid user input")