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

import ong.semear.controller.AbstractController;
import ong.semear.model.bean.cadastros.Cargo;
import ong.semear.model.bean.cadastros.Imagem;
import ong.semear.util.FacesContextUtil;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ImagemController extends AbstractController<Imagem> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Class<Imagem> getClazz() {
        return Imagem.class;
    }

    @Override
    public String getFuncaoBase() {
        return "IMAGEM";
    }

    @Override
    public void incluir() {
        super.incluir();
        
        
    }

}
