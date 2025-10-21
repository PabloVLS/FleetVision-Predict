package com.fv.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PVLS_ResultadoPrevisaoDTO {
    private Integer PVLS_anoAlvo;
    private Double PVLS_frotaPrevista;
    private Double PVLS_diferenca;
    private Double PVLS_variacao;
    private String PVLS_tipoModelo;
    private Integer PVLS_grauPolinomio;

    public String getPVLS_tipoModeloFormatado() {
        switch(PVLS_tipoModelo) {
            case "linear": return "Linear Simples";
            case "poly-simple": return "Polinomial Simples";
            case "poly-multiple": return "Polinomial Múltipla";
            default: return PVLS_tipoModelo;
        }
    }
}