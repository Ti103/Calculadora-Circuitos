package br.com.ti103.calculadora.model;

import java.util.List;

public class Circuito {
	private double tensao;
	private double corrente;
	private double resistenciaEqv;
	private List<Resistor> resistores;

	public Circuito(double tensao) {
		this.tensao = tensao;
	}

	public double getTensao() {
		return tensao;
	}

	public void setTensao(double tensao) {
		this.tensao = tensao;
	}

	public double getCorrente() {
		return tensao / resistenciaEqv;
	}

	public double getResistenciaEqv() {
		return resistenciaEqv;
	}

	public void serie(List<Resistor> resistores) {
		double total = 0;
		
		for (Resistor resistor : resistores) {
			total += resistor.getResistencia();
			resistor.setCircuito(this);
		}
		this.resistenciaEqv = total;
		this.resistores = resistores;
//		return this;
	}

	@Override
	public String toString() {
		
		return "Dados do Circuito\n"
				+ "\nTensão: " + getTensao() 
				+ "\nResistencia Equivalente: " + getResistenciaEqv()
				+ "\nCorrente: " + getCorrente() + "A"
				+ "\n\nResistores\n" + resistores;
	}
}
