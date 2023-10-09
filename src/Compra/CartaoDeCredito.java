package Compra;

import Compra.Compra;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double saldo;
    private double limite;
    private List<Compra> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }
    public boolean aprovaCompra(Compra compraAtual){
        if(compraAtual.getValor() > this.getSaldo()){
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            this.saldo -= compraAtual.getValor();
            this.compras.add(compraAtual);
            String respota = String.format("Compra realizada. Saldo atual: R$%.2f", this.getSaldo());
            System.out.println(respota);
            return true;
        }
    }

}
