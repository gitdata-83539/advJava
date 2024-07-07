package com.sunbeam.jbeans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandBeans {
	
	private List<Candidate> c;

	public List<Candidate> getC() {
		return c;
	}

	public void setC(List<Candidate> c) {
		this.c = c;
	}
	
	public void getAll()
	{
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			this.c=cdao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
