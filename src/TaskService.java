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
	
	
	public String update(long id, String taskName) {
		Task updateTask = null;
		for(Task t: tasks) {
			if(t.getId() == id) {
				updateTask = t;
			}
		}
		
		updateTask.setTaskName(taskName);
		return "Name Updated successfully";
	}
	
	
	public String update(String description, long id) {
		Task updateTask = null;
		for(Task t: tasks) {
			if(t.getId() == id) {
				updateTask = t;
			}
		}
		
		updateTask.setDescription(description);
		return "Description Updated successfully";
	}
	
	public String update(long id, boolean status) {
		Task updateTask = null;
		for(Task t: tasks) {
			if(t.getId() == id) {
				updateTask = t;
			}
		}
		
		updateTask.setIsCompleted(status);
		return "Status Updated successfully";
	}
	
	public String update(long id, String taskName, String description, boolean isCompleted) {
		Task updateTask = null;
		for(Task t: tasks) {
			if(t.getId() == id) {
				updateTask = t;
			}
		}
		
		updateTask.setDescription(description);
		updateTask.setTaskName(taskName);
		updateTask.setIsCompleted(isCompleted);
		return "Task Updated successfully";
	}
	
	public String deleteTask(long id) {
		Task d = null;
		for(Task t: tasks) {
			if(t.getId() == id) {
				d = t;
				
			}
		}
		if(d != null) {
			tasks.remove(d);
			return "Task deleted";
		}
		return "Task is not deleted";
	}
	
	public boolean search(long id) {
		for(Task t: tasks) {
			if(t.getId() == id) {
				return true;
			}
		}
		return false;
	}
	

}
