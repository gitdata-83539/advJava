package CandidateDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DbUtil.IdbUtil;
import Entity.Candidate;
import Entity.User;
public class CandidateDao implements IdbUtil,AutoCloseable{
	private Connection connection;
	
	public CandidateDao() throws SQLException
	{
		connection=IdbUtil.getConnection();
		}
	
	public List<Candidate> findAll() throws SQLException
	{
		List<Candidate> l=new ArrayList<Candidate>();
		
		String sql="select * from  candidates;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{Candidate c=new Candidate();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setParty(rs.getString(3));
			c.setVotes(rs.getInt(4));
			l.add(c);
			
		}
		
		return l;
	}
	public List<Candidate> findByParty(String party) throws SQLException
	{
		List<Candidate> l=new ArrayList<Candidate>();
		
		String sql="select * from candidates where party=?;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		stmt.setString(1, party);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{   Candidate c=new Candidate();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setParty(rs.getString(3));
			c.setVotes(rs.getInt(4));
			l.add(c);
			
		}
		
		return l;
	}
	public List<Candidate> findAllOrderByVotesDesc() throws SQLException
	{
		List<Candidate> l=new ArrayList<Candidate>();
		
		String sql="select * from candidates order by votes desc;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		ResultSet rs= stmt.executeQuery();
	
		while(rs.next())
		{	Candidate c=new Candidate();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setParty(rs.getString(3));
			c.setVotes(rs.getInt(4));
			//System.out.println(c.toString());
			l.add(c);
			
		}
		
		return l;
	}
	
	public int save(Candidate u) throws SQLException
	{
		String sql="insert into candidates (name,party,votes) values(?,?,?)";
		PreparedStatement stmt=connection.prepareStatement(sql);
		stmt.setString(1, u.getName());
		stmt.setString(2, u.getParty());
		stmt.setInt(3, u.getVotes());
		
        stmt.executeUpdate();
        System.out.println("inserted successfully");
        
        return 0;
	}
	public int deleteId(int id) throws SQLException
	{
		String sql="delete from candidates where id=?;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		return 0;
	}
	public int update(Candidate u) throws SQLException
	{
		String sql="update users set name=?,party=?,votes=? where id=?;";
		PreparedStatement stmt=connection.prepareStatement(sql);
		stmt.setString(1, u.getName());
		stmt.setString(2, u.getParty());
		stmt.setInt(3, u.getVotes());
		
        stmt.executeUpdate();
        System.out.println("inserted successfully");
        
        return 0;
	}
	public Candidate findById(int id) throws SQLException
	{
		List<Candidate> l=new ArrayList<Candidate>();
		Candidate c=new Candidate();
		String sql="select * from from candidates where id=?;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{ 
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setParty(rs.getString(3));
			c.setVotes(rs.getInt(4));
			
			
		}
		
		return c;
	}
	public int incrementVotes(int id) throws SQLException
	{
		String sql="update candidates set votes=votes+1 where id=?;";
		PreparedStatement stmt= connection.prepareStatement(sql);
		stmt.setInt(1,id);
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
