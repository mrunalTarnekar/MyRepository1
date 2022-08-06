package com.fileuploadr.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fileuploadr.crud.model.Document;
import com.fileuploadr.crud.repository.DocumentRepository;
import com.fileuploadr.crud.service.DocumentService;

@Service
public class DocumentServiceimpl implements DocumentService{
	@Autowired
	DocumentRepository dr;

	@Override
	public Document SaveDoc(Document d) {
		
		return  dr.save(d);
	}

	@Override
	public List<Document> getDoc() {
		
		return dr.findAll();
	}

}
