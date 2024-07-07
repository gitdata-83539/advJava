package com.sunbeam.jbeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateBean {
	
	private String id;
	private String name;
	private String party;
	private String votes;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getVotes() {
		return votes;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	
	public void updateCand()
	{ System.out.println("hello");
		int i=Integer.parseInt(id);
		int v=Integer.parseInt(votes);
		
		Candidate c= new Candidate(i,name,party,v);
		System.out.println("hello1111");
		System.out.println(c.toString());
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			count=cdao.update(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String toString() {
		return "UpdateBean [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + ", count=" + count
				+ "]";
	}
}
