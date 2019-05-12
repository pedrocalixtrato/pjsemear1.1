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
package ong.semear.controller;

import ong.semear.model.dao.DaoGenerico;
import ong.semear.util.FacesContextUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

public abstract class AbstractController<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    protected T2TiLazyDataModel<T> dataModel;
    private T objetoSelecionado;
    private T objeto;
    private boolean telaGrid = true;

    protected DaoGenerico<T> dao;
    
    private Map<String, String> simNao;

    @PostConstruct
    public void init() {
        dao = new DaoGenerico<>(getClazz());
        dataModel = new T2TiLazyDataModel<>();
        dataModel.setClazz(getClazz());
        dataModel.setDao(dao);
        
        simNao = new LinkedHashMap<>();
        simNao.put("Sim", "S");
        simNao.put("Não", "N");
    }

    public abstract Class<T> getClazz();

    public abstract String getFuncaoBase();

    public T2TiLazyDataModel<T> getDataModel() {
        return dataModel;
    }

    public void incluir() {
        try {
            objeto = (T) getClazz().newInstance();
            telaGrid = false;
        } catch (InstantiationException | IllegalAccessException e) {
            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao iniciar a inclusão do registro!", e.getMessage());
        }
    }

    public void alterar() {
        objeto = objetoSelecionado;
        telaGrid = false;
    }

    public void salvar() {
        salvar(null);
    }

    public void salvar(String mensagem) {
        try {
            objeto = dao.merge(objeto);
            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, mensagem != null ? mensagem : "Registro salvo com sucesso!", null);
        } catch (Exception e) {
            e.printStackTrace();
            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao salvar o registro!", e.getMessage());
        }
    }

    public void excluir() {
        try {
            Integer idObjeto = null;
            if (objetoSelecionado != null) {
                idObjeto = (Integer) getClazz().getMethod("getId").invoke(objetoSelecionado);
            }
            if (objetoSelecionado == null || idObjeto == null) {
                FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, "Nenhum registro selecionado!", null);
            } else {
                dao.excluir(objetoSelecionado, idObjeto);
                FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso!", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContextUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao excluir o registro!", e.getMessage());
        }
    }

    public void voltar() {
        telaGrid = true;
    }

    public boolean isTelaGrid() {
        return telaGrid;
    }

    public boolean podeConsultar() {
        return FacesContextUtil.isUserInRole(getFuncaoBase() + "_CONSULTA") || FacesContextUtil.isUserInRole("ADMIN");
    }

    public boolean podeInserir() {
        return FacesContextUtil.isUserInRole(getFuncaoBase() + "_INSERE") || FacesContextUtil.isUserInRole("ADMIN");
    }

    public boolean podeAlterar() {
        return FacesContextUtil.isUserInRole(getFuncaoBase() + "_ALTERA") || FacesContextUtil.isUserInRole("ADMIN");
    }

    public boolean podeExcluir() {
        return FacesContextUtil.isUserInRole(getFuncaoBase() + "_EXCLUI") || FacesContextUtil.isUserInRole("ADMIN");
    }

    public T getObjetoSelecionado() {
        return objetoSelecionado;
    }

    public void setObjetoSelecionado(T objetoSelecionado) {
        this.objetoSelecionado = objetoSelecionado;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
    
    public Map<String, String> getSimNao() {
        return simNao;
    }

}
