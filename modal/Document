package org.itc.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.Table;


@Entity
@Table(name="documents")
public class Document {

                private  int docId;
                private int id;
                private  String  docPath;
                
                 
                @Id
                @Column(name="docId")
                public int getDocId() {
                	return docId;
                }
                
                public void setDocId(int docId) {
                    this.docId = docId;
                }
                
                @Column(name="id")
                public int getId() {
					return id;
				}

				public void setId(int id) {
					this.id = id;
				}
                
                @Column(name="docPath")
                public String getDocPath() {
                    return docPath;
                }
                
                public void setDocPath(String docPath) {
                    this.docPath = docPath;
                }
                
                public Document(){
                	
                }
                
			
                
               /* public Document(int docId, int id, String docPath) {
                                super();
                                this.docId = docId;
                                this.docPath = docPath;
                                this.id = id;
                                
                }*/

				public Document(int id, String docPath) {
					this.id = id;
					 this.docPath = docPath;
					
				}
                
}

