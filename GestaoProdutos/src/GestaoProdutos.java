import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GestaoProdutos {

	private JFrame frame;
	private JTextField txtpnome;
	private JTextField txtqtd;
	private JTextField txtpreco;
	private JTable table;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoProdutos window = new GestaoProdutos();
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
	public GestaoProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestão de Loja");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 11, 647, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastro de Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(32, 81, 390, 220);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQtd.setBounds(33, 71, 101, 14);
		panel.add(lblQtd);
		
		JLabel lblPNome = new JLabel("Nome Produto");
		lblPNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPNome.setBounds(33, 35, 126, 14);
		panel.add(lblPNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(33, 107, 101, 14);
		panel.add(lblPreco);
		
		txtpnome = new JTextField();
		txtpnome.setBounds(150, 34, 201, 20);
		panel.add(txtpnome);
		txtpnome.setColumns(10);
		
		txtqtd = new JTextField();
		txtqtd.setColumns(10);
		txtqtd.setBounds(150, 70, 201, 20);
		panel.add(txtqtd);
		
		txtpreco = new JTextField();
		txtpreco.setColumns(10);
		txtpreco.setBounds(150, 106, 201, 20);
		panel.add(txtpreco);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(33, 149, 89, 49);
		panel.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(262, 149, 89, 49);
		panel.add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(150, 149, 89, 49);
		panel.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 86, 323, 211);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Procurar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 312, 390, 84);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPID = new JLabel("ID do Produto");
		lblPID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPID.setBounds(31, 33, 101, 14);
		panel_1.add(lblPID);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(159, 32, 201, 20);
		panel_1.add(textID);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(498, 330, 89, 49);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(610, 330, 89, 49);
		frame.getContentPane().add(btnExcluir);
	}
}
