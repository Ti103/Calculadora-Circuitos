package br.com.ti103.calculadora.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resistor {
	private static int numeroInstancia = 1;
	private String nome;
	private double resistencia;
	private double tolerancia;
	private List<String> cores;
	private TabelaCores tabela;
	private Circuito circuito;

	public Resistor(double resistencia, double tolerancia) {
		this.resistencia = resistencia;
		this.tolerancia = tolerancia;
		this.nome = "R" + numeroInstancia;
		numeroInstancia++;
	}

	public Resistor(String... cores) {
		this.cores = new ArrayList<String>(Arrays.asList(cores));
		if (getCores().size() == 3) {
			getCores().add("");
		}
		this.tabela = new TabelaCores(this.cores);
		this.resistencia = tabela.getResistencia();
		this.tolerancia = tabela.getTolerancia();
		this.nome = "R" + numeroInstancia;
		numeroInstancia++;
	}

	public double getResistencia() {
		return resistencia;
	}

	public double getTolerancia() {
		return tolerancia;
	}

	public List<String> getCores() {
		return cores;
	}
	public String getNome() {
		return nome;
	}

	public double getResistenciaMinima() {
		return getResistencia() * (1 - getTolerancia());
	}

	public double getResistenciaMaxima() {
		return getResistencia() * (1 + getTolerancia());
	}

	public double getQuedaDeTensao() {
		return circuito.getCorrente() * getResistencia();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##.00\u2126");
		String str = "";
		str += "\nNome: " + getNome();
		str += "\nCores: " + tabela.toString();
		str += "\nResistencia: " + df.format(getResistencia());
		str += "\nQueda de Tensao: " + getQuedaDeTensao();
		str += "\nRange de Resistencia: " + df.format(getResistenciaMinima()) + " -> " + df.format(getResistenciaMaxima());
		str += "\n";
		return str;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

}
