public class Tabuleiro {
    private int tamanho;
    private int[][] matriz;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        matriz = new int[tamanho][tamanho];
    }

    public boolean posicionarRainha(int linha, int coluna){
        if(linha<tamanho && coluna<tamanho && matriz[linha][coluna] == 0){
            boolean podeColocar = true;
            for(int i = 0; i < tamanho; i++) {
                if (matriz[i][coluna] == 1) {
                    podeColocar = false;
                } else if (matriz[linha][i] == 1) {
                    podeColocar = false;
                }
            }

            int linhaCopia;
            int colunaCopia;
            if (linha < coluna){
                linhaCopia = 0;
                colunaCopia = coluna-linha;
            }else{
                linhaCopia = linha - coluna;
                colunaCopia = 0;
            }
            while (linhaCopia < tamanho && colunaCopia < tamanho) {
                if (matriz[linhaCopia][colunaCopia] != 0) {
                    podeColocar = false;
                }
                linhaCopia ++;
                colunaCopia++;
            }
            linhaCopia = linha;
            colunaCopia = coluna;
            while(linhaCopia > 0 && colunaCopia < tamanho-1){
                linhaCopia --;
                colunaCopia ++;
            }
            while (linhaCopia < tamanho && colunaCopia >= 0){
                if (matriz[linhaCopia][colunaCopia] != 0) {
                    podeColocar = false;
                }
                linhaCopia ++;
                colunaCopia--;
            }
            if(podeColocar){
                matriz[linha][coluna] = 1;
                return true;
            }
        }
        return false;
    }

    public Rainha[] tetativa() {
        Rainha[] rainhas = new Rainha[tamanho];
        int countRainhas = 0;
        for (int primeira = 0; primeira < tamanho; primeira++) {

            countRainhas = 0;
            matriz = new int[tamanho][tamanho];
            rainhas = new Rainha[tamanho];

            posicionarRainha(primeira, 0);
            rainhas[0] = new Rainha(primeira, 0);
            countRainhas++;
            for (int i = 1; i < tamanho; i++) {
                if (countRainhas < i) {
                    break;
                }
                for (int j = 0; j < tamanho; j++) {
                    boolean posicionada = posicionarRainha(j, i);
                    if (posicionada) {
                        rainhas[i] = new Rainha(j, i);
                        countRainhas++;
                        break;
                    }
                }
            }
            if (countRainhas == tamanho) {
                System.out.println("Resultado: ");
                for (int i = 0; i < tamanho; i++) {
                    System.out.println(rainhas[i]);
                }
                return rainhas;
            }
        }
        System.out.println("Não foi possível posicionar todas as rainhas.");
        for (int i = 0; i < tamanho; i++) {
            System.out.println(rainhas[i]);
        }
        return rainhas;
    }




    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public int getTamanho(){
        return tamanho;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
}
