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
			
			System.out.print("Enter your choice: ");			
			choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice){
				case 1:{
					System.out.print("Enter id: ");
					long id = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter Task Name: ");
					String taskName = scanner.nextLine();
					System.out.print("Enter Description: ");
					String description = scanner.nextLine();
					boolean isCompleted = false;
					String result = tm.addTask(id,taskName,description,isCompleted);
					System.out.println(result);
					break;
					
				}
					
				
				case 2:{
					System.out.print("Enter id");
					long id = Integer.parseInt(scanner.nextLine());
					String result = tm.viewById(id);
					System.out.println(result);
					break;
					
				}
				
				case 3:{
					System.out.println(tm.viewAll());
					break;
				}
				
				
				case 4:{
					System.out.print("Enter id: ");
					long id = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter Task Name: ");
					String taskName = scanner.nextLine();
					System.out.print("Enter Description: ");
					String description = scanner.nextLine();
					System.out.print("Enter Status(true/false): ");
					boolean isCompleted = Boolean.parseBoolean(scanner.nextLine());
					String result = tm.update(id,taskName,description,isCompleted);
					System.out.println(result);
					break;
					
				}
				
				
				case 5: {
					System.out.print("Enter id: ");
					long id = Integer.parseInt(scanner.nextLine());
					String result = tm.deleteTask(id);
					System.out.println(result);
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
