package br.com.joaoclaudioribeiro.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.joaoclaudioribeiro.dao.AlunoDAO;
import br.com.joaoclaudioribeiro.dao.CampusDAO;
import br.com.joaoclaudioribeiro.dao.CursoDAO;
import br.com.joaoclaudioribeiro.dao.DisciplinaDAO;
import br.com.joaoclaudioribeiro.dao.MatriculaDAO;
import br.com.joaoclaudioribeiro.dao.PeriodoDAO;
import br.com.joaoclaudioribeiro.dao.PonderadoDAO;
import br.com.joaoclaudioribeiro.model.Aluno;
import br.com.joaoclaudioribeiro.model.Campus;
import br.com.joaoclaudioribeiro.model.Curso;
import br.com.joaoclaudioribeiro.model.Disciplina;
import br.com.joaoclaudioribeiro.model.Matricula;
import br.com.joaoclaudioribeiro.model.Ponderado;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmExcluir;
	private JMenuItem mntmSair;
	private JMenu mnNotasEFaltas;
	private JMenuItem mntmSalvar_1;
	private JMenuItem mntmAlterar_1;
	private JMenuItem mntmExcluir_1;
	private JMenuItem mntmConsultar_1;
	private JMenu mnAjuda;
	private JMenuItem mntmSobre;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblRgm;
	private JTextField txtRGM;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField txtDtaNasc;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblEnd;
	private JTextField txtEnd;
	private JLabel lblMunicpio;
	private JTextField txtMuni;
	private JLabel lblUf;
	private JComboBox cbmUF;
	private JLabel lblCelular;
	private JFormattedTextField txtCelular;
	private JLabel lblCurso;
	private JComboBox cbmCurso;
	private JLabel lblCampus;
	private JComboBox cbmCampus;
	private JLabel lblPeriodo;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	private JButton btnSair;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JLabel lblRgm_1;
	private JTextField txtRgm;
	private JLabel lblMostraAluno;
	private JLabel lblMostraCurso;
	private JLabel lblDisciplina;
	private JComboBox cbmDisciplina;
	private JLabel lblSemestre;
	private JComboBox cbmSemestre;
	private JLabel lblNota;
	private JComboBox cbmNota;
	private JLabel lblFaltas;
	private JTextField txtFaltas;
	private JButton btnSairNotasFaltas;
	private JButton btnSalvarNotasFaltas;
	private JButton btnAlterarNotasFaltas;
	private JButton btnConsultarNotasFaltas;
	private JButton btnExcluirNotasFaltas;
	private MaskFormatter ftmData;// Atributo formatador para data
	private MaskFormatter ftmCpf;// Atributo formatador para cpf
	private MaskFormatter ftmCel;// Atributo formatador para Celular
	private final ButtonGroup btnGroupPeriodo = new ButtonGroup();
	private CursoDAO daoCurso;
	private CampusDAO daoCampus;
	private DisciplinaDAO daoDisciplina;
	private PeriodoDAO daoPeriodo;
	private Aluno aluno;
	private Curso curso;
	private Disciplina disciplina;
	private Ponderado ponderado;
	private Matricula matricula;
	private AlunoDAO daoAluno;
	private SimpleDateFormat formatDate;
	private SimpleDateFormat formatDateSql;
	private MatriculaDAO daoMatricula;
	private PonderadoDAO daoPonderado;
	private JLabel lblRgm_2;
	private JTextField txtRgmBoletim;
	private JLabel lblMostrarNomeBoletim;
	private JLabel lblMostrarCursoBoletim;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBoletim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 323);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarAluno();
			}
		});
		mnAluno.add(mntmSalvar);

		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateAluno();
			}
		});
		mnAluno.add(mntmAlterar);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectAluno();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar aluno pelo RGM\n " + e.getMessage());
				}
			}
		});
		mnAluno.add(mntmConsultar);

		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAluno();
			}
		});
		mnAluno.add(mntmExcluir);

		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		mnAluno.add(mntmSair);

		mnNotasEFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasEFaltas);

		mntmSalvar_1 = new JMenuItem("Salvar");
		mntmSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNotaFalta();
			}
		});
		mnNotasEFaltas.add(mntmSalvar_1);

		mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNotaFalta();
			}
		});
		mnNotasEFaltas.add(mntmAlterar_1);

		mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNotasFalta();
			}
		});
		mnNotasEFaltas.add(mntmExcluir_1);

		mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNotaFalta();
			}
		});
		mnNotasEFaltas.add(mntmConsultar_1);

		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Sistema Gerenciamento de Alunos\nAutor: João Claudio Ribeiro\nE-mail: contato@joaoclaudioribeiro.com.br\nTel.: (11)94710-8920");
			}
		});
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 529, 253);
		contentPane.add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);

		lblRgm = new JLabel("RGM");
		lblRgm.setBounds(10, 11, 46, 14);
		panel.add(lblRgm);

		txtRGM = new JTextField();

		txtRGM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtRGM.setText(null);
				txtNome.setText(null);
				txtDtaNasc.setText(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtEnd.setText(null);
				txtMuni.setText(null);
				cbmUF.setSelectedIndex(0);
				txtCelular.setText(null);
				cbmCurso.setSelectedIndex(0);
				cbmCampus.setSelectedIndex(0);
				btnGroupPeriodo.clearSelection();
				
			}
		});
		txtRGM.setBounds(40, 8, 128, 20);
		panel.add(txtRGM);
		txtRGM.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(179, 11, 46, 14);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(216, 8, 281, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 39, 116, 14);
		panel.add(lblDataDeNascimento);

		ftmData = new MaskFormatter("##/##/####");
		txtDtaNasc = new JFormattedTextField(ftmData);
		txtDtaNasc.setBounds(133, 36, 111, 20);
		panel.add(txtDtaNasc);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(254, 39, 23, 14);
		panel.add(lblCpf);

		ftmCpf = new MaskFormatter("###.###.###-##");
		txtCpf = new JFormattedTextField(ftmCpf);
		txtCpf.setBounds(280, 36, 217, 20);
		panel.add(txtCpf);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 67, 37, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(50, 64, 447, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		lblEnd = new JLabel("End");
		lblEnd.setBounds(10, 98, 37, 14);
		panel.add(lblEnd);

		txtEnd = new JTextField();
		txtEnd.setBounds(50, 95, 447, 20);
		panel.add(txtEnd);
		txtEnd.setColumns(10);

		lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setBounds(10, 129, 56, 14);
		panel.add(lblMunicpio);

		txtMuni = new JTextField();
		txtMuni.setBounds(71, 126, 135, 20);
		panel.add(txtMuni);
		txtMuni.setColumns(10);

		lblUf = new JLabel("UF");
		lblUf.setBounds(216, 129, 23, 14);
		panel.add(lblUf);

		cbmUF = new JComboBox();
		cbmUF.setModel(new DefaultComboBoxModel(
				new String[] { "SELECIONE", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
						"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbmUF.setBounds(239, 125, 58, 22);
		panel.add(cbmUF);

		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(307, 129, 46, 14);
		panel.add(lblCelular);

		ftmCel = new MaskFormatter("(##)#####-####");
		txtCelular = new JFormattedTextField(ftmCel);
		txtCelular.setBounds(351, 126, 146, 20);
		panel.add(txtCelular);

		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 15, 55, 14);
		panel_1.add(lblCurso);

		cbmCurso = new JComboBox();
		cbmCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// listarDisciplina();
			}
		});
		cbmCurso.addItem("SELECIONE O CURSO");
		listarCurso();
		// cbmCurso.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE O CURSO",
		// "ANALISE E DESENVOLVIMENTO DE SISTEMAS", "CIENCIAS DACOMPUTACAO", "ENGENHARIA
		// DA COMPUTACAO", "ENGENHARIA DE CONTROLE E AUTOMACAO", "ENGENHARIA DE
		// SOFTWARE", "JOGOS DIGITAIS", "SISTEMA DE INFORMACAO", "SISTEMA PARA
		// INTERNET"}));
		cbmCurso.setBounds(75, 11, 439, 22);
		panel_1.add(cbmCurso);

		lblCampus = new JLabel("Campus");
		lblCampus.setBounds(10, 56, 55, 14);
		panel_1.add(lblCampus);

		cbmCampus = new JComboBox();
		cbmCampus.addItem("SELECIONE O CAMPUS");
		listarCampus();
		// cbmCampus.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE O
		// CAMPUS", "TATUAPE", "PINHEIROS"}));
		cbmCampus.setBounds(75, 52, 439, 22);
		panel_1.add(cbmCampus);

		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(10, 94, 46, 14);
		panel_1.add(lblPeriodo);

		rdbtnMatutino = new JRadioButton("MATUTINO");
		btnGroupPeriodo.add(rdbtnMatutino);
		rdbtnMatutino.setBounds(75, 90, 91, 23);
		panel_1.add(rdbtnMatutino);

		rdbtnVespertino = new JRadioButton("VESPERTINO");
		btnGroupPeriodo.add(rdbtnVespertino);
		rdbtnVespertino.setBounds(171, 90, 99, 23);
		panel_1.add(rdbtnVespertino);

		rdbtnNoturno = new JRadioButton("NOTURNO");
		btnGroupPeriodo.add(rdbtnNoturno);
		rdbtnNoturno.setBounds(279, 90, 99, 23);
		panel_1.add(rdbtnNoturno);

		btnSair = new JButton();
		btnSair.setToolTipText("Sair");
		ImageIcon iconSair = new ImageIcon(getClass().getResource("/br/joaoclaudioribeiro/icon/sair.png"));
		iconSair.setImage(iconSair.getImage().getScaledInstance(30, 30, 30));
		btnSair.setIcon(iconSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		});

		btnSair.setBounds(10, 138, 91, 79);
		panel_1.add(btnSair);

		btnSalvar = new JButton();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarAluno();
			}
		});
		btnSalvar.setToolTipText("Salvar");
		ImageIcon iconSalvar = new ImageIcon(getClass().getResource("/br/joaoclaudioribeiro/icon/salvar.png"));
		iconSalvar.setImage(iconSalvar.getImage().getScaledInstance(30, 30, 30));
		btnSalvar.setIcon(iconSalvar);
		btnSalvar.setBounds(111, 138, 91, 79);
		panel_1.add(btnSalvar);

		btnAlterar = new JButton();
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// #####################################
				try {
					updateAluno();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar aluno\n " + e.getMessage());
				}
				// ####################################
			}
		});
		btnAlterar.setToolTipText("Alterar");
		ImageIcon iconAlterar = new ImageIcon(TelaAluno.class.getResource("/br/joaoclaudioribeiro/icon/alterar.png"));
		iconAlterar.setImage(iconAlterar.getImage().getScaledInstance(30, 30, 30));
		btnAlterar.setIcon(iconAlterar);
		btnAlterar.setBounds(212, 138, 91, 79);
		panel_1.add(btnAlterar);

		btnConsultar = new JButton();
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectAluno();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar aluno pelo RGM\n " + e.getMessage());
				}
			}
		});
		btnConsultar.setToolTipText("Consultar");
		ImageIcon iconConsultar = new ImageIcon(
				TelaAluno.class.getResource("/br/joaoclaudioribeiro/icon/consultar.png"));
		iconConsultar.setImage(iconConsultar.getImage().getScaledInstance(30, 30, 30));
		btnConsultar.setIcon(iconConsultar);
		btnConsultar.setBounds(313, 138, 91, 79);
		panel_1.add(btnConsultar);

		btnExcluir = new JButton();
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAluno();
			}
		});
		btnExcluir.setToolTipText("Excluir");
		ImageIcon iconExcluir = new ImageIcon(TelaAluno.class.getResource("/br/joaoclaudioribeiro/icon/excluir.png"));
		iconExcluir.setImage(iconExcluir.getImage().getScaledInstance(30, 30, 30));
		btnExcluir.setIcon(iconExcluir);
		btnExcluir.setBounds(414, 138, 91, 79);
		panel_1.add(btnExcluir);

		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setBounds(10, 11, 46, 14);
		panel_2.add(lblRgm_1);

		txtRgm = new JTextField();
		txtRgm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtRgm.setText("");
				cbmSemestre.setSelectedIndex(0);
				cbmNota.setSelectedIndex(0);
				txtFaltas.setText("");
				cbmDisciplina.removeAllItems();
				lblMostraAluno.setText("");
				lblMostraCurso.setText("");
			}
		});

		txtRgm.setBounds(42, 8, 95, 20);
		panel_2.add(txtRgm);
		txtRgm.setColumns(10);

		lblMostraAluno = new JLabel("");
		lblMostraAluno
				.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		lblMostraAluno.setBounds(147, 8, 367, 20);
		panel_2.add(lblMostraAluno);

		lblMostraCurso = new JLabel("");
		lblMostraCurso
				.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		lblMostraCurso.setBounds(10, 36, 504, 20);
		panel_2.add(lblMostraCurso);

		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 72, 57, 14);
		panel_2.add(lblDisciplina);

		cbmDisciplina = new JComboBox();
		cbmDisciplina.setBounds(77, 68, 437, 22);
		panel_2.add(cbmDisciplina);

		lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(10, 106, 57, 14);
		panel_2.add(lblSemestre);

		cbmSemestre = new JComboBox();
		cbmSemestre.setModel(new DefaultComboBoxModel(new String[] { "2019-1", "2019-2", "2020-1", "2020-2" }));
		cbmSemestre.setBounds(77, 102, 67, 22);
		panel_2.add(cbmSemestre);

		lblNota = new JLabel("Nota");
		lblNota.setBounds(212, 106, 37, 14);
		panel_2.add(lblNota);

		cbmNota = new JComboBox();
		cbmNota.setModel(new DefaultComboBoxModel(
				new String[] { "00.0", "00.5", "01.0", "01.5", "02.0", "02.5", "03.0", "03.5", "04.0", "04.5", "05.0",
						"05.5", "06.0", "06.5", "07.0", "07.5", "08.0", "08.5", "09.0", "09.5", "10.0" }));
		cbmNota.setBounds(246, 102, 57, 22);
		panel_2.add(cbmNota);

		lblFaltas = new JLabel("Faltas");
		lblFaltas.setBounds(386, 106, 46, 14);
		panel_2.add(lblFaltas);

		txtFaltas = new JTextField();
		txtFaltas.setBounds(428, 101, 86, 20);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);

		btnSairNotasFaltas = new JButton();
		btnSairNotasFaltas.setToolTipText("Sair");
		btnSairNotasFaltas.setIcon(iconSair);
		btnSairNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnSairNotasFaltas.setBounds(10, 138, 91, 79);
		panel_2.add(btnSairNotasFaltas);

		btnSalvarNotasFaltas = new JButton();
		btnSalvarNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNotaFalta();
			}
		});
		btnSalvarNotasFaltas.setToolTipText("Salvar");
		btnSalvarNotasFaltas.setIcon(iconSalvar);
		btnSalvarNotasFaltas.setBounds(111, 138, 91, 79);
		panel_2.add(btnSalvarNotasFaltas);

		btnAlterarNotasFaltas = new JButton();
		btnAlterarNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNotaFalta();
			}
		});
		btnAlterarNotasFaltas.setToolTipText("Alterar");
		btnAlterarNotasFaltas.setIcon(iconAlterar);
		btnAlterarNotasFaltas.setBounds(212, 138, 91, 79);
		panel_2.add(btnAlterarNotasFaltas);

		btnConsultarNotasFaltas = new JButton();
		btnConsultarNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectNotaFalta();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Consutar notas e faltas");
				}
			}

		});
		btnConsultarNotasFaltas.setToolTipText("Consultar");
		btnConsultarNotasFaltas.setIcon(iconConsultar);
		btnConsultarNotasFaltas.setBounds(313, 138, 91, 79);
		panel_2.add(btnConsultarNotasFaltas);

		btnExcluirNotasFaltas = new JButton();
		btnExcluirNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNotasFalta();
			}
		});
		btnExcluirNotasFaltas.setToolTipText("Excluir");
		btnExcluirNotasFaltas.setIcon(iconExcluir);
		btnExcluirNotasFaltas.setBounds(414, 138, 91, 79);
		panel_2.add(btnExcluirNotasFaltas);

		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);

		lblRgm_2 = new JLabel("RGM");
		lblRgm_2.setBounds(10, 11, 46, 14);
		panel_3.add(lblRgm_2);

		txtRgmBoletim = new JTextField();
		txtRgmBoletim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtRgmBoletim.setText("");
				lblMostrarNomeBoletim.setText("");
				lblMostrarCursoBoletim.setText("");
				((DefaultTableModel) table.getModel()).setRowCount(0);
			}
		});
		txtRgmBoletim.setBounds(40, 8, 86, 20);
		panel_3.add(txtRgmBoletim);
		txtRgmBoletim.setColumns(10);

		lblMostrarNomeBoletim = new JLabel("");
		lblMostrarNomeBoletim
				.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		lblMostrarNomeBoletim.setBounds(234, 8, 280, 20);
		panel_3.add(lblMostrarNomeBoletim);

		lblMostrarCursoBoletim = new JLabel("");
		lblMostrarCursoBoletim
				.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		lblMostrarCursoBoletim.setBounds(10, 36, 504, 20);
		panel_3.add(lblMostrarCursoBoletim);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 504, 164);
		panel_3.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnBoletim = new JButton("Consutar");
		btnBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					daoAluno = new AlunoDAO();
					aluno = new Aluno();
					aluno = daoAluno.select(Integer.parseInt(txtRgmBoletim.getText()));
					
					daoMatricula = new MatriculaDAO();
					matricula = new Matricula();
					matricula = daoMatricula.select(Integer.parseInt(txtRgmBoletim.getText()));

					lblMostrarCursoBoletim.setText(daoCurso.selectCurso(matricula.getCursoId()).getCursoDesc());
					
					lblMostrarNomeBoletim.setText(aluno.getNomeAluno());
					daoCurso = new CursoDAO();
					daoPonderado = new PonderadoDAO();
					table.setModel(daoPonderado.boletim(Integer.parseInt(txtRgmBoletim.getText())));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar Boletim\n" + e1.getMessage());
				}
			}
		});
		btnBoletim.setBounds(136, 7, 91, 23);
		panel_3.add(btnBoletim);
	}

	public void sair() {
		System.exit(0);
	}

	public void listarCurso() {
		try {
			daoCurso = new CursoDAO();
			List<Curso> cursos = new ArrayList<Curso>();
			cursos = daoCurso.selectAll();
			for (Curso curso : cursos) {
				cbmCurso.addItem(curso);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir Cursos!");
		}
	}

	public void listarCampus() {
		try {
			daoCampus = new CampusDAO();
			List<Campus> campus = new ArrayList<Campus>();
			campus = daoCampus.selectAll();
			for (Campus campu : campus) {
				cbmCampus.addItem(campu);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir Campus!");
		}
	}

	public void listarDisciplina(int idCurso) {
		try {
			cbmDisciplina.removeAllItems();
			daoDisciplina = new DisciplinaDAO();
			List<Disciplina> disciplina = new ArrayList<Disciplina>();
			disciplina = daoDisciplina.selectDisciplinaCurso(idCurso);
			for (Disciplina disci : disciplina) {
				cbmDisciplina.addItem(disci);
			}
		} catch (Exception e) {

		}
	}

	public void salvarAluno() {
		try {
			if (txtRGM.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher RGM!");
				return;
			}
			if (txtNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher nome do aluno!");
				return;
			}
			if (txtDtaNasc.getText().equals("  /  /    ")) {
				JOptionPane.showMessageDialog(null, "Preencher Data de Nascimento!");
				return;
			}
			if (txtDtaNasc.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "Data de Nascimento Invalida!");
				return;
			}
			if (txtCpf.getText().equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Preencher CPF!");
				return;
			}
			if (txtCpf.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "CPF Invalido!");
				return;
			}
			if (txtEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher E-mail!");
				return;
			}
			if (txtEnd.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher Endereço!");
				return;
			}
			if (txtMuni.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher Municipio!");
				return;
			}
			if (txtMuni.getText().equals("(  )     -    ")) {
				JOptionPane.showMessageDialog(null, "Preencher Celular!");
				return;
			}

			if (cbmUF.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione UF!");
				return;
			}

			if (cbmCurso.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione o Curso!");
				return;
			}
			if (cbmCampus.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione o Campus");
				return;
			}
			if (btnGroupPeriodo.getSelection() == null) {
				JOptionPane.showMessageDialog(null, "Selecione o Periodo");
				return;
			}

			formatDate = new SimpleDateFormat("dd/MM/yyyy");
			formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatDate.parse(txtDtaNasc.getText());

			aluno = new Aluno();
			aluno.setNomeAluno(txtNome.getText().toUpperCase());
			aluno.setDataNscAluno(formatDateSql.format(date));
			aluno.setCpfAluno(txtCpf.getText().replaceAll("[.-]", ""));
			aluno.setEmailAluno(txtEmail.getText().toUpperCase());
			aluno.setEndAluno(txtEnd.getText().toUpperCase());
			aluno.setMuniAluno(txtMuni.getText().toUpperCase());
			aluno.setUfAluno(String.valueOf(cbmUF.getSelectedItem()));
			aluno.setCelularAluno(txtCelular.getText().replaceAll("[()-]", ""));
			daoAluno = new AlunoDAO();

			int idAluno = daoAluno.create(aluno);

			matricula = new Matricula();
			matricula.setMatriculaId(Integer.parseInt(txtRGM.getText()));
			matricula.setAlunoId(idAluno);

			Curso curso = new Curso();
			curso = (Curso) cbmCurso.getSelectedItem();
			matricula.setCursoId(curso.getCursoId());

			Campus campus = new Campus();
			campus = (Campus) cbmCampus.getSelectedItem();
			matricula.setCampusId(campus.getCampusId());

			if (rdbtnMatutino.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("MATUTINO");
				matricula.setPeriodoId(id);
			}
			if (rdbtnVespertino.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("VESPERTINO");
				matricula.setPeriodoId(id);
			}
			if (rdbtnNoturno.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("NOTURNO");
				matricula.setPeriodoId(id);
			}

			daoMatricula = new MatriculaDAO();

			if (!daoMatricula.create(matricula)) {
				JOptionPane.showMessageDialog(null, "Matricula ja Existente!");
			} else {
				JOptionPane.showMessageDialog(null, "Matricula Realizada com sucesso!");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar Aluno e sua Matricula\n " + e1.getMessage());
		}
	}

	public void selectAluno() {
		try {
			if (txtRGM.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher RGM!");
				return;
			}
			daoAluno = new AlunoDAO();
			aluno = new Aluno();
			aluno = daoAluno.select(Integer.parseInt(txtRGM.getText()));
			if (aluno != null) {
				daoMatricula = new MatriculaDAO();
				matricula = new Matricula();
				matricula = daoMatricula.select(Integer.parseInt(txtRGM.getText()));

				formatDate = new SimpleDateFormat("dd/MM/yyyy");
				formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
				Date date = formatDateSql.parse(aluno.getDataNscAluno());

				txtNome.setText(aluno.getNomeAluno().toUpperCase());
				txtDtaNasc.setText(String.valueOf(formatDate.format(date)));
				txtCpf.setText(aluno.getCpfAluno());
				txtEmail.setText(aluno.getEmailAluno().toUpperCase());
				txtEnd.setText(aluno.getEndAluno().toUpperCase());
				txtMuni.setText(aluno.getMuniAluno().toUpperCase());
				txtCelular.setText(aluno.getCelularAluno());
				cbmUF.setSelectedItem(aluno.getUfAluno());

				cbmCurso.setSelectedIndex(matricula.getCursoId());
				cbmCampus.setSelectedIndex(matricula.getCampusId());

				if (matricula.getPeriodoId() == 1) {
					rdbtnMatutino.setSelected(true);
				} else if (matricula.getPeriodoId() == 2) {
					rdbtnVespertino.setSelected(true);
				} else if (matricula.getPeriodoId() == 3) {
					rdbtnNoturno.setSelected(true);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar aluno pelo RGM\n " + e1.getMessage());
		}

	}

	public void updateAluno() {
		try {
			if (txtRGM.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher RGM!");
				return;
			}
			if (txtNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher nome do aluno!");
				return;
			}
			if (txtDtaNasc.getText().equals("  /  /    ")) {
				JOptionPane.showMessageDialog(null, "Preencher Data de Nascimento!");
				return;
			}
			if (txtDtaNasc.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "Data de Nascimento Invalida!");
				return;
			}
			if (txtCpf.getText().equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Preencher CPF!");
				return;
			}
			if (txtCpf.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "CPF Invalido!");
				return;
			}
			if (txtEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher E-mail!");
				return;
			}
			if (txtEnd.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher Endereço!");
				return;
			}
			if (txtMuni.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher Municipio!");
				return;
			}
			if (txtMuni.getText().equals("(  )     -    ")) {
				JOptionPane.showMessageDialog(null, "Preencher Celular!");
				return;
			}

			if (cbmUF.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione UF!");
				return;
			}

			if (cbmCurso.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione o Curso!");
				return;
			}
			if (cbmCampus.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Selecione o Campus");
				return;
			}
			if (btnGroupPeriodo.getSelection() == null) {
				JOptionPane.showMessageDialog(null, "Selecione o Periodo");
				return;
			}
			formatDate = new SimpleDateFormat("dd/MM/yyyy");
			formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatDate.parse(txtDtaNasc.getText());
			daoAluno = new AlunoDAO();

			aluno = new Aluno();
			int idAluno = daoAluno.returnId(Integer.parseInt(txtRGM.getText()));
			if (idAluno != 0) {
				aluno.setAlunoId(idAluno);
			} else {
				JOptionPane.showMessageDialog(null, "Aluno com esse RGM não cadastrado");
			}

			aluno.setNomeAluno(txtNome.getText().toUpperCase());
			aluno.setDataNscAluno(formatDateSql.format(date));
			aluno.setCpfAluno(txtCpf.getText().replaceAll("[.-]", ""));
			aluno.setEmailAluno(txtEmail.getText().toUpperCase());
			aluno.setEndAluno(txtEnd.getText().toUpperCase());
			aluno.setMuniAluno(txtMuni.getText().toUpperCase());
			aluno.setUfAluno(String.valueOf(cbmUF.getSelectedItem()));
			aluno.setCelularAluno(txtCelular.getText().replaceAll("[()-]", ""));

			daoAluno.update(aluno);

			matricula = new Matricula();
			matricula.setMatriculaId(Integer.parseInt(txtRGM.getText()));
			matricula.setAlunoId(idAluno);

			Curso curso = new Curso();
			curso = (Curso) cbmCurso.getSelectedItem();
			matricula.setCursoId(curso.getCursoId());

			Campus campus = new Campus();
			campus = (Campus) cbmCampus.getSelectedItem();
			matricula.setCampusId(campus.getCampusId());

			if (rdbtnMatutino.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("MATUTINO");
				matricula.setPeriodoId(id);
			}
			if (rdbtnVespertino.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("VESPERTINO");
				matricula.setPeriodoId(id);
			}
			if (rdbtnNoturno.isSelected()) {
				daoPeriodo = new PeriodoDAO();
				int id = daoPeriodo.selectIdPeriodo("NOTURNO");
				matricula.setPeriodoId(id);
			}

			daoMatricula = new MatriculaDAO();

			if (daoMatricula.update(matricula)) {
				JOptionPane.showMessageDialog(null, "Aluno e matricula Atualizado\n com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar Aluno e matricula!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar Aluno e sua Matricula!");
		}
	}

	public void deleteAluno() {
		try {
			if (txtRGM.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher RGM!");
				return;
			}
			daoAluno = new AlunoDAO();
			int idAluno = daoAluno.returnId(Integer.parseInt(txtRGM.getText()));
			if (idAluno != 0) {
				daoAluno.delete(idAluno);
				JOptionPane.showMessageDialog(null, "Aluno Deletado com Sucesso!");
				txtNome.setText("");
				txtDtaNasc.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtEnd.setText("");
				txtMuni.setText("");
				txtCelular.setText("");
				cbmUF.setSelectedItem("");

				cbmCurso.setSelectedIndex(0);
				cbmCampus.setSelectedIndex(0);

				btnGroupPeriodo.clearSelection();

			} else {
				JOptionPane.showMessageDialog(null, "Aluno com esse RGM não cadastrado");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao Excluir Aluno e sua Matricula!");
		}

	}

	public void selectNotaFalta() {
		try {
			if (txtRgm.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencher RGM!");
				return;
			}
			daoAluno = new AlunoDAO();
			aluno = new Aluno();
			daoCurso = new CursoDAO();
			daoPonderado = new PonderadoDAO();
			ponderado = new Ponderado();

			aluno = daoAluno.select(Integer.parseInt(txtRgm.getText()));
			if (aluno != null) {
				daoMatricula = new MatriculaDAO();
				matricula = new Matricula();
				matricula = daoMatricula.select(Integer.parseInt(txtRgm.getText()));

				lblMostraAluno.setText(aluno.getNomeAluno().toUpperCase());

				lblMostraCurso.setText(daoCurso.selectCurso(matricula.getCursoId()).getCursoDesc());

				if (cbmDisciplina.getItemCount() == 0) {
					listarDisciplina(matricula.getCursoId());
				}
				disciplina = new Disciplina();
				disciplina = (Disciplina) cbmDisciplina.getSelectedItem();

				ponderado = daoPonderado.select(Integer.parseInt(txtRgm.getText()), disciplina.getDisciplinaId());

				if (ponderado != null) {
					cbmSemestre.setSelectedItem(ponderado.getSemestre());

					cbmNota.setSelectedItem(ponderado.getNota());

					txtFaltas.setText(String.valueOf(ponderado.getFalta()));
				} else {
					cbmSemestre.setSelectedIndex(0);

					cbmNota.setSelectedIndex(0);

					txtFaltas.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Notas do aluno pelo RGM\n " + e1.getMessage());
		}

	}

	public void createNotaFalta() {
		try {
			ponderado = new Ponderado();

			ponderado.setMatriculaId(Integer.parseInt(txtRgm.getText()));

			disciplina = new Disciplina();
			disciplina = (Disciplina) cbmDisciplina.getSelectedItem();
			ponderado.setDisciplinaId(disciplina.getDisciplinaId());
			ponderado.setNota(String.valueOf(cbmNota.getSelectedItem()));
			ponderado.setFalta(Integer.parseInt(txtFaltas.getText()));
			ponderado.setSemestre(String.valueOf(cbmSemestre.getSelectedItem()));

			daoPonderado = new PonderadoDAO();

			daoPonderado.create(ponderado);
			JOptionPane.showMessageDialog(null,
					"Notas e Faltas gravado com sucesso para\n" + disciplina.getDisciplinaDesc());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao gravar Nota e Faltas da Disciplina\n"
					+ disciplina.getDisciplinaDesc() + "\n" + e.getMessage());
		}
	}

	public void updateNotaFalta() {
		try {
			ponderado = new Ponderado();

			ponderado.setMatriculaId(Integer.parseInt(txtRgm.getText()));

			disciplina = new Disciplina();
			disciplina = (Disciplina) cbmDisciplina.getSelectedItem();
			ponderado.setDisciplinaId(disciplina.getDisciplinaId());
			ponderado.setNota(String.valueOf(cbmNota.getSelectedItem()));
			ponderado.setFalta(Integer.parseInt(txtFaltas.getText()));
			ponderado.setSemestre(String.valueOf(cbmSemestre.getSelectedItem()));

			daoPonderado = new PonderadoDAO();

			daoPonderado.update(ponderado);
			JOptionPane.showMessageDialog(null,
					"Nota e Faltas alteradas com sucesso para\n" + disciplina.getDisciplinaDesc());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Nota e Faltas da Disciplina\n"
					+ disciplina.getDisciplinaDesc() + "\n" + e.getMessage());
		}
	}

	public void deleteNotasFalta() {
		try {

			disciplina = new Disciplina();
			disciplina = (Disciplina) cbmDisciplina.getSelectedItem();

			daoPonderado = new PonderadoDAO();
			daoPonderado.delete(Integer.parseInt(txtRgm.getText()), disciplina.getDisciplinaId());
			JOptionPane.showMessageDialog(null,
					"Nota e Faltas Deletadas com sucesso para\n" + disciplina.getDisciplinaDesc());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Nota e Faltas da Disciplina\n"
					+ disciplina.getDisciplinaDesc() + "\n" + e.getMessage());
		}
	}
}
