package Model;

import main.ApplicationConfig;

public class Carro {

    public Carro(String renavan, String modelo, String cor, int ano, double preco, boolean vendido) {
        this.id = ApplicationConfig.CONTADOR_ID;
        ApplicationConfig.CONTADOR_ID++;
        this.renavan = renavan;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.vendido = vendido;
    }
    
    
    private int id;
    private String renavan;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;
    private boolean vendido;

    public int getId() {
        return id;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    
    
}
