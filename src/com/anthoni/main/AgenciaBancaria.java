package com.anthoni;

import java.util.ArrayList;
import java.util.List;

public class AgenciaBancaria {
    private int numero;
    private String nome;
    private List<ContaCorrente> contas;

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

    public void cadastraConta(ContaCorrente conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta inválida.");
        }
        for (ContaCorrente c : contas) {
            if (c.getNumero() == conta.getNumero()) {
                throw new IllegalArgumentException("Já existe uma conta com este número.");
            }
        }
        contas.add(conta);
    }

    public ContaCorrente recuperaConta(int numeroConta) {
        for (ContaCorrente c : contas) {
            if (c.getNumero() == numeroConta) {
                return c;
            }
        }
        return null;
    }

    public void encerraConta(int numeroConta) {
        ContaCorrente conta = recuperaConta(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        if (!conta.isAtiva()) {
            throw new IllegalStateException("A conta já está encerrada.");
        }
        conta.fecha();
    }

    @Override
    public String toString() {
        return "AgenciaBancaria{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", contas=" + contas.size() +
                '}';
    }
}