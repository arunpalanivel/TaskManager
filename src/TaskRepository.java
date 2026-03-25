import java.util.List;

public interface TaskRepository {
	String addTask(Task t);
	List<Task> viewAll();
	String viewById(long id);
	List<Task> getTaskDone();
	List<Task> getTaskInProgress();
	List<Task> getTaskTodo();
	String updateName(long id, String taskName);
	String updateDescription(long id, String description);
	String updateStatus(long id, Status status);
	String updateAll(long id, String taskName, String description, Status status);
	String deleteTask(long id);
}
