package ong.semear.controller.cadastros;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TesteCDI {
	
	@Inject
	private Teste calculadora;
	
	public double getPreco() {
		return calculadora.calcularPreco(12, 44.55);
	}

}
