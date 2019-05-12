package ong.semear.model.dao.cadastros;



import java.util.List;

import javax.ejb.Local;

import ong.semear.model.bean.cadastros.PapelFuncao;
import ong.semear.model.bean.cadastros.Usuario;

@Local
public interface UsuarioDAO {
	Usuario getUsuario(String login, String senha) throws Exception;
	
	Usuario getUsuario(String login) throws Exception;

	List<PapelFuncao> getPapelFuncao(Usuario usuario) throws Exception;
}
