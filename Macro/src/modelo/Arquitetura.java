/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Classe que representa a arquitetura da maquina HERA
 * 
 * @author geovana
 */

public class Arquitetura {

    protected static int memoria[] = new int[65536]; 
    protected static int registradores[] = new int[16];
    protected static int flags[] = new int[5]; // 1 - True 0 - False
    protected static int pc = 0;   
    
     /* Inicializa memoria */
    public static void setMemoria(){
        for(int i = 0; i < 65536; i++){
            memoria[i] = 0;
        }
    }
    
    /* Inicializa registradores */
    public static void setRegistradores(){
        for(int i = 0; i < 16; i++ ){
           registradores[i] = 0;
        }
    }
  
    /* Retorna posição de memoria */
    public static int getMemoria(int posicao){
        return memoria[posicao];
    }
    
    /* atribui um valor a uma posicao de memoria */
    public static void setMemoria(int posicao,int valor){
       if(posicao >= 0 && posicao < 65536){
           memoria[posicao] = valor;
       }else{
           System.out.println("Referencia invalida a memoria");
       }
    }
            
    /* retorna valor de determinada posicao do registrador */
    public static int getReg(int posicao){
        if(posicao <=16 && posicao>=0){
           return registradores[posicao];
        }else{
            System.out.println("Registrador da posicao " + posicao + "nao existe");
            return -1;
        }
    }
    
    /* Função auxiliar que passa um numero inteiro com sinal para um numero inteiro sem sinal */
     public static int toUnsigned(int b) { 
        return (b & 0xff);
     }
    
   /* Retorna numero sem sinal de uma posição determinada */
    public static int getUreg(int posicao){
        if(posicao <=16 && posicao>=0){
           return toUnsigned(registradores[posicao]);
        }else{
            System.out.println("Registrador da posicao " + posicao + "nao existe");
            return -1;
        }
    }
     
    /*Atribui valor a um registrador determinado*/
    public static void setReg(int posicao, int novoValor){
      if(posicao <=16 || posicao > 0){ //R0 é sempre zero,logo nao pode ter o valor alterado
           registradores[posicao] = novoValor;
      }else{
            System.out.println("Registrador da posicao " + posicao + "nao existe");
        }
    }
    
    /* Retorna o stack pointer */
    public static int getSP(){
        return registradores[15];
    }   
    
   /* Atribui valor ao stack pointer */
    public static void setSP(int valor){
         registradores[15] = valor;
     }   
    
     /* Retorna o frame pointer */
    public static int getFP(){
        return registradores[14];
    }   
    
   /* Atribui valor ao frame pointer */
    public static void setFP(int valor){
         registradores[14] = valor;
     }  
    
     /* Retorna o registrador temporario */
    public static int getRT(){
        return registradores[13];
    }   
    
   /* Atribui valor ao registrador temporario */
    public static void setRT(int valor){
         registradores[13] = (short) valor;
     } 
   
    /* Definição das flags */
    public static void def_flags(int val){
       setFlag(4,((val) & 16));
       setFlag(3,((val) & 8));
       setFlag(2,((val) & 4));
       setFlag(1,((val) & 2));
       setFlag(0,((val) & 1));
    }
       
       
 /* Função que verifica as flags */
    public static int check_flags(int u5){
      if( (((u5) < 0) | (u5) > 0x1f)) {
          System.out.println("Especificação de flag invalida");
          return ((u5)&0x1f);
      }else{
         return u5;
      }
    } 
    
    /**
     * Retorna o status da flag sign(s ou F0)
     * @param result
     * @return 1 se o result for negativo
     */
    public static int getFlag_s(int result){
        if(result < 0){
            return flags[0] = 1;
        }else{
            return flags[0] = 0;
        }
    }
    
    /**
     * Retorna o status da flag zero(z ou F1)
     * @param result
     * @return 1 se o result for zero
     */
    public static int getFlag_z(int result){
        if(result == 0){
            return flags[1] = 1;
        }else{
            return flags[1] = 0;
        }
    }
    
    /**
     * Retorna o status da flag overflow(v ou F2)
     * @param a
     * @param b
     * @return 1 se o resultado da operaçao com complemento de 2 der overflow 
     */
    public static int getFlag_v(int a, int b){
        if((a + b) > 65536){      //verificar condição
           return flags[2] = 1;
        }else{
           return flags[2] = 0;
        }
    }
    
         
    /**
     * Retorna o status da flag carry(c ou F3)
     * @param a
     * @param b
     * @return 1 se o resultado da operação sem sinal resultar em overflow
     */
    public static int getFlag_c(int a,int b){
       if((toUnsigned(a) + toUnsigned(b)) > 65536){ //verificar condição
           return flags[3] = 1;
       }else{
           return flags[3] = 0;
       }
           
    }
    
    public static int getFlag_CarryBlock(){
       if(flags[2]==1 || flags[3]==1){ //verificar condição
           return flags[4] = 1;
       }else{
          return flags[4] = 1;   
       }
    } 
    
    /* Retorna valor da flag determinada */
    public static int getFlag(int indice){
         if(indice >= 0 && indice <=4){
           return flags[indice];
        }
         System.out.println("Flag inexistente");
         return 0;
    }
    
    /* Seta status a flag  */
    public static void setFlag(int indice, int status){
        if(indice >= 0 && indice <= 4){
            if(status==0 || status==1){
               flags[indice] = status;
            }else{
                System.out.println("Flag Invalida");
            }
        }
    }
    
    /*retorna o valor do program counter */
    public static int getPc() {
        return pc;
    }
    
    /* Atribui valor ao pc*/
    public static void setPc(int pc) {
        Arquitetura.pc = pc;
    }
    
    /* incrementa o program counter*/
    public static int incrementaPC(){
        pc += 1;
        return pc;
    }
    
}
