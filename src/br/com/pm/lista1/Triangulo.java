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
	private static final String NAO_EH_TRIANGULO = "Isto n�o � um tri�ngulo"; 
	private static final String EQUILATERO = "Equil�tero";
	private static final String ISOSCELES = "Is�sceles";
	private static final String ESCALENO = "Escaleno";
	private static final String RETANGULO = "Ret�ngulo";
	
	/**
	 * 
	 * @param lado1 inteiro maior que zero
	 * @param lado2 inteiro maior que zero
	 * @param lado3 inteiro maior que zero
	 * 
	 * constr�i um tri�ngulo a partir de tr�s valore inteiros passados e 
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
	 * Testa se os valores passados s�o um triangulo testanto se
	 * a soma de dois lados � maior do que o tamanho do terceiro. 
	 * @return boolean indicando se � triangulo ou n�o.
	 */
	private boolean ehTriangulo(int lado1, int lado2, int lado3){
		if(((lado1 + lado2) > lado3)&&((lado1 + lado3) > lado2)&&((lado2 + lado3) > lado1))
			return true;
		else 
			return false;
	}
	/**
	 * Utilizando HashSet testa se o tri�ngulo � equil�tero.
	 * Se os valores passados pro construtor forem todos iguais,
	 * o m�todo size de HashSet retornar� 1, indicando um tri�ngulo
	 * equil�tero. 
	 * @return boolean indicando se � equilatero ou n�o 
	 */
	private boolean equilatero(){
		if(ladosTriangulo.size() == 1)
			return true;
		else 
			return false;
	}
	/**
	 * Utilizando HashSet testa se o tri�ngulo � isosceles
	 * Se os valores passados pro construtor tiverem dois 
	 * iguais, o m�todo size de HashSet retornar� 2, indicando um 
	 * tri�ngulo is�sceles
	 * @return boolean indicando se � is�sceles ou n�o
	 */ 
	private boolean isosceles(){
		if(ladosTriangulo.size() == 2)
			return true;
		else
			return false;
	}
	/**
	 * Utilizando HashSet testa se o tri�ngulo � escaleno
	 * Se os valores passados pro construtor n�o tiver nenhum valor 
	 * igual, o m�todo size de HashSet retornar� 3, indicando um 
	 * tri�ngulo escaleno.
	 * @return boolean indicando se � escaleno ou n�o
	 */ 
	private boolean escaleno() {
		if(ladosTriangulo.size() == 3)
			return true;
		else
			return false;
	}
	/**
	 * Testa se o tri�ngulo � retangulo isando pit�goras 
	 * e testando antes se ele � escaleno.
	 * @return boolean indicando se � ret�ngulo ou n�o
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
