package com.jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.jsf.model.Produto;

@ManagedBean(name="gp")
@SessionScoped
public class GestaoProdutos implements Serializable{
	
	private Produto produto;
	private List<Produto> produtos;
	
	public GestaoProdutos(){
		produto = new Produto();
		produtos = new ArrayList<Produto>();
	}
	
	public String obterAjuda(){
		if(this.produtos.isEmpty()){
			return "ajudaProduto?faces-redirect=true";
		}else
			return "ajudaProdutoTelefone?faces-redirect=true";
	}
	
	
	public void verificarFabricante(ActionEvent event){
		if(this.produto.getFabricante().isEmpty()){
			this.produto.setFabricante("Sem Fabricante");
		}
	}
	public void cadastrar(){
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	public Produto getProduto() {
		return produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
