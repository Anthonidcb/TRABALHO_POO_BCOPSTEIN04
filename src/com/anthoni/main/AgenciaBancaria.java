package com.anthoni;

import java.util.ArrayList;

public class AgenciaBancaria {
    private static final int MAXCONTAS = 100;
    private int numero;
    private String nome;
    private ArrayList<ContaCorrente> contas;

    public AgenciaBancaria(int numero, String nome) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da agência deve ser positivo.");
        }
        if (nome == null || nome.length() < 2) {
            throw new IllegalArgumentException("Nome da agência deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(ContaCorrente conta) {
        if (contas.size() >= MAXCONTAS) {
            throw new IllegalStateException("Limite máximo de contas atingido.");
        }
        for (ContaCorrente c : contas) {
            if (c.getNumero() == conta.getNumero()) {
                throw new IllegalArgumentException("Já existe uma conta com esse número.");
            }
        }
        contas.add(conta);
    }

    public ContaCorrente recuperarConta(int numeroConta) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void encerrarConta(int numeroConta) {
        ContaCorrente conta = recuperarConta(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        if (!conta.isAtiva()) {
            throw new IllegalStateException("Conta já está encerrada.");
        }
        conta.fecha();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
}