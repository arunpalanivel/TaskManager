import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		TaskService tm = new TaskService();
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while(choice != 6){
			System.out.println("Welcome to Task Manager");
			System.out.println("1. Add Task");
			System.out.println("2. View Task");
			System.out.println("3. View All Task");
			System.out.println("4. Update Task");
			System.out.println("5. Delete Task");
			System.out.println("6. Quit");
			
			choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice){
				case 1:{
					long id = Integer.parseInt(scanner.nextLine());
					String taskName = scanner.nextLine();
					String description = scanner.nextLine();
					boolean isCompleted = false;
					String result = tm.addTask(id,taskName,description,isCompleted);
					System.out.println(result);
					break;
					
				}
					
				
				case 2:{
					long id = Integer.parseInt(scanner.nextLine());
					String result = tm.viewById(id);
					System.out.println(result);
					break;
					
				}
				
				case 3:{
					System.out.println(tm.viewAll());
					break;
				}
				
				
					
					
				case 6:
					System.out.println("Thank You");
					break;
					
				default:
					System.out.println("Enter valid number");
					break;
					
			
			
			
			
		}
		
		
	

}
		}}
