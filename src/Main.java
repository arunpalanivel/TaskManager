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
			
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a number " + e.getMessage());
			}
			
			switch(choice){
				case 1:{ 
					try {
						System.out.println("Add task to the list. ");
						System.out.print("Enter id: ");
						long id = Long.parseLong(scanner.nextLine());
						System.out.print("Enter Task Name: ");
						String taskName = scanner.nextLine();
						System.out.print("Enter Description: ");
						String description = scanner.nextLine();
						boolean isCompleted = false;
						String result = tm.addTask(id,taskName,description,isCompleted);
						System.out.println(result);
					} catch (NumberFormatException e) {
						System.out.println("Error: Enter a number " + e.getMessage());
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
								System.out.print("Enter the status(true/false): ");
								boolean status = Boolean.parseBoolean(scanner.nextLine());
								System.out.println(tm.updateStatus(id,status));
								break;
								
							}
							case 4:{
								System.out.print("Enter Task Name: ");
								String taskName = scanner.nextLine();
								System.out.print("Enter Description: ");
								String description = scanner.nextLine();
								System.out.print("Enter Status(true/false): ");
								boolean isCompleted = Boolean.parseBoolean(scanner.nextLine());
								String result = tm.updateAll(id,taskName,description,isCompleted);
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
						
				case 6:
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
