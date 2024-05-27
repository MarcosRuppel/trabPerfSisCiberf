/* # ================================================================= #
   # PUCPR - Escola Politécnica - Bacharelado em Ciência da Computação #
   # Performance em Sistemas Ciberfísicos - Prof. Guilherme Schnirmann #
   # Atividade RA02 - Mapeamento Direto e Associativo de Memória Cache #
   # Autor do código: Marcos Paulo Ruppel - Turma 3U (Noite)           #
   # ================================================================= # */

public class Main {
    public static void main(String[] args) {
        int tamanhoCache = 8;
        int tamanhoConjunto = 2;
        int[] posMemoria = {1,9,0,8,1,2,3,9,2};

        System.out.println("\n============================================");
        System.out.println("            Mapeamento Direto");
        System.out.println("============================================");
        DirectMappedCache directCache = new DirectMappedCache(tamanhoCache);
        for (int pos : posMemoria) {
            directCache.acessarMemoria(pos);
        }
        directCache.imprimirResumo();

        System.out.println("\n============================================");
        System.out.println("    Mapeamento Associativo por Conjunto");
        System.out.println("============================================");

        SetAssociativeCache assocCache = new SetAssociativeCache(tamanhoCache, tamanhoConjunto);
        for (int pos : posMemoria) {
            assocCache.acessarMemoria(pos);
        }
        assocCache.imprimirResumo();
    }
}
