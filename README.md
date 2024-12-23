# Shopcart - Fidelity Service

Universidade Federal do Rio Grande do Norte
Departamento de Informática e Matemática Aplicada
Bacharelado em Tecnologia da Informação
Tópicos Especiais em Engenharia de Software IV *(Tolerância a Falhas)*

## Projeto de Tolerância a Falhas

## Participantes

Docente:

- Prof. Dr. Gibeon Soares

Discentes:

- [Joarêmio Neto](https://github.com/Joaremio)
- [Rary Coringa](https://github.com/rarycoringa)
- [Vanessa Maria](https://github.com/Vanessa-Maria2)

## Tecnologias Utilizadas

| Tecnologia    | Versão    |
|              -|          -|
| Java          | 21.0.4    |
| Gradle        | 8.10.2    |
| Spring        | 3.4.0     |

## Instalação e Uso

1. Garantir que possui instalado em sua máquina as versões corretas do Gradle e Java:

    ```shell
    $ java --version
    openjdk 21.0.4 2024-07-16 LTS
    [...]
    ```

    ```shell
    $ gradle --version
    ----------------------------------------------
    Gradle 8.10.2
    ----------------------------------------------
    [...]
    ```

    > O uso da ferramenta **SDKMAN** pode ser útil para gerenciar versões do Java e do Gradle.

2. Realizar o build do ambiente e instalação de pacotes através do gradle:

    ```shell
    $ gradle build
    ```

3. Inicializar a aplicação Spring Boot através do gradle:

    ```shell
    $ gradle bootRun
    ```

## Exemplo de Requisição

Para realizar uma requisição no serviço de **fidelity**:

```shell
$ curl -X POST http://localhost:8083/bonus \
    --header 'Accept: application/json' \
    --header 'Content-Type: application/json' \
    --data '{"user": 1, "bonus": 59}' \
    --verbose
```

---
