/*
package com.rest.consultorio.storage;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Tag;

@Component
public class S3 {
	
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public String salvarTemporariamente(MultipartFile arquivo) {
		AccessControlList acl = new AccessControlList();
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		
		ObjectMetadata omd = new ObjectMetadata();
		omd.setContentType(arquivo.getContentType());
		omd.setContentLength(arquivo.getSize());
		
		String nomeUnico = gerarNomeUnico(arquivo.getOriginalFilename());
		
		try {
		
		PutObjectRequest por = new PutObjectRequest(
				"bucketnamenamebucket", nomeUnico, 
				arquivo.getInputStream(), omd
				).withAccessControlList(acl);
		
		por.setTagging(new ObjectTagging(Arrays.asList(new Tag("experirar", "true"))));
		
		amazonS3.putObject(por);
		
		
	}catch(IOException e) {
		
		e.printStackTrace();
	}
		return nomeUnico;

}

		
		
	private String gerarNomeUnico(String originalFilename) {
		return UUID.randomUUID().toString() + "_" + originalFilename;
	}

}
*/
