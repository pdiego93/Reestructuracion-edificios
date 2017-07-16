package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NivelesAbonadosFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dirLTextFd;
	private JTextField dirHTextFd;
	private JTextField cantPisosTextField;
	private JTextField cantDptosPisoTxtField;
	private JTextField cantCuerposTxtFd;
	private JTextField tapsxCuerpoTxtFd;
	private JTextField mtsRg11;
	private JTextField rtTextFd;
	
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Amplificador");
		lblNewLabel.setBounds(10, 11, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDirL = new JLabel("Directa Baja:");
		lblDirL.setBounds(10, 36, 104, 14);
		contentPane.add(lblDirL);
		
		JLabel lblDirH = new JLabel("Directa Alta:");
		lblDirH.setBounds(10, 61, 104, 14);
		contentPane.add(lblDirH);
		
		dirLTextFd = new JTextField();
		dirLTextFd.setBounds(168, 33, 50, 20);
		contentPane.add(dirLTextFd);
		dirLTextFd.setColumns(10);
		
		dirHTextFd = new JTextField();
		dirHTextFd.setBounds(168, 58, 50, 20);
		contentPane.add(dirHTextFd);
		dirHTextFd.setColumns(10);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(10, 125, 86, 14);
		contentPane.add(lblEdificio);
		
		JLabel lblCantidadPisos = new JLabel("Cantidad Pisos:");
		lblCantidadPisos.setBounds(10, 150, 86, 14);
		contentPane.add(lblCantidadPisos);
		
		cantPisosTextField = new JTextField();
		cantPisosTextField.setBounds(168, 150, 50, 20);
		contentPane.add(cantPisosTextField);
		cantPisosTextField.setColumns(10);
		
		cantDptosPisoTxtField = new JTextField();
		cantDptosPisoTxtField.setBounds(168, 181, 50, 20);
		contentPane.add(cantDptosPisoTxtField);
		cantDptosPisoTxtField.setColumns(10);
		
		
		JLabel lblDptosPorPiso = new JLabel("Dptos. por piso:");
		lblDptosPorPiso.setBounds(10, 181, 148, 14);
		contentPane.add(lblDptosPorPiso);
		
		JLabel lblCantCuerpos = new JLabel("Cant. Cuerpos:");
		lblCantCuerpos.setBounds(10, 216, 95, 14);
		contentPane.add(lblCantCuerpos);
		
		cantCuerposTxtFd = new JTextField();
		cantCuerposTxtFd.setBounds(168, 216, 50, 20);
		contentPane.add(cantCuerposTxtFd);
		cantCuerposTxtFd.setColumns(10);
		
		JLabel lblTapsxCuerpo = new JLabel("Cant. Taps por Cuerpo:");
		lblTapsxCuerpo.setBounds(10, 281, 158, 14);
		contentPane.add(lblTapsxCuerpo);
		
		tapsxCuerpoTxtFd = new JTextField();
		tapsxCuerpoTxtFd.setBounds(168, 278, 50, 20);
		contentPane.add(tapsxCuerpoTxtFd);
		tapsxCuerpoTxtFd.setColumns(10);
		
		
		mtsRg11 = new JTextField();
		mtsRg11.setBounds(168, 247, 50, 20);
		contentPane.add(mtsRg11);
		mtsRg11.setColumns(10);
		
		JLabel lblMtsRgEntre = new JLabel("Mts. RG11 entre cuerpos:");
		lblMtsRgEntre.setBounds(10, 250, 158, 14);
		contentPane.add(lblMtsRgEntre);
		
		JLabel lblRetorno = new JLabel("Retorno:");
		lblRetorno.setBounds(10, 86, 104, 14);
		contentPane.add(lblRetorno);
		
		rtTextFd = new JTextField();
		rtTextFd.setBounds(168, 83, 50, 20);
		contentPane.add(rtTextFd);
		rtTextFd.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantCuerpos = Integer.parseInt(cantCuerposTxtFd.getText());
				int cantTapsxCuerpo = Integer.parseInt(tapsxCuerpoTxtFd.getText());
				int cantTaps=0;
				
				JLabel arrayLabels[] = new JLabel[cantCuerpos];
				JTextField arrayTextFd[] = new JTextField[cantCuerpos];
				
				for (int i = 0; i < cantCuerpos; i++) {
					
					for (int j = 0; j < cantTapsxCuerpo; j++) {
					
					arrayLabels[i] = new JLabel("Modelo TAP " + (j+1) +" C" + (i+1) +":");
					arrayLabels[i].setBounds(10, 310 + cantTaps*30, 148, 14);
					contentPane.add(arrayLabels[i]);
					
					arrayTextFd[i] = new JTextField();
					arrayTextFd[i].setBounds(168, 310 + cantTaps*30, 50, 20);
					contentPane.add(arrayTextFd[i]);
					arrayTextFd[i].setColumns(10);
					
					contentPane.repaint();
					cantTaps++;
					
					}
					
				}
			}
		});
		btnGenerar.setBounds(228, 277, 89, 23);
		contentPane.add(btnGenerar);
		
		
		
	}
}
