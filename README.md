# Bankers_Algorithm
Programmed a simulation of the banker’s algorithm. The program cycles through each of the bank clients asking for a request and evaluating whether it is safe or unsafe. 
 Documentation Program name: BankersAlgorithm.java
General Logic: The program accepts the number of processes, number of resources, allocation matrix, max matrix, available matrix as input from the user. The program calculates the need matrix from the max and allocation matrices. Then it proceeds to determine if the process is in safe state and allocates resources if possible. The output containing the process number in order of their request completion is printed on the terminal.
Function Main: Create an object to call upon the functions like get_Input( ) and allocation( ).
Function get_Input: The function accepts the number of processes, number of resources, allocation matrix, max matrix, available matrix as input from the user using the Scanner class and its object.
Function calculate_Need: The need matrix is calculated by subtracting the max matrix from the allocation matrix.
Function is_safe: This function checks if the system is in a safe state or not by checking if the elements in available matrix is greater than the need matrix. It returns false if available is lesser and true otherwise (available matrix > need matrix).
Function allocation: A boolean matrix called visited, with size equivalent to number of processes is assigned. The process is checked if it is in safe state and if found in safe state and visited is not true, return True for allocated and visited and increase the count by 1 and allocate resources to the process. Now the process will finish its execution and add the allocated resources back to the available matrix. If allocated is not set to true, break and exit. If all the processes are able to complete their execution i.e if count is equal to number of processes, print “All processes are safely allocated”. Otherwise print “All processes can not be safely allocated”.
Algorithm logic:
Calculate need matrix:
Need [i, j] = max[i, j] - allocation[i ,j]
Step to check if it is safe:
Need [i, j] < Available[i, j]
Allocation:
Count = 0. Visited : It is initially set to “False” but if the process is in safe state, it is set to “True” one by one. Increase count by 1.
P0 P1 P2 P3 P4 FALSE FALSE FALSE FALSE FALSE
If the first process is in safe state, then P0 is set to “True”:
P0 P1 P2 P3 P4 TRUE FALSE FALSE FALSE FALSE
Available[i, j] = Available[i, j] + allocation[i ,j]
    
 Once all processes are visited, i.e count is equal to number of processes, print "All processes are safely allocated”. Otherwise print “All processes can not be safely allocated”.
Compilation and execution:
Extract the contents of the Zip file onto a folder. Open the terminal and go to the current directory in which the files are saved by using “cd” command. Then use the following command for compiling and executing the file: 
javac BankersAlgorithm.java
java BankesrAlgorithm
Then enter the inputs like in the output snapshot given below.

 
