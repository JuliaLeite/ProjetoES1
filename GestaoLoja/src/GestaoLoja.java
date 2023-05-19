
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestaoLoja {

	private JFrame frame;
	private JTextField txtpnome;
	private JTextField txtqtd;
	private JTextField txtpreco;
	private JTable table;
	private JTextField txtpid;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoLoja window = new GestaoLoja();
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
	public GestaoLoja() {
		initialize();
		Connect();
		table_load();
	}
	
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/gestaoloja", "root","1234");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	
	
	
	  public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select * from produto");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	  
	  

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 963, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestão de Loja");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 5, 647, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastro de Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(32, 81, 896, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQtd.setBounds(33, 109, 101, 14);
		panel.add(lblQtd);
		
		JLabel lblPNome = new JLabel("Nome Produto");
		lblPNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPNome.setBounds(33, 35, 126, 14);
		panel.add(lblPNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(35, 75, 101, 14);
		panel.add(lblPreco);
		
		txtpnome = new JTextField();
		txtpnome.setBounds(150, 34, 281, 20);
		panel.add(txtpnome);
		txtpnome.setColumns(10);
		
		txtqtd = new JTextField();
		txtqtd.setColumns(10);
		txtqtd.setBounds(150, 108, 281, 20);
		panel.add(txtqtd);
		
		txtpreco = new JTextField();
		txtpreco.setColumns(10);
		txtpreco.setBounds(151, 70, 280, 20);
		panel.add(txtpreco);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pnome, qtd, preco;
				
				pnome = txtpnome.getText();
				qtd = txtqtd.getText();
				preco = txtpreco.getText();
				
				try {
					pst = con.prepareStatement("insert into produto(nome,quantidade,preco)values(?,?,?)");
					pst.setString(1, pnome);
					pst.setString(2, qtd);
					pst.setString(3, preco);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto registrado!!!!!");
					table_load();
					          
					txtpnome.setText("");
					txtqtd.setText("");
					txtpreco.setText("");
					txtpnome.requestFocus();
					   }
				
				catch (SQLException e1)
		        {
		e1.printStackTrace();
		}
				
				
			}
		});
		btnSalvar.setBounds(580, 35, 236, 74);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 143, 863, 84);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Procurar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblPID = new JLabel("ID do Produto");
		lblPID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPID.setBounds(31, 33, 101, 14);
		panel_1.add(lblPID);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			@Override
				
				public void keyReleased(KeyEvent e) {
					try {
					          
					            String id = txtpid.getText();
					 
					                pst = con.prepareStatement("select nome,quantidade,preco from produto where id = ?");
					                pst.setString(1, id);
					                ResultSet rs = pst.executeQuery();
					 
					            if(rs.next()==true)
					            {
					              
					                String nome = rs.getString(1);
					                String qtd = rs.getString(2);
					                String preco = rs.getString(3);
					                
					                txtpnome.setText(nome);
					                txtqtd.setText(qtd);
					                txtpreco.setText(preco);
					                
					                
					            }  
					            else
					            {
					             txtpnome.setText("");
					             txtqtd.setText("");
					                txtpreco.setText("");
					                
					            }
					            
					 
					 
					        }
					catch (SQLException ex) {
					          
					        }
				}
		});
		
		
		
		txtpid.setColumns(10);
		txtpid.setBounds(159, 32, 201, 20);
		panel_1.add(txtpid);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(572, 18, 89, 49);
		panel_1.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(717, 18, 89, 49);
		panel_1.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String pid;
                pid  = txtpid.getText();
	
                try {
					pst = con.prepareStatement("delete from produto where id=?");
			
		            pst.setString(1, pid);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Produto deletado!!!!!");
		            table_load();
		           
		            txtpnome.setText("");
		            txtqtd.setText("");
		            txtpreco.setText("");
		            txtpnome.requestFocus();
		            
                	}

                catch (SQLException e1) {
			
                	e1.printStackTrace();
                }
	 
			}
		});
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pnome, qtd, preco, pid;
				
				pnome = txtpnome.getText();
				qtd = txtqtd.getText();
				preco = txtpreco.getText();
				pid = txtpid.getText();
				
				try {
					pst = con.prepareStatement("update produto set nome=?, quantidade=?, preco=? where id=?");
					pst.setString(1, pnome);
					pst.setString(2, qtd);
					pst.setString(3, preco);
					pst.setString(4, pid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto atualizado!!!!!");
					table_load();
					          
					txtpnome.setText("");
					txtqtd.setText("");
					txtpreco.setText("");
					txtpnome.requestFocus();
					
					   }
				
				catch (SQLException e1)
		        {
		e1.printStackTrace();
		}
				
				
				
			}
		});
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(34, 330, 891, 128);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
	}
}

