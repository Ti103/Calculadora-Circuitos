package br.com.ti103.calculadora.test;

import java.util.ArrayList;
import java.util.List;

import br.com.ti103.calculadora.model.Circuito;
import br.com.ti103.calculadora.model.Resistor;

public class TesteCircuito {

	public static void main(String[] args) {
		Circuito circuito = new Circuito(12);
		
		List<Resistor> resistores = new ArrayList<Resistor>() ;
		resistores.add(new Resistor("vm", "az", "ma"));
		resistores.add(new Resistor("am", "pt", "ma", "dr"));
		
		circuito.setAssociacao(resistores, "SERIe");
		resistores.clear();
		
		resistores.add(new Resistor("vm", "az", "ma"));
		resistores.add(new Resistor("az", "pt", "ma", "dr"));
		resistores.add(new Resistor("vd", "az", "ma"));
		resistores.add(new Resistor("az", "pt", "ma", "dr"));
		
		circuito.setAssociacao(resistores, "paralelo");
		resistores.clear();
		
		System.out.println(circuito);
		

	}

}
