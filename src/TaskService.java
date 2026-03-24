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
		Status s = Status.TODO;
		Task t = new Task(0,taskName,"description",s);
		return repo.updateName(id, t.getTaskName());
	}
	
	public String updateDescription(long id, String description) {
		Status s = Status.TODO;
		Task t = new Task(0,"taskName",description,s);
		return repo.updateDescription(id, t.getDescription());
	}
	
	public String updateStatus(long id, Status status) {
		
		Task t = new Task(0,"taskName","description",status);
		return repo.updateStatus(id, t.getStatus());
	}
	
	public String updateAll(long id, String taskName, String description, Status status) {
		Task t = new Task(0,taskName,description,status);
		return repo.updateAll(id, t);
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
