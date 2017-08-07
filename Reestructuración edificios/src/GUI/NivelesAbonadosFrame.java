package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import logica.tableModel;

public class NivelesAbonadosFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dirLTextFd;
	private JTextField dirHTextFd;
	private JTextField cantPisosTextField;
	private JTextField cantDptosPisoTxtField;
	private JTextField tapsxCuerpoTxtFd;
	private JTextField rtTextFd;
	private JTable dptosTable;
	private JTable cables11Table;
	private JTextField textField;
	private JTextField cantBajadasTxtFd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NivelesAbonadosFrame frame = new NivelesAbonadosFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean areFieldsEmpty() {
		
		/*if(dirLTextFd.getText().length()==0)
			return true;
		if(dirHTextFd.getText().length()==0)
			return true;
		if(rtTextFd.getText().length()==0)
			return true;*/
		if(cantPisosTextField.getText().length()==0)
			return true;
		if(cantDptosPisoTxtField.getText().length()==0)
			return true;
		//if(tapsxCuerpoTxtFd.getText().length()==0)
			//return true;
	
		
		return false;
	}
	
	/**
	 * Create the frame.
	 */
	public NivelesAbonadosFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Amplificador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 104, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblDirL = new JLabel("Directa Baja:");
		lblDirL.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDirL.setBounds(10, 36, 104, 14);
		contentPane.add(lblDirL);
		
		JLabel lblDirH = new JLabel("Directa Alta:");
		lblDirH.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDirH.setBounds(10, 61, 104, 14);
		contentPane.add(lblDirH);
		
		dirLTextFd = new JTextField();
		dirLTextFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		dirLTextFd.setBounds(124, 33, 50, 20);
		contentPane.add(dirLTextFd);
		dirLTextFd.setColumns(10);
		
		dirHTextFd = new JTextField();
		dirHTextFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		dirHTextFd.setBounds(124, 58, 50, 20);
		contentPane.add(dirHTextFd);
		dirHTextFd.setColumns(10);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdificio.setBounds(265, 10, 86, 14);
		contentPane.add(lblEdificio);
		
		JLabel lblCantidadPisos = new JLabel("Cantidad Pisos:");
		lblCantidadPisos.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCantidadPisos.setBounds(265, 36, 86, 14);
		contentPane.add(lblCantidadPisos);
		
		cantPisosTextField = new JTextField();
		cantPisosTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
		cantPisosTextField.setBounds(457, 33, 50, 20);
		contentPane.add(cantPisosTextField);
		cantPisosTextField.setColumns(10);
		
		cantDptosPisoTxtField = new JTextField();
		cantDptosPisoTxtField.setFont(new Font("Calibri", Font.PLAIN, 14));
		cantDptosPisoTxtField.setBounds(457, 58, 50, 20);
		contentPane.add(cantDptosPisoTxtField);
		cantDptosPisoTxtField.setColumns(10);
		
		
		JLabel lblDptosPorPiso = new JLabel("Dptos. por piso:");
		lblDptosPorPiso.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDptosPorPiso.setBounds(265, 61, 148, 14);
		contentPane.add(lblDptosPorPiso);
		
		JLabel lblTapsxCuerpo = new JLabel("Cant. Taps por Cuerpo:");
		lblTapsxCuerpo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTapsxCuerpo.setBounds(124, 153, 158, 14);
		contentPane.add(lblTapsxCuerpo);
		
		tapsxCuerpoTxtFd = new JTextField();
		tapsxCuerpoTxtFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		tapsxCuerpoTxtFd.setEditable(false);
		tapsxCuerpoTxtFd.setBounds(265, 150, 50, 20);
		contentPane.add(tapsxCuerpoTxtFd);
		tapsxCuerpoTxtFd.setColumns(10);
		
		JLabel lblRetorno = new JLabel("Retorno:");
		lblRetorno.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblRetorno.setBounds(10, 86, 104, 14);
		contentPane.add(lblRetorno);
		
		rtTextFd = new JTextField();
		rtTextFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		rtTextFd.setBounds(124, 83, 50, 20);
		contentPane.add(rtTextFd);
		rtTextFd.setColumns(10);
		
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(areFieldsEmpty())
					JOptionPane.showMessageDialog(null, "¡No puede haber campos vacíos!", "Error",
							JOptionPane.ERROR_MESSAGE);
				else {
					int cantPisos = Integer.parseInt(cantPisosTextField.getText());
					int cantDptosPiso = Integer.parseInt(cantDptosPisoTxtField.getText());
					
					int cantBajadas = Integer.parseInt(cantBajadasTxtFd.getText());
						
					Object [][] dptos = new Object[cantPisos*cantDptosPiso][4];
					
					//String [] cableCols = {"", "Cable", "Metros"};
					
					JComboBox<Integer> comboBajadas = new JComboBox<Integer>();
					comboBajadas.setFont(new Font("Calibri", Font.PLAIN, 14));
					for (int x = 0; x < cantBajadas; x++) {
						comboBajadas.addItem(x+1);
					}
					
					
					int cont = 0;
					for (int i = 0; i < cantPisos; i++) {
						for (int f = 0; f < cantDptosPiso; f++) {
							dptos[cont][0] = new Integer(cont+1);
							
							if(i==0)
								dptos[cont][1] = new String("P PB D" + (f+1));
							else
								dptos[cont][1] = new String("P " + i + " D" + (f+1));
							
							dptos[cont][2] = new Boolean(false);
							dptos[cont][3] = new Integer(1);
							cont++;
						}
					}
					
					tableModel utm1 = new tableModel(dptos);
					
					dptosTable = new JTable(utm1);
					dptosTable.setFont(new Font("Calibri", Font.PLAIN, 14));
					dptosTable.getColumnModel().getColumn(0).setMaxWidth(25);
					dptosTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBajadas));
					//dptosTable.getColumn("").setMaxWidth(25);
					//dptosTable.setCellSelectionEnabled(true);
					//dptosTable.setColumnSelectionAllowed(true);
					//dptosTable.setBounds(10, 180, 250, 100);
					contentPane.add(dptosTable);
					
						
					JScrollPane scrollPane1 = new JScrollPane(dptosTable);
				    scrollPane1.setBounds(10, 200, 250, 100);
				    contentPane.add(scrollPane1);
				    
				    JButton btnCalcular = new JButton("Calcular");
				    btnCalcular.setFont(new Font("Calibri", Font.PLAIN, 14));
				    btnCalcular.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						
						}});
				    btnCalcular.setBounds(280, 200, 150, 50);
				    contentPane.add(btnCalcular);
				    
				    /*    
				    JScrollPane scrollPane2 = new JScrollPane(cables11Table);
				    
				    scrollPane2.setBounds(280,150, 250, 100);
				    contentPane.add(scrollPane2);
				    */
					contentPane.repaint();
				}
			}
		});
		btnGenerar.setBounds(10, 149, 89, 23);
		contentPane.add(btnGenerar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 136, 532, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(219, 11, 2, 120);
		contentPane.add(separator);
		
		JLabel lblMetrosRgEntre = new JLabel("Metros RG11 entre conjuntos:");
		lblMetrosRgEntre.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMetrosRgEntre.setBounds(265, 86, 182, 14);
		contentPane.add(lblMetrosRgEntre);
		
		textField = new JTextField();
		textField.setBounds(457, 83, 50, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantZonasDe = new JLabel("Cant. zonas de bajada:");
		lblCantZonasDe.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCantZonasDe.setBounds(265, 111, 166, 14);
		contentPane.add(lblCantZonasDe);
		
		cantBajadasTxtFd = new JTextField();
		cantBajadasTxtFd.setBounds(456, 108, 51, 20);
		contentPane.add(cantBajadasTxtFd);
		cantBajadasTxtFd.setColumns(10);
		
		
		
		
	}
}
