public class Task {
	private final long id;
	private String taskName;
	private String description;
	private boolean isCompleted;
	
	Task(long id, String taskName, String description, boolean isCompleted){
		this.id = id;
		setTaskName(taskName);
		setDescription(description);
		this.isCompleted = isCompleted;
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
	
	public boolean getIsCompleted() {
		return isCompleted;
	}
	
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public String toString() {
		return "Task Id: " + id + ", Task Name: " + taskName + ", Description: " + description + ", Is completed: " + isCompleted;
	}
}
