
public class Task {
	private final long id;
	private String taskName;
	private String description;
	private Status status;
	
	Task(long id, String taskName, String description, Status status){
		this.id = id;
		setTaskName(taskName);
		setDescription(description);
		setStatus(status);
	}
	
	public long getId() {
		return id;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		if(taskName == null || taskName.trim().isEmpty()) {
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		this.taskName = taskName.trim();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(description == null || description.trim().isEmpty()) {
			throw new IllegalArgumentException("Task description cannot be empty");
		}
		this.description = description;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		if(status == null) {
			throw new IllegalArgumentException("Status cannot be null");
		}
		this.status = status;
	}
	
	public String toString() {
		return "Task Id: " + id + ", Task Name: " + taskName + ", Description: " + description + ", Status: " + status;
	}
}
