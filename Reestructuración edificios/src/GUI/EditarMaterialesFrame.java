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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import objetos.Material;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditarMaterialesFrame extends JFrame {

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
					EditarMaterialesFrame frame = new EditarMaterialesFrame();
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
	public EditarMaterialesFrame() {
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
		
		JLabel lblCdigoMaterial = new JLabel("C\u00F3digo Material:");
		lblCdigoMaterial.setBounds(10, 11, 103, 14);
		contentPane.add(lblCdigoMaterial);
		
		codTextField = new JTextField();
		codTextField.setBounds(130, 8, 110, 20);
		contentPane.add(codTextField);
		codTextField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod = Integer.parseInt(codTextField.getText()); 
				Material m1;
				if ((m1=Archivo.buscar("materiales", cod)) == null) {
					JOptionPane.showMessageDialog(null, "El material no existe", "No se ha encontrado",
							JOptionPane.INFORMATION_MESSAGE);
					codTextField.requestFocus();
				}
				else {
					descTextField.setText(m1.getDesc());
					
				}
				
			}
		});
		btnBuscar.setBounds(250, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 36, 120, 14);
		contentPane.add(lblDescripcin);
		
		descTextField = new JTextField();
		descTextField.setBounds(130, 33, 494, 20);
		contentPane.add(descTextField);
		descTextField.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Archivo.actualizar("materiales", Integer.parseInt(codTextField.getText()), descTextField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnActualizar.setBounds(91, 87, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(271, 87, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		btnCancelar.setBounds(451, 87, 89, 23);
		contentPane.add(btnCancelar);
	}
}
