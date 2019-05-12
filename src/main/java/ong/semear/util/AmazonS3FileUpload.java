package ong.semear.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.primefaces.event.FileUploadEvent;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class AmazonS3FileUpload {
	private static AmazonS3 s3;
	private final static String S3WAWSURL = "https://s3-sa-east-1.amazonaws.com/%s/%s";
	private final static String S3_BUCKETNAME="projetosemear"; 
	static{
		InputStream credentials = AmazonS3FileUpload.class.getClassLoader().getResourceAsStream("AwsCredentials.properties");
		PropertiesCredentials awsCredentials = null;
		if(credentials == null)
			try {
				awsCredentials = new PropertiesCredentials(credentials);
			} catch (IOException e) {
				e.printStackTrace();
			}
		s3 = new AmazonS3Client(awsCredentials);
	}
	public static String uploadFoto(FileUploadEvent event) throws IOException{
		Date fileName = new Date();
		//String fileName = URLEncoder.encode(event.getFile().getFileName(),"UTF-8");
		PutObjectRequest request = new PutObjectRequest(S3_BUCKETNAME, fileName.toString(), event.getFile().getInputstream(), getMetaData(event));
		s3.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
		return new URL(String.format(S3WAWSURL,S3_BUCKETNAME,fileName)).toExternalForm(); 
	}
	private static ObjectMetadata getMetaData(FileUploadEvent event){
		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(event.getFile().getSize());
		metaData.setContentType(event.getFile().getContentType());
		return metaData;
	}
}