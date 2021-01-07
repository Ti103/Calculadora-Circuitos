package br.com.ti103.calculadora.test;

import java.util.ArrayList;
import java.util.List;

import br.com.ti103.calculadora.model.Circuito;
import br.com.ti103.calculadora.model.Resistor;

public class TesteCircuito {

	public static void main(String[] args) {
		List<Resistor> ress = new ArrayList<Resistor>();
		ress.add(new Resistor("ma", "az", "vm"));
		ress.add(new Resistor("ma", "az", "vm"));
		ress.add(new Resistor("ma", "az", "vm"));
		
		Circuito circuito = new Circuito(12);
		circuito.serie(ress);
		System.out.println(circuito);

	}

}
