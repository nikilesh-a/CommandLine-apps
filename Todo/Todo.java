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
		int continueOption = 1;
		scan = new Scanner(System.in);
		int userOption;

		System.out.println("\t*** Silverfox Todo ***");
		while(continueOption == 1)
		{
			String option1 = "1 = New todo(+)";
			String option2 = "2 = for Remove todo(-)";
			System.out.println(option1 +", "+option2);//asking user their option
			
			System.out.print("Press 1 or 2 : ");
			userOption = scan.nextInt(); 

				if(userOption == 1) newTodo(data); //calling fn to create new todo
				else if(userOption == 2) removeTodo(data); //calling fn to remove an existing todo
				else System.out.println("Entered option not available");
				
			printTodoList(data);

			System.out.println("Do you want to continue ? 1 = yes 0 = no");
		    continueOption = scan.nextInt();	
		}
		
	}

	private static void newTodo(List<String> data){

		System.out.print("Enter the text: ");
		scan = new Scanner(System.in);
		
		String text = scan.nextLine(); //reading text
		data.add(text); //store it in a list
	}

	private static void removeTodo(List<String> data){
		int MAX_INDEX = data.size();
		scan = new Scanner(System.in);

		System.out.print("Enter the index of the todo you want to remove: ");
		
		int index = scan.nextInt();
		if(index < 0 || index > MAX_INDEX) // checking whether valid index value
			System.out.println("Index is not valid");
		else
		{
			data.remove(index);	// removing from list
			 System.out.println("Todo removed successfully");
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

