package view;

import model.Produto;
import dao.ProdutoDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoView {

	private JFrame frame;
	private JTextField txtpnome;
	private JTextField txtdesc;
	private JTextField txtqtd;
	private JTextField txtpreco;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView window = new ProdutoView();
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
	public ProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 838, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastro de Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 32, 804, 183);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 35, 110, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 68, 110, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 105, 110, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Preço");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(24, 133, 110, 17);
		panel.add(lblNewLabel_1_1_1);
		
		txtpnome = new JTextField();
		txtpnome.setBounds(150, 35, 249, 20);
		panel.add(txtpnome);
		txtpnome.setColumns(10);
		
		txtdesc = new JTextField();
		txtdesc.setColumns(10);
		txtdesc.setBounds(150, 68, 249, 20);
		panel.add(txtdesc);
		
		txtqtd = new JTextField();
		txtqtd.setColumns(10);
		txtqtd.setBounds(150, 99, 249, 20);
		panel.add(txtqtd);
		
		txtpreco = new JTextField();
		txtpreco.setColumns(10);
		txtpreco.setBounds(150, 130, 249, 20);
		panel.add(txtpreco);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProdutoDAO produtoDAO = new ProdutoDAO();
				
				String pnome, desc, preco, qtd;
				
				
				pnome = txtpnome.getText();
				desc = txtdesc.getText();
				preco = txtqtd.getText();
				qtd = txtpreco.getText();
				
				
				Produto produto = new Produto();
				produto.setNome(pnome);
				produto.setDesc(desc);
				produto.setQtd(Integer.parseInt(qtd));
				//produto.setPreco(Double.parseDouble(preco));
				
				produtoDAO.salvar(produto);
				
			}
		});
		btnSalvar.setBounds(510, 57, 226, 69);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Procurar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 214, 804, 82);
		frame.getContentPane().add(panel_1);
		
		JLabel lblIdDoProduto = new JLabel("ID do produto");
		lblIdDoProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdDoProduto.setBounds(24, 35, 110, 17);
		panel_1.add(lblIdDoProduto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 35, 249, 20);
		panel_1.add(textField);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(451, 23, 150, 44);
		panel_1.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(617, 23, 150, 44);
		panel_1.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 307, 797, 120);
		frame.getContentPane().add(scrollPane);
	}
}
