package br.com.pm.lista1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangulo{
	private Set<Integer> ladosTriangulo;
	private String tipo;
	private static final String NAO_EH_TRIANGULO = "Isto não é um triângulo"; 
	private static final String EQUILATERO = "Equilátero";
	private static final String ISOSCELES = "Isósceles";
	private static final String ESCALENO = "Escaleno";
	private static final String RETANGULO = "Retângulo";
	
	/**
	 * 
	 * @param lado1 inteiro maior que zero
	 * @param lado2 inteiro maior que zero
	 * @param lado3 inteiro maior que zero
	 * 
	 * constrói um triângulo a partir de três valore inteiros passados e 
	 * testa para saber qual o seu tipo : Equilatero, Isosceles, Escaleno ou
	 * Retangulo.
	 *  
	 */
	public Triangulo(int lado1, int lado2, int lado3) {
		if((lado1 <= 0)||(lado2 <=0)||(lado3)<=0)
			throw new IllegalArgumentException("lados do triangulo devem ser maiores do que zero");
		if(ehTriangulo(lado1, lado2, lado3)) {
			HashSet<Integer> ladosTriangulo = new HashSet<Integer>();
			ladosTriangulo.add(lado1);
			ladosTriangulo.add(lado2);
			ladosTriangulo.add(lado3);
			this.ladosTriangulo = ladosTriangulo;
			if(equilatero())
				tipo = EQUILATERO;
			else {
				if(isosceles())
					tipo = ISOSCELES;
				else {
					if(escaleno() & trianguloRetangulo())
						tipo = RETANGULO;
					else
						tipo = ESCALENO;
				}	
			}	
		}else{
			tipo = NAO_EH_TRIANGULO;
		}
 	}
	/**
	 * Testa se os valores passados são um triangulo testanto se
	 * a soma de dois lados é maior do que o tamanho do terceiro. 
	 * @return boolean indicando se é triangulo ou não.
	 */
	private boolean ehTriangulo(int lado1, int lado2, int lado3){
		if(((lado1 + lado2) > lado3)&&((lado1 + lado3) > lado2)&&((lado2 + lado3) > lado1))
			return true;
		else 
			return false;
	}
	/**
	 * Utilizando HashSet testa se o triângulo é equilátero.
	 * Se os valores passados pro construtor forem todos iguais,
	 * o método size de HashSet retornará 1, indicando um triângulo
	 * equilátero. 
	 * @return boolean indicando se é equilatero ou não 
	 */
	private boolean equilatero(){
		if(ladosTriangulo.size() == 1)
			return true;
		else 
			return false;
	}
	/**
	 * Utilizando HashSet testa se o triângulo é isosceles
	 * Se os valores passados pro construtor tiverem dois 
	 * iguais, o método size de HashSet retornará 2, indicando um 
	 * triângulo isósceles
	 * @return boolean indicando se é isósceles ou não
	 */ 
	private boolean isosceles(){
		if(ladosTriangulo.size() == 2)
			return true;
		else
			return false;
	}
	/**
	 * Utilizando HashSet testa se o triângulo é escaleno
	 * Se os valores passados pro construtor não tiver nenhum valor 
	 * igual, o método size de HashSet retornará 3, indicando um 
	 * triângulo escaleno.
	 * @return boolean indicando se é escaleno ou não
	 */ 
	private boolean escaleno() {
		if(ladosTriangulo.size() == 3)
			return true;
		else
			return false;
	}
	/**
	 * Testa se o triângulo é retangulo isando pitágoras 
	 * e testando antes se ele é escaleno.
	 * @return boolean indicando se é retângulo ou não
	 */
	private boolean trianguloRetangulo(){
		if(escaleno()) {
			List<Integer> ladosOrdenados = new ArrayList<Integer>(ladosTriangulo);
			Collections.sort(ladosOrdenados);
			int catetoA = ladosOrdenados.get(0);
			int catetoB = ladosOrdenados.get(1);
			int hipotenusa = ladosOrdenados.get(2);
			if(((catetoA*catetoA) + (catetoB*catetoB)) == (hipotenusa*hipotenusa)) {
				return true;
			}
		}
		return false;
	}
	public String getTipo() {
		return tipo;
	}
}
