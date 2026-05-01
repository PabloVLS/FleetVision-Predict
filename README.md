<div align="center">

![FleetVision](https://img.shields.io/badge/FleetVision-Predict-0066cc?style=flat-square&logo=github)
![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green?style=flat-square&logo=spring-boot)
![Status](https://img.shields.io/badge/Status-Active-success?style=flat-square)

# 🚗 FleetVision-Predict

**Sistema Avançado de Previsão de Frota Veicular**

*Previsões precisas usando modelos de regressão semi-supervisionada para análises de tendências de 2006 até 2050*

[Demo](#-sobre) • [Recursos](#-funcionalidades) • [Instalação](#-instalação) • [Uso](#-como-usar) • [Tecnologias](#-stack-tecnológico)

</div>

---

## 📋 Sobre

**FleetVision-Predict** é uma aplicação web desenvolvida com **Java Spring Boot** e **Thymeleaf** que oferece análises preditivas avançadas da frota veicular brasileira. 

Utilizando dados históricos de **2006 a 2024**, o sistema aplica múltiplos modelos de regressão matemática para projetar cenários futuros até **2050**, permitindo análises de tendências, crescimento e variações percentuais com alta precisão.

### ✨ Aplicações
- 📊 **Análise de Tendências** - Compreender o histórico da frota veicular
- 🔮 **Previsões Futuras** - Projetar cenários até 2050
- 📈 **Comparações** - Visualizar variações e crescimento percentual
- 🎓 **Fins Acadêmicos** - Demonstração prática de regressão aplicada

---

## 🎯 Funcionalidades Principais

### 📐 Múltiplos Modelos de Regressão
```
✅ Regressão Linear Simples
✅ Regressão Polinomial Simples (Graus 2–5)
✅ Regressão Polinomial Múltipla (Graus 2–5)
```

### 📊 Análises Preditivas Detalhadas
| Recurso | Descrição |
|---------|-----------|
| 🎯 **Projeções Anuais** | Previsão até 2050 com precisão matemática |
| 📈 **Variações Percentuais** | Cálculo automático de diferenças e crescimento |
| 📋 **Tabelas Dinâmicas** | Visualização interativa dos dados |
| 🔍 **Dados Históricos** | Base consolidada de 2006–2024 |
| 🎨 **Interface Responsiva** | Layout moderno e adaptável |

### 🗂️ Organização de Dados
- Base de dados histórica (2006-2024)
- Sistema de abas para melhor navegação
- Comparações lado a lado
- Exportação de resultados

---

## 🛠️ Stack Tecnológico

### Backend
```yaml
Runtime: Java 25
Framework: Spring Boot 3.x
Padrões: MVC, DTO Pattern, Service Layer
Ferramentas: Maven, Lombok, Spring Boot DevTools
```

### Frontend
```yaml
Template Engine: Thymeleaf
Markup: HTML5
Styling: CSS3
Interatividade: JavaScript
```

### Arquitetura
```
Controller (Spring MVC)
    ↓
Service Layer (Lógica de Negócio)
    ↓
DTO Pattern (Transferência de Dados)
    ↓
Database (Dados Históricos)
```

---

## 🚀 Instalação

### Pré-requisitos
- **Java 25+** instalado
- **Maven 3.8+** configurado
- **Git** para clonar o repositório

### Passos

1. **Clone o repositório**
```bash
git clone https://github.com/PabloVLS/FleetVision-Predict.git
cd FleetVision-Predict
```

2. **Instale as dependências**
```bash
mvn clean install
```

3. **Execute a aplicação**
```bash
mvn spring-boot:run
```

4. **Acesse no navegador**
```
http://localhost:8080
```

---

## 💻 Como Usar

### Interface Principal

1. **Selecione o Modelo de Regressão**
   - Escolha entre Linear, Polinomial Simples ou Múltipla
   - Configure o grau do polinômio (2-5)

2. **Visualize os Resultados**
   - Tabela com projeções anuais
   - Cálculos de diferenças
   - Variações percentuais

3. **Analise os Dados**
   - Compare períodos diferentes
   - Identifique tendências
   - Extraia insights

### Exemplo de Resultado
```
Modelo: Regressão Polinomial Grau 2
Período: 2006-2024 (histórico)
Projeção: 2025-2050

Ano    | Frota      | Diferença | Var. %
-------|------------|-----------|--------
2024   | 32.505.234 | -         | -
2025   | 33.012.847 | +507.613  | +1.56%
2026   | 33.542.105 | +529.258  | +1.60%
...
2050   | 45.678.234 | +3.172.129| +7.45%
```

---

## 📁 Estrutura do Projeto

```
FleetVision-Predict/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.pvls/
│   │   │       ├── controller/    # Controladores Spring MVC
│   │   │       ├── service/       # Lógica de Negócio
│   │   │       ├── dto/           # Data Transfer Objects
│   │   │       ├── model/         # Modelos de Regressão
│   │   │       └── utils/         # Utilitários
│   │   └── resources/
│   │       ├── templates/         # Templates Thymeleaf
│   │       └── static/            # CSS, JS, Imagens
│   └── test/                      # Testes Unitários
├── pom.xml                        # Configuração Maven
└── README.md
```

---

## 🎓 Características Técnicas

### Padronização de Código
- Prefixo de classe: `PVLS_` (FleetVision Prediction)
- Nomenclatura clara e consistente
- Documentação inline

### Robustez
- ✅ Tratamento de exceções avançado
- ✅ Validação de dados entrada
- ✅ Logs estruturados
- ✅ Performance otimizada

### Experiência do Usuário
- 📱 Design responsivo
- 🎨 Interface moderna e intuitiva
- ⚡ Carregamento rápido
- 🎯 Navegação clara com abas

---

## 📚 Aplicação Acadêmica

Este projeto demonstra na prática:

| Conceito | Implementação |
|----------|---------------|
| 📊 **Modelos de Regressão** | Aplicação em problemas reais |
| 🌐 **Desenvolvimento Web** | Spring Boot + MVC Pattern |
| 📈 **Análise de Séries Temporais** | Projeções baseadas em histórico |
| 🏗️ **Arquitetura de Software** | Padrões de Design (DTO, Service Layer) |
| ✍️ **Boas Práticas** | Código limpo e padronizado |

---

## 📊 Dados Utilizados

- **Período Histórico:** 2006 - 2024
- **Fonte:** Dados consolidados da frota veicular brasileira
- **Projeção:** até 2050
- **Precisão:** Baseada em modelos matemáticos validados

---

## 🤝 Contribuindo

Sugestões e contribuições são bem-vindas!

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto está disponível sob a licença MIT - consulte o arquivo LICENSE para detalhes.

---

## 📧 Contato

**Pablo VLS**
- GitHub: [@PabloVLS](https://github.com/PabloVLS)
- Repository: [FleetVision-Predict](https://github.com/PabloVLS/FleetVision-Predict)

---

<div align="center">

**⭐ Se este projeto foi útil, considere deixar uma star!**

Desenvolvido com ❤️ por Pablo VLS

</div>
