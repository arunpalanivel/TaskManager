import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository{
	private Connection getConnection() throws Exception{
		String url = "jdbc:postgresql://localhost:5432/task_manager";
		String user = "postgres";
		String password = "postgres";
		
		return DriverManager.getConnection(url,user,password);
	}
	
	@Override
	public String addTask(String taskName, String description, boolean isCompleted) {
		String sql = "INSERT INTO task(taskname,description,iscompleted) VALUES(?,?,?)";
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			ps.setString(1,taskName);
			ps.setString(2, description);
			ps.setBoolean(3, isCompleted);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					return "Task created with ID: " + rs.getLong(1);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not created";
	}
	
	@Override
	public String viewById(long id) {
		String sql = "SELECT * FROM task WHERE id = ?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				long taskId = rs.getLong("id");
				String taskName = rs.getString("taskname");
				String description = rs.getString("description");
				boolean isCompleted = rs.getBoolean("iscompleted");
				
				Task t = new Task(taskId, taskName, description, isCompleted);
				return t.toString();
			}			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";	
	}
	
	@Override
	public List<Task> viewAll(){
		List<Task> tasks = new ArrayList<>();
		String sql = "SELECT * FROM task";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				long id = rs.getLong("id");
				String taskName = rs.getString("taskname");
				String description = rs.getString("description");
				boolean isCompleted = rs.getBoolean("iscompleted");
				
				Task t = new Task(id,taskName,description,isCompleted);
				tasks.add(t);
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return tasks;
	}
	
	@Override
	public String updateName(long id, String taskName) {
		String sql = "UPDATE task SET taskname = ? WHERE id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, taskName);
			ps.setLong(2, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				return "Task updated successfully";
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";
	}
	
	@Override
	public String updateDescription(long id, String description) {
		String sql = "UPDATE task SET description = ? WHERE id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, description);
			ps.setLong(2, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				return "Task updated successfully";
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";
	}
	
	@Override
	public String updateStatus(long id, boolean status) {
		String sql = "UPDATE task SET iscompleted = ? WHERE id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setBoolean(1, status);
			ps.setLong(2, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				return "Task updated successfully";
			}
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";
	}
	
	@Override
	public String updateAll(long id, String taskName, String description, boolean isCompleted) {
		String sql = "UPDATE task SET taskname = ?, description = ?, iscompleted = ? WHERE id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, taskName);
			ps.setString(2,description);
			ps.setBoolean(3,isCompleted);
			ps.setLong(4,id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				return "Task updated successfully";
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";
	}
	
	@Override
	public String deleteTask(long id) {
		String sql = "DELETE FROM task WHERE id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setLong(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				return "Task deleted successfully";
			}
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Task not found";
	}
}
