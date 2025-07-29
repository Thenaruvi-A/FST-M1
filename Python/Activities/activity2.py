num= int(input ("Enter a number: "))
is_even_or_not = num % 2
if (is_even_or_not == 0) :
    print("{} is an even number".format(num))
else:
    print("{} is an odd number".format(num))