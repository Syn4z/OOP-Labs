#include <stdio.h>
#include<stdlib.h>
#define limit 99

void check();
void clear();
void insert();
void priority_insert();
void circular_insert();
void delete();
void circular_delete();
void reverse();
void sort();
void display();
int priority_queue();
int circular_queue();
int main();
int queue_struct[limit];
int rear = - 1;
int front = - 1;

void clear()
{
    system("clear");
}

void check(int element)
{
	int i;
    for (i = 0; i <= rear; i++)
    {
        if (element >= queue_struct[i])
        {
            for (int j = rear+1; j > i; j--)
            {
                queue_struct[j] = queue_struct[j - 1];
            }
            queue_struct[i] = element;
            return;
        }
    }

    queue_struct[i] = element;
}

void insert(int element)
{
    if (rear == limit - 1)
        printf("\n\tQueue Overflow!");
    else
	{
        if (front == - 1)
            front = 0;
            rear = rear + 1;
            queue_struct[rear] = element;
    }
}

void priority_insert(int element)
{
	if (rear >= limit - 1)
	{
		printf("\n\tQueue Overflow!");
		return;
	}

	if ((front == -1) && (rear == -1))
	{
		front++;
		rear++;
		queue_struct[rear] = element;
		return;
	}    
	else
		check(element);
	rear++;
}

void circular_insert(int element)
{
    if ((front == rear + 1) || (front == 0 && rear == limit - 1))
        printf("\n\tQueue Overflow!");
    else 
	{
        if (front == -1) 
            front = 0;
            rear = (rear + 1) % limit;
            queue_struct[rear] = element;
    }
}

void delete(int element)
{
    if ((front == -1) && (rear == -1))
    {
        printf("\nQueue is Empty!");
        return;
    }

    for (int i = 0; i <= rear; i++)
    {
        if (element == queue_struct[i])
        {
            for (i; i < rear; i++)
			{
                queue_struct[i] = queue_struct[i + 1];
			}	

        rear--;

        if (rear == -1) 
            front = -1;
        return;
        }
	}

    printf("\n\t%d is not in queue!", element);
}	

void circular_delete()
{
    if (front == -1) 
	{
        printf("\n\tQueue is empty!");
    } 
    else 
	{
        if (front == rear) 
		{
            front = -1;
            rear = -1;
        } 
        else 
		{
            printf("Element deleted from queue is: %d \n", queue_struct[front]);
            front = (front + 1) % limit;
        }
    }
}

void reverse()
{
    int i, j, t;
	for (i = front, j = rear; i < j; i++,j--)
    {
		t = queue_struct[i];
		queue_struct[i] = queue_struct[j];
		queue_struct[j] = t;
	}
	printf("\n\tReversed queue: ");
	for (i = front; i <= rear; i++)
			printf("%d ", queue_struct[i]);
}

void sort()
{
	printf("\n\tSorted queue: ");
	int i, j, t;
	for (i = front, j = rear; i < j; i++,j--)
    {
		t = queue_struct[i];
		queue_struct[i] = queue_struct[j];
		queue_struct[j] = t;
	}
	for (i = front; i <= rear; i++)
			printf("%d ", queue_struct[i]);
	for (i = front, j = rear; i < j; i++,j--)
    {
		t = queue_struct[i];
		queue_struct[i] = queue_struct[j];
		queue_struct[j] = t;
	}
}

void display()
{
	int i;
	if ((front == -1) && (rear == -1))
	{
		printf("\n\tQueue is empty!");
		return;
	}	
	else
	{
		printf("\n\tThe Queue: ");
		for (i = front; i <= rear; i++)
			printf("%d ", queue_struct[i]);
	}

	front = 0;
}

void load_file()
{
    int i = 0;
    front = 0;
    rear = -1;

    FILE *loaded_file  = fopen("load.txt", "r");

    if (loaded_file == NULL) 
	{   
        printf("\n\tFile cannot be accesed!"); 
        exit(0);
    }
    else
	{
        printf("\n\tFile loaded up");

        while(fscanf(loaded_file, "%d ", &queue_struct[i]) != EOF)
		{
            i++;
            rear++;
        }
    }

    fclose(loaded_file);
}

