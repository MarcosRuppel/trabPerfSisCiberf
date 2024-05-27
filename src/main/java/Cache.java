/* # ================================================================= #
   # PUCPR - Escola Politécnica - Bacharelado em Ciência da Computação #
   # Performance em Sistemas Ciberfísicos - Prof. Guilherme Schnirmann #
   # Atividade RA02 - Mapeamento Direto e Associativo de Memória Cache #
   # Autor do código: Marcos Paulo Ruppel - Turma 3U (Noite)           #
   # ================================================================= # */

public abstract class Cache {
    protected int tamanhoCache;
    protected int totalHits;
    protected int totalMisses;
    protected int acessos;

    public Cache(int tamanhoCache) {
        this.tamanhoCache = tamanhoCache;
        this.totalHits = 0;
        this.totalMisses = 0;
        this.acessos = 0;
    }

    public abstract void acessarMemoria(int posicaoMem);

    public abstract void imprimirCache();

    public void imprimirResumo() {
        System.out.println("*------------- RESUMO ------------*");
        System.out.println("Memórias acessadas: " + acessos);
        System.out.println("Total de hits: " + totalHits);
        System.out.println("Total de misses: " + totalMisses);
        System.out.println(String.format("Taxa de acertos (hits): %.2f%%", (totalHits / (double) acessos) * 100));
        System.out.println("*---------------------------------*");
    }
}