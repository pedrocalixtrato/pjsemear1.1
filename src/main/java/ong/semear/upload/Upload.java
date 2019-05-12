package ong.semear.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@ManagedBean(name="upload")
@RequestScoped
public class Upload  {	
	
	public Upload() {
		
	}
	
			public void doUpload(FileUploadEvent fileUploadEvent) { 
		        UploadedFile uploadedFile = fileUploadEvent.getFile();  
		        String fileNameUploaded = uploadedFile.getFileName(); 
		        long fileSizeUploaded = uploadedFile.getSize(); 
		        String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded                     +"</b><br/>"+
		            "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>";
		        FacesContext facesContext = FacesContext.getCurrentInstance();
		        facesContext.addMessage(null, new FacesMessage("Sucesso",                                                                                 infoAboutFile));
		}

}
