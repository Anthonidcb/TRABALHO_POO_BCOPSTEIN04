package com.anthoni;

import java.util.Scanner;

public class App {
     
    // main para o exercício da classe ContaCorrente
    public static void main(String[] args) {
        AgenciaBancaria ag = new AgenciaBancaria(5142,"Agencia ACME");
        ag.cadastrarConta(new ContaCorrente(100,"Huguinho"));
        ag.cadastrarConta(new ContaCorrente(105,"Zezinho"));
        ag.cadastrarConta(new ContaCorrente(110,"Luizinho"));
        ag.cadastrarConta(new ContaCorrente(115,"Pikachu"));

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.print("\nDigite o número da conta: ");
            int numeroConta = scanner.nextInt();
            ContaCorrente conta = ag.recuperarConta(numeroConta);

            if (conta == null) {
                System.out.println("Conta não encontrada.");
                continue;
            }

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Retirada");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Consultar extrato");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.deposita(valorDeposito);
                    System.out.println("Depósito realizado. Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Valor para retirar: ");
                    double valorRetirada = scanner.nextDouble();
                    try {
                        conta.saca(valorRetirada);
                        System.out.println("Retirada realizada. Saldo atual: " + conta.getSaldo());
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar retirada: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Extrato da conta:");
                    for (EntradaExtrato entrada : conta.getExtrato()) {
                        System.out.println(entrada);
                    }
                    System.out.println("Saldo atual: "+conta.getSaldo());
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }    
}
