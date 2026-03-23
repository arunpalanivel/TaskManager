import java.util.List;

public class TaskService{
	private TaskRepository repo = new TaskRepositoryImpl();
	
	public String addTask(String taskName, String description, boolean isCompleted) {
		return repo.addTask(taskName, description, isCompleted);
	}
	
	public String viewById(long id) {
		return repo.viewById(id);	
	}
	
	public List<Task> viewAll(){
		return repo.viewAll();
	}
	
	public String updateName(long id, String taskName) {
		return repo.updateName(id, taskName);
	}
	
	public String updateDescription(long id, String description) {
		return repo.updateDescription(id, description);
	}
	
	public String updateStatus(long id, boolean status) {
		return repo.updateStatus(id, status);
	}
	
	public String updateAll(long id, String taskName, String description, boolean isCompleted) {
		return repo.updateAll(id, taskName, description, isCompleted);
	}
	
	public String deleteTask(long id) {
		return repo.deleteTask(id);
	}
}
