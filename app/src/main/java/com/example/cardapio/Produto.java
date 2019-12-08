package com.example.cardapio;

import android.widget.ImageView;

public class Produto {

    private String nome;

    private String descricao;

    private double preco;

    private ImageView foto;

    public int imagens[] = {R.drawable.xburguer, R.drawable.xbacon, R.drawable.xtudo, R.drawable.xsalada};



    public static final Produto[] produtos = {
            new Produto ("X Burguer", "Pão, maionese, queijo, presunto, hambúrguer", 10.00),
            new Produto ("X Bacon", "Pão, maionese, queijo, presunto, alface, tomate, hambúrguer, bacon", 13.00 ),
            new Produto ("X Tudo", "Pão, maionese, queijo, presunto, alface, hambúrguer, bacon, tomate, ovo frito, calabresa, picles", 16.00),
            new Produto ("X Salada", "Pão, maionese, queijo, presunto, alface, tomate, hambúrguer", 12.00)
    };


    public Produto() {
    }

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int[] getImagens() {
        return imagens;
    }

    public void setImagens(int[] imagens) {
        this.imagens = imagens;
    }

    public Produto(ImageView foto) {
        this.foto = foto;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
