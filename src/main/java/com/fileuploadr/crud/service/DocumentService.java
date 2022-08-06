package com.fileuploadr.crud.service;

import java.util.List;

import com.fileuploadr.crud.model.Document;

public interface DocumentService {

	Document SaveDoc(Document d);

	List<Document> getDoc();

}
