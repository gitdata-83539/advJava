package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CandidateDao.CandidateDao;
import Entity.Candidate;
import Entity.User;
import UserDao.UserDao;

public class Main {
	public static void main(String[] args) {
		try {
			UserDao d1 = new UserDao();
			CandidateDao c1=new CandidateDao();
			Candidate c= new Candidate();
			List<Candidate> l=new ArrayList<Candidate>();
			l=c1.findAll();
			for(Candidate c2:l)
			{
				System.out.println(c2.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
