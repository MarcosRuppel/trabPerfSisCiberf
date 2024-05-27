/* # ================================================================= #
   # PUCPR - Escola Politécnica - Bacharelado em Ciência da Computação #
   # Performance em Sistemas Ciberfísicos - Prof. Guilherme Schnirmann #
   # Atividade RA02 - Mapeamento Direto e Associativo de Memória Cache #
   # Autor do código: Marcos Paulo Ruppel - Turma 3U (Noite)           #
   # ================================================================= # */

import java.util.ArrayList;

class DirectMappedCache extends Cache {
    private ArrayList<Integer> cache;

    public DirectMappedCache(int tamanhoCache) {
        super(tamanhoCache);
        this.cache = new ArrayList<>(tamanhoCache);
        // inicializando a cache
        for (int i = 0; i < tamanhoCache; i++) {
            cache.add(-1);
        }
    }

    @Override
    public void acessarMemoria(int posicaoMem) {
        int posicaoCache = posicaoMem % tamanhoCache;
        acessos++;
        if (cache.get(posicaoCache) == posicaoMem) {
            System.out.println("Acesso à posição " + posicaoMem + " - Status: HIT");
            totalHits++;
        } else {
            System.out.println("Acesso à posição " + posicaoMem + " - Status: MISS");
            totalMisses++;
            cache.set(posicaoCache, posicaoMem);
        }
        imprimirCache();
    }

    @Override
    public void imprimirCache() {
        System.out.println("Posição Cache | Posição Memória");
        for (int i = 0; i < cache.size(); i++) {
            System.out.println(i + "             | " + cache.get(i));
        }
        System.out.println();
    }
}

class SetAssociativeCache extends Cache {
    private final int tamanhoConjunto;
    private final int numConjuntos;
    private final int[][] conjuntos;

    public SetAssociativeCache(int tamanhoCache, int tamanhoConjunto) {
        super(tamanhoCache);
        this.tamanhoConjunto = tamanhoConjunto;
        this.numConjuntos = tamanhoCache / tamanhoConjunto;
        this.conjuntos = new int[numConjuntos][tamanhoConjunto];
        for (int i = 0; i < numConjuntos; i++) {
            for (int j = 0; j < tamanhoConjunto; j++) {
                conjuntos[i][j] = -1;
            }
        }
    }

    @Override
    public void acessarMemoria(int posicaoMem) {
        int conjuntoIndex = posicaoMem % numConjuntos;

        acessos++;
        boolean hit = false;
        for (int i = 0; i < tamanhoConjunto; i++) {
            if (conjuntos[conjuntoIndex][i] == posicaoMem) {
                hit = true;
                break;
            }
        }

        if (hit) {
            System.out.println("Acesso à posição " + posicaoMem + " - Status: HIT");
            totalHits++;
        } else {
            System.out.println("Acesso à posição " + posicaoMem + " - Status: MISS");
            totalMisses++;
            for (int i = 0; i < tamanhoConjunto; i++) {
                if (conjuntos[conjuntoIndex][i] == -1) {
                    conjuntos[conjuntoIndex][i] = posicaoMem;
                    break;
                }
            }
        }
        imprimirCache();
    }

    public void imprimirCache() {
        System.out.println("Conjunto | Blocos");
        for (int i = 0; i < numConjuntos; i++) {
            System.out.print(i + "        | ");
            for (int j = 0; j < tamanhoConjunto; j++) {
                System.out.print(conjuntos[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}