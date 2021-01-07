package br.com.ti103.calculadora.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.ti103.calculadora.model.Resistor;

public class TesteResistor {

	public static void main(String[] args) {
		String str = new DecimalFormat("##.00\u2126").format(123.43);
		List<Resistor> ress = new ArrayList<Resistor>();
		ress.add(new Resistor("ma", "az", "vm"));
		ress.add(new Resistor("az", "pr", "cz"));
		ress.add(new Resistor("am", "vd", "br"));
		ress.add(new Resistor("la", "rx", "az"));
		
		System.out.println(ress);
	}
}
