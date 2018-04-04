package com.up.clinicavet.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ViewPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton btnAnimais = new JButton("Animais");
	private JButton btnEspecies = new JButton("Espécies");
	private JPanel conteudoMenuPrincipal;
	
	public ViewPrincipal() {
		conteudoMenuPrincipal = new JPanel();

		SpringLayout layout = new SpringLayout();

		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);

		//ajuste o componente btnAnimais 5 pixels (a direita) do painel principal (âncora oeste)
		layout.putConstraint(SpringLayout.WEST, btnAnimais, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		//ajuste o componente btnAnimais 5 pixels (abaixo) do painel principal (âncora norte)
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 5, SpringLayout.NORTH, conteudoMenuPrincipal);
		//ajuste o componente btnEspecies 5 pixels (a direita) do painel principal (âncora oeste)
		layout.putConstraint(SpringLayout.WEST, btnEspecies, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		//ajuste o componente btnAnimais 40 pixels (abaixo) do painel principal (âncora oeste)
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 40, SpringLayout.NORTH, conteudoMenuPrincipal);

		//caso queiram ajustar o tamanho da janela de acordo com as posições relativas dos componentes
		//ajuste o tamano do conteúdo principal de acordo com a borda sul do botão espécies
		//layout.putConstraint(SpringLayout.SOUTH, content, 5, SpringLayout.SOUTH, btnEspecies);
		//ajuste o tamano do conteúdo principal de acordo com a borda leste do botão espécies
		//layout.putConstraint(SpringLayout.EAST, content, 5, SpringLayout.EAST, btnAnimais);


		this.setTitle("Clínica Veterinária UP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exibirTelaInicial();
		}

	private void exibirTelaInicial() {
		// tamanho inicial da janela em pixels
		this.setPreferredSize(new Dimension(120, 120));
		// seta o conteúdo do painel atual (JFrame) como o JPAnel content recém criado
		this.setContentPane(conteudoMenuPrincipal);
		this.pack();// Ajusta o conteúdo (content) para o JFrame (ex.: ajuste de resolução)
		
	}
}

