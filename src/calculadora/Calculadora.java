package calculadora;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Calculadora {
	private int a;
	private int b;
	private String operador;
	public static int calcular(int a, int b, String operador)
	{
		switch(operador)
		{
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a*b;
			case "/":
				if(b == 0)
				{
					JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
					return 0;
				}
				else
				{
					return a/b;
				}
			default:
				JOptionPane.showMessageDialog(null, "Operador Inválido");
				return 0;
		}
	}
	public int calcular()
	{
		switch(operador)
		{
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a*b;
			case "/":
				return a/b;
			default:
				JOptionPane.showMessageDialog(null, "Operador Inválido");
				return 0;
		}
	}
	private int actualIndex;
	public void obtenerDatos(Scanner entrada)
	{
		String operacion = entrada.nextLine();
				
		a = obtenNumero(operacion, 0);
		operador = operacion.substring(actualIndex, actualIndex + 1);
		b = obtenNumero(operacion, actualIndex + 1);
	}
	public int obtenNumero(String cadena, int index)
	{
		char[] linea = cadena.toCharArray();
		for(int i = index; i< linea.length; i++ )
		{
			if(!esNumero(linea[i]))
			{
				String numero = cadena.substring(index, i);
				actualIndex = i;
				return Integer.parseInt(numero);
			}
		}
		return Integer.parseInt(cadena.substring(index));
	}
	public boolean esNumero(char caracter)
	{
		try {
			Integer.parseInt(String.valueOf(caracter));
			return true;
		}catch(Exception ex)
		{
			return false;
		}
	}
	public void obtenerDatos(int a, int b, String operador)
	{
		this.a = a;
		this.b = b;
		this.operador = operador;
	}
}