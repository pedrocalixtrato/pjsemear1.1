package ong.semear.controller.cadastros;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;



import ong.semear.controller.T2TiLazyDataModel;
import ong.semear.model.bean.cadastros.Aluno;




public class AlunoDataModel extends T2TiLazyDataModel<Aluno> {
	
	
	 private static final long serialVersionUID = 1L;

	    @Override
	    public List<Aluno> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
	        try {
	            String globalFilter = (String) filters.get("globalFilter");

	            if (globalFilter != null) {
	                filters.clear();

	                filters.put("nome", globalFilter);
	                filters.put("nome_pai", globalFilter);
	                filters.put("nome_mae", globalFilter);
	                filters.put("nmatricula", globalFilter);
	                filters.put("rg_numero", globalFilter);
	                filters.put("cpf", globalFilter);
	                filters.put("nis_aluno", globalFilter);
	                filters.put("rg_pai", globalFilter);
	                filters.put("rg_mae", globalFilter);
	                filters.put("cpf_pai", globalFilter);
	                filters.put("cpf_mae", globalFilter);

//	                try {
//	                    BigDecimal valorAPagar = BigDecimal.valueOf(Double.valueOf(globalFilter.replace(",", ".")));
//	                    filters.put("valorAPagar", valorAPagar);
//	                } catch (Exception e) {
	                    //
	                //}
	                try {
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                    Date filtroData = dateFormat.parse(globalFilter);
	                    filters.put("dataNascimento", filtroData);
	                } catch (Exception e) {
	                    //
	                }
	            }

	            List<Aluno> beans = getDao().getBeans(first, pageSize, sortField, sortOrder, filters, "OR");
	            Long totalRegistros = getDao().getTotalRegistros(filters, "OR");
	            this.setRowCount(totalRegistros.intValue());
	            return beans;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return new ArrayList<>();
	    }

}
