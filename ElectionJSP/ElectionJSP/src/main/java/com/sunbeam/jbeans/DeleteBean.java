package com.sunbeam.jbeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteBean {
	private String id;
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

	public void deleteById()
	{
		int i=Integer.parseInt(id);
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			count=cdao.deleteById(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
