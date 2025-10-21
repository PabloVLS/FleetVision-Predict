package com.fv.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fv.demo.dto.PVLS_ProjecaoAnualDTO;
import com.fv.demo.dto.PVLS_ResultadoPrevisaoDTO;

@Service
public class PVLS_PrevisaoService {

    public PVLS_ResultadoPrevisaoDTO PVLS_calcular(String PVLS_tipoRegressao, Integer PVLS_grauPolinomio, Integer PVLS_anoAlvo) {
        PVLS_ResultadoPrevisaoDTO PVLS_resultado = new PVLS_ResultadoPrevisaoDTO();
        PVLS_resultado.setPVLS_anoAlvo(PVLS_anoAlvo);
        PVLS_resultado.setPVLS_tipoModelo(PVLS_tipoRegressao);
        PVLS_resultado.setPVLS_grauPolinomio(PVLS_grauPolinomio);

        // Cálculo da frota para o ano alvo
        Double PVLS_frotaAlvo = PVLS_calcularFrota(PVLS_anoAlvo, PVLS_tipoRegressao, PVLS_grauPolinomio);
        PVLS_resultado.setPVLS_frotaPrevista(PVLS_frotaAlvo);

        // Cálculo da frota para o ano anterior
        Double PVLS_frotaAnterior = PVLS_calcularFrota(PVLS_anoAlvo - 1, PVLS_tipoRegressao, PVLS_grauPolinomio);

        // Calculo diferença e variação
        Double PVLS_diferenca = PVLS_frotaAlvo - PVLS_frotaAnterior;
        Double PVLS_variacao = (PVLS_diferenca / PVLS_frotaAnterior) * 100;

        PVLS_resultado.setPVLS_diferenca(PVLS_diferenca);
        PVLS_resultado.setPVLS_variacao(PVLS_variacao);

        return PVLS_resultado;
    }

    public List<PVLS_ProjecaoAnualDTO> PVLS_gerarProjecao(Integer PVLS_anoAlvo, String PVLS_tipoRegressao, Integer PVLS_grauPolinomio) {
        List<PVLS_ProjecaoAnualDTO> PVLS_projecao = new ArrayList<>();

        Double PVLS_frota2024 = 74942.0; 
        Double PVLS_frota2023 = 71264.0; 
        Double PVLS_diferenca2023_2024 = 3678.0; 

        Double PVLS_frotaAnterior = PVLS_frota2024;

        for (int PVLS_ano = 2025; PVLS_ano <= PVLS_anoAlvo; PVLS_ano++) {
            Double PVLS_frotaAtual;

            if ("poly-multiple".equals(PVLS_tipoRegressao)) {
                // Pra polinomial múltipla, usa a diferença do período anterior
                Double PVLS_diferencaUsar = (PVLS_ano == 2025)? PVLS_diferenca2023_2024 : PVLS_projecao.get(PVLS_projecao.size() - 1).getPVLS_diferenca();

                PVLS_frotaAtual = PVLS_calcularFrotaPolinomialMultipla(PVLS_ano, PVLS_diferencaUsar, PVLS_grauPolinomio);
            } else {
                PVLS_frotaAtual = PVLS_calcularFrota(PVLS_ano, PVLS_tipoRegressao, PVLS_grauPolinomio);
            }

            Double PVLS_diferenca = PVLS_frotaAtual - PVLS_frotaAnterior;
            Double PVLS_variacao = (PVLS_diferenca / PVLS_frotaAnterior) * 100;

            PVLS_ProjecaoAnualDTO PVLS_proj = new PVLS_ProjecaoAnualDTO();
            PVLS_proj.setPVLS_ano(PVLS_ano);
            PVLS_proj.setPVLS_frota(PVLS_frotaAtual);
            PVLS_proj.setPVLS_diferenca(PVLS_diferenca);
            PVLS_proj.setPVLS_variacao(PVLS_variacao);

            PVLS_projecao.add(PVLS_proj);
            PVLS_frotaAnterior = PVLS_frotaAtual;
        }

        return PVLS_projecao;
    }

    private Double PVLS_calcularFrota(Integer PVLS_ano, String PVLS_tipoRegressao, Integer PVLS_grauPolinomio) {
        switch (PVLS_tipoRegressao) {
            case "linear":
                return PVLS_calcularFrotaLinear(PVLS_ano);
            case "poly-simple":
                return PVLS_calcularFrotaPolinomialSimples(PVLS_ano, PVLS_grauPolinomio);
            case "poly-multiple":
                Double PVLS_diferencaPadrao = 2797.5; 
                return PVLS_calcularFrotaPolinomialMultipla(PVLS_ano, PVLS_diferencaPadrao, PVLS_grauPolinomio);
            default:
                throw new IllegalArgumentException("Tipo de regressão não suportado: " + PVLS_tipoRegressao);
        }
    }

