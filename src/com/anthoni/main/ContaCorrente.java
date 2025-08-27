package com.anthoni;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContaCorrente{
    private int numero;
    private String correntista;
    private double saldo;
    private boolean ativa;
    private ArrayList<EntradaExtrato> extrato;

    public ContaCorrente(int numero, String correntista) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número da conta não pode ser negativo.");
        }
        if (correntista == null || correntista.length() < 2) {
            throw new IllegalArgumentException("Correntista não pode ser nulo e deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = 0.0;
        this.ativa = true;
        extrato = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getCorrentista() {
        return correntista;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<EntradaExtrato> getExtrato(){
        return extrato;
    }
    
    public boolean isAtiva() {
        return ativa;
    }

    public void deposita(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
        extrato.add(new EntradaExtrato(LocalDateTime.now(), TipoOperacao.DEPOSITO, valor));
    }

    public void saca(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        extrato.add(new EntradaExtrato(LocalDateTime.now(), TipoOperacao.RETIRADA, valor));
    }

    public void transfere(double valor, ContaCorrente contaDestino) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        extrato.add(new EntradaExtrato(LocalDateTime.now(), TipoOperacao.RETIRADA, valor));
        contaDestino.deposita(valor);
    }

    public void fecha() {
        ativa = false;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", correntista='" + correntista + '\'' +
                ", saldo=" + saldo +
                ", ativa=" + ativa +
                '}';
    }
}