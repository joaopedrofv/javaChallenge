# DentalSin

## Autores

**João Pedro Fontana Villagra | RM553343**  
Idealização do projeto Java, criação de grande parte do código fonte.

**Vinicius Malavia Lorenzetti | RM 553121**  
Criação dos métodos PUT e DELETE e auxílio com a ideia principal do Challenge.

## Link do Vídeo da Proposta Tecnológica

[[Link do vídeo.](https://www.youtube.com/watch?v=yUlYOG-bqCk&ab_channel=Jo%C3%A3oPedro)]

## Objetivo

O objetivo da aplicação é o usuário relatar os sintomas que está sentindo e, através de uma predição analítica, devolver um possível diagnóstico.

## Público-alvo

Quem seria esse possível usuário? Qualquer um que necessite de tratamento dentário. Claro que pode se estimar uma faixa etária de 15 a 60 anos. A explicação para isso é que o sistema é voltado para indivíduos que já possuem todos os dentes permanentes e estão mais suscetíveis a problemas dentários, além de que a triagem de casos atuaria tanto no começo de complicações odontológicas quanto com elas já em atuação.

## Descrição do Sistema

O sistema Java consiste em uma API para administração de cadastros. Através dela, todo cadastro realizado na plataforma seria mantido no banco de dados Oracle, além de possibilitar realizar o CRUD com os mesmos dados.

## Instruções para Rodar a Aplicação

O usuário apenas deve rodar a classe `JavaChallengeApplication`, visto que o banco de dados Oracle ja está criado e com as tabelas configuradas, e o usuário e senha é automaticamente passado na `application.properties`, não necessitando que o programa seja rodado com parâmetros.

## Endpoints da API

### 1. **Criar Cadastro** - `POST /cadastros`
   - Descrição: Cria um novo cadastro no sistema.
   - Corpo da Requisição:
     ```json
     {
       "id": 1,
       "nome": "João",
       "sobrenome": "Pedro",
       "email": "joao.pedro@gmail.com",
       "senha": "senhaSegura",
       "dataNascimento": "1995-05-20",
       "sexo": "M",
       "tipoPlano": "Premium",
       "cep": "08730-300"
     }
     ```

### 2. **Listar Cadastros** - `GET /cadastros`
   - Descrição: Retorna uma lista de cadastros.

### 3. **Consultar Cadastro por ID** - `GET /cadastros/{id}`
   - Descrição: Retorna um cadastro específico.

### 4. **Atualizar Cadastro** - `PUT /cadastros/{id}`
   - Descrição: Atualiza os dados de um cadastro.

### 5. **Deletar Cadastro** - `DELETE /cadastros/{id}`
   - Descrição: Deleta um cadastro do sistema.
