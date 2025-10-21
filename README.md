#  FleetVision-Predict - Sistema de Previsão de Frota Veicular

Sistema avançado de previsão de frota veicular utilizando **modelos de regressão semi-supervisionada** para projeções anuais precisas.  
Desenvolvido com **Java Spring Boot** e **Thymeleaf**, oferece **análises preditivas** baseadas em dados históricos de **2006–2024**.

---

##  Funcionalidades Principais

###  Múltiplos Modelos de Regressão
- **Regressão Linear Simples**
- **Regressão Polinomial Simples** (Graus 2–5)
- **Regressão Polinomial Múltipla** (Graus 2–5)

###  Projeções Anuais Detalhadas
- Previsão de frota veicular até **2050**
- Cálculo de **diferenças e variações percentuais**
- **Visualização em tabela dinâmica**

###  Base de Dados Histórica
- Dados consolidados de **2006–2024**
- Análise de **tendências e crescimento**
- Interface intuitiva para **comparações**

---

## 🧰 Tecnologias Utilizadas

**Backend:**  
- Java 25  
- Spring Boot 3  
- Spring MVC  

**Frontend:**  
- Thymeleaf  
- HTML5, CSS3, JavaScript  

**Arquitetura:**   
- DTO Pattern  
- Service Layer  

**Ferramentas:**  
- Maven  
- Lombok  
- Spring Boot DevTools  

---

##  Características Técnicas

- Padronização de código com prefixo **`PVLS_`**
- Tratamento de **exceções robusto**
- Interface **responsiva e moderna**
- Cálculos matemáticos precisos baseados em **dados reais**
- Sistema de **abas** para melhor organização

---

##  Aplicação Acadêmica

Projeto desenvolvido para demonstração de:

- Aplicação de **modelos de regressão** em problemas reais  
- **Desenvolvimento web** com Spring Boot  
- **Análise preditiva** de séries temporais  
- Boas práticas de **padronização de código**

---

###  Exemplo de Uso (opcional)
```bash
# Clonar repositório
git clone https://github.com/seu-usuario/FleetVision-Predict.git

# Entrar no diretório
cd FleetVision-Predict

# Executar o projeto
mvn spring-boot:run
