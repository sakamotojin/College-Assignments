#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
void demo()
{
	if(fork()==0)
	for(int i =0 ; i < 10 ; i++)
		printf("child\n");
	else printf("parent\n");
		
}
int main()
{
	demo();
	//char *a[]={"ls",NULL};
	//execvp(a[0],a);
	//int pid = 90;
	//char *b[]={"ps",NULL};
	//printf("%d\n",pid);
	//execvp(b[0],b);
	wait(NULL);
	printf("hi\n");
	return 0 ;
}
