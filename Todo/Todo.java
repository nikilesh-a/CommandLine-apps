import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
class Todo
{
	static Scanner scan ;
	static List<String> data ;

	public static void main(String[] args) 
	{
		data = new LinkedList<String>();

		System.out.println("*** Silverfox Todo ***");  //CMDline app title
		//printTodoList(data);
		
		boolean loop = true;
		while(loop)
		{
		System.out.println("Enter 1 to add a todo");  //asking user for their option
		System.out.println("Enter 2 to remove a todo");
		scan = new Scanner(System.in);
		int option = scan.nextInt(); //reading the option
		
			if(option == 1) 
			{
				newTodo(data); //calling fn to create new todo
				printTodoList(data);

			}
			else if(option == 2)
				
			{
				System.out.println(removeTodo(data)); //calling fn to remove an existing todo
				printTodoList(data);
			}
			else System.out.println("Entered option not available");	
			
		System.out.println("Do you want to continue ? 1 = yes 0 = no");
		int continueOption = scan.nextInt();
			if (continueOption == 0 )
			{
				loop = false;
			}
		}
		
	}

	private static void newTodo(List<String> data){

		System.out.print("Enter the text: ");
		scan = new Scanner(System.in);
		
		String text = scan.nextLine(); //reading text
		data.add(text); //store it in a list
	}

	private static String removeTodo(List<String> data){
		int MAX_INDEX = data.size();
		scan = new Scanner(System.in);

		System.out.print("Enter the index of the todo you want to remove: ");
		
		int index = scan.nextInt();
		if(index < 0 || index > MAX_INDEX)
			return "Index is not valid";
		else
		{
			data.remove(index);	
			return "Todo removed successfully";
		}
	}
	
	private static void printTodoList(List<String> data){
		
		System.out.printf("\tIndex   TODO\n");
		System.out.printf("\t------------\n");
		for (int i=0; i<data.size(); i++ )
		{
			System.out.printf("\t%d\t %s \n",i, data.get(i));
		}
	}
}

