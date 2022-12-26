package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Met_Conversion;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Conversor extends JFrame {
	private JTextField txtCantidad;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setLocationRelativeTo(null); 
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
	public Conversor() {
		
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(10, 85, 87, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 69, 87, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox cbxConvertA = new JComboBox();
		cbxConvertA.setModel(new DefaultComboBoxModel(new String[] {"Dolar a Euro", "Euro a Dolar", "Rublo a Dolar", "Dolar a  Rublo"}));
		cbxConvertA.setBounds(138, 83, 139, 22);
		getContentPane().add(cbxConvertA);
		
		JLabel lblConvertirA = new JLabel("Convertir a");
		lblConvertirA.setForeground(Color.WHITE);
		lblConvertirA.setBounds(138, 64, 105, 14);
		getContentPane().add(lblConvertirA);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBounds(319, 69, 87, 14);
		getContentPane().add(lblResultado);
		
		txtResult = new JTextField();
		txtResult.setEnabled(false);
		txtResult.setColumns(10);
		txtResult.setBounds(319, 85, 87, 20);
		getContentPane().add(txtResult);
		
		JLabel lblNewLabel_1 = new JLabel("Conversor de monedas");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(68, 11, 278, 32);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvertir.setForeground(Color.LIGHT_GRAY);
		btnConvertir.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnConvertir.setBackground(Color.DARK_GRAY);
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double coin =0, result=0;
				int selectedOption=0;
				Met_Conversion mcon = new Met_Conversion();
				if (!txtCantidad.getText().isEmpty()) {
					
					coin = Double.parseDouble(txtCantidad.getText());
					mcon.setCoin(coin); 
					selectedOption= cbxConvertA.getSelectedIndex()+1;
					result= mcon.Menu_conversion(selectedOption);
					
					txtResult.setText(Double.toString(result));  
				}
				
			}
		});
		btnConvertir.setBounds(138, 126, 139, 32);
		getContentPane().add(btnConvertir);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 300);
	}
}
