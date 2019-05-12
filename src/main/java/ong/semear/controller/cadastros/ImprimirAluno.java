//package ong.semear.controller.cadastros;
//
//import java.awt.Image;
//import java.io.InputStream;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.persistence.EntityManager;
//import javax.servlet.http.HttpServletResponse;
//import javax.swing.ImageIcon;
//
//import org.hibernate.Session;
//
//import ong.semear.model.dao.T2TiEntityManagerFactory;
//import ong.semear.util.FacesUtil;
//import ong.semear.util.report.ExecutorRelatorio;
//@ManagedBean
//@ViewScoped
//public class ImprimirAluno implements Serializable {
//	
//	
//	private static final long serialVersionUID = 1L;
//	
//
//	
//	private FacesContext facesContext;
//
//	private HttpServletResponse response;
//	private String caminhoLogo;
//	
//
//	
//	private EntityManager manager;
//
//	public void emitir() {
//		Map<String, Object> parametros = new HashMap<>();		
//		try {
//			manager = T2TiEntityManagerFactory.createEntityManager();
//			facesContext = FacesContext.getCurrentInstance();
//			response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//			
//			ImageIcon gto = new ImageIcon(getClass().getResource("/relatorios/Semear.png"));			
//					
//		    parametros.put("pic", gto.getImage());
//		    
//			parametros.put("id_aluno", 2);
//			
//		
//		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/CadastroAluno.jasper",
//				this.response, parametros, "Pedidos emitidos.pdf");
//		
//		Session session = manager.unwrap(Session.class);
//		session.doWork(executor);
//		
//		if (executor.isRelatorioGerado()) {
//			facesContext.responseComplete();
//		} else {
//			FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
//		}
//	}
//
//	catch (Exception e) {
//		
//		e.printStackTrace();
//	}
//	}
//
//	
//	
//	
//
//}
