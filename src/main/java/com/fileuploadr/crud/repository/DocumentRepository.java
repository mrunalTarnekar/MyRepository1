package com.fileuploadr.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileuploadr.crud.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

	

}
