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
				return t.getId() + " " +  t.getTaskName() + " " + t.getDescription() + " " + t.getIsCompletd();
			}
		}
		return "No task with given id";
	}
	
	public List<Task> viewAll(){
		return new ArrayList<>(tasks);
		
	}
	
	public String update(long id, String taskName, String description, boolean isCompleted) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				t.setTaskName(taskName);
				t.setDescription(description);
				t.setIsCompleted(isCompleted);
				return "task updated";
			}
		}
		return "No task exist with given id";
	}
	
	public String deleteTask(long id) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				tasks.remove(t);
				return "Task deleted";
			}
		}
		return "Task is not deleted";
	}
	

}
