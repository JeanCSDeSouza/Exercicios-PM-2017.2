package br.com.pm.lista1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangulo{
	private Set<Double> ladosTriangulo;
	private String tipo;
	public enum tipoTriangulo{
		NAO_EH_TRIANGULO("Isto não é um triângulo"), EQUILATERO("Equilátero"),
		ISOSCELES("Isósceles"), ESCALENO("Escaleno");
		
		public String value;
		tipoTriangulo(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	/**
	 * constrói um triângulo a partir de três valore reais passados e 
	 * testa para saber qual o seu tipo : Equilatero, Isosceles, Escaleno.
	 *  
	 * @param lado1 número real maior que zero
	 * @param lado2 número real maior que zero
	 * @param lado3 número real maior que zero
	 * @exception Throws IllegalArgumentException caso não seja um triangulo
	 */
	public Triangulo(Double lado1, Double lado2, Double lado3) throws IllegalArgumentException{
		if(ehTriangulo(lado1, lado2, lado3)) {
			ladosTriangulo = new HashSet<Double>(3);
			ladosTriangulo.add(lado1);
			ladosTriangulo.add(lado2);
			ladosTriangulo.add(lado3);
			String tipo = testaTipoTriangulo(ladosTriangulo); 
			if(tipo.equals(tipoTriangulo.NAO_EH_TRIANGULO.getValue()))
				throw new IllegalArgumentException(tipoTriangulo.NAO_EH_TRIANGULO.getValue());
			else
				this.tipo = tipo; 
		}else
			throw new IllegalArgumentException(tipoTriangulo.NAO_EH_TRIANGULO.getValue());

	}
	/**
	 * Testa se os valores passados são um triangulo testanto se
	 * a soma de dois lados é maior do que o tamanho do terceiro. 
	 * @return boolean indicando se é triangulo ou não.
	 */
	public boolean ehTriangulo(Double lado1, Double lado2, Double lado3){
		if(((lado1 + lado2) > lado3)&&((lado1 + lado3) > lado2)&&((lado2 + lado3) > lado1))
			return true;
		else 
			return false;
	}
	/**
	 * Testa o tipo de um triangulo dada a quantidade de valores no hashset passado
	 * @param ladosTriangulo hashset contendo 1 a 3 valores
	 * @return tipo do triangulo: Equilatero, Isosceles ou Escaleno
	 * @exception Throws IllegalArgumentException caso o HashSet tenha 0 ou mais de 3 
	 * valores
	 */
	public String testaTipoTriangulo(Set<Double> ladosTriangulo) {
		if((ladosTriangulo.size() == 0)||(ladosTriangulo.size() > 3))
			throw new IllegalArgumentException(tipoTriangulo.NAO_EH_TRIANGULO.getValue());
		switch (ladosTriangulo.size()) {
			case 1: return tipoTriangulo.EQUILATERO.getValue();
			case 2: return tipoTriangulo.ISOSCELES.getValue();
			case 3: return tipoTriangulo.ESCALENO.getValue();
		}
		return tipoTriangulo.NAO_EH_TRIANGULO.getValue();
	}
	public String getTipo() {
		return tipo;
	}
}
