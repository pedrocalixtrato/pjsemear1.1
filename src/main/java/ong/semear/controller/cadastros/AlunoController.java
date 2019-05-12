/*
* The MIT License
* 
* Copyright: Copyright (C) 2017 T2Ti.COM
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
* 
* The author may be contacted at: t2ti.com@gmail.com
*
* @author Claudio de Barros (T2Ti.com)
* 
 */
package ong.semear.controller.cadastros;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.hibernate.Session;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;



import ong.semear.controller.AbstractController;
import ong.semear.model.bean.cadastros.Aluno;
import ong.semear.model.bean.cadastros.Imagem;
import ong.semear.model.dao.T2TiEntityManagerFactory;
import ong.semear.util.AmazonS3FileUpload;
import ong.semear.util.FacesContextUtil;
import ong.semear.util.FacesUtil;
import ong.semear.util.report.ExecutorRelatorio;

@ManagedBean
@ViewScoped
public class AlunoController extends AbstractController<Aluno> implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesContext facesContext;
	private HttpServletResponse response;
	private EntityManager manager;
	private Aluno aluno;
	private Imagem imagem;
	private Imagem imagemSelecionada;
	private List<Imagem> imagens;

	@Override
	public Class<Aluno> getClazz() {
		return Aluno.class;
	}

	@Override
	public String getFuncaoBase() {
		return "Aluno";
	}
	
	@PostConstruct
    @Override
    public void init() {
		 super.init();
		 dataModel = new AlunoDataModel();
	     dataModel.setClazz(getClazz());
	     dataModel.setDao(dao);
	}

	@Override
	public void incluir() {
		super.incluir();
		aluno = new Aluno();
		aluno.setDataMatricula(new Date());

	}
	

	public void emitir() {

		Map<String, Object> parametros = new HashMap<>();
		try {
			manager = T2TiEntityManagerFactory.createEntityManager();
			facesContext = FacesContext.getCurrentInstance();
			response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

			ImageIcon gto = new ImageIcon(getClass().getResource("/relatorios/Semear.png"));

			parametros.put("pic", gto.getImage());

			parametros.put("id_aluno", getObjetoSelecionado().getId());

			ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/CadastroAluno.jasper", this.response,
					parametros, getObjetoSelecionado().getNome() + ".pdf");

			Session session = manager.unwrap(Session.class);
			session.doWork(executor);

			if (executor.isRelatorioGerado()) {
				facesContext.responseComplete();
			} else {
				FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
		public void uploadImagem(FileUploadEvent event) {
	        try {
	            if (getObjeto().getId() == null) {
	                throw new Exception("Necessário salvar o produto antes de realizar o upload");
	            }
	
	            UploadedFile arquivo = event.getFile();
	            
	            File diretorio = new File("C://imagens//" + getObjeto().getCpf() + "//"); // ajfilho é uma pasta!
	            if (!diretorio.exists()) {
	               diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
	            } else {
	               System.out.println("Diretório já existente");
	            }
	            imagem = new Imagem();	            
	            
	            getObjeto().getListaImagem().add(imagem);
	            String localArquivo = "C://imagens//" + getObjeto().getCpf() + "//" + event.getFile().getFileName(); 
	            			           //+ arquivo.getFileName().substring(arquivo.getFileName().lastIndexOf("."));
	           
	             imagem.setCaminho("/images/" + event.getFile().getFileName());
	             //.substring(arquivo.getFileName().indexOf("."))  
	             //+ arquivo.getFileName().substring(arquivo.getFileName().lastIndexOf(".")));
	             
	            imagem.setAluno(getObjetoSelecionado());
	            Files.copy(arquivo.getInputstream(), Paths.get(new File(localArquivo).toURI()), StandardCopyOption.REPLACE_EXISTING);	            
	            
	            
	        } catch (Exception e) {
	            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao realizar o upload do arquivo!", e.getMessage());
	            e.printStackTrace();
	        }
	    }
	 
	 public void salvarImagem() {
	    	try{	       
	        if (getObjeto().getId() == null) {
	           // getObjeto().getListaImagem().add(imagem);
	            salvar();
	        }
	        salvar("Imagem salva com sucesso!");
	       
	    	}catch(RuntimeException e){
	    		e.printStackTrace();
	    	}
	    }
	 
	 @Override
	 public void salvar(){
		 try{
		 
		 super.salvar("Salvo com sucesso!");
		 //voltar();
		 }catch(Exception e){
			 
			 e.printStackTrace();
		 }
	 }
	 
		 	public void enviaImagem(FileUploadEvent event) {
				String linkDaImagem = "";
					try {
			                  linkDaImagem = AmazonS3FileUpload.uploadFoto(event);
			                  
			                  
			                  imagem = new Imagem();			                  
			                  imagem.setCaminho(linkDaImagem);
			                  /*Verifica se é um novo cliente*/
			                 if(getObjeto().getListaImagem() == null){			                	 
			                	 getObjeto().setListaImagem(new HashSet<Imagem>());			                	 
			                 }		                	 
			                	
			                	imagem.setAluno(getObjeto());			                	
			                	getObjeto().getListaImagem().add(imagem);
			                	
			                  System.out.println(linkDaImagem);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
		 	
		 	public void alterarImagem() {
		        imagem = imagemSelecionada;
		    }
			
		 	
		 	public void excluirImagem() {
		        if (imagemSelecionada == null || imagemSelecionada.getId() == null) {
		            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, "Nenhum registro selecionado!", null);
		        } else {
		            getObjetoSelecionado().getListaImagem().remove(imagemSelecionada);
		            salvar("Contato excluído com sucesso!");
		        }
		    }
	
	
	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Imagem getImagemSelecionada() {
		return imagemSelecionada;
	}

	public void setImagemSelecionada(Imagem imagemSelecionada) {
		this.imagemSelecionada = imagemSelecionada;
	}
	
	
	

}
