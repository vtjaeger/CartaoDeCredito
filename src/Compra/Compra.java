package Compra;

import java.util.Collections;

public class Compra implements Comparable<Compra> {
    private String produto;
    private double valor;

    public Compra(String produto, double valor) {
        this.produto = produto;
        this.valor = valor;
    }

    //PARA COMECAR COM LIMITE:
    //alterar no main: sem argumento, tirar sout de limite
//    public CartaoDeCredito() {
//        this.saldo = 200;
//        this.compras = new ArrayList<>();
//    }

    public String getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s no valor de R$%.2f.", getProduto(), getValor());
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valor).compareTo(outraCompra.valor);
    }
}
