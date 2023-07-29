package interfaz;

import javax.swing.*;

import arbol_binario.ArbolBinarioBusqueda;
import arbol_binario.Nodo;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGraficaArbol extends JFrame {
	private ArbolBinarioBusqueda arbol;
	private JTextArea textoArea;

	public InterfazGraficaArbol() {
		arbol = new ArbolBinarioBusqueda();

		setTitle("Árbol Binario de Búsqueda");
		setSize(665, 388);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Crear componentes
		JButton botonAgregar = new JButton("Agregar Jugador");
		botonAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonAgregar.setForeground(new Color(0, 0, 128));
		botonAgregar.setBackground(new Color(240, 240, 240));
		botonAgregar.setBounds(453, 46, 186, 25);

		// Agregar componentes al contenedor
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador();
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarJugador();
			}
		});
		btnEliminar.setForeground(new Color(0, 0, 102));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(10, 241, 186, 25);
		panel.add(btnEliminar);
		btnBuscar.setForeground(new Color(0, 0, 102));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(10, 277, 186, 25);
		panel.add(btnBuscar);

		JLabel lblNewLabel_1_1 = new JLabel("Guaman Jhon");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 30, 95, 26);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Diaz Nicole");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 45, 77, 26);
		panel.add(lblNewLabel_1);
		btnSalir.setForeground(new Color(0, 0, 102));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(10, 313, 186, 25);
		panel.add(btnSalir);


		JLabel lblNewLabel = new JLabel("PROYECTO UNIDAD 2 - ARBOLES BINARIOS DE BUSQUEDA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 0, 617, 34);
		panel.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 654, 2);
		panel.add(scrollPane);

		JButton botonOrdenar = new JButton("Ordenar por Puntaje");
		botonOrdenar.setBackground(new Color(240, 240, 240));
		botonOrdenar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonOrdenar.setForeground(new Color(0, 0, 102));
		botonOrdenar.setBounds(453, 82, 186, 25);
		panel.add(botonOrdenar);

		// Acción del botón Ordenar por Puntaje
		botonOrdenar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenarPorPuntaje(); //llamando al metodoo 
			}
		});


		panel.add(botonAgregar);
		getContentPane().add(panel);
		textoArea = new JTextArea();
		textoArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textoArea.setForeground(new Color(255, 255, 255));
		textoArea.setBackground(new Color(0, 0, 128));
		textoArea.setBounds(226, 170, 426, 179);
		panel.add(textoArea);

		JButton botonRecorridos = new JButton("Recorridos");
		botonRecorridos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append("Recorrido en preorden: ");
				sb.append(arbol.recorridoPreorden());
				sb.append("\nRecorrido en inorden: ");
				sb.append(arbol.recorridoInorden());
				sb.append("\nRecorrido en posorden: ");
				sb.append(arbol.recorridoPosorden());
				textoArea.setText(sb.toString());
			}
		});
		botonRecorridos.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonRecorridos.setForeground(new Color(0, 0, 102));
		botonRecorridos.setBounds(453, 116, 186, 25);
		panel.add(botonRecorridos);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(75, 0, 130));
		lblFondo.setBounds(0, 0, 654, 349);
		lblFondo.setIcon(new ImageIcon(InterfazGraficaArbol.class.getResource("/imagenes/fondo1.jpg")));
		panel.add(lblFondo);

		// Acción del botón Agregar Jugador
		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarJugador();
			}
		});
	}

	private void agregarJugador() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
		if (nombre != null && !nombre.isEmpty()) {
			String puntajeStr = JOptionPane.showInputDialog(this, "Ingrese el puntaje del jugador:");
			try {
				int puntaje = Integer.parseInt(puntajeStr);
				if (puntaje > 0) {
					arbol.insertar(nombre, puntaje);
					textoArea.append("Jugador agregado: " + nombre + " - Puntaje: " + puntaje + "\n");
				} else {
					JOptionPane.showMessageDialog(this, "El puntaje debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Puntaje inválido. Ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void ordenarPorPuntaje() {
		List<String> jugadoresOrdenados = arbol.obtenerJugadoresOrdenados();
		StringBuilder sb = new StringBuilder();
		for (String jugador : jugadoresOrdenados) {
			sb.append(jugador).append("\n");
		}
		textoArea.setText(sb.toString());
	}
	private void buscarJugador() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador a buscar:");
		if (nombre != null && !nombre.isEmpty()) {
			int puntaje = arbol.obtenerPuntaje(nombre);
			if (puntaje != -1) {
				textoArea.setText("Jugador encontrado: " + nombre + " - Puntaje: " + puntaje);
			} else {
				textoArea.setText("Jugador no encontrado en el árbol.");
			}
		}
	}

	private void eliminarJugador() {
	    String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador a eliminar:");
	    if (nombre != null && !nombre.isEmpty()) {
	        arbol.eliminar(nombre);
	        ordenarPorPuntaje();
	    }
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				InterfazGraficaArbol ventana = new InterfazGraficaArbol();
				ventana.setVisible(true);
			}


		});
	}
}
