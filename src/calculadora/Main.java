package calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		boolean ejecuta = true;
		Scanner entrada = new Scanner(System.in);
		createFrame();
		while(ejecuta)
		{
			Calculadora calculadora = new Calculadora();
			calculadora.obtenerDatos(entrada);
			int c = calculadora.calcular();
			
			System.out.println(c + "\n¿Continuar? (S/N)");
			String continuar = entrada.nextLine().toUpperCase();
			ejecuta = continuar.equals("S");
		}
		entrada.close();
	}
	static String operacion = "";
	static JTextField total;
	static int a;
	static String operador = "";
	static int b;
	public static void createFrame()
	{
		
		JFrame x = new JFrame("Hola");
		x.setSize(300, 400);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 0.1;
		constraints.weightx= 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		JPanel resultado = new JPanel();
		resultado.setLayout(new GridLayout(1, 1));
		total = new JTextField("0");
		total.setEnabled(false);
		total.setHorizontalAlignment(JTextField.RIGHT);
		Font font1 = new Font("SansSerif", Font.BOLD, 40);
		total.setFont(font1);
		total.setDisabledTextColor(Color.BLACK);
		resultado.add(total);
		panel.add(resultado, constraints);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.9;
		constraints.weightx= 1;
		constraints.gridx = 0;
		constraints.gridy = 1;
		JPanel botones = new JPanel();
		
		botones.setLayout(new GridLayout(4, 4));
		
		JButton siete = new JButton("7");
		siete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "7";
				total.setText(operacion);
			}
		});
		
		botones.add(siete);
		JButton ocho = new JButton("8");
		ocho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "8";
				total.setText(operacion);
			}
		});
		botones.add(ocho);
		
		JButton nueve = new JButton("9");
		nueve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "9";
				total.setText(operacion);
			}
		});
		botones.add(nueve);
		
		JButton mas = new JButton("+");
		mas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operador == "")
				{
					a = Integer.parseInt(total.getText());
					total.setText("0");
					operacion = "";
				}
				operador = "+";
			}
		});
		botones.add(mas);
		
		JButton cuatro = new JButton("4");
		cuatro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "4";
				total.setText(operacion);
			}
		});
		botones.add(cuatro);
		
		JButton cinco = new JButton("5");
		cinco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "5";
				total.setText(operacion);
			}
		});
		botones.add(cinco);
		
		JButton seis = new JButton("6");
		seis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "6";
				total.setText(operacion);
			}
		});
		botones.add(seis);
		
		JButton menos = new JButton("-");
		menos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operador == "")
				{
					a = Integer.parseInt(total.getText());
					total.setText("0");
					operacion = "";
				}
				operador = "-";
			}
		});
		botones.add(menos);

		JButton uno = new JButton("1");
		uno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "1";
				total.setText(operacion);
			}
		});
		botones.add(uno);

		JButton dos = new JButton("2");
		dos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "2";
				total.setText(operacion);
			}
		});
		botones.add(dos);

		JButton tres = new JButton("3");
		tres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "3";
				total.setText(operacion);
			}
		});
		botones.add(tres);
		JButton por = new JButton("*");
		por.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operador == "")
				{
					a = Integer.parseInt(total.getText());
					total.setText("0");
					operacion = "";
				}
				operador = "*";
			}
		});
		botones.add(por);
		JButton cancelar = new JButton("C");
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				a = 0;
				total.setText("0");
				operacion = "";
				operador = "";
			}
		});
		botones.add(cancelar);

		JButton cero = new JButton("0");
		cero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion += "0";
				total.setText(operacion);
			}
		});
		
		botones.add(cero);
		JButton igual = new JButton("=");
		igual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operador != "")
				{
					b = Integer.parseInt(total.getText());
					int c = Calculadora.calcular(a, b, operador);
					total.setText(Integer.toString(c));
					operador = "";
					operacion = "";
				}
			}
		});
		botones.add(igual);
		JButton entre = new JButton("÷");
		entre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operador == "")
				{
					a = Integer.parseInt(total.getText());
					total.setText("0");
					operacion = "";
				}
				operador = "/";
			}
		});
		botones.add(entre);
		
		panel.add(botones, constraints);
		x.add(panel);
		x.setVisible(true);
	}
	
}
