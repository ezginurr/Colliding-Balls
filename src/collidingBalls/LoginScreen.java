package collidingBalls;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
	
	SecondScreen screen;
	Balls balls;
	Color c;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		screen=new SecondScreen();
		screen.setVisible(false);
		balls=new Balls();
		c=null;
		
		JLabel lblNewLabel = new JLabel("Enter the radius of the ball");
		lblNewLabel.setBounds(30, 26, 171, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the speed of the ball");
		lblNewLabel_1.setBounds(30, 91, 171, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(295, 31, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 96, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Ball");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==null) {
					for(int i=0; i<Integer.parseInt(textField_2.getText());i++) {
						Ball ball=new Ball(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
						balls.addBall(ball);
					}
				}
				else {
					for(int i=0; i<Integer.parseInt(textField_2.getText());i++) {
						Ball ball=new Ball(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()), c);
						balls.addBall(ball);
					}
					c=Color.black;
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton.setBounds(265, 223, 122, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Balls");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.getContentPane().add(balls); 
				screen.setVisible(true); 
			}
		});
		btnNewButton_1.setBounds(172, 284, 116, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the number of balls");
		lblNewLabel_2.setBounds(30, 157, 165, 22);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 157, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Choose Color");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=JColorChooser.showDialog(null, "Color Chooser", Color.black);
			}
		});
		btnNewButton_2.setBounds(73, 223, 122, 32);
		contentPane.add(btnNewButton_2);
		
	}
}
