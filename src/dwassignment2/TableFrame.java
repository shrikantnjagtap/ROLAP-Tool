package dwassignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Color;

public class TableFrame extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public TableFrame(JScrollPane jsp) {
		setMinimumSize(new Dimension(1400, 900));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1400, 900));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		jsp.getViewport().setBackground(Color.blue);
		panel.add(jsp);
		panel.repaint();
		panel.revalidate();
	}

	
}
