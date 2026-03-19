import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		TaskService taskService = new TaskService();
		TaskService tm = new TaskService();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to Task Manager");
			System.out.println("1. Add Task");
			System.out.println("2. View Task");
			System.out.println("3. View All Task");
			System.out.println("4. Update Task");
			System.out.println("5. Delete Task");
			System.out.println("6. Quit");
			
			int choice = Integer.parseInt(scanner.nextLine());
			Switch(choice){
				case 1:
					
			}
			
			
			
		}
		Task t = new Task(1L,"Study", "Study Physics", false);
		taskService.addTask(t);
		taskService.viewAll();
		Task t2 = new Task(2L, "Cook", "Cook briyani", false);
		tm.addTask(t2);
		tm.viewAll();
		taskService.addTask(t2);
		taskService.viewAll();
		taskService.viewById(2L);
		
	}

}
