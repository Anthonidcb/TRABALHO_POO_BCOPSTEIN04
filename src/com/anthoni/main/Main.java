package com.anthoni;

public class Main {
    public static void main(String[] args) {
        AgenciaBancaria agencia = new AgenciaBancaria(1, "Central");

        ContaCorrente conta1 = new ContaCorrente(101, "João");
        ContaCorrente conta2 = new ContaCorrente(102, "Maria");

        agencia.cadastraConta(conta1);
        agencia.cadastraConta(conta2);

        conta1.deposita(500);
        conta2.deposita(300);

        conta1.transfere(200, conta2);

        System.out.println(agencia.recuperaConta(101));
        System.out.println(agencia.recuperaConta(102));

        agencia.encerraConta(101);
        System.out.println(agencia.recuperaConta(101));
    }
}