package com.sunbeam.jbeans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBean {
	
	private List<Candidate> clist;

	
	public List<Candidate> getClist() {
		return clist;
	}


	public void setClist(List<Candidate> clist) {
		this.clist = clist;
	}


	public void getAll()
	{
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			this.clist=cdao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
