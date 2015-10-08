package com.jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.jsf.model.Produto;

@ManagedBean(name="gp")
@SessionScoped
public class GestaoProdutos implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", "Produto cadastrado com sucesso"));
	}
	public void editar(Produto produto){
		getProdutos().get(getProdutos().indexOf(produto)).setNome(produto.getNome());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto Alterado!", "Produto Alterado com sucesso"));
		
	}
	
	
	public Produto getProduto() {
		return produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
