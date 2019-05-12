package ong.semear.util;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ong.semear.model.bean.cadastros.Cargo;
import ong.semear.model.dao.T2TiEntityManagerFactory;
@Singleton
@Startup
public class UtilitarioBean implements Serializable{
		

	private static final long serialVersionUID = 1L;
	private boolean autoCommit = true;
	protected EntityManager em;
	
	@PostConstruct
	public void consultar() {
			
				new Thread(){
					public void run(){
						while(0==0){
							try {						
								
								System.out.println("----------------continuar---------------------");
								listaBeans2();
								System.out.println("----------------resultado da query---------------------");
								sleep(4680000);//Para por 10 segundo
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}.start();
			}
	
	
	public List<Cargo> listaBeans2() throws Exception {
        try {
            abrirConexao();            
            String jpql = "SELECT o FROM Cargo o WHERE 0 = 1";
            Query query = em.createQuery(jpql);
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (isAutoCommit()) {
                fecharConexao();
            }
        }
    }
	
	
	
	private EntityManager abrirConexao() throws Exception {
        if (em == null || !em.isOpen()) {
            em = T2TiEntityManagerFactory.createEntityManager();
            em.getTransaction().begin();
        }
        return em;
    }

    public void fecharConexao() throws Exception {
        if (em != null && em.isOpen()) {
            try {
                if (em.getTransaction() != null && em.getTransaction().isActive()) {
                    if (em.getTransaction().getRollbackOnly()) {
                        em.getTransaction().rollback();
                    } else {
                        em.getTransaction().commit();
                    }
                }
            } catch (Exception e) {
                if (em.getTransaction() != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            } finally {
                em.close();
            }
        }
    }

	
	

	
    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

	
}
