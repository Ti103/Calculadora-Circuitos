package br.com.ti103.calculadora.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Resistor {
	private static int numeroResistor = 1;
	private static int numeroAssociacao = 65;
	private double resistencia;
	private double tolerancia;
	private String nome;
	private List<String> cores;
	private TabelaCores tabela;
	private Circuito circuito;

	public Resistor(double resistencia, double tolerancia) {
		this.resistencia = resistencia;
		this.tolerancia = tolerancia;
		this.nome = "R" + numeroResistor;
		numeroResistor++;
	}
	
	public Resistor(Double resistencia, double tolerancia) {
		this(resistencia.doubleValue(), tolerancia);
		this.nome = "R" + String.valueOf(Character.toChars(numeroAssociacao));
		numeroResistor--;
	}

	public Resistor(String... cores) {
		this.cores = new ArrayList<String>(Arrays.asList(cores));
		
		if (this.cores.size() == 3) {
			this.cores.add("");
		}
		this.tabela = new TabelaCores(this.cores);
		this.resistencia = tabela.getResistencia();
		this.tolerancia = tabela.getTolerancia();
		this.nome = "R" + numeroResistor;
		numeroResistor++;
	}

	public double getResistencia() {
		return resistencia;
	}

	public double getTolerancia() {
		return tolerancia;
	}

	public List<String> getCores() {
		return Collections.unmodifiableList(cores);
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
	
	public double getCorrente() {
		return circuito.getCorrente();
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##.00\u2126");
		String str = "";
		str += "\nNome: " + getNome();
		str += "\nCores: " + tabela.toString();
		str += "\nResistencia: " + df.format(getResistencia());
		str += "\nQueda de Tensao: " + getQuedaDeTensao();
		str += "\nRange de Resistencia: " + df.format(getResistenciaMinima()) + " -> "
				+ df.format(getResistenciaMaxima());
		str += "\n";
		return str;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

}
