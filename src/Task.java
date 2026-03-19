
public class Task {
	private final Long id;
	private String taskName;
	private String description;
	private boolean isCompleted;
	
	
	Task(Long id, String taskName, String description, boolean isCompleted){
		this.id = id;
		this.taskName = taskName;
		this.description = description;
		this.isCompleted = isCompleted;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isCompletd() {
		return isCompleted;
	}
	
	public String toString() {
		return "Task Id: " + id + ", Task Name: " + taskName + ", Description: " + description + ", Is completed: " + isCompleted;
	}
	
	
	

}
