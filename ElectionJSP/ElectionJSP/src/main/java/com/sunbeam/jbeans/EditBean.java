package com.sunbeam.jbeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class EditBean {
	private Candidate cd;
	private String id;
	public Candidate getCd() {
		return cd;
	}
	public void setCd(Candidate cd) {
		this.cd = cd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void getCand()
	{
		int i=Integer.parseInt(id);
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			cd=cdao.findById(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
