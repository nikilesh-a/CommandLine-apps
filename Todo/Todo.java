import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
class Todo
{
	static Scanner scan ;
	static List<String> data ;

	public static void main(String[] args) throws Exception
	{
		File filePath = new File("D:\\P\\Projects\\Commandline apps\\Todo\\todos.txt");
		PrintWriter pw = new PrintWriter(filePath);
				
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

				if(userOption == 1) newTodo(pw); //calling fn to create new todo
				else if(userOption == 2) removeTodo(pw); //calling fn to remove an existing todo
				else System.out.println("Entered option not available");
				
			printTodoList(filePath);

			System.out.println("Do you want to continue ? 1 = yes 0 = no");
		    continueOption = scan.nextInt();	
		}
		
	}

	private static void newTodo(PrintWriter pw) throws Exception{
		System.out.print("Enter the text: ");
		scan = new Scanner(System.in);
		
		String text = scan.nextLine(); 
		pw.println(text);
		pw.flush();
	}

	private static void removeTodo(PrintWriter pw) throws Exception{
		
		data = new LinkedList<String>();
		scan = new Scanner(System.in);
		
		File filePath = new File("D:\\P\\Projects\\Commandline apps\\Todo\\todos.txt");
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		System.out.print("Enter the index of the todo you want to remove: ");
		// PrintWriter pw = new PrintWriter(filePath);
		int index = scan.nextInt();
		
		String temp = br.readLine();
		while(temp != null){
			data.add(temp);
			temp = br.readLine();
		}
		System.out.println(data);
		data.remove(index);
		System.out.println(data);
		
		for(String x:data){
			pw.println(x);
			pw.flush();
		}


		}
	
	
	private static void printTodoList(File filePath) throws Exception{
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		int i= 0;


		System.out.printf("\tIndex   TODO\n");
		System.out.printf("\t------------\n");
	
		String temp = br.readLine();
		
		while(temp != null){
			System.out.printf("\t%d\t %s \n",i, temp);
			++i;
			temp = br.readLine();
		}

	}
}
/