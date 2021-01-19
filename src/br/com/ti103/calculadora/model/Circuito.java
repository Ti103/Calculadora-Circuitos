package br.com.ti103.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
	private double tensao;
	private double resistenciaEqv;
	private List<Resistor> resistores;
	private List<Resistor> associacoes;

	public Circuito(double tensao) {
		this.tensao = tensao;
		this.resistores = new ArrayList<Resistor>();
		this.associacoes = new ArrayList<Resistor>();
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
	
	public void setResistenciaEqv() {
		this.resistenciaEqv = this.associacoes.stream().mapToDouble(Resistor::getResistencia).sum();
	}

	public void setAssociacao(List<Resistor> resistores, String tipo) {
		this.resistores.addAll(resistores);
		setCircuitoResistor();
		this.associacoes.add(Associador.associar(resistores, tipo));
		setResistenciaEqv();
	}

	private void setCircuitoResistor() {
		this.resistores.forEach(r -> r.setCircuito(this));
	}

	@Override
	public String toString() {

		return "Dados do Circuito\n" + "\nTensão: " + getTensao() + "\nResistencia Equivalente: " + getResistenciaEqv()
				+ "\nCorrente: " + getCorrente() + "A" + "\n\nResistores\n" + resistores;
	}
}
