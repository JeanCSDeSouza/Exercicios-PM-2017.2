package br.com.pm.lista1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Divisores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long numero = 0;
		Divisores divisores = new Divisores();
		try {
		  numero = Long.parseLong(JOptionPane.showInputDialog("Digite um número a ser decomposto"));
		  JOptionPane.showMessageDialog(null, divisores.decompor(numero));
		}catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			Divisores.main(args);
		}catch(IllegalArgumentException iae) {
			iae.printStackTrace();
			Divisores.main(args);
		}
	}
	
	public List decompor(long numero) throws IllegalArgumentException {
		if(numero == 0)
			throw new IllegalArgumentException("Somente números maiores que zero são válidos");
		ArrayList<Integer> listaDeDivisores = new ArrayList<Integer>();
		for(int i = 1; i <= numero; i++) {
			if(numero % i == 0)
				listaDeDivisores.add(i); 
		}
		return listaDeDivisores;
	}
}