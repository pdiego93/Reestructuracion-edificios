package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Archivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CargaMaterialesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField codTextField;
	private JTextField descTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargaMaterialesFrame frame = new CargaMaterialesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cerrarVentana() {
		int opc = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Cerrar",
				JOptionPane.OK_CANCEL_OPTION);
		if (opc == JOptionPane.OK_OPTION) {
			this.dispose();
		}
	}

	/**
	 * Create the frame.
	 */
	public CargaMaterialesFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrarVentana();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaterial = new JLabel("Cod. Material:");
		lblMaterial.setBounds(10, 11, 96, 14);
		contentPane.add(lblMaterial);

		codTextField = new JTextField();
		codTextField.setBounds(116, 8, 86, 20);
		contentPane.add(codTextField);

		descTextField = new JTextField();
		descTextField.setBounds(116, 31, 508, 19);
		contentPane.add(descTextField);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 36, 96, 14);
		contentPane.add(lblDescripcin);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		btnCancelar.setBounds(393, 92, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(descTextField.getText().equals("") || codTextField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "¡No puede haber campos vacíos!", "Error",
							JOptionPane.ERROR_MESSAGE);
				else {
				int cod = Integer.parseInt(codTextField.getText());
				String desc = descTextField.getText();
				
				if (Archivo.buscar("materiales", cod) == null) {
					Archivo.escribir("materiales", cod + "|" + desc);
					JOptionPane.showMessageDialog(null, "El material ha sido registrado", "Guardado exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					codTextField.setText("");
					descTextField.setText("");
					codTextField.requestFocus();
				}
				else
					JOptionPane.showMessageDialog(null, "El código de material ya existe", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(152, 92, 89, 23);
		contentPane.add(btnAceptar);

	}
}
