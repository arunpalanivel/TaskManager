import java.util.List;

public class TaskService{
	private TaskRepository repo = new TaskRepositoryImpl();
	
	public String addTask(String taskName, String description, Status status) {
		Task t = new Task(0, taskName, description, status);
		return repo.addTask(t);
	}
	
	public String viewById(long id) {
		return repo.viewById(id);	
	}
	
	public List<Task> viewAll(){
		return repo.viewAll();
	}
	
	public String updateName(long id, String taskName) {
		if(taskName.trim().isEmpty() || taskName == null) {
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		return repo.updateName(id, taskName);
	}
	
	public String updateDescription(long id, String description) {
		if(description.trim().isEmpty() || description == null) {
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		return repo.updateDescription(id, description);
	}
	
	public String updateStatus(long id, Status status) {
		return repo.updateStatus(id, status);
	}
	
	public String updateAll(long id, String taskName, String description, Status status) {
		if(taskName.trim().isEmpty() || taskName == null) {
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		
		if(description.trim().isEmpty() || description == null) {
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		
		return repo.updateAll(id, taskName, description, status);
	}
	
	public String deleteTask(long id) {
		return repo.deleteTask(id);
	}
	
	public List<Task> getTaskDone(){
		return repo.getTaskDone();
	}
	
	public List<Task> getTaskTodo(){
		return repo.getTaskTodo();
	}
	
	public List<Task> getTaskInProgress(){
		return repo.getTaskInProgress();
	}
}
