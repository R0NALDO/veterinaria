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
		//itens da tela principal
	private JButton btnAnimais = new JButton("Animais");
	private JButton btnEspecies = new JButton("Esp�cies");
	private JPanel conteudoMenuPrincipal;
		//itens da janela de animais
	private JButton btnVoltar = new JButton("Voltar");
	private JPanel conteudoManutencaoAnimais;
	private ExibicaoAnimais modeloExibicaoAnimaisTabela;
	private JTable tabelaAnimais;
	
	public ViewPrincipal() {
		conteudoMenuPrincipal = new JPanel();

		SpringLayout layout = new SpringLayout();

		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);

		//ajuste o componente btnAnimais 5 pixels (a direitaa) do painel principal (�ncora oeste)
		layout.putConstraint(SpringLayout.WEST, btnAnimais, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		//ajuste o componente btnAnimais 5 pixels (abaixo) do painel principal (�ncora norte)
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 5, SpringLayout.NORTH, conteudoMenuPrincipal);
		//ajuste o componente btnEspecies 5 pixels (a direita) do painel principal (�ncora oeste)
		layout.putConstraint(SpringLayout.WEST, btnEspecies, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		//ajuste o componente btnAnimais 40 pixels (abaixo) do painel principal (�ncora oeste)
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 40, SpringLayout.NORTH, conteudoMenuPrincipal);

		//caso queiram ajustar o tamanho da janela de acordo com as posi��es relativas dos componentes
		//ajuste o tamano do conte�do principal de acordo com a borda sul do bot�o esp�cies
		//layout.putConstraint(SpringLayout.SOUTH, content, 5, SpringLayout.SOUTH, btnEspecies);
		//ajuste o tamano do conte�do principal de acordo com a borda leste do bot�o esp�cies
		//layout.putConstraint(SpringLayout.EAST, content, 5, SpringLayout.EAST, btnAnimais);


		this.setTitle("Cl�nica Veterin�ria UP");
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
		// tamanho inicial da janela em pixels
		this.setPreferredSize(new Dimension(120, 120));
		// seta o conte�do do painel atual (JFrame) como o JPAnel content rec�m criado
		this.setContentPane(conteudoMenuPrincipal);
		this.pack();// Ajusta o conte�do (content) para o JFrame (ex.: ajuste de resolu��o)
		
	}
	
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
		}
	
	public void addBtnAnimaisListener(ActionListener animaisListener) {

		btnAnimais.addActionListener(animaisListener);
		}
	
	public void exibirTelaAnimais(List<Animal> animaisParaExibir) {
		modeloExibicaoAnimaisTabela.setAnimaisTabela(animaisParaExibir);
		// tamanho inicial da janela em pixels
		this.setPreferredSize(new Dimension(400, 400));
		this.setContentPane(conteudoManutencaoAnimais);
		this.pack();
		}

	public void addBtnVoltarListener(ActionListener voltarListener) {
		btnVoltar.addActionListener(voltarListener);
	}
}

