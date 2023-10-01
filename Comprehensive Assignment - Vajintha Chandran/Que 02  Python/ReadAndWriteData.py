# Name: Vajintha Chandran
# Comprehensive Assignment - Que 02
# Added few print statements for logs (E.g. Method names)

import csv

class ReadAndWriteData:  

    def read_data(self,csvFileName):  
        print ("\n\n--------- Method : read_data ---------")

        testdata =[] # 'read_data' method will return the data as list of dictionaries

        temp=[] # get all the data and store in 'temp' list
        with open(csvFileName, 'r') as file:      
            csvreader = csv.reader(file)  

            for row in csvreader:
                temp.append(row)


        key_list=[] # list all the keys [1st row in the file] available in the file for dictionary 
        for key in temp[0]:
            key_list.append(key)


        data_set ={} #initialize the dictionary
        for key in key_list:
            data_set[key]=None


        temp.remove(temp[0]) # Remove data headers [1st row] from the data


        for row in temp:
            x=dict(zip(data_set,row)) # assign values to the initialized dictionary keys
            testdata.append(x) # add dictionaries to the testdata list

        print("Successfully read the data from CSV file")   
        return testdata

    


    def print_data_knownData(self,testdata): # When user know the data headers available in the CSV file (E.g. : Name, SkillSet, Experience)
        print ("\n\n--------- Method : print_data_knownData ---------")

        for data_set in testdata:
            print (data_set["Name"], "\t", data_set["SkillSet"], "\t", data_set["Experience"] )




    def print_data_UnknownData(self, testdata): # When user don't know the data headers available in the CSV file (E.g. : Name, SkillSet, Experience)
        print ("\n\n--------- Method : print_data_UnknownData ---------")

        i=1
        for dataset in testdata:
            temp= list(dataset.keys())
            print ("\nData "+str(i)+" : ")
            for a in temp:
                print (a + " : "+dataset[a])
            i=i+1

    

a = ReadAndWriteData()  
data= a.read_data('Que02TestData.csv') #since file is in same location, didn't add entire location
a.print_data_knownData(data)
a.print_data_UnknownData(data)
