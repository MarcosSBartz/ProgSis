/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MacroOP {

    public Macro mac[];
    public int tamMacro;
    public ArrayList<String> inputCode;
    public ArrayList<String> outPutCode;

    public MacroOP() {

        this.inputCode = new ArrayList();
        this.outPutCode = new ArrayList();
        this.mac = new Macro[100];

        int i;

        for (i = 0; i < 100; i++) {

            this.mac[i] = new Macro();

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
                        this.mac[this.tamMacro].label += strAux1.charAt(j);
                        j++;
                    }
                    while (true) {
                        if (strAux1.charAt(j) == '\n' || strAux1.charAt(j) == ' ') {
                            j++;
                            break;
                        }
                        this.mac[this.tamMacro].nomeMacro += strAux1.charAt(j);
                        j++;
                    }

                    while (strAux1.length() > j) {
                        if (strAux1.charAt(j) == ' ') {
                            this.mac[this.tamMacro].Args.add(strAux2);
                            strAux2 = "";
                            this.mac[this.tamMacro].num++;
                        }

                        if (strAux1.charAt(j) != ' ') {
                            strAux2 += strAux1.charAt(j);
                        }

                        j++;
                    }
                    this.mac[this.tamMacro].Args.add(strAux2);
                    strAux2 = "";
                    this.mac[this.tamMacro].num++;
                }

                while (!strAux1.equals("MCEND")) {

                    i++;
                    strAux1 = this.inputCode.get(i);

                    if (!strAux1.equals("MCEND")) {
                        this.mac[this.tamMacro].tabelaMacros.add(strAux1);
                    }

                }
                System.out.println("Nome da Label: " + this.mac[this.tamMacro].label);
                System.out.println("Nome da Macro: " + this.mac[this.tamMacro].nomeMacro);
                System.out.println("Argumentos: " + this.mac[this.tamMacro].Args);
                System.out.println("Corpo da Macro: " + this.mac[this.tamMacro].tabelaMacros.toString());
                this.tamMacro++;

            }

        }

    }

    public void expandMacro() {
        int i = 0;
        String strAux = new String();
        String strAux2 = new String();
        boolean macrFind = false;
        boolean t = true;
        
        String macroName = new String();
        String label = new String();
        ArrayList<String> args = new ArrayList();
        int numberArgs = 0;
        
        for(i = 0; i < this.inputCode.size(); i++){
            
            macrFind = false;
            
            strAux = this.inputCode.get(i);
            
            int p = 0;
            
            if("MCDEFN".equals(strAux)){
                
                boolean mceend = false;
                while(!mceend && this.inputCode.size() > i){
                    strAux = this.inputCode.get(i);
                    if("MCEND".equals(strAux))
                        mceend = true;
                    else i++;
                 
                }
                
            }
            
            while(p < this.tamMacro){
                if(strAux.contains(this.mac[p].nomeMacro)){
                    macrFind = true;
                    
                    t = true;
                    
                    int j = 0;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' '){
                            t = false;
                        }
                        
                        if(t){
                            label += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ')
                            t = false;
                        if(t){
                            macroName += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    
                    while(strAux.length() > j){
                        
                        if(strAux.charAt(j) == ' '){
                            args.add(strAux2);
                            strAux2 = "";
                            numberArgs++;
                            
                        }
                        
                        if(strAux.charAt(j) != ' ')
                            strAux2 += strAux.charAt(j);
                         
                      j++;
                    }
                    
                    args.add(strAux2);
                    strAux2 = "";
                    numberArgs++;
                    
                    if(this.mac[p].nomeMacro.equals(macroName)){
                        
                        if(!(this.mac[p].num == numberArgs)){
                            System.out.println("ERRO AO PROCESSAR MACRO, numero de argumentos invalido >>" + this.mac[p].nomeMacro);
                            return;
                        }
                            
                        int k = 0;
                        int v = 0;
                        
                        for(k = 0; k < this.mac[p].tabelaMacros.size(); k++){
                            v = 0;
                            
                           
                            strAux = this.mac[p].tabelaMacros.get(k);
                            
                            strAux = strAux.replace(this.mac[p].label, label);
                            System.out.println("test:" + strAux);
                            while(v < this.mac[p].num){
                                strAux = strAux.replace(this.mac[p].Args.get(v), args.get(v));
                                v++;
                            }
                            
                            
                            this.outPutCode.add(strAux);
                        }
                        
                        
                    }
                    
                    
                }
               p++;    
             }
             
             numberArgs = 0;
             macroName = "";
             label = "";
                
             args.clear();
             
            if(!macrFind && !"MCEND".equals(strAux))
                this.outPutCode.add(strAux);
            
          }
    }
        public void writeArchive(String archive) throws  IOException{
        
        
        FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        int i = 0;
        
        for(i = 0; i < this.outPutCode.size(); i++){
            
            archiveFinal.write(this.outPutCode.get(i));
            archiveFinal.newLine();
            
        }
        
        archiveFinal.close();
        
        
    }

     public void getMacro(){
       
        int i = 0;
        String strAux = new String();
        String strAux2 = new String();
        
        for(i = 0; i < this.inputCode.size(); i++){
            
            strAux = this.inputCode.get(i);
            boolean t = true;
            
            if("MCDEFN".equals(strAux)){
                i++;
                strAux = this.inputCode.get(i); 
                if(!"MCEND".equals(strAux)){
                    int j = 0;
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' '){
                            t = false;
                        }
                        
                        if(t){
                            this.mac[this.tamMacro].label += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ')
                            t = false;
                        if(t){
                            this.mac[this.tamMacro].nomeMacro += strAux.charAt(j);
                            
                            
                            
                        }
                        
                        j++;
                    }
                    
                    
                    while(strAux.length() > j){
                        
                        if(strAux.charAt(j) == ' '){
                            this.mac[this.tamMacro].Args.add(strAux2);
                            strAux2 = "";
                            this.mac[this.tamMacro].num++;
                            
                        }
                        
                        if(strAux.charAt(j) != ' ')
                            strAux2 += strAux.charAt(j);
                         
                      j++;
                    }
                    
                    this.mac[this.tamMacro].Args.add(strAux2);
                    strAux2 = "";
                    this.mac[this.tamMacro].num++;
                    
                }
                
                while(!"MCEND".equals(strAux)){
                    
                    
                    i++;
                    strAux = this.inputCode.get(i);
                    
                   if((!"MCEND".equals(strAux)))
                        this.mac[this.tamMacro].tabelaMacros.add(strAux);
                    
                }
                
                this.tamMacro++;
                
            }
            
        }
        
        
    }   
     
    public void print(){
        
        int i = 0;
        
        for(i = 0; i < this.outPutCode.size(); i++){
            
            System.out.println(this.outPutCode.get(i));
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        MacroOP teste = new MacroOP();
        try {
            teste.read("CodigoEntrada.txt");
            
            teste.getMacro();
        
            teste.expandMacro();
        
            teste.writeArchive("CodigoSaida.txt");
            
            //teste.print();
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
