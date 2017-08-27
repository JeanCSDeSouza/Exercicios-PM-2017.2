package br.com.pm.list1.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.pm.lista1.Triangulo;

public class TrianguloTeste {
	private Triangulo triangulo;
	@Test
	public void evaluateTrianguloEquilatero() {
		triangulo = new Triangulo(4,4,4);
		assertEquals("Failure - Strings are not equal","Equilátero", triangulo.getTipo());		
	}
	@Test
	public void evaluateTrianguloIsosceles() {
		triangulo = new Triangulo(5,4,4);
		assertEquals("Failure - Strings are not equal","Isósceles", triangulo.getTipo());
		triangulo = new Triangulo(4,5,4);
		assertEquals("Failure - Strings are not equal","Isósceles", triangulo.getTipo());
		triangulo = new Triangulo(4,4,5);
		assertEquals("Failure - Strings are not equal","Isósceles", triangulo.getTipo());
	}
	@Test
	public void evaluateTrianguloRetangulo() {
		triangulo = new Triangulo(3,4,5);
		assertEquals("Failure - Strings are not equal","Retângulo", triangulo.getTipo());
	}
	@Test
	public void evaluateTrianguloEscaleno() {
		triangulo = new Triangulo(4,5,6);
		assertEquals("Failure - Strings are not equal","Escaleno", triangulo.getTipo());
	}
}
