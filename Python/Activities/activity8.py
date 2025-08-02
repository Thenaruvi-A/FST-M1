mylist = input("Provide list of number seperated by comma:").split(',')
#mylist =int(mylist) it wont work as the return type is string 
sum=0
for i in mylist:
    sum += int(i)
print("the sum of the elements in list", sum)