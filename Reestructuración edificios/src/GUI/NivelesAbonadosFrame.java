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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;

public class NivelesAbonadosFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dirLTextFd;
	private JTextField dirHTextFd;
	private JTextField cantPisosTextField;
	private JTextField cantDptosPisoTxtField;
	private JTextField cantCuerposPorRamaTxtFd;
	private JTextField tapsxCuerpoTxtFd;
	private JTextField cantRamasTxtFd;
	private JTextField rtTextFd;
	private JTable dataTable;
	
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
		cantPisosTextField.setBounds(420, 33, 50, 20);
		contentPane.add(cantPisosTextField);
		cantPisosTextField.setColumns(10);
		
		cantDptosPisoTxtField = new JTextField();
		cantDptosPisoTxtField.setFont(new Font("Calibri", Font.PLAIN, 14));
		cantDptosPisoTxtField.setBounds(420, 58, 50, 20);
		contentPane.add(cantDptosPisoTxtField);
		cantDptosPisoTxtField.setColumns(10);
		
		
		JLabel lblDptosPorPiso = new JLabel("Dptos. por piso:");
		lblDptosPorPiso.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDptosPorPiso.setBounds(265, 61, 148, 14);
		contentPane.add(lblDptosPorPiso);
		
		JLabel lblCantCuerpos = new JLabel("Cant. Cuerpos por rama:");
		lblCantCuerpos.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCantCuerpos.setBounds(265, 86, 148, 14);
		contentPane.add(lblCantCuerpos);
		
		cantCuerposPorRamaTxtFd = new JTextField();
		cantCuerposPorRamaTxtFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		cantCuerposPorRamaTxtFd.setBounds(420, 83, 50, 20);
		contentPane.add(cantCuerposPorRamaTxtFd);
		cantCuerposPorRamaTxtFd.setColumns(10);
		
		JLabel lblTapsxCuerpo = new JLabel("Cant. Taps por Cuerpo:");
		lblTapsxCuerpo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTapsxCuerpo.setBounds(124, 156, 158, 14);
		contentPane.add(lblTapsxCuerpo);
		
		tapsxCuerpoTxtFd = new JTextField();
		tapsxCuerpoTxtFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		tapsxCuerpoTxtFd.setEditable(false);
		tapsxCuerpoTxtFd.setBounds(265, 153, 50, 20);
		contentPane.add(tapsxCuerpoTxtFd);
		tapsxCuerpoTxtFd.setColumns(10);
		
		
		cantRamasTxtFd = new JTextField();
		cantRamasTxtFd.setFont(new Font("Calibri", Font.PLAIN, 14));
		cantRamasTxtFd.setBounds(420, 108, 50, 20);
		contentPane.add(cantRamasTxtFd);
		cantRamasTxtFd.setColumns(10);
		
		JLabel lblMtsRgEntre = new JLabel("Cant. Ramas:");
		lblMtsRgEntre.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMtsRgEntre.setBounds(265, 111, 158, 14);
		contentPane.add(lblMtsRgEntre);
		
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
				int cantCuerposPorRama = Integer.parseInt(cantCuerposPorRamaTxtFd.getText());
				int cantRamas = Integer.parseInt(cantRamasTxtFd.getText());
				
				int cantRg11 = cantCuerposPorRama-cantRamas + cantRamas-1;
									
				String [] columnas = {"", "Cable", "Metros"};
				
				Object [][] data = new Object[cantCuerposPorRama*cantRamas-1][3];
	
				/*for (int i = 0; i < cantRamas; i++) {
					for (int j = 0; j < cantCuerposPorRama; j++){
						data[i*cantCuerposPorRama+j][0] = new Integer(i*cantCuerposPorRama+(j+1));
						data[i*cantCuerposPorRama+j][1] = new String("RG11 R" + (i+1) + " C" + (j+1));
						data[i*cantCuerposPorRama+j][2] = new Integer(0);
					}
							
				}*/
				
				for (int i = 0; i < data.length; i++) {
					System.out.println(i);
				}
				
				dataTable = new JTable(data, columnas);
				dataTable.setFont(new Font("Calibri", Font.PLAIN, 14));
				dataTable.getColumn("").setMaxWidth(25);
				dataTable.setCellSelectionEnabled(true);
				dataTable.setColumnSelectionAllowed(true);
				dataTable.setBounds(10, 180, 500, 100);
				contentPane.add(dataTable);
				
				JScrollPane scrollPane = new JScrollPane(dataTable);
			    scrollPane.setBounds(10, 180, 500, 100);
			    contentPane.add(scrollPane);
				contentPane.repaint();
			}
		});
		btnGenerar.setBounds(10, 152, 89, 23);
		contentPane.add(btnGenerar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 139, 532, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(220, 11, 1, 125);
		contentPane.add(separator);
		
	
		
		
	}
}
