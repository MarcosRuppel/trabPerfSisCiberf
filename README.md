# trabPerfSisCiberf

Trabalho desenvolvido como parte do RA2 da disciplina de Performance em Sistemas Ciberfísicos, do terceiro período do curso Bacharelado em Ciência da Computação da PUCPR.

Autor do código: Marcos Paulo Ruppel

Professor orientador: Guilherme Schnirmann

## Proposta da aplicação
A proposta dessa aplicação consiste em consolidar o conhecimento adquirido na disciplina ao simular um mapeamento de memória cache em uma arquitetura hipotética, permitindo visualizar como ocorre o processo em determinados métodos de mapeamento e comparar os resultados quanto a quantidade de acertos (cache hits).

## Estrutura Geral da Aplicação
A aplicação foi desenvolvida em Java (JVM OpenJDK 21), empregando os conceitos de encapsulamento, hierarquia, herança de classes e polimorfismo.
O código foi estruturado da seguinte forma:

### Classe Cache
- Contém os atributos e métodos utilizados por ambas as classes que correspondem aos tipos de mapeamento de cache (direto e associativo)

### Classe CacheSimulator
- Contém as classes DirectMappedCache e setAssociativeCache, que correspondem respectivamente aos métodos de mapeamento direto e associativo de cache.

### Classe Main
- Contém a implementação dos métodos e a formatação da exibição dos resultados dos mapeamentos.

