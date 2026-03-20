import java.util.List;
import java.util.ArrayList;

public class TaskService {
	
	private List<Task> tasks = new ArrayList<>();
	
	public String addTask(long id, String taskName, String description, boolean isCompleted) {
		if(findById(id) != null) {
			return "id is already exists";	
		}
		tasks.add(new Task(id,taskName,description,isCompleted));
		return "Task added successfully";
	}
	
	public String viewById(long id) {
		Task result = findById(id);
		if(result == null) {
			return "Task not found";
		}
		return result.getId() + " " +  result.getTaskName() + " " + result.getDescription() + " " + result.getIsCompleted();	
	}
	
	public List<Task> viewAll(){
		return new ArrayList<>(tasks);
	}
	
	public String updateName(long id, String taskName) {
		Task updateTask = findById(id);
		if(updateTask == null) {
			return "Task not found";	
		}
		updateTask.setTaskName(taskName);
		return "Name Updated successfully";
	}
	
	public String updateDescription(long id, String description) {
		Task updateTask = findById(id);
		if(updateTask == null) {
			return "Task not found";	
		}
		updateTask.setDescription(description);
		return "Description Updated successfully";
	}
	
	public String updateStatus(long id, boolean status) {
		Task updateTask = findById(id);
		if(updateTask == null) {
			return "Task not found";	
		}
		updateTask.setIsCompleted(status);
		return "Status Updated successfully";
	}
	
	public String updateAll(long id, String taskName, String description, boolean isCompleted) {
		Task updateTask = findById(id);
		if(updateTask == null) {
			return "Task not found";	
		}
		updateTask.setDescription(description);
		updateTask.setTaskName(taskName);
		updateTask.setIsCompleted(isCompleted);
		return "Task Updated successfully";
	}
	
	public String deleteTask(long id) {
		Task d = findById(id);
		if(d == null) {
			return "Task not found";	
		}
		tasks.remove(d);
		return "Task deleted";
	}
	
	public Task findById(long id) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}
}
