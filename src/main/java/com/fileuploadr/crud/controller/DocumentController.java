package com.fileuploadr.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fileuploadr.crud.model.Document;
import com.fileuploadr.crud.service.DocumentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService ds;
	
	@RequestMapping(value="/adddoc",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addDoc(
			@RequestPart(required = true,value="address_proof") MultipartFile file1,
			@RequestPart(required = true,value="photo") MultipartFile file2,
			@RequestPart(required = true,value="signature") MultipartFile file3,
			@RequestPart(required = true,value="thumb") MultipartFile file4,
			@RequestPart("doc") String doc
			) throws IOException
	{
		
		Document d=new Document();
		d.setAddress_proof(file1.getBytes());
		d.setPhoto(file2.getBytes());
		d.setSignature(file3.getBytes());
		d.setThumb(file4.getBytes());
		
		ObjectMapper mapper= new ObjectMapper();
		Document d1=mapper.readValue(doc, Document.class);
		
		d.setCustomer_id(d1.getCustomer_id());
		
		Document document=ds.SaveDoc(d);
		
		return "Added";
	}

	@GetMapping("/getDoc")
	public List<Document> getDoc()
	{
		List<Document> dlist=ds.getDoc();
		return dlist;
	}
}
