import pandas as pd
from pandas import ExcelWriter
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
	}
	
df=pd.DataFrame(data)
print(df)
		
# Writes	
writer = ExcelWriter('sample.xlsx')
df.to_excel(writer, 'Sheet1', index = False)	
writer.close()

	
dataframe = pd.read_excel('sample.xlsx')	
# Print the dataframe
print(dataframe)	
# Print the number of rows and columns	
print("====================================")	
print("Number of rows and columns:", dataframe.shape)	
# Print the data in the emails column only	
print("====================================")	
print("Emails:")
print(dataframe['Email'])	
# Sort the data based on FirstName in ascending order and print the data	
print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))