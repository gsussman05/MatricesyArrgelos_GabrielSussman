/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices_arreglos_gabrielsussman;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class EjerciciosMatrices_Arreglos_GabrielSussman {

    private static int[][] TableroA;
    private static int[][] TableroB;
    private static int[][] BarcosA;
    private static int[][] BarcosB;
    private static int contBombaA;
    private static int contBombaB;
    private static Scanner sc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TableroA = new int[5][6];
        TableroB = new int[5][6];
        BarcosA = new int[][]{{0, 0}, {0, 1}, {0, 2}, {2, 1}, {3, 1}, {4, 3}, {4, 4}, {4, 5}};
        BarcosB = new int[][]{{1, 3}, {1, 4}, {1, 5}, {3, 1}, {3, 2}, {3, 3}, {3, 5}, {4, 5}};
        contBombaA = 0;
        contBombaB = 0;
        sc = new Scanner(System.in);

        inicializarTabs();

        System.out.println("Batalla Naval - Multijugador");
        System.out.println("-----------------------------");

        while (true) {
            printTableros(TableroB);
            System.out.println("Jugador 1, ingrese las coordenadas (fila and col): ");
            int[] bomb = conseguirCoordenadas();
            if (tirarBomba(bomb, BarcosA)) {
                System.out.println("Uy, un barco ha sido dañado.");
                contBombaA++;
            } else {
                System.out.println("Bomba Agua");
            }
            if (contBombaA == 3) {
                System.out.println("EL JUGADOR 1 HA GANADO");
                break;
            }

            printTableros(TableroA);
            System.out.println("Jugador 2, ingrese las coordenadas (fila and col): ");
            bomb = conseguirCoordenadas();
            if (tirarBomba(bomb, BarcosB)) {
                System.out.println("Uy, un bsrco ha sido dañado");
                contBombaB++;
            } else {
                System.out.println("Bomba Agua");
            }
            if (contBombaB == 3) {
                System.out.println("El Jugador 2 ha ganado!");
                break;
            }
        }

        sc.close();
    }

    private static void inicializarTabs() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                TableroA[i][j] = -1;
                TableroB[i][j] = -1;
            }
        }
    }

    private static void printTableros(int[][] board) {
        System.out.println("  0 1 2 3 4 5");
        System.out.println("-----------------");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%d ", i);
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == -1) {
                    System.out.print("- ");
                } else if (board[i][j] == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    private static int[] conseguirCoordenadas() {
        int[] bomb = new int[2];
        bomb[0] = sc.nextInt();
        bomb[1] = sc.nextInt();
        return bomb;
    }

    private static boolean tirarBomba(int[] bomba, int[][] barcos) {
        for (int[] barco : barcos) {
            if (barco[0] == bomba[0] && barco[1] == bomba[1]) {
                TableroA[bomba[0]][bomba[1]] = 0;
                TableroB[bomba[0]][bomba[1]] = 0;
                return true;
            }
        }
        TableroB[bomba[0]][bomba[1]] = 1;
        return false;
    }
}
