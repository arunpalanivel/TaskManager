import java.util.List;

public interface TaskRepository {
	String addTask(String taskName, String description, boolean isCompleted);
	List<Task> viewAll();
	String viewById(long id);
	String updateName(long id, String taskName);
	String updateDescription(long id, String description);
	String updateStatus(long id, boolean isCompleted);
	String updateAll(long id, String taskName, String description, boolean isCompleted);
	String deleteTask(long id);
}
