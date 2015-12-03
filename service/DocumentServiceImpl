package org.itc.service;

import java.util.List;

import org.itc.dao.DocumentDao;
import org.itc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentServiceImpl  implements DocumentService {
    
    @Autowired
    private DocumentDao documentDao;
    
    @Transactional
    public void addItem(Document doc) {  
      documentDao.addItem(doc);  
      
    }
    
    public List<Document> getDoc(int id){
    return documentDao.getDoc(id);
    }
    
}

