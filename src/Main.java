import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TaskService tm = new TaskService();
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		while(choice != 9){
			System.out.println("Welcome to Task Manager");
			System.out.println("1. Add Task");
			System.out.println("2. View Task");
			System.out.println("3. View All Task");
			System.out.println("4. Update Task");
			System.out.println("5. Delete Task");
			System.out.println("6. Get Task TODO");
			System.out.println("7. Get Task IN PROGRESS");
			System.out.println("8. Get Task DONE");
			System.out.println("9. Quit");
			System.out.print("Enter your choice: ");	
			
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a number " + e.getMessage());
			}
			
			switch(choice){
				case 1:{ 
					try {
						System.out.println("Add task to the list. ");
						System.out.print("Enter Task Name: ");
						String taskName = scanner.nextLine();
						System.out.print("Enter Description: ");
						String description = scanner.nextLine();
						Status status = Status.TODO;
						String result = tm.addTask(taskName,description,status);
						System.out.println(result);
					} catch(IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;
				}
					
				case 2:{
					try {
						System.out.println("View task by using id. ");
						System.out.print("Enter id: ");
						long id = Long.parseLong(scanner.nextLine());
						String result = tm.viewById(id);
						System.out.println(result);
					} catch (NumberFormatException e) {
						System.out.println("Error: Enter a number " + e.getMessage());
					}
					break;
				}
				
				case 3:{
					System.out.println("View all tasks from the list. ");
					System.out.println(tm.viewAll());
					break;
				}
				
				case 4:{
					try {
						System.out.println("Update task by using id. ");
						System.out.print("Enter id: ");
						long id = Long.parseLong(scanner.nextLine());
						System.out.println("What you want to update(name/ description/ status/ All?): ");
						System.out.println("1. name");
						System.out.println("2. description");
						System.out.println("3. status");
						System.out.println("4. all");
						System.out.println("5. no update");
						System.out.print("Enter your choice: ");
						int updateChoice = Integer.parseInt(scanner.nextLine());
						switch (updateChoice) {
							case 1: {
									System.out.print("Enter the name: ");
									String name = scanner.nextLine();
									System.out.println(tm.updateName(id, name));
								break;
							}
							
							case 2: {
								System.out.print("Enter the description: ");
								String description = scanner.nextLine();
								System.out.println(tm.updateDescription(id,description));
								break;
							}
							
							case 3:{
								System.out.print("Enter the status(TODO/IN_PROGRESS/DONE): ");
								Status status = Status.valueOf(scanner.nextLine().trim().toUpperCase());
								System.out.println(tm.updateStatus(id,status));
								break;
								
							}
							case 4:{
								System.out.print("Enter Task Name: ");
								String taskName = scanner.nextLine();
								System.out.print("Enter Description: ");
								String description = scanner.nextLine();
								System.out.print("Enter Status(TODO/IN_PROGRESS/DONE): ");
								Status status = Status.valueOf(scanner.nextLine().trim().toUpperCase());
								String result = tm.updateAll(id,taskName,description,status);
								System.out.println(result);	
								break;
							}
							
							case 5:{
								System.out.println("Changed mind? dont' want to update?");
								System.out.println("Thank you");
								break;
							}
							default:{
								System.out.println("Enter valid number");
								break;
							}	
						}				
					} catch(NumberFormatException e) {
						System.out.println("Error: Enter a number " + e.getMessage());
					} catch(IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;
				}
				
				case 5: {
					try {
						System.out.println("Delete task by using id. ");
						System.out.print("Enter id: ");
						long id = Long.parseLong(scanner.nextLine());
						String result = tm.deleteTask(id);
						System.out.println(result);
					} catch(NumberFormatException e) {
						System.out.println("Error: Enter a number " + e.getMessage());
					} catch(IllegalArgumentException e) {
						System.out.println("Error: Enter a number " + e.getMessage());
					}
					break;
				}
				
				case 6:{
					System.out.println("Task in Todo Status. ");
					var t = tm.getTaskTodo();
					if(t.isEmpty()) {
						System.out.println("There is no task with TODO status.");
					}
					else {
						System.out.println(t);
					}
					break;
				}
				
				case 7:{
					System.out.println("Task in In Progress Status. ");
					var t = tm.getTaskInProgress();
					if(t.isEmpty()) {
						System.out.println("There is no task with In Progress status.");
					}
					else {
						System.out.println(t);
					}
					break;
				}
					
				case 8:{
					System.out.println("Task in Done Status. ");
					var t = tm.getTaskDone();
					if(t.isEmpty()) {
						System.out.println("There is no task with Done status.");
					}
					else {
						System.out.println(t);
					}
					break;
				}
				
				case 9:
					System.out.println("Thank You");
					break;
					
				default:
					System.out.println("Enter valid number");
					break;
			}
		}
		scanner.close();
	}
}
