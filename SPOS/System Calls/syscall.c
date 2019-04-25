#include<stdio.h>
//#include<string.h>
#include<stdlib.h>
//#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>

int main()
{
   
    int n ;
    
    printf("Which operation you want to perform:-\n");
    printf("1.Join\n");
    printf("2.Exec\n");
    printf("3.Fork , wait, ps,exit\n");
    printf("Enter Your choice\n");
    scanf("%d", &n);
    
     
    switch(n){
        case 1 :{
            char *join[]={"join","a.txt","b.txt",NULL};
	        execvp(join[0],join);
	        printf("param");
	        break;
        }
       case 2:{
           execl("/bin/ls", "ls", 0);
           printf("This text won't be printed unless an error  occurs in exec()."); 
           break;
        
       } 
       case 3:{ 
	        int p_id = fork();	//fork()
	        if(p_id < 0)
	        {
		        printf("creation of a child process was unsuccessful\n");
		        exit(-1);	
	        }
	        else if(p_id == 0)
	        {
		        printf("Child process, Process id = %d \n\n", p_id);
		        execlp("/bin/ps","ps",NULL);	//ps
		        printf("Child exiting");
	        }
	    else{
	            printf("Parent Process,process id = %d \n\n", p_id);
		        wait(NULL);	//wait()
		        printf("\nParent Exiting\n");
		        exit(0);	//exit()
	        }
	        break;
	    }
	
	
	}
	
}


// for running join you must have created two files a.txt and b.txt
// gcc syscall.c
//./a.out                               






