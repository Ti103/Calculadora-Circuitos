package br.com.ti103.calculadora.model;

import java.util.List;

public class Associador {
	
	public static Resistor associar(List<Resistor> resistores, String tipo) {
		double tol = resistores.stream().mapToDouble(Resistor::getResistencia).average().getAsDouble();
		
		if(tipo.toLowerCase().equals("serie")) {
			Double res = resistores.stream().mapToDouble(Resistor::getResistencia).sum();
			
			return new Resistor(res, tol);
		}else {
			Double res = 1/resistores.stream().mapToDouble(r -> 1 / r.getResistencia()).sum();
			
			return new Resistor(res, tol);
		}
	}
}