void save_file()
{
	FILE *fp;
	fp = fopen("queue.txt", "w+");
	for (int i = 0; i < limit; i++)
		{
			if (queue_struct[i] == 0)
				break;
			fprintf(fp, "%i ", queue_struct[i]);
		}
	fclose(fp);
	printf("\n\n\tQueue saved to file named 'queue.txt'");
}

int priority_queue()
{
	int choice, e;

	while (1)
	{
		printf("\n\n==================Priority Queue==================");
		printf("\nType '1' to insert an element to priority queue");
		printf("\nType '2' to delete an element from priority queue");
		printf("\nType '3' to display the elements of priority queue");
		printf("\nType '4' to reverse the priority queue");
		printf("\nType '5' to load priority queue from a file");
		printf("\nType '6' to save priority queue to a file");
		printf("\nType '7' to quit");
		printf("\nType '0' to go back to Queue Menu");
		printf("\n--------------------------------------------------");
		printf("\n\n\tType in your choice: ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
				printf("Type the element to insert: ");
				scanf("%d", &e);
				priority_insert(e);
				break;
			case 2:
				circular_delete();
				break;
			case 3:
				display();
				break;
			case 4:
				reverse();
				int i, j, t;
				for (i = front, j = rear; i < j; i++,j--)
				{
					t = queue_struct[i];
					queue_struct[i] = queue_struct[j];
					queue_struct[j] = t;
				}
				break;	
			case 5:
				load_file();
				break;		
			case 6:
				save_file();
				break;	
			case 7:
				exit(0);
			case 0:
				main();
			default:
				printf("\nTry again!");
		}
		clear();
	}		
}

int circular_queue()
{
	int choice, e;

	while (1)
	{
		printf("\n\n==================Circular Queue==================");
		printf("\nType '1' to insert an element to circular queue");
		printf("\nType '2' to delete an element from circular queue");
		printf("\nType '3' to display the elements of circular queue");
		printf("\nType '4' to reverse the circular queue");
		printf("\nType '5' to load circular queue from a file");
		printf("\nType '6' to save circular queue to a file");
		printf("\nType '7' to quit");
		printf("\nType '0' to go back to Queue Menu");
		printf("\n--------------------------------------------------");
		printf("\n\n\tType in your choice: ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
				printf("Type the element to insert: ");
				scanf("%d", &e);
				circular_insert(e);
				break;
			case 2:
				circular_delete();
				break;
			case 3:
				display();
				break;
			case 4:
				reverse();
				int i, j, t;
				for (i = front, j = rear; i < j; i++,j--)
				{
					t = queue_struct[i];
					queue_struct[i] = queue_struct[j];
					queue_struct[j] = t;
				}
				break;	
			case 5:
				load_file();
				break;		
			case 6:
				save_file();
				break;	
			case 7:
				exit(0);
			case 0:
				main();		
			default:
				printf("\nTry again!");
		}
		clear();
	}		
}

int main()
{
	int choice, e;

	while (1)
	{
		clear();
		printf("\n\n================Queue Menu================");
		printf("\nType '1' to insert an element to queue");
		printf("\nType '2' to delete an element from queue");
		printf("\nType '3' to display the elements of queue");
		printf("\nType '4' to reverse the queue");
        printf("\nType '5' to sort the queue");
		printf("\nType '6' to load queue from a file");
		printf("\nType '7' to save queue to a file");
        printf("\nType '0' to quit");
		printf("\nType '8' to enter priority queue");
		printf("\nType '9' to enter circular queue");
		printf("\n------------------------------------------");
		printf("\n\n\tType in your choice: ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
				printf("Type the element to insert: ");
				scanf("%d", &e);
				insert(e);
				break;
			case 2:
				printf("Type the element to delete: ");
				scanf("%d", &e);
				delete(e);
				break;
			case 3:
				display();
				break;
			case 4:
				reverse();
				int i, j, t;
				for (i = front, j = rear; i < j; i++,j--)
				{
					t = queue_struct[i];
					queue_struct[i] = queue_struct[j];
					queue_struct[j] = t;
				}
                break;	
			case 5:
				sort();
				break;
			case 6:
				load_file();
				break;		
			case 7:
				save_file();
				break;	
			case 0:
				exit(0);
			case 8:
				clear();
				priority_queue();		
			case 9:
				clear();
				circular_queue();		
			default:
				printf("\nTry again!");
		}
	}
	
	return 0;
}

