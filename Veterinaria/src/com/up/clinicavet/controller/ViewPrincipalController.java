package com.up.clinicavet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.up.clinicavet.view.ViewPrincipal;

public class ViewPrincipalController {
	
	private ViewPrincipal view;

	public ViewPrincipalController(ViewPrincipal view) {
	this.view = view;
	this.view.addBtnAnimaisListener(new BtnAnimaisListener());

	}

	private class BtnAnimaisListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	view.showError("Exibindo um erro de teste");
	}
	
	}
}
