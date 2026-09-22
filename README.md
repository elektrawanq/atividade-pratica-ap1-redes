# Atividade prática para AP1 de Redes de Computadores

## Identificação do discente

- **Aluna:** Letícia Queiroz Wanderley
- **Matrícula:** 20250027823
- **Email:** [leticia.queiroz.109@ufrn.edu.br](leticia.queiroz.109@ufrn.edu.br)

## Link do Repositório no GitHub

[atividade-pratica-ap1-redes](https://github.com/elektrawanq/atividade-pratica-ap1-redes.git)

## Ideia do projeto

### Jogo de "Pedra, Papel e Tesoura" - TCP

- O que o `Cliente.java` faz: lê a jogada do usuário no terminal e a envia para o servidor.

- O que o `Servidor.java` faz: recebe a jogada, sorteia a sua própria jogada (jogando contra a máquina), calcula quem venceu usando a lógica do jogo e devolve o resultado (ex: "Você jogou PEDRA. O Servidor jogou PAPEL. Você perdeu.").

## Instruções de Compilação e de Execução

```bash
# Abra o terminal na pasta "src".
# Para compilação:
javac Servidor.java Cliente.java
# Para execução:
java Servidor
# O terminal vai parecer que "travou" ou ficou em branco. Isso é o comportamento esperado, pois o servidor está rodando em um laço infinito aguardando conexões na porta 5000.

# Abra um novo terminal na pasta "src".
# Execute Cliente.java:
java Cliente
```
