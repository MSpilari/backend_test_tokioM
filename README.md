# Tokio Marine Transferência

Este projeto é composto por dois módulos:

- **Backend:** [tokio_marine_test](tokio_marine_test/pom.xml) (Spring Boot, Java 21)
- **Frontend:** [tokio-marine-front](tokio-marine-front/package.json) (Angular 19)

## Funcionalidades

- Agendamento de transferências bancárias entre contas.
- Cálculo automático de taxas conforme a data da transferência.
- Listagem de todas as transferências agendadas/realizadas.

---

## Backend - Spring Boot

### Pré-requisitos

- Java 21+
- Maven 3.9+

### Como rodar

```sh
cd tokio_marine_test
./mvnw spring-boot:run
```

O backend será iniciado em `http://localhost:8080`.

### Endpoints principais

- `POST /transfers/make` — Agendar uma nova transferência.
- `GET /transfers/` — Listar todas as transferências.

### Testes

```sh
./mvnw test
```

---

## Frontend - Angular

### Pré-requisitos

- Node.js 18+
- npm 9+

### Como rodar

```sh
cd tokio-marine-front
npm install
npm start
```

Acesse em `http://localhost:4200`.

---

## Observações

- O backend utiliza banco de dados em memória (H2) e pode ser acessado em `http://localhost:8080/h2-console`.
- O CORS já está configurado para permitir requisições do frontend local.
- As validações de formulário e regras de negócio estão implementadas tanto no frontend quanto no backend.

---

## Estrutura dos diretórios

```
tokio_marine_test/         # Backend Spring Boot
tokio-marine-front/        # Frontend Angular
```

---

## Licença

Este projeto é apenas para fins de demonstração.
