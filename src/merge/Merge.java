package merge;

/**
 *
 * @author Carlos Adão - Albert Paixão
 */

public class Merge {

    static int inicio, meio, fim;

    public static void main(String[] args) {

        int numeros[] = {400, 2, 6, 7, 7, 6, 4, 8, 9};
        inicio = getInicioArray(numeros);
        meio = getMeioArray(numeros);
        fim = getFimArray(numeros);

        /*Saida do array ordenado*/
        System.out.println("\nNumeros Desordenados");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

        mergeSort(numeros, inicio, fim);

        /*Saida do array ordenado*/
        System.out.println("\n\nNumeros Ordenados");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

    }

    public static void Merge(int[] numeros, int inicio, int meio, int fim) {

        int tamVet1 = (meio - inicio);
        int tamVet2 = (fim - (meio));
        int vet1[] = new int[tamVet1 + 1];
        int vet2[] = new int[tamVet2];

        /*Pega a parte esquerda do vetor*/
        for (int i = 0; i <= tamVet1; i++) {
            vet1[i] = numeros[i + inicio];

        }

        /*Pega a parte direita do vetor*/
        for (int j = 0; j < tamVet2; j++) {
            vet2[j] = numeros[(meio + 1) + j];

        }

        int i = 0;
        int j = 0;

        for (int k = inicio; k <= fim; k++) {

            int tam1 = (vet1.length - 1);
            int tam2 = (vet2.length - 1);

            if (j > tam2) {/*Verifica se é o final do array 2*/
                numeros[k] = vet1[i];
                i++;

            } else if (i > tam1) {/*Verifica se é o final do array 1*/
                numeros[k] = vet2[j];
                j++;

            } else if (vet1[i] <= vet2[j]) {
                numeros[k] = vet1[i];
                i++;

            } else {
                numeros[k] = vet2[j];
                j++;
            }
        }

    }

    public static void mergeSort(int[] numeros, int inicio, int fim) {
        int meio;

        if (inicio < fim) {
            meio = (inicio + fim) / 2;
            mergeSort(numeros, inicio, meio);
            mergeSort(numeros, (meio + 1), fim);
            Merge(numeros, inicio, meio, fim);
        }
    }

    public static int getInicioArray(int numeros[]) {

        return 0;
    }
    
    public static int getMeioArray(int numeros[]) {

        return (numeros.length / 2);
    }

    public static int getFimArray(int numeros[]) {

        return (numeros.length) - 1;
    }
}
