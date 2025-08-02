import pandas as pd

#write a CSV file & creating a data set (Activity 17)
data ={
    "Usernames": ["Admin","Charles","Deku"],
    "Passwords":["Password","Char12","AllMight"]
}

#data to data frame
df=pd.DataFrame(data)


# ./ is the current folder, noe in the Vm file, if file exists pandas will override it
#if to be in local try use absolute path
# write data to the data frame not just data
df.to_csv("./sample.csv", index=False)

# Read from CSV file (Activity 18)
# converts the data into data frame, default haeader =0; first row in file , can say header = 0 if theere is no keys just data 
input_data  = pd.read_csv("./sample.csv")
#input_data["Permissions"] = ["Read", "Write","Execute"]
print(input_data)
## add new rows
#new_row = pd.DataFrame({
 #   "Usernames": ["new_user"],
 #   "Passwords": ["new_password"]
#})
#input_data = pd.concat([input_data, new_row]).reset_index(drop=True)
#print(input_data)

print("##### Only Usernames#####")
print(input_data["Usernames"])

print("##### Second row data#####")
print(input_data["Usernames"][1],input_data["Passwords"][1])

print("##### Sorted Usernames col#####")
print(input_data.sort_values(by="Usernames"))

print("##### Sorted Passwords col#####")
print(input_data.sort_values(by="Passwords",ascending=False))