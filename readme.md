# 🏦 Java ATM Simulator - Sistema Bancário POO

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Um simulador de Caixa Eletrônico (ATM) robusto, desenvolvido em Java, focado na aplicação de boas práticas de **Programação Orientada a Objetos (POO)** e precisão em cálculos financeiros.

## 🎯 Objetivo do Projeto
Este projeto foi construído para demonstrar o domínio de conceitos fundamentais do desenvolvimento backend, como encapsulamento, manipulação de coleções, tratamento de exceções e o uso correto de tipos de dados para sistemas monetários.

## ✨ Funcionalidades Principais
- **Autenticação Segura**: Sistema de login por número de conta e senha.
- **Operações Financeiras**:
    - Consulta de saldo em tempo real.
    - Saques (com validação de saldo).
    - Depósitos.
    - **Transferências entre contas**: Lógica de interação entre diferentes objetos de conta.
- **Extrato Detalhado**: Histórico completo de transações com data, hora, tipo de operação e valores formatados.
- **Precisão Decimal**: Utilização de `BigDecimal` para garantir que não ocorram erros de arredondamento comuns em tipos `double` ou `float`.

## 🛠️ Tecnologias e Conceitos Aplicados
- **Linguagem**: Java 17.
- **Estrutura de Dados**: `HashMap` para busca eficiente de contas e `ArrayList` para o histórico.
- **Data/Hora**: API `java.time` para registros precisos no extrato.
- **POO**: Divisão clara de responsabilidades entre as classes `Main`, `Banco`, `Conta` e `Transacao`.

## 📂 Estrutura de Arquivos
- `Main.java`: Ponto de entrada da aplicação e gerenciamento dos menus.
- `Banco.java`: Atua como o repositório de dados e gerencia a lógica de autenticação.
- `Conta.java`: Contém as regras de negócio e o estado de cada conta individual.
- `Transacao.java`: Modelo de dados para registros do histórico.

## 🚀 Como Executar
1. Clone o repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)