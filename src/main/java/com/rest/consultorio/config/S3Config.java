/*
package com.rest.consultorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;

@Configuration
public class S3Config {
	
	@Bean
	public AmazonS3 amazonS3() {
		AWSCredentials crendentials = new BasicAWSCredentials("AKIAJUNJKSIX2MTXERAA", "vmIfb1BQE8XccdHJ1ryKlnqHwzZ8bFLAOyeCwdtt");
		
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(crendentials))
				.withRegion(Regions.US_WEST_2)
				.build();
		
		
		//CRIAÇÃO DO BUCKET
		if(!amazonS3.doesBucketExistV2("bucketnamenamebucket")) {
			amazonS3.createBucket(new CreateBucketRequest("bucketnamenamebucket"));
			
			BucketLifecycleConfiguration.Rule regraExpiracao = 
					new BucketLifecycleConfiguration.Rule()
					.withId("Regra de expiração de arquivos temporarios")
					.withFilter(new LifecycleFilter(new LifecycleTagPredicate(new Tag("expirar", "true"))))
					.withExpirationInDays(1)
					.withStatus(BucketLifecycleConfiguration.ENABLED);
			
			BucketLifecycleConfiguration config = new BucketLifecycleConfiguration()
					.withRules(regraExpiracao);
			amazonS3.setBucketLifecycleConfiguration("bucketnamenamebucket", config);
		}
		
		
		return amazonS3;
	}
	
	
	
	

}
*/