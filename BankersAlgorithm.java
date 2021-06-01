import java.util.Scanner;

public class BankersAlgorithm {
    int max[][],need[][],available[][],allocation[][],np,nr;

public void get_Input(){
    Scanner input=new Scanner(System.in);
    System.out.println("Enter the number of Processes and number of Resources: ");
    np=input.nextInt();
    nr=input.nextInt();
    max=new int[np][nr];
    need=new int[np][nr];
    available=new int[1][nr];
    allocation=new int[np][nr];

    //Get Allocation matrix as input
    System.out.println("Enter the Allocation Matrix:");
    for(int i=0;i<nr;i++){
      char c= (char) ((char) 65+i);
      System.out.print(c+"\t");
    }
    System.out.println();
    for(int i=0;i<np;i++){
      for(int j=0;j<nr;j++){
         allocation[i][j]=input.nextInt();
        }
    }

    //Get Max matrix as input
    System.out.println("Enter the Max Matrix:");
    for(int i=0;i<nr;i++){
      char c= (char) ((char) 65+i);
      System.out.print(c+"\t");
    }
    System.out.println();
    for(int i=0;i<np;i++){
    for(int j=0;j<nr;j++){
       max[i][j]=input.nextInt();
      }
    }

    //Get Available matrix as input
    System.out.println("Enter the Available Matrix:");
    for(int i=0;i<nr;i++){
      char c= (char) ((char) 65+i);
      System.out.print(c+"\t");
    } 
    System.out.println();
    for(int i=0;i<nr;i++){
      available[0][i]=input.nextInt();
    }
    input.close();
    }

//Calculate need matrix 
public void calculate_Need(){
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
        need[i][j]=max[i][j]-allocation[i][j];
          }
        }
    }

//Check if the system is in safe state or not
public boolean is_Safe(int p){
    for(int i=0;i<nr;i++){
        if(available[0][i]<need[p][i]){
        return false;
          }
        }
        return true;
    }

//after checking for safe state, processes are allocated resources if found in safe state
public void allocation(){
        calculate_Need();
        int count = 0;
        boolean visited[]=new boolean[np];
        while(count<np){
        boolean allocated=false;
        for(int i=0;i<np;i++){
            if(!visited[i] && is_Safe(i)){
                visited[i]=true;
                allocated=true;
                count++;
                System.out.println("Allocated process : "+i);
                for(int j=0;j<nr;j++){
                //the allotted process completes its execution and adds its resources back to available matrix
                available[0][j]=available[0][j]+allocation[i][j];
                   }
                 }
                }
                if(!allocated) break; //if no allocation is possible
                }
                if(count==np) //if all processes are allocated
                System.out.println("\nAll processes are safely allocated");
                else
                System.out.println("All processes can not be allocated safely");
    }

    public static void main(String[] args) {
        //Create object for the class and call the functions
        BankersAlgorithm b = new BankersAlgorithm();
        b.get_Input();
        b.allocation();
    }
}
