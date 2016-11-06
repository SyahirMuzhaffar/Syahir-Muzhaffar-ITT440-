#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h>

int main(void)
{
    int sockfd = 0;
    int bytesR = 0;
    char data[256];
    float salary=0.0;
    int age=0,id=0;
    char recvBuff[256];
    memset(recvBuff, '0', sizeof(recvBuff));
    struct sockaddr_in serv_addr;

    /* Create a socket first */
    if((sockfd = socket(AF_INET, SOCK_STREAM, 0))< 0)
    {
        printf("No Socket \n");
        return 1;
    }

    /* Initialize sockaddr_in data structure */
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(5000); // port
    serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    /* Attempt a connection */
    if(connect(sockfd, (struct sockaddr *)&serv_addr,
sizeof(serv_addr))<0)
    {

		 printf("Failed");
        return 1;
    }

    /* Create file where data will be stored */
    FILE *fp;
    fp = fopen("file.txt", "ab");
    if(NULL == fp)
    {
        printf("Error opening file");
        return 1;
    }

    /* Receive data in chunks of 256 bytes */

    printf(ID     : ");
    scanf("%d",&id);
    fprintf(fp,"\n\nID    :%d \n",id);
    printf("Name        : ");
    scanf("%s",&data);

	 fprintf(fp,"NAME : %s \n",data);

    printf("Salary : RM ");
    scanf("%f",&salary);
    fprintf(fp,"Salary : RM %.2f \n",salary);

  /* while((bytesR = read(sockfd, recvBuff, 256)) > 0)
    {
        printf("Bytes received %d\n",bytesR);
        // recvBuff[n] = 0;
        //fwrite(recvBuff, 256,data,fp);
         //printf("%s \n", recvBuff);
    }

    if(bytesR < 0)
    {
        printf("\n Read Error \n");
    }*/

	
	    return 0;
}

