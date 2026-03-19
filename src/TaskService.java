import java.util.List;
import java.util.ArrayList;

public class TaskService {
	
	private static List<Task> tasks = new ArrayList<>();
	
	public String addTask(long id, String taskName, String description, boolean isCompleted) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				return "Id is already exists";
			}
		}
		tasks.add(new Task(id,taskName,description,isCompleted));
		return "Task added successfully";
	}
	
	public String viewById(long id) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				return t.getId() + " " +  t.getTaskName() + " " + t.getDescription() + " " + t.isCompletd();
			}
		}
		return "No task with given id";
	}
	
	public List<Task> viewAll(){
		return new ArrayList<>(tasks);
		
	}
	

}
