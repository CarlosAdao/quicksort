package quick;

import java.util.Random;
import merge.Merge;

/**
 *
 * @author José Carlos Adão - Albert Paixão - Ricardo Neves
 */
public class QuickSort {

    static int min, max, mediana;
    static String msg;

    public static void main(String[] args) {

        int numeros[] = {2, 5, -37, 700, 7, 5, 3, 8, 9, 10, 15, 3, 0, 1};
        min = Merge.getInicioArray(numeros);
        max = Merge.getFimArray(numeros);

        msg = "[Vetor sem Ordenação]";
        printVector(numeros, msg);

        quicksort(numeros, min, max);

        msg = "[Vetor após ordenação QuickSort]";
        printVector(numeros, msg);

    }

    /*metodo usado para sortear um numero do array*/
    public static int sorteiaNumero(int min, int max) {
        Random random = new Random();
        return (int) Math.ceil(Math.random() * (max - min + 1)) - 1 + min;
    }

    /*metodo usado para pegar a mediana de três numeros do vetor*/
    public static int calculaMediana(int numeros[], int min, int max) {
        int indice1, indice2, indice3;
        int vetAux[] = new int[3];
        int vetAuxIndice[] = new int[3];

        /*verifica se os indices sorteados são diferentes*/
        indice1 = sorteiaNumero(min, max);
        indice2 = sorteiaNumero(min, max);
        while (indice2 == indice1) {
            indice2 = sorteiaNumero(min, max);
        }
        indice3 = sorteiaNumero(min, max);
        while (indice3 == indice2 || indice3 == indice1) {
            indice3 = sorteiaNumero(min, max);
        }

        vetAux[0] = numeros[indice1];
        vetAux[1] = numeros[indice2];
        vetAux[2] = numeros[indice3];

        vetAuxIndice[0] = numeros[indice1];
        vetAuxIndice[1] = numeros[indice2];
        vetAuxIndice[2] = numeros[indice3];

        Merge.mergeSort(vetAux, Merge.getInicioArray(vetAux), Merge.getFimArray(vetAux));

        if (vetAux[1] == vetAuxIndice[0]) {
            
            return indice1;
        } else if (vetAux[1] == vetAuxIndice[1]) {
           
            return indice2;

        } else {
            
            return indice3;
        }

    }

    public static void quicksort(int numeros[], int inicio, int fim) {
        int q, med, a, b;

        if (((fim - inicio) >= 2)) {
            med = calculaMediana(numeros, inicio, fim);
            q = partition(numeros, inicio, med, fim);
            a = (q - 1);
            b = (q);

            quicksort(numeros, inicio, a);
            quicksort(numeros, b, max);
        }

    }

    public static int partition(int numeros[], int inicio, int mediana, int fim) {
        int i = inicio + 1;//inicia a leitura do vetor da segunda posição
        int j = fim;//guarda a ultima posição do array
        int md = numeros[mediana];//deixa armazenado o valor da mediana

        int aux = numeros[inicio];//guarda o numero para não ocorrer perda
        numeros[inicio] = numeros[mediana];//faz a primeira posição receber o pivô
        numeros[mediana] = aux;//posição do pivô recebe o primeiro elemento
        boolean entrou = false, avancou = false;

        while (j > (i - 1)) {//verifica se o j passou o pivô

            if (numeros[i] >= md && numeros[j] < md) {
                /*Realiza a troca*/
                aux = numeros[i];//Auxiliar para guardar o valor de trocas
                numeros[i] = numeros[j];
                numeros[j] = aux;

                i++;
                j--;
                entrou = true;

            }

            if (numeros[i] <= md && !entrou) {
                i++;
            }
            if (numeros[j] >= md && !entrou) {
                j--;
            }

            if (j < i) {
                aux = numeros[inicio];//guarda o numero para não ocorrer perda
                numeros[inicio] = numeros[j];//faz a primeira posição receber o pivô
                numeros[j] = aux;

                if (inicio == 0) {
                    mediana = (j + 1);
                } else {
                    mediana = (j);
                }
                break;
            }

            entrou = false;
        }

        return mediana;
    }
    
    /*Método usado para imprimir o vetor*/
    public static void printVector(int vector[], String msg) {
        System.out.println("\n" + msg);
        System.out.print("[");
        for (int num : vector) {
            System.out.print(" " + num);
        }
        System.out.print("]\n\n");
    }

}
