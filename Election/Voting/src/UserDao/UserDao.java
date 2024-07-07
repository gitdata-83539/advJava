package UserDao;


	
	import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import DbUtil.IdbUtil;
    import Entity.User;
	public class UserDao implements IdbUtil,AutoCloseable{
		private Connection connection;
		
		public UserDao() throws SQLException
		{
			connection=IdbUtil.getConnection();
			
		}
		
		
		public User findByEmail(String email) throws SQLException
		{   User u= new User();
			String sql="Select * from users where email=?";
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setFirst_name(rs.getString(2));
				u.setLast_name(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setDob(rs.getDate(6));
				u.setStatus(rs.getInt(7));
				u.setRole(rs.getString(8));
				
			}
			System.out.println("loaded successfully");
			return u;
		}
		public User findById(int id) throws SQLException
		{   User u= new User();
			String sql="Select * from users where id=?";
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setFirst_name(rs.getString(2));
				u.setLast_name(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setDob(rs.getDate(6));
				u.setStatus(rs.getInt(7));
				u.setRole(rs.getString(8));
				
			}
			System.out.println("loaded successfully");
			return u;
		}
		
		public int save(User u) throws SQLException
		{
			String sql="insert into users (first_name,last_name,email,password,dob,status,role) values(?,?,?,?,?,?,?)";
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, u.getFirst_name());
			stmt.setString(2, u.getLast_name());
			stmt.setString(3, u.getEmail());
			stmt.setString(4,u.getPassword());
			stmt.setDate(5,u.getDob());
			stmt.setInt(6,u.getStatus());
			stmt.setString(7,u.getRole());
            stmt.executeUpdate();
            System.out.println("inserted successfully");
            
            return 0;
		}
		public int updatePassword(int userId,String newPassword) throws SQLException
		{
			String sql="update users set password=? where id=?;";
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
			
			return 0;
		}
		public int update(User u) throws SQLException
		{
			String sql="update users set first_name=?,last_name=?,email=?,password=?,dob=?,status=?,role=? where id=?;";
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, u.getFirst_name());
			stmt.setString(2, u.getLast_name());
			stmt.setString(3, u.getEmail());
			stmt.setString(4,u.getPassword());
			stmt.setDate(5,u.getDob());
			stmt.setInt(6,u.getStatus());
			stmt.setString(7,u.getRole());
			stmt.setInt(8,u.getId());
            stmt.executeUpdate();
            System.out.println("inserted successfully");
            
            return 0;
		}
		
		public int deleteId(int userId) throws SQLException
		{
			String sql="delete from users where id=?;";
			PreparedStatement stmt= connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.executeUpdate();
			return 0;
		}
		
        		
		@Override
		public void close() throws Exception {
			// TODO Auto-generated method stub
			if(connection!=null)
			{
				connection.close();
			}
			
		}
		
	}


