import java.util.List;
import java.util.ArrayList;

public class TaskService {
	
	private static List<Task> tasks = new ArrayList<>();
	
	public String addTask(Task task) {
		for(Task t: tasks) {
			if(t.getId() == task.getId()) {
				return "Id is already exists";
			}
		}
		tasks.add(task);
		return "Task added successfully";
	}
	
	public Task viewById(Long id) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	
	public List<Task> viewAll(){
		return new ArrayList<>(tasks);
		
	}
	

}
