package com.sunbeam.jbeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class VoteBeans {
	private String candidate;
	private int count;

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void incrementVote()
	{
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			int id=Integer.parseInt(candidate);
			System.out.println("id is "+id);
			count=cdao.incrementVote(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
