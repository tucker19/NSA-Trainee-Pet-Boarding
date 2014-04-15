package boardingGui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BoardingGui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BoardingGui window = new BoardingGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardingGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel patientLookup = new JPanel();
		tabbedPane.addTab("Patient Lookup", null, patientLookup, null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("Last Name:");
		
		table = new JTable();
		GroupLayout gl_patientLookup = new GroupLayout(patientLookup);
		gl_patientLookup.setHorizontalGroup(
			gl_patientLookup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patientLookup.createSequentialGroup()
					.addGroup(gl_patientLookup.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_patientLookup.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_patientLookup.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_patientLookup.setVerticalGroup(
			gl_patientLookup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patientLookup.createSequentialGroup()
					.addGroup(gl_patientLookup.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_patientLookup.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel))
						.addGroup(gl_patientLookup.createSequentialGroup()
							.addGap(6)
							.addComponent(label)))
					.addGap(12)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		patientLookup.setLayout(gl_patientLookup);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
	}
}
