# 🏗️ Arquitetura Hexagonal — Sistema de Cartão de Crédito

Refatoração de um CRUD de clientes e emissão de cartão de crédito aplicando os princípios rigorosos da Arquitetura Hexagonal (Ports & Adapters).

## 📌 Sobre o Projeto

Este projeto parte de uma implementação funcional de um sistema de cadastro de clientes e o reestrutura. O objetivo central foi **desacoplar a lógica de negócio da infraestrutura**, tornando o core da aplicação completamente agnóstico em relação a frameworks, bancos de dados ou qualquer detalhe técnico de entrada e saída.

## 🧱 Arquitetura Hexagonal (Ports & Adapters)

O princípio inviolável desta arquitetura é: **o core (domínio) não depende de nada externo**. É a infraestrutura que se adapta ao core, nunca o contrário.

(Aqui está o diagrama corrigido, com linhas em branco antes e depois)

```mermaid
flowchart TD
    subgraph Inbound [Adapters de Entrada / Inbound]
        A[REST Controller]
    end

    subgraph Core [Domínio da Aplicação / Core]
        B([Porta de Entrada<br>IClienteServiceGateway])
        C{Regra de Negócio Pura<br>ClienteService}
        D([Porta de Saída<br>IClienteRepositoryGateway])
    end

    subgraph Outbound [Adapters de Saída / Outbound]
        E[(Repository Adapter<br>MongoDB)]
    end

    A -- "Invoca" --> B
    B -. "Implementado por" .-> C
    C -- "Chama" --> D
    D -. "Implementado por" .-> E

    classDef core fill:#1e1e1e,stroke:#4caf50,stroke-width:2px,color:#fff;
    classDef adapter fill:#2d2d2d,stroke:#2196f3,stroke-width:2px,color:#fff;
    
    class C core;
    class A,E adapter;
 ```

## 🚀 Tecnologias e Ferramentas

| Tecnologia | Finalidade |
| :--- | :--- |
| **Java 25** | Linguagem principal do domínio e infraestrutura. |
| **Spring Boot 4.0.2** | Framework base para injeção de dependência e exposição REST. |
| **Gradle** | Gerenciamento de dependências e automação de build. |
| **MongoDB** | Persistência de dados (NoSQL). |
| **SonarQube** | Análise estática e garantia de qualidade de código. |

## 📁 Estrutura do Projeto

A organização de pastas reflete estritamente os limites arquiteturais estabelecidos, garantindo que o domínio permaneça isolado:

```text
src/
├── core/
│   ├── domain/
│   │   ├── ClienteDomain.java          # Entidade pura (sem anotações de framework)
│   │   └── CartaoDomain.java
│   ├── service/
│   │   ├── ClienteService.java         # Casos de uso e regras de negócio
│   │   └── GeraDadosCartaoService.java # Lógica de geração de cartão
│   └── gateway/
│       ├── IClienteServiceGateway.java    # Driving Port (Entrada)
│       └── IClienteRepositoryGateway.java # Driven Port (Saída)
│
└── adapter/
    ├── inbound/
    │   └── ClienteController.java      # Adapter REST (Entrada)
    └── outbound/
        └── ClienteRepositoryAdapter.java # Adapter de persistência (Saída)
```
## 🔧 Como Executar

**Pré-requisitos**
- Java 25 instalado
- MongoDB rodando localmente (porta padrão `27017`)

**Rodando a aplicação**

```bash
./gradlew bootRun
```

**Análise de qualidade com SonarQube**

```bash
./gradlew sonar
```

---

## 🧠 Decisões Técnicas

**Por que refatorar para Hexagonal?**

O código original funcionava, mas a lógica de negócio estava fortemente acoplada à infraestrutura. Trocar o banco de dados ou o framework exigiria modificações diretas no core, correndo o risco de quebrar regras de negócio.

Com a arquitetura hexagonal, o `ClienteService` não sabe se o banco é MongoDB, PostgreSQL ou um mock em memória — ele só conhece a interface `IClienteRepositoryGateway`.

**Ports & Adapters na prática**

- `IClienteServiceGateway` → **Port de entrada**: contrato que os adapters de entrada (REST controller) usam para acionar o core
- `IClienteRepositoryGateway` → **Port de saída**: contrato que o core usa para persistência, sem conhecer a tecnologia por baixo

---

## 🔍 Pontos de Melhoria Identificados

| Ponto | Problema | Solução |
|---|---|---|
| `new Random()` instanciado por chamada | Cria novo objeto a cada execução | Declarar `private static final Random RANDOM = new Random()` como campo da classe |
| Limite de crédito com `if/else` encadeado | Difícil de escalar para novas faixas | Refatorar para Strategy Pattern ou mapa de faixas |

> Documentar melhorias identificadas demonstra maturidade técnica — todo código tem débito, o diferencial é reconhecê-lo.
