package br.com.ti103.calculadora.model;

import java.util.Arrays;
import java.util.List;

public class TabelaCores implements Cores {

	private List<String> cores;

	public TabelaCores(List<String> cores) {
		this.cores = cores;
	}

	public double getTolerancia() {
		if (cores.get(cores.size()-1).isEmpty())
			return 0.2;			
		else 
			return TOLERANCIA_VALORES[getTolIndex(cores.get(cores.size() - 1))];
	}

	public double getResistencia() {
		double expoente;
		if (RESISTENCIA.contains(cores.get(cores.size()-2))) {
			expoente = getResIndex(cores.get(cores.size()-2));
		} else {
			expoente = (cores.get(2).compareTo("pt") < 0) ? -1 : -2;
		}
		double multiplicador = Math.pow(10, expoente);
		
		int soma = 0;
		for(int i = cores.size()-3, mult = 1; i >= 0; i--, mult *= 10) {
			soma += getResIndex(cores.get(i)) * mult;
		}

		return soma * multiplicador;
	}

	public int getResIndex(String cor) {
		return RESISTENCIA.indexOf(cor) / 2;
	}

	public int getTolIndex(String cor) {
		return TOLERANCIA.indexOf(cor) / 2;
	}

	@Override
	public String toString() {
		List<String> nomesList = Arrays.asList(CORES);
		String str = "";
		
		if(cores.get(3).isEmpty()) {
			cores.remove(3);
		}
		
		for (String cor : cores) {
			str += "\n" + nomesList.get(getResIndex(cor));
		}
		return str;
	}

}
