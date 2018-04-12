package com.up.clinicavet.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import com.up.clinicavet.model.Animal;

public class ViewPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnAnimais = new JButton("Animais");
	private JButton btnEspecies = new JButton("Espécies");
	private JButton btnVoltar = new JButton("Voltar");
	private JPanel conteudoMenuPrincipal;
	private JPanel conteudoManutencaoAnimais;
	private JTable tabelaAnimais;
	private ExibicaoAnimais modeloExibicaoAnimaisTabela;
	
	public ViewPrincipal() {
		conteudoMenuPrincipal = new JPanel();

		SpringLayout layout = new SpringLayout();

		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);

		layout.putConstraint(SpringLayout.WEST, btnAnimais, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 5, SpringLayout.NORTH, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.WEST, btnEspecies, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 40, SpringLayout.NORTH, conteudoMenuPrincipal);

		this.setTitle("Clínica Veterinária");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exibirTelaInicial();
				
		//segunda parte da aula
		modeloExibicaoAnimaisTabela = new ExibicaoAnimais();
		tabelaAnimais = new JTable(modeloExibicaoAnimaisTabela);
		conteudoManutencaoAnimais = new JPanel();
		SpringLayout layoutManutencaoAnimais = new SpringLayout();
		conteudoManutencaoAnimais.setLayout(layoutManutencaoAnimais);
		conteudoManutencaoAnimais.add(tabelaAnimais);
		conteudoManutencaoAnimais.add(btnVoltar);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, tabelaAnimais, 5, SpringLayout.WEST,
		conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, btnVoltar, 300, SpringLayout.WEST,
		conteudoManutencaoAnimais);
		}

	private void exibirTelaInicial() {
		this.setPreferredSize(new Dimension(500, 500));
		this.setContentPane(conteudoMenuPrincipal);
		this.pack();
		
	}
	
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
		}
	
	public void addBtnAnimaisListener(ActionListener animaisListener) {

		btnAnimais.addActionListener(animaisListener);
		}
	
	public void exibirTelaAnimais(List<Animal> animaisParaExibir) {
		modeloExibicaoAnimaisTabela.setAnimaisTabela(animaisParaExibir);
		this.setPreferredSize(new Dimension(400, 400));
		this.setContentPane(conteudoManutencaoAnimais);
		this.pack();
		}

	public void addBtnVoltarListener(ActionListener voltarListener) {
		btnVoltar.addActionListener(voltarListener);
	}
}

