/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MacroOP {

    public Macro mc[];
    public int tamMacro;
    public ArrayList<String> inputCode;
    public ArrayList<String> outPutCode;

    public MacroOP() {

        this.inputCode = new ArrayList();
        this.outPutCode = new ArrayList();
        this.mc = new Macro[100];

        int i;

        for (i = 0; i < 100; i++) {

            this.mc[i] = new Macro();

        }

        this.tamMacro = 0;

    }

    public void read(String arq) throws FileNotFoundException {

        Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n");

        while (leitor.hasNext()) {

            this.inputCode.add(leitor.nextLine());

        }

    }

    public void printInputCode() {
        for (int i = 0; i < this.inputCode.size(); i++) {
            System.out.println(this.inputCode.get(i));
        }
    }

    public void printOutputCode() {
        for (int i = 0; i < this.outPutCode.size(); i++) {
            System.out.println(this.outPutCode.get(i));
        }
    }

    public void findMacro() {

        int i = 0;
        String strAux1 = new String();
        String strAux2 = new String();

        for (i = 0; i < this.inputCode.size(); i++) {

            strAux1 = this.inputCode.get(i);
            if (strAux1.equals("MCDEFN")) {
                i++;
                strAux1 = this.inputCode.get(i);
                if (!"MCEND".equals(strAux1)) {
                    int j = 0;
                    while (true) {
                        if (strAux1.charAt(j) == '\n' || strAux1.charAt(j) == ' ') {
                            j++;
                            break;
                        }
                        this.mc[this.tamMacro].label += strAux1.charAt(j);
                        j++;
                    }
                    while (true) {
                        if (strAux1.charAt(j) == '\n' || strAux1.charAt(j) == ' ') {
                            j++;
                            break;
                        }
                        this.mc[this.tamMacro].nomeMacro += strAux1.charAt(j);
                        j++;
                    }

                    while (strAux1.length() > j) {
                        if (strAux1.charAt(j) == ' ') {
                            this.mc[this.tamMacro].Args.add(strAux2);
                            strAux2 = "";
                            this.mc[this.tamMacro].num++;
                        }

                        if (strAux1.charAt(j) != ' ') {
                            strAux2 += strAux1.charAt(j);
                        }

                        j++;
                    }
                    this.mc[this.tamMacro].Args.add(strAux2);
                    strAux2 = "";
                    this.mc[this.tamMacro].num++;
                }

                while (!strAux1.equals("MCEND")) {

                    i++;
                    strAux1 = this.inputCode.get(i);

                    if (!strAux1.equals("MCEND")) {
                        this.mc[this.tamMacro].tabelaMacros.add(strAux1);
                    }

                }
                System.out.println("Nome da Label: " + this.mc[this.tamMacro].label);
                System.out.println("Nome da Macro: " + this.mc[this.tamMacro].nomeMacro);
                System.out.println("Argumentos: " + this.mc[this.tamMacro].Args);
                System.out.println("Corpo da Macro: " + this.mc[this.tamMacro].tabelaMacros.toString());

                this.tamMacro++;

            }

        }

    }

    public static void main(String[] args) {

        MacroOP teste = new MacroOP();
        try {
            teste.read("CodigoEntrada.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Erro, arquivo nao encontrado");

        }
        //System.out.println("Codigo de entrada: ");
        //teste.printInputCode();

        teste.findMacro();

        //System.out.println("Codigo de saida: ");
        //teste.printOutputCode();
    }
}
