/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorrateo_de_facturaas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Prorrateo_de_Facturaas {

    private static String[][] factura;
    private static String[][] Gastos;
    private static String[][] Cuadro;
    private static int TotalFac, GastoTotalValor, PesoTotal, GastosAlPeso;
    private static float GranTotal;
    //FACTURA
    private static final int CANTIDAD = 0;
    private static final int NOMBRE = 1;
    private static final int PRECIO = 2;
    private static final int PESOUNITARIO = 3;
    private static final int VALORTOTAL = 4;
    private static final int GASTOALVALOR = 5;
    private static final int GASTOALPESO = 6;
    private static final int PESOSTOTALES = 7;
    private static final int COSTOPORUNIDAD = 8;
    private static final int COSTOTOTAL = 9;

    //GASTOS
    private static final int SEGURO = 0;
    private static final int FLETE = 1;
    private static final int IMPUESTOS = 2;
    private static final int ACARREO = 3;
    private static final int COMISIONES = 4;

    private static String[] NGastos = {"Seguro Local", "Flete", "Impuestos de Aduana", "Acarreo", "Comisiones Bancarias"};

    private static float CoeGasto, CoeGastoAlPeso;

    public static void CargaFactura() throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t\tINGRESO DE FACTURA");
        int cProd = 0;

        System.out.println("Ingrese la cantidad de articulos de la factura");
        String entrada = s.readLine();
        cProd = Integer.parseInt(entrada);
        factura = new String[cProd][10];
        int i;
        int total = 0;
        int Pesos = 0;

        for (i = 0; i < cProd; i++) {

            System.out.println("Ingrese la cantidad de producto adquirido #" + (i + 1));
            factura[i][CANTIDAD] = s.readLine();
            System.out.println("Ingrese el nombre del producto : ");
            factura[i][NOMBRE] = s.readLine();
            System.out.println("Ingrese el precio, ejm (100)");
            factura[i][PRECIO] = s.readLine();
            System.out.println("Ingrese el Peso Unitario del producto en Kgs:");
            factura[i][PESOUNITARIO] = s.readLine();
            total = Integer.parseInt(factura[i][CANTIDAD]) * Integer.parseInt(factura[i][PRECIO]);
            factura[i][VALORTOTAL] = String.valueOf(total);
            Pesos = Integer.parseInt(factura[i][CANTIDAD]) * Integer.parseInt(factura[i][PESOUNITARIO]);         //PASO NUMERO 5
            factura[i][PESOSTOTALES] = String.valueOf(Pesos);
            PesoTotal = PesoTotal + Integer.parseInt(factura[i][PESOSTOTALES]);
        }
        for (int x = 0; x < cProd; x++) {

            TotalFac = TotalFac + (Integer.parseInt(factura[x][VALORTOTAL]));                                    //PASO NUMERO 1
        }

    }

    public static void IngresoGastos() throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t\tINGRESO DE GASTOS");

        float GastoAValor, GastoAPeso, CostoPUnidad, CostoTotal;
        DecimalFormat formato = new DecimalFormat("#.00");
        Gastos = new String[NGastos.length][2];

        for (int i = 0; i < NGastos.length; i++) {

            Gastos[i][0] = NGastos[i];
            System.out.println("De cúanto ha sido el gasto: " + NGastos[i] + "?");
            Gastos[i][1] = s.readLine();
        }
        GastoTotalValor = (Integer.parseInt(Gastos[SEGURO][1]) + Integer.parseInt(Gastos[IMPUESTOS][1])
                + Integer.parseInt(Gastos[COMISIONES][1]));                                                     //PASO NUMERO 2
        GastosAlPeso = (Integer.parseInt(Gastos[FLETE][1]) + Integer.parseInt(Gastos[ACARREO][1]));             //PASO NUMERO 6
        
        //COEFICIENTES
        CoeGasto = (float) GastoTotalValor / TotalFac;                                                          //PASO NUMERO 3
        CoeGastoAlPeso = (float) GastosAlPeso / PesoTotal;                                                      //PASO NUMERO 7

        for (int i = 0; i < factura.length; i++) {

            GastoAValor = Float.parseFloat(factura[i][PRECIO]) * CoeGasto;                                      //PASO NUMERO 4
            factura[i][GASTOALVALOR] = String.valueOf(formato.format(GastoAValor));

            GastoAPeso = Float.parseFloat(factura[i][PESOUNITARIO]) * CoeGastoAlPeso;                            //PASO NUMERO 8
            factura[i][GASTOALPESO] = String.valueOf(GastoAPeso);

            CostoPUnidad = Float.parseFloat(factura[i][PRECIO]) + Float.parseFloat(factura[i][GASTOALVALOR]) + Float.parseFloat(factura[i][GASTOALPESO]);
            factura[i][COSTOPORUNIDAD] = String.valueOf(CostoPUnidad);

            CostoTotal = Float.parseFloat(factura[i][COSTOPORUNIDAD]) * Float.parseFloat(factura[i][CANTIDAD]);
            factura[i][COSTOTOTAL] = String.valueOf(CostoTotal);

            GranTotal = GranTotal + Float.parseFloat(factura[i][COSTOTOTAL]);
        }

    }

    public static void CreaCuadro() {                                                                           //PASO NUMERO 9

        int[] PCuadro = {CANTIDAD, NOMBRE, PRECIO, GASTOALVALOR, GASTOALPESO, COSTOPORUNIDAD, COSTOTOTAL};
        Cuadro = new String[factura.length][PCuadro.length];

        for (int x = 0; x < Cuadro.length; x++) {

            Cuadro[x][0] = (factura[x][CANTIDAD]);
            Cuadro[x][1] = (factura[x][NOMBRE]);
            Cuadro[x][2] = (factura[x][PRECIO]);
            Cuadro[x][3] = (factura[x][GASTOALVALOR]);
            Cuadro[x][4] = (factura[x][GASTOALPESO]);
            Cuadro[x][5] = (factura[x][COSTOPORUNIDAD]);
            Cuadro[x][6] = (factura[x][COSTOTOTAL]);
        }

    }

    public static void Comprobacion() {                                                                        //PASO NUMERO 10
        int Suma;
        System.out.println("\nTotal segun Factura..........." + TotalFac + ".00");
        System.out.println("Total de Gastos al Valor......." + GastoTotalValor + ".00");
        System.out.println("Total de Gastos al Peso........" + GastosAlPeso + ".00");
        System.out.println("                         --------------");
        Suma = TotalFac + GastoTotalValor + GastosAlPeso;
        System.out.println("GRAN TOTAL:________________Q. " + Suma + ".00");
    }

    public static void imprimircuadro(String[][] ma) {
        System.out.println("N. UNIDADES" + "\t\tDESCRIPCION"
                + "\t\tVALOR_S_FAC" + "\t\tGASTO_VALOR" + "\t\tGASTO_PESO"
                + "\t\tCOSTO_P_UNIDAD" + "\t\tCOSTO_TOTAL");
        for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t\t\t");
                }
            }
            System.out.println("|");
        }
        System.out.println("                                   Gran Total........................................"
                + "..........................................................Q." + GranTotal);
    }

    public static void main(String[] args) throws IOException {

        CargaFactura();
        IngresoGastos();
        CreaCuadro();
        imprimircuadro(Cuadro);
        Comprobacion();

    }

}
