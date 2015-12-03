package org.itc.dao;

import java.util.List;

import org.itc.model.Document;

public interface DocumentDao {
	
	public void addItem(Document doc);
    
    public List<Document> getDoc(int id);


}
