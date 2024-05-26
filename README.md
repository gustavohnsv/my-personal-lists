<div style="text-align: justify;">

# 🗒️ Minhas implementacoes de listas dinamicas

Este é um projeto de Implementacoes pessoais de listas dinamicas 
(Geralmente ensinadas em materias como Algortimos e Estruturas de Dados), criado
utilizando Java e JUnit 5 (Para os testes). O objetivo deste projeto é fornecer
uma interface em que o usuario possa escolher com qual estrutura deseja trabalhar, 
mas sem precisar saber sobre como funciona, facilitando e otimizando o seu desenvolvimento.

| Listas                         | Implementada? | Inserção em ordem? | É linear? | Tipo do nó          |
|--------------------------------|---------------|--------------------|-----------|---------------------|
| Lista ligada                   | Sim           | Sim                | Sim       | Apenas chave        |  
| Lista duplamente ligada        | Sim           | Sim                | Sim       | Apenas chave        | 
| Fila                           | Sim           | Não                | Sim       | Apenas chave        |   
| Fila duplamente ligada (Deque) | Sim           | Não                | Sim       | Apenas chave        | 
| Matrizes esparsas              | Sim           | Não                | Não       | Chaves, Coordenadas |
| Árvore binária de busca (ABB)  | Sim           | Sim                | Não       | Apenas chaves       |


## 🈳 Tecnologias Utilizadas

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original-wordmark.svg" width="50"/>


## 🛠️ Funcionalidades

`isEmpty()`, `addNode(double key)`, `removeNode(double key)`, `modifyNode(double oldkey, double newKey)`,
`findNode(double key)`, `printNodes()`, `printNode(double key)`, `containdsNode(double key)`,
`sublist(double fromIndex, double toIndex)`, `findMax(T t)`, `findMin(T t)`, `setCoordinatedNode(double key, int x, int y)`, 
`sublist(int fromX, int toX, int fromY, int toY)`.

## 🗂️ Instalação

Para rodar este projeto localmente, siga os passos abaixo:

1. Clone este repositorio
```
git clone <url-do-repositorio>
```

2. Acesse a pasta onde esta o projeto na sua maquina
```
cd my-personal-lists
```

3. Compile todos os arquivos (Lembre-se de fazer suas alteracoes no arquivo Main.java)
```
javac *.java
```

4. Execute o programa
```
java Main
```

## 🌐 Contribuição
Se você deseja contribuir com este projeto, siga os passos abaixo:

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature (git checkout -b feature/nome-da-feature).
3. Commit suas mudanças (git commit -m 'Adiciona nova feature').
4. Faça um push para a branch (git push origin feature/nome-da-feature).
5. Abra um Pull Request.

## 📜 Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 📞 Contato
Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para abrir uma issue ou entrar em contato.
</div>