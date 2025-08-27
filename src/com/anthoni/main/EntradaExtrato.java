package com.anthoni;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EntradaExtrato {
    private LocalDateTime dataHora;
    private TipoOperacao tipoOperacao;
    private double valor;
    
    public EntradaExtrato(LocalDateTime dataHora, TipoOperacao tipoOperacao, double valor) {
        this.dataHora = dataHora;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("pt").setRegion("BR").build());
        sb.append("{");
        sb.append(dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        sb.append(" <").append(tipoOperacao).append(">");
        sb.append(" ").append(nf.format(valor));
        sb.append('}');
        return sb.toString();
    }
    
    
}
