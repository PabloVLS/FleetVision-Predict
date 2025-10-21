package com.fv.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fv.demo.dto.PVLS_ProjecaoAnualDTO;
import com.fv.demo.dto.PVLS_ResultadoPrevisaoDTO;
import com.fv.demo.services.PVLS_PrevisaoService;

import org.springframework.ui.Model;

@Controller
public class PVLS_PrevisaoController {

    @Autowired
    private PVLS_PrevisaoService previsaoService; 

    @GetMapping("/")
    public String PVLS_home(Model model) {
        model.addAttribute("resultados", new PVLS_ResultadoPrevisaoDTO());
        model.addAttribute("projecao", new ArrayList<PVLS_ProjecaoAnualDTO>());
        return "index";
    }

    @PostMapping("/calcular-previsao")
    public String PVLS_calcularPrevisao(
            @RequestParam String tipoRegressao,
            @RequestParam(required = false) Integer grauPolinomio,
            @RequestParam Integer anoAlvo,
            Model model) {

        try {
            String PVLS_tipoRegressao = tipoRegressao;
            Integer PVLS_grauPolinomio = grauPolinomio;
            Integer PVLS_anoAlvo = anoAlvo;

            if ("linear".equals(PVLS_tipoRegressao)) {
                PVLS_grauPolinomio = null;
            }

            PVLS_ResultadoPrevisaoDTO PVLS_resultados = previsaoService.PVLS_calcular(PVLS_tipoRegressao,
                    PVLS_grauPolinomio, PVLS_anoAlvo);
            List<PVLS_ProjecaoAnualDTO> PVLS_projecao = previsaoService.PVLS_gerarProjecao(PVLS_anoAlvo,
                    PVLS_tipoRegressao, PVLS_grauPolinomio);

            model.addAttribute("resultados",
                    PVLS_resultados != null ? PVLS_resultados : new PVLS_ResultadoPrevisaoDTO());
            model.addAttribute("projecao",
                    PVLS_projecao != null ? PVLS_projecao : new ArrayList<PVLS_ProjecaoAnualDTO>());

        } catch (Exception PVLS_e) {
            System.err.println("Erro ao calcular previsão: " + PVLS_e.getMessage());
            PVLS_e.printStackTrace();
            model.addAttribute("resultados", new PVLS_ResultadoPrevisaoDTO());
            model.addAttribute("projecao", new ArrayList<PVLS_ProjecaoAnualDTO>());
        }

        return "index";
    }
}