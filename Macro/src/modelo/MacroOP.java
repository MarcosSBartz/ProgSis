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

    public void getMacro() {

        int i = 0;
        String strAux = new String();
        String strAux2 = new String();

        for (i = 0; i < this.inputCode.size(); i++) {

            strAux = this.inputCode.get(i);
            boolean t = false;

            if ("MCDEFN".equals(strAux)) {
                i++;
                strAux = this.inputCode.get(i);
                System.out.println(strAux + "\n");
                if (!"MCEND".equals(strAux)) {
                    int j = 0;

                    t = true;

                    while (t) {
                        if (strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ') {
                            t = false;
                        }

                        if (t) {
                            this.mc[this.tamMacro].label += strAux.charAt(j);

                        }

                        j++;
                    }

                    t = true;

                    while (t) {
                        if (strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ') {
                            t = false;
                        }
                        if (t) {
                            this.mc[this.tamMacro].nomeMacro += strAux.charAt(j);

                        }

                        j++;
                    }

                    while (strAux.length() > j) {

                        if (strAux.charAt(j) == ' ') {
                            this.mc[this.tamMacro].Args.add(strAux2);
                            strAux2 = "";
                            this.mc[this.tamMacro].num++;

                        }

                        if (strAux.charAt(j) != ' ') {
                            strAux2 += strAux.charAt(j);
                        }

                        j++;
                    }

                    this.mc[this.tamMacro].Args.add(strAux2);
                    strAux2 = "";
                    this.mc[this.tamMacro].num++;

                }

                while (!"mcend".equals(strAux)) {

                    i++;
                    strAux = this.inputCode.get(i);

                    if ((!"mcend".equals(strAux))) {
                        this.mc[this.tamMacro].tabelaMacros.add(strAux);
                    }

                }

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
        System.out.println("Codigo de entrada: ");
        teste.printInputCode();

        teste.getMacro();

        //System.out.println("Codigo de saida: ");
        teste.printOutputCode();
    }
}
