package Questao10;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Q10 extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    
    private DefaultTableModel model;
    
    public Q10(List<MPessoa> lista) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        setTitle("Lista de pessoas");
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 464, 239);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        model = new DefaultTableModel();
        model.addColumn("CPF");
        model.addColumn("Nome");
        model.addColumn("Idade");

        for (MPessoa obj : lista) {
            Object[] rowData = { obj.getBDCPF(), obj.getBDNOME(), obj.getBDIDADE() };
            model.addRow(rowData);
        }

        table.setModel(model);
    }

    public static void main(String[] args) { 
        DAOPessoa FDAOPessoa = new DAOPessoa();
        MPessoa   FMPessoa   = new MPessoa();
        List<MPessoa> lista = FDAOPessoa.ListPessoa(FMPessoa);

        Q10 frame = new Q10(lista);
        frame.setVisible(true);
    }
}