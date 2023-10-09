package Principal;
import Compra.CartaoDeCredito;
import Compra.Compra;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartao:");
        double limite = scanner.nextDouble();

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);
        double valorTotal = 0.0;

        int opcao = 1;
        while (opcao != 0){
            System.out.println("Digite o produto a comprar:");
            String produto = scanner.nextLine();
            produto = scanner.nextLine(); //

            System.out.println("Digite o valor:");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(produto, valor);
            boolean compraRealizada = cartaoDeCredito.aprovaCompra(compra);

            if(compraRealizada == true) {
                valorTotal += valor;
                if(cartaoDeCredito.getSaldo() <= 0){
                    opcao = 0;
                } else {
                    System.out.println("Para continuar comprando, digite 1. Para sair digite 0");
                    opcao = scanner.nextInt();
                }
            } else {
                opcao = 0;
            }
        }

        if(cartaoDeCredito.getCompras().isEmpty()){
            System.out.println("Nenhuma compra realizada.");
        } else {
            System.out.println("\nCompras realizadas:");
            Collections.sort(cartaoDeCredito.getCompras());
            for (Compra compra : cartaoDeCredito.getCompras()) {
                System.out.println(compra.toString());
            }
        }
        System.out.printf("\nValor total: R$%.2f", valorTotal);
    }
}
