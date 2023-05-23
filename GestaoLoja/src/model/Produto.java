/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author jdelgado
 */
public class Produto {
	
	private int id;
	private String nome;
	private String desc;
	private int qtd;
	private double preco;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd2) {
		this.qtd = qtd2;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco2) {
		this.preco = preco2;
	}
	
}