    private Double PVLS_calcularFrotaLinear(Integer PVLS_ano) {
        return (2730.363158 * PVLS_ano) - 5450985.711;
    }

    private Double PVLS_calcularFrotaPolinomialSimples(Integer PVLS_ano, Integer PVLS_grau) {
        double PVLS_a = PVLS_ano;
        if (PVLS_grau == 2) {

            return (-27.60511573 * PVLS_a * PVLS_a) + (113978.9796 * PVLS_a) - 117533138.6;
        
        } else if (PVLS_grau == 3) {

            return (1.048476248 * PVLS_a * PVLS_a * PVLS_a) + (-6365.644037 * PVLS_a * PVLS_a) + (12885071.0 * PVLS_a) - 8695374170.0;
        
        } else if (PVLS_grau == 4) {

            return (1.0e-12 * PVLS_a * PVLS_a * PVLS_a * PVLS_a)+ (1.048476248 * PVLS_a * PVLS_a * PVLS_a)+ (-6365.644037 * PVLS_a * PVLS_a)+ (12885071.0 * PVLS_a)- 8695374170.0;
        
        } else if (PVLS_grau == 5) {

            return (1.0e-14 * PVLS_a * PVLS_a * PVLS_a * PVLS_a * PVLS_a)+ (1.0e-11 * PVLS_a * PVLS_a * PVLS_a * PVLS_a)+ (1.048476248 * PVLS_a * PVLS_a * PVLS_a)+ (-6365.644037 * PVLS_a * PVLS_a)+ (12885071.0 * PVLS_a)- 8695374170.0;
        
        } else {
            throw new IllegalArgumentException("Grau polinomial não suportado: " + PVLS_grau);
        }
    }

    private Double PVLS_calcularFrotaPolinomialMultipla(Integer PVLS_ano, Double PVLS_diferenca, Integer PVLS_grau) {
        double PVLS_a = PVLS_ano;
        double PVLS_d = PVLS_diferenca;

        if (PVLS_grau == 2) {

            return (-32.88733608 * PVLS_a * PVLS_a) + (135298.527 * PVLS_a) + (-0.0000314346 * PVLS_d * PVLS_d) + (0.909919494 * PVLS_d)- 139047186.2;
        
        } else if (PVLS_grau == 3) {

            return (0.077724063 * PVLS_a * PVLS_a * PVLS_a) + (-502.5976671 * PVLS_a * PVLS_a) + (1081489.735 * PVLS_a)+ (-0.0000000122861 * PVLS_d * PVLS_d * PVLS_d) + (0.000344429 * PVLS_d * PVLS_d) + (-0.913312487 * PVLS_d) - 774378511.0;
        
        } else if (PVLS_grau == 4) {

            return Math.pow(PVLS_a, 4) * 1.0e-12+ (0.077724063 * PVLS_a * PVLS_a * PVLS_a)+ (-502.5976671 * PVLS_a * PVLS_a)+ (1081489.735 * PVLS_a)+ Math.pow(PVLS_d, 4) * 1.0e-12+ (-0.0000000122861 * PVLS_d * PVLS_d * PVLS_d)+ (0.000344429 * PVLS_d * PVLS_d)+ (-0.913312487 * PVLS_d)- 774378511.0;
        
        } else if (PVLS_grau == 5) {

            return Math.pow(PVLS_a, 5) * 1.0e-15+ Math.pow(PVLS_a, 4) * 1.0e-12+ (0.077724063 * PVLS_a * PVLS_a * PVLS_a)+ (-502.5976671 * PVLS_a * PVLS_a)+ (1081489.735 * PVLS_a)+ Math.pow(PVLS_d, 5) * 1.0e-15+ Math.pow(PVLS_d, 4) * 1.0e-12+ (-0.0000000122861 * PVLS_d * PVLS_d * PVLS_d)+ (0.000344429 * PVLS_d * PVLS_d)+ (-0.913312487 * PVLS_d)- 774378511.0;
        
        } else {

            throw new IllegalArgumentException("Grau polinomial múltiplo não suportado: " + PVLS_grau);
        
        }
    }
}