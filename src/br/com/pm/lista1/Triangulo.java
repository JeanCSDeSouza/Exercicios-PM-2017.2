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
	private static final String RETANGULO = "Retângulo";
	
	public Triangulo(int lado1, int lado2, int lado3) {
		if((lado1 <= 0)||(lado2 <=0)||(lado3)<=0)
			throw new IllegalArgumentException("lados do triangulos devem ser maiores que zero");
		if(ehTriangulo(lado1, lado2, lado3))
			tipo = NAO_EH_TRIANGULO;
		else {
			HashSet<Integer> ladosTriangulo = new HashSet<Integer>();
			ladosTriangulo.add(lado1);
			ladosTriangulo.add(lado2);
			ladosTriangulo.add(lado3);
			this.ladosTriangulo = ladosTriangulo;
		}
 	}
	
	private boolean ehTriangulo(int lado1, int lado2, int lado3){
		if(((lado1 + lado2) > lado3)||((lado1 + lado3) > lado2)||((lado2 + lado3) > lado1))
			return true;
		else 
			return false;
	}
	private boolean equilatero(){
		if(ladosTriangulo.size() == 1)
			return true;
		else 
			return false;
	}
	private boolean isosceles(){
		if(ladosTriangulo.size() == 2)
			return true;
		else
			return false;
	}
	private boolean escaleno() {
		if(ladosTriangulo.size() == 3)
			return true;
		else
			return false;
	}
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
}
