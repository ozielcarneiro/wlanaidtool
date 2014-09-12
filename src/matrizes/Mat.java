package matrizes;

/**
 * Classe contendo rotinas e operações referentes ao uso de Matrizes.
 *
 * Última Modificação Oziel 17/06/2010 13:50
 */
public class Mat {

    /**
     * Método para soma de matrizes.
     *
     * @param a Primeira Matriz a ser somada.
     * @param b Segunda Matriz a ser somada.
     * @return Matriz com a soma matricial a+b.
     */
    public static double[][] sum(double a[][], double b[][]) {
        int m = a.length;
        int n = a[0].length;
        double c[][] = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    //Soma de uma matriz com um escalar
    public static double[][] sumEscalar(double[][] a, double b) {
        int m = a.length;
        int n = a[0].length;
        double[][] res = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] + b;
            }
        }
        return res;
    }

    //Soma de uma vetor com um escalar
    public static double[] sumEscalar(double[] a, double b) {
        int m = a.length;
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            res[i] = a[i] + b;
        }
        return res;
    }

    //Diferenca de um escalar com uma matriz
    public static double[][] difEscalar(double b, double[][] a) {
        int m = a.length;
        int n = a[0].length;
        double[][] res = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = b - a[i][j];
            }
        }
        return res;
    }

    //Diferenca de um escalar com um vetor
    public static double[] difEscalar(double b, double[] a) {
        int m = a.length;
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            res[i] = b - a[i];

        }
        return res;
    }

    /**
     * Método para subtração de matrizes.
     *
     * @param a Primeira matriz (minuendo)
     * @param b Segunda matriz (subtraendo)
     * @return Matriz com a diferença matricial a-b.
     */
    public static double[][] dif(double a[][], double b[][]) {
        int m = a.length;
        int n = a[0].length;
        double[][] c = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    /**
     * Método para soma de vetores.
     *
     * @param a Primeiro vetor.
     * @param b Segundo vetor.
     * @return Vetor com a soma vetorial a+b.
     */
    public static double[] sum(double a[], double b[]) {
        int n = a.length;
        double[] c = new double[n];
        for (int j = 0; j < n; j++) {
            c[j] = a[j] + b[j];
        }
        return c;
    }
    //  Diferença de vetores

    /**
     * Método para subtração entre vetores.
     *
     * @param a Primeiro vetor (minuendo).
     * @param b Segundo vetor (subtraendo).
     * @return Vetor com a diferença vetorial a-b.
     */
    public static double[] dif(double a[], double b[]) {
        int n = a.length;
        double[] c = new double[n];
        for (int j = 0; j < n; j++) {
            c[j] = a[j] - b[j];
        }
        return c;
    }

    //  Produto de matrizes
    /**
     * Método para produto de matrizes.
     * 
     * @param a Primeira matriz a ser multiplicada. Número de colunas precisa ser igual ao número de linhas da matriz b.
     * @param b Segunda matriz a ser multiplicada. Número de linhas precisa ser igual ao número de colunas da matriz a.
     * @return Matriz contendo o produto matricial a*b com dimensões (linhas de a por colunas de b).
     */
    public static double[][] prod(double a[][], double b[][]) {
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;
        double[][] c = new double[m][p];
        double s = 0;
        int i, k, j;
        for (k = 0; k < p; k++) {
            for (i = 0; i < m; i++) {
                s = 0;
                for (j = 0; j < n; j++) {
                    s += a[i][j] * b[j][k];
                }
                c[i][k] = s;
            }
        }
        return c;
    }

    // Produto de matriz por vetor
    /**
     * Metodo para produto de uma matriz por um vetor.
     * @param a Matriz a ser multiplicada. Numero de colunas precisa ser igual ao tamanho do vetor x.
     * @param x Vetor a ser multiplicado. Tamanho do vetor precisa ser igual ao numero de colunas de a.
     * @return Vetor contendo o vetor resultante do produto matriz por vetor a*x com tamanho igual ao numero de linhas de a.
     */
    public static double[] prod(double a[][], double x[]) {
        double s = 0;
        int m = a.length;
        int n = a[0].length;
        double[] ax = new double[m];
        int i, j;
        for (i = 0; i < m; i++) {
            s = 0;
            for (j = 0; j < n; j++) {
                s += a[i][j] * x[j];
            }
            ax[i] = s;
        }
        return ax;
    }

    // Produto array entre duas matrizes
    /**
     * Metodo para efetuar o produto array entre duas matrizes. Matrizes precisam ter mesmas dimensoes.
     * @param a Primeira matriz a ser multiplicada. Precisa ter as mesmas dimensoes de b.
     * @param b Segunda matriz a ser multiplicada. Precisa ter as mesmas dimensoes de a.
     * @return Matriz contendo o produto array a.*b
     */
    public static double[][] prodp(double a[][], double b[][]) {
        int m = a.length;
        int n = a[0].length;
        double[][] ab = new double[m][n];
        double s = 0;
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                ab[i][j] = a[i][j] * b[i][j];
            }
        }
        return ab;
    }

    // Divisão array entre duas matrizes
    /**
     * Metodo para divisao array entre duas matrizes. Matrizes precisam possuir mesmas dimensoes.
     * @param a Matriz dividendo. Dimensoes precisam ser iguais as de b.
     * @param b Matriz divisor. Dimensoes precisam ser iguais as de a.
     * @return Matriz contendo o resultado da divisao array a./b
     */
    public static double[][] divp(double a[][], double b[][]) {
        int m = a.length;
        int n = a[0].length;
        double[][] adivb = new double[m][n];
        double s = 0;
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                adivb[i][j] = a[i][j] / b[i][j];
            }
        }
        return adivb;
    }

    // Produto de um escalar por uma matriz
    /**
     * Metodo para a multiplicacao de um escalar por uma matriz.
     * @param a Matriz a ser multiplicada.
     * @param fator Escalar a ser multiplicado.
     * @return Matriz resultante da multiplicacao fator*a
     */
    public static double[][] mprod(double a[][], double fator) {
        int m = a.length;
        int n = a[0].length;
        double[][] b = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = fator * a[i][j];
            }
        }
        return b;
    }

    public static double[] vprod(double a[], double escalar){
        double[] r = new double[a.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = a[i]*escalar;
        }
        return r;
    }

    // Produto array entre dois vetores
    /**
     * Metodo para o produto array entre dois vetores. Tamanho dos vetores precisa ser igual.
     * @param a Primeiro vetor a ser multiplicado. Tamanho precisa ser igual ao tamanho de b.
     * @param b Segundo vetor a ser multiplicado. Tamanho precisa ser igual ao tamanho de a.
     * @return Vetor contendo o produto array a.*b.
     */
    public static double[] prodp(double a[], double b[]) {
        int n = a.length;
        double[] ab = new double[n];
        for (int i = 0; i < n; i++) {
            ab[i] = a[i] * b[i];
        }
        return ab;
    }

    // Produto escalar entre dois vetores
    /**
     * Metodo para operacao de produto escalar entre dois vetores. Tamanho dos vetores deve ser igual.
     * @param a Primeiro vetor. Tamanho do vetor deve ser igual ao tamanho de b
     * @param b Segundo vetor. Tamanho do vetor deve ser igual ao tamanho de a.
     * @return Valor resultante do produto escalar entre a e b.
     */
    public static double prod(double a[], double b[]) {
        int n = a.length;
        double ab = 0;
        for (int i = 0; i < n; i++) {
            ab += a[i] * b[i];
        }
        return ab;
    }

    // Potencia elementar em uma matriz
    public static double[][] powp(double[][] a, double pow) {
        int n = a.length;
        int m = a[0].length;
        double[][] res = new double[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                res[i][j] = Math.pow(a[i][j], pow);
            }
        }
        return res;
    }

    // Potencia elementar em vetor
    public static double[] powp(double[] a, double pow) {
        int m = a.length;
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            res[i] = Math.pow(a[i], pow);
        }
        return res;
    }

    //  Transposta de uma matriz
    /**
     * Metodo para transpor uma matriz
     * @param a Matriz a ser transposta
     * @return Transposta de a
     */
    public static double[][] transp(double a[][]) {
        int m = a.length;
        int n = a[0].length;
        double[][] at = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                at[j][i] = a[i][j];
            }
        }
        return at;
    }

    public static double[][] diagonal(double a[][]){
        double[][] out = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(j==i){
                    out[i][j] = a[i][j];
                }else{
                    out[i][j] = 0;
                }

            }

        }
        return out;
    }

    // Copia de uma matriz
    /**
     * Metodo para replicar uma matriz em outra referencia.
     * @param a Matriz a ser copiada.
     * @param acopy Matriz copia. Precisa possuir mesmas dimensoes que a matriz original.
     */
    public static void copy(double a[][], double acopy[][]) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                acopy[i][j] = a[i][j];
            }
        }
    }

    // Agregação colunar entre duas matrizes com mesmo numero de linhas
    /**
     * Metodo para agregacao colunar entre duas matrizes com o mesmo numero de linhas
     * @param a Matriz a iniciar a nova matriz. Deve possuir o mesmo numero de linhas de b.
     * @param b Matriz a terminar a nova matriz. Deve possuir o mesmo numero de linhas de a.
     * @return Matriz contendo a agregacao colunar [a b]
     */
    public static double[][] agrecol(double a[][], double b[][]) {
        int ncola = a[0].length;
        int nlin = a.length;
        int ncolb = b[0].length;
        double[][] ab = new double[nlin][ncola + ncolb];
        for (int i = 0; i < nlin; i++) {
            for (int j = 0; j < ncola; j++) {
                ab[i][j] = a[i][j];
            }
            for (int j = ncola; j < ncola + ncolb; j++) {
                ab[i][j] = b[i][j - ncola];
            }
        }
        return ab;
    }

    // Agregação por linhas entre duas matrizes com mesmo numero de colunas
    /**
     * Metodo para agregacao por linhas entre duas matrizes com mesmo numero de colunas
     * @param a Matriz a iniciar a nova matriz (superior). Deve possuir o mesmo numero de colunas de b.
     * @param b Matriz a terminar a nova matriz (inferior). Deve possuir o mesmo numero de colunas de a.
     * @return Nova matriz com a agregacao por linhas [a;b]
     */
    public static double[][] agrelin(double a[][], double b[][]) {
        int nlina = a.length;
        int ncol = a[0].length;
        int nlinb = b.length;
        double[][] ab = new double[nlina + nlinb][ncol];
        for (int j = 0; j < ncol; j++) {
            for (int i = 0; i < nlina; i++) {
                ab[i][j] = a[i][j];
            }
            for (int i = nlina; i < nlinb + nlina; i++) {
                ab[i][j] = b[i - nlina][j];
            }
        }
        return ab;
    }

    // Troca duas linhas de uma matriz
    /**
     * Metodo para troca de linhas em uma matriz.
     * @param a Matriz a ter linhas trocadas.
     * @param i1 Indice da primeira linha a ser trocada.
     * @param i2 Indice da segunda linha a ser trocada.
     */
    public static void trocalin(double a[][], int i1, int i2) {
        int nlin = a.length;
        int ncol = a[0].length;
        for (int j = 0; j < ncol; j++) {
            double t = a[i1][j];
            a[i1][j] = a[i2][j];
            a[i2][j] = t;
        }
    }
    // Troca duas colunas de uma matriz

    public static void trocacol(double a[][], int nlin, int ncol, int j1, int j2) {
        for (int i = 1; i <= nlin; i++) {
            double t = a[i][j1];
            a[i][j1] = a[i][j2];
            a[i][j2] = t;
        }
    }
    // Copia de um vetor

    public static void copy(double v[], int n, double vcopy[]) {
        for (int i = 0; i < n; i++) {
            vcopy[i] = v[i];
        }
    }
    // Elemento maximo de uma matriz

    public static void maxm(double a[][], int m, int n, double amax, int indrow,
            int indcol) {
        amax = a[1][1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (amax < a[i][j]) {
                    amax = a[i][j];
                    indrow = i;
                    indcol = j;
                }
            }
        }
    }
    // Elemento maximo de uma coluna de uma matriz

    public static void maxcol(double a[][], int m, int n, int col, double amax,
            int ind) {
        amax = a[1][col];
        for (int i = 2; i <= m; i++) {
            if (amax < a[i][col]) {
                amax = a[i][col];
                ind = i;
            }
        }
    }
    // Elemento maximo de uma linha de uma matriz

    public static void maxrow(double a[][], int m, int n, int row, double amax,
            int ind) {
        amax = a[row][1];
        for (int j = 2; j <= n; j++) {
            if (amax < a[row][j]) {
                amax = a[row][j];
                ind = j;
            }
        }
    }

    // Elemento maximo de uma coluna de uma matriz
    public static void maxabscol(double a[][], int m, int n, int col, double amax,
            int ind) {
        amax = Math.abs(a[1][col]);
        for (int i = 2; i <= m; i++) {
            if (amax < Math.abs(a[i][col])) {
                amax = Math.abs(a[i][col]);
                ind = i;
            }
        }
    }

    //  Elemento maximo de um vetor
    public static void max(double v[], int n, double vmax, int ind) {
        vmax = v[1];
        for (int j = 2; j <= n; j++) {
            if (vmax < v[j]) {
                vmax = v[j];
                ind = j;
            }
        }
    }
    //  Elemento mínimo de um vetor

    public static void min(double v[], int n, double vmin, int ind) {
        vmin = v[1];
        for (int j = 2; j <= n; j++) {
            if (vmin > v[j]) {
                vmin = v[j];
                ind = j;
            }
        }
    }
    //  Norma 2 de um vetor

    public static void norm2(double v[], int n, double norm2) {
        norm2 = 0;
        for (int j = 1; j <= n; j++) {
            norm2 += v[j] * v[j];
        }
        norm2 = Math.sqrt(norm2);
    }
    //  Norma infinito de um vetor

    public static void norminf(double v[], int n, double norminf) {
        norminf = Math.abs(v[1]);
        for (int j = 2; j <= n; j++) {
            if (norminf < Math.abs(v[j])) {
                norminf = Math.abs(v[j]);
            }
        }
    }

    /**
     * Método para impressão no terminal de uma matriz.
     *
     * @param a Matriz a ser impressa.
     * @param texto Texto inicial da impressão.
     */
    public static void print(double a[][], String texto) {
        int m = a.length;
        int n = a[0].length;
        System.out.println(texto + "\n\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    /**
     * Método para impressão de vetor.
     *
     * @param v Vetor a ser impresso.
     * @param texto Texto inicial da apresentação.
     */
    public static void print(double v[], String texto) {
        int n = v.length;
        System.out.println(texto + "\n\n");
        for (int j = 0; j < n; j++) {
            System.out.print(v[j] + " ");
        }
        System.out.println("\n");

    }
    //  Dada uma coluna de uma matriz , ordena as linhas dessa matriz,
    //  de acordo com a coluna dada. Se tipo=0 a ordem é do maior
    //  para o menor. Se tipo diferente de zero é do menor para o maior.

    public static void sortrows(double a[][], int m, int n, int col, int tipo) {
        if (col >= 1 & col <= m) {
            for (int i1 = 1; i1 <= m - 1; i1++) {
                for (int i2 = i1 + 1; i2 <= m; i2++) {
                    if (tipo == 0) {
                        if (a[i1][col] < a[i2][col]) {
                            for (int k = 1; k <= n; k++) {
                                double temp = a[i1][k];
                                a[i1][k] = a[i2][k];
                                a[i2][k] = temp;
                            }
                        }
                    }
                    if (tipo != 0) {
                        if (a[i1][col] > a[i2][col]) {
                            for (int k = 1; k <= n; k++) {
                                double temp = a[i1][k];
                                a[i1][k] = a[i2][k];
                                a[i2][k] = temp;
                            }
                        }
                    }


                }
            }
        }
    }
    // Extrai da matriz a a sub-matrix aex

    public static void extrai(double a[][], int m, int n, double aex[][], int m1, int m2, int n1, int n2) {
        int ii = 0;
        for (int i = m1; i <= m2; i++) {
            int jj = 0;
            ii = ii++;
            for (int j = n1; j <= n2; j++) {
                jj++;
                aex[ii][jj] = a[i][j];
            }
        }
    }

    // Matriz identidade
    public static double[][] id(int m, int n) {
        double[][] iden = new double[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            iden[i][i] = 1;
        }
        return iden;
    }

    //  Resolve um sistema linear usando o método de Gram-Schimidt modificado.
    public static void solvesis(double a[][], int m, int n, double b[],
            double x[], double res[]) {
        double acopy[][] = new double[m][n];
        double bcopy[] = new double[m];
        copy(a, acopy);//atualizado para nova versao do metodo
        copy(b, m, bcopy);
        System.out.println(a[0][0] + "\t" + a[m - 1][n - 1]);
        for (int i = 0; i < m - 1; i++) {
            double an = 0;
            for (int j = 0; j < n; j++) {
                an += a[i][j] * a[i][j];
            }
            an = Math.sqrt(an);
            System.out.println(an);
            for (int j = 0; j < n; j++) {
                a[i][j] = a[i][j] / an;
            }
            b[i] = b[i] / an;
            for (int i1 = i + 1; i1 < m; i1++) {
                double p = 0;
                for (int j = 0; j < n; j++) {
                    p += a[i][j] * a[i1][j];
                }
                for (int j = 0; j < n; j++) {
                    a[i1][j] -= p * a[i][j];
                }
                b[i1] -= p * b[i];
            }

        }
        for (int j = 0; j < n; j++) {
            double s = 0;
            for (int i = 0; i < m; i++) {
                s += b[i] * a[i][j];
            }
            x[j] = s;
        }
//                Calculo do residuo
        res = prod(acopy, x); //ja atualizado mas falta verificar
        for (int i = 0; i < m; i++) {
            res[i] = bcopy[i] - res[i];
        }
    }

    /**
     * Metodo para calcular a matriz inversa de uma matriz quadrada;
     * @param aa Matriz quadrada
     * @return Matriz inversa de aa
     */
    public static double[][] inv(double aa[][]) {
        int n = aa.length;
        double[][] a = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            a[i][n + i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = aa[i][j];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i][i] == 0) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j][i] != 0) {
                        for (int k = 0; k < a[i].length; k++) {
                            double d = a[i][k];
                            a[i][k] = a[j][k];
                            a[j][k] = d;
                        }
                    }
                }
                if (a[i][i] == 0) {
                    System.out.println("Nao inversivel");
                    return null;
                }
            }
            if (a[i][i] != 1) {
                double x = a[i][i];
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = a[i][j] / x;
                }
            }
            for (int j = i + 1; j < a.length; j++) {
                if (a[j][i] != 0) {
                    double x = -a[j][i];
                    for (int k = 0; k < a[i].length; k++) {
                        a[j][k] = a[j][k] + x * a[i][k];
                    }
                }
            }
        }
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (a[j][i] != 0) {
                    double x = -a[j][i];
                    for (int k = 0; k < a[i].length; k++) {
                        a[j][k] = a[j][k] + x * a[i][k];
                    }
                }
            }
        }
        double[][] inv = new double[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                inv[i][j] = a[i][n + j];
            }
        }
        return inv;
        // incompleto
    }

    /**
     * Metodo para calcular o determinante de uma matriz quadrada
     * @param a Matriz quadrada
     * @return Valor do determinante da matriz a
     */
    public static double det(double[][] a) {
        double det = 0;
        if (a.length <= 3) {
            if (a.length == 1) {
                det = a[0][0];
            } else if (a.length == 2) {
                det = a[0][0] * a[1][1] - a[1][0] * a[0][1];
            } else if (a.length == 3) {
                det = a[0][0] * a[1][1] * a[2][2] + a[0][1] * a[1][2] * a[2][0]
                        + a[0][2] * a[1][0] * a[2][1] - a[2][0] * a[1][1] * a[0][2]
                        - a[2][1] * a[1][2] * a[0][0] - a[2][2] * a[1][0] * a[0][1];
            }
        }
        //incompleto
        return det;
    }

    public static double[] linspace(double begin, double end, int n) {
        double[] space = new double[n];
        double step = (end - begin) / (double) (n - 1);
        space[0] = begin;
        for (int i = 1; i < space.length; i++) {
            space[i] = space[i - 1] + step;
        }
        return space;
    }

    public static double[][] meshgrid(double[] x, double[] y) {
        double[][] grid = new double[x.length * y.length][2];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                grid[i * y.length + j][0] = x[i];
                grid[i * y.length + j][1] = y[j];
            }
        }
        return grid;
    }

    public static double max(double[] x) {
        double max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    public static double min(double[] x) {
        double min = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    public static double matmax(double[][] x) {
        double max = x[0][0];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] > max) {
                    max = x[i][j];
                }
            }
        }
        return max;
    }

    public static double matmin(double[][] x) {
        double min = x[0][0];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] < min) {
                    min = x[i][j];
                }
            }
        }
        return min;
    }

    public static double[][] reshape(double[][] x, int m, int n) {
        double[][] y = new double[m][n];
        double[] aux = new double[m * n];
        for (int i = 0; i < x[0].length; i++) {
            for (int j = 0; j < x.length; j++) {
                aux[i * x.length + j] = x[j][i];
            }
        }
        for (int i = 0; i < y[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                y[j][i] = aux[i * y.length + j];
            }
        }
        return y;
    }

    public static double[] toLineVector(double[][] x){
        double[] v = new double[x.length*x[0].length];
        for (int i = 0; i < v.length; i++) {
            v[i] = x[i/x[0].length][i%x[0].length];
        }
        return v;
    }

    public static double[] toColumVector(double[][] x){
        double[] v = new double[x.length*x[0].length];
        for (int i = 0; i < v.length; i++) {
            v[i] = x[i%x.length][i/x.length];
        }
        return v;
    }

    public static double[][] reshape(double[] x, int m, int n) {
        double[][] y = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                y[j][i] = x[i * m + j];
            }
        }
        return y;
    }

    public static double round(double x, int n) {
        return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
    }

    public static double variance(double[] x) {
        double var = 0;
        double med = 0;
        for (int i = 0; i < x.length; i++) {
            med += x[i];
        }
        med /= (double) x.length;
        for (int i = 0; i < x.length; i++) {
            var += Math.pow((x[i] - med), 2);
        }
        var /= (double) x.length;
        return var;
    }

    public static double[] givens(double[][] a, double b[]) {
        int m = a.length, n = a[0].length;
        double EPS = 0.00001, c, s, d, a1, a2, x1, y1;
        int n1 = n - 1, m1 = m - 1, im, l, k1, i1, jp, nj;
        if (n1 == 0) {
            b[n1] = b[n1] / a[n1][n1];
            return b;
        }
        for (int i = 0; i <= n1; i++) {
            im = i + 1;
            if (Math.abs(a[i][i]) < EPS) {
                if (im > m1) {
                    System.out.println("Erro nos dados da Matriz");
                    return null;
                }
                l = im;
                do {
                    l++;
                } while (Math.abs(a[l][i]) < EPS);

                for (int k = 0; k <= n1; k++) {
                    double temp = a[i][k];
                    a[i][k] = a[l][k];
                    a[l][k] = temp;
                }
                {
                    double temp = b[i];
                    b[i] = b[l];
                    b[l] = temp;
                }
            }
            i1 = i;
            jp = i;
            if (im <= m1) {
                for (int i2 = im; i2 <= m1; i2++) {
                    if (Math.abs(a[i2][jp]) > EPS) {
                        x1 = a[i1][jp];
                        y1 = a[i2][jp];
                        d = Math.hypot(x1, y1);
                        c = x1 / d;
                        s = y1 / d;
                        a[i1][jp] = d;
                        if ((n1 > 0) || (jp != n1)) {
                            for (int k = jp + 1; k <= n1; k++) {
                                a1 = a[i1][k];
                                a2 = a[i2][k];
                                if (Math.abs(a1) > EPS || Math.abs(a2) > EPS) {
                                    a[i1][k] = c * a1 + s * a2;
                                    a[i2][k] = -s * a1 + c * a2;
                                }
                            }
                        }
                        a1 = b[i1];
                        a2 = b[i2];
                        b[i1] = c * a1 + s * a2;
                        b[i2] = -s * a1 + c * a2;

                    }
                }
            }

        }

        b[n1] = b[n1] / a[n1][n1];
        if (n1 == 0) {
            return b;
        }
        for (int k = 1; k <= n1; k++) {
            s = 0;
            k1 = n1 - k;
            for (int j = 0; j <= k - 1; j++) {
                nj = n1 - j;
                s = s + a[k1][nj] * b[nj];
            }
            b[k1] = (b[k1] - s) / a[k1][k1];
        }
        return b;
    }
}// fim Mat

