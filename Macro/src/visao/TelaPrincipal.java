/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Arquitetura;
import modelo.MacroOP;
import modelo.ModeloTabela;

/**
 *
 * @author marcos
 */
public class TelaPrincipal extends javax.swing.JFrame {

    MacroOP macOp = new MacroOP();
    private Arquitetura novaarquitetura = new Arquitetura();
    ModeloTabela mtMemoria;
    ModeloTabela mtInstrucoes;
    public ArrayList<String> inputCode;

    /**
     * Creates new form NewJFrame
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMacro = new javax.swing.JLabel();
        jButtonOpen = new javax.swing.JButton();
        jButtonDealExpand = new javax.swing.JButton();
        jTextFieldEntrada = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelOutput = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jRegistradoresTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabelMacro2 = new javax.swing.JLabel();
        jButtonOpen1 = new javax.swing.JButton();
        jButtonDealExpand1 = new javax.swing.JButton();
        jTextFieldEntrada1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelMacro3 = new javax.swing.JLabel();
        jButtonOpen2 = new javax.swing.JButton();
        jButtonDealExpand2 = new javax.swing.JButton();
        jTextFieldEntrada2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabelOutput1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabelOutput2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMemoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelMacro.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelMacro.setText("MACROS");

        jButtonOpen.setBackground(new java.awt.Color(204, 204, 204));
        jButtonOpen.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonOpen.setText("Open");
        jButtonOpen.setFocusable(false);
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jButtonDealExpand.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDealExpand.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonDealExpand.setText("Expand");
        jButtonDealExpand.setEnabled(false);
        jButtonDealExpand.setFocusable(false);
        jButtonDealExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDealExpandActionPerformed(evt);
            }
        });

        jTextFieldEntrada.setText("CodigoEntrada.txt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDealExpand))
                            .addComponent(jTextFieldEntrada)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabelMacro)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMacro)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDealExpand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 220, 160);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelOutput.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelOutput.setText("REGISTRADORES");

        jRegistradoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Registrador", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jRegistradoresTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(810, 20, 350, 340);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelMacro2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelMacro2.setText("LIGADOR");

        jButtonOpen1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonOpen1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonOpen1.setText("Open");
        jButtonOpen1.setFocusable(false);
        jButtonOpen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpen1ActionPerformed(evt);
            }
        });

        jButtonDealExpand1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDealExpand1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonDealExpand1.setText("Expand");
        jButtonDealExpand1.setEnabled(false);
        jButtonDealExpand1.setFocusable(false);
        jButtonDealExpand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDealExpand1ActionPerformed(evt);
            }
        });

        jTextFieldEntrada1.setText("CodigoSaida.txt");
        jTextFieldEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntrada1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDealExpand1))
                            .addComponent(jTextFieldEntrada1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelMacro2)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMacro2)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDealExpand1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 190, 220, 160);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelMacro3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelMacro3.setText("LIGADOR");

        jButtonOpen2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonOpen2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonOpen2.setText("Open");
        jButtonOpen2.setFocusable(false);
        jButtonOpen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpen2ActionPerformed(evt);
            }
        });

        jButtonDealExpand2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDealExpand2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonDealExpand2.setText("Expand");
        jButtonDealExpand2.setEnabled(false);
        jButtonDealExpand2.setFocusable(false);
        jButtonDealExpand2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDealExpand2ActionPerformed(evt);
            }
        });

        jTextFieldEntrada2.setText("CodigoEntrada.txt");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDealExpand2))
                            .addComponent(jTextFieldEntrada2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelMacro3)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMacro3)
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDealExpand2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 370, 220, 160);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelOutput1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelOutput1.setText("INSTRUÇÕES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "opcode", "reg1", "reg2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabelOutput1)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutput1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(290, 20, 490, 170);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabelOutput2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelOutput2.setText("OUTPUT");

        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setRows(5);
        jTextAreaOutput.setFocusable(false);
        jScrollPane3.setViewportView(jTextAreaOutput);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabelOutput2)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutput2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(290, 200, 490, 160);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel6.setText("Memória");

        jTableMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableMemoria);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(280, 370, 870, 170);

        setSize(new java.awt.Dimension(1353, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        //atualiza a tabela do programa
    /*public void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        int rows = 0;
        for(int i=0; i<this.total_code;){
            int mod1 = 0;
            int mod2 = 0;
            
            String modEnd;
            String modEnd2;
            String load;
            String reg1;
            String reg2;
            short opcode;
            short internal_code;
            opcode = Short.parseShort(memoria.load(i++), 2);
          
//            System.out.println("opcde: " + opcode);
                    model.addRow(new Object[]{"NOP", "","","DIR"});
            if (mv.pc == i) {
                jTable1.setRowSelectionInterval(rows, rows);
            }
            rows++;
            
        
        }
        
        model.addRow(new Object[]{"", "", "",""});
//        System.out.println("Linha tab: " + linhaTabSel);
//        jTable1.setRowSelectionInterval(linhaTabSel, linhaTabSel);
//        linhaTabSel++;
//        System.out.println(linhaTabSel);
        
    }*/
    public void read(String arq) throws FileNotFoundException {

        Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n");

        while (leitor.hasNext()) {

            this.inputCode.add(leitor.nextLine());

        }

    }

    public void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String strAux,opcode,reg1,reg2;
        
        int rows = 0;
        for(int i=0; i < this.inputCode.size();i++){

            strAux = this.inputCode.get(i);
            if (strAux.equals("MCDEFN")) {
                i++;
                strAux = this.inputCode.get(i);
                int j = 0;
                while (true) {
                    if (strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ') {
                        j++;
                        break;
                    }
                    //this.mac[this.tamMacro].label += strAux.charAt(j);
                    j++;
                }
                }
            model.addRow(new Object[]{"NOP", "",""});
            }
        }
    public void printInputCode() {
        for (int i = 0; i < this.inputCode.size(); i++) {
            System.out.println(this.inputCode.get(i));
        }
    }
        
    public void atualizarRegistradores(){
        DefaultTableModel model = (DefaultTableModel) jRegistradoresTable.getModel();
        model.setRowCount(0);
        novaarquitetura.getReg(12);
        for (int i = 0; i < 16; i++) {
            model.addRow(new Object[]{"reg" + i,novaarquitetura.getReg(i)});
        }
        
    }
    public void preencherTabelaMemoria(){
        ArrayList dados = new ArrayList();
        
        String[] colunas = new String[] {"Endreço", "Valor(+0)","Valor(+1)", "Valor(+2)", "Valor(+3)"
                , "Valor(+4)", "Valor(+5)", "Valor(+6)", "Valor(+7)", "Valor(+8)", "Valor(+9)"};
        int cnt = 0;
        for(int i=0;i<6000;i++){
            dados.add(new String[]{Integer.toString(cnt), "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"});
            cnt += 10;
        }
        mtMemoria = new ModeloTabela(dados, colunas);
        jTableMemoria.setModel(mtMemoria);
        for(int i=0;i<11;i++){
            jTableMemoria.getColumnModel().getColumn(i).setPreferredWidth(90);
            jTableMemoria.getColumnModel().getColumn(i).setResizable(false);
            
        }
        jTableMemoria.getTableHeader().setReorderingAllowed(false);
        jTableMemoria.setAutoResizeMode(jTableMemoria.AUTO_RESIZE_OFF);
        jTableMemoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
    }
    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed

        try {
            macOp.read(jTextFieldEntrada.getText());
            jButtonDealExpand.setEnabled(true);
            jTextAreaOutput.setText(jTextAreaOutput.getText() + "Arquivo aberto com sucesso!\n\n");
            atualizarRegistradores();
            preencherTabelaMemoria();
        } catch (FileNotFoundException ex) {
            jTextAreaOutput.setText(jTextAreaOutput.getText() + "Erro, arquivo não encontrado\n\n");
        }
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void jButtonDealExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDealExpandActionPerformed

        try {
            macOp.getMacro();
            macOp.expandMacro();
            macOp.writeArchive("CodigoSaida.txt");
            jTextAreaOutput.setText(jTextAreaOutput.getText() + "Macros expandidas com sucesso!\n\n");
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDealExpandActionPerformed

    
    
    private void jButtonOpen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOpen1ActionPerformed

    private void jButtonDealExpand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDealExpand1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDealExpand1ActionPerformed

    private void jButtonOpen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOpen2ActionPerformed

    private void jButtonDealExpand2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDealExpand2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDealExpand2ActionPerformed

    private void jTextFieldEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntrada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntrada1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDealExpand;
    private javax.swing.JButton jButtonDealExpand1;
    private javax.swing.JButton jButtonDealExpand2;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonOpen1;
    private javax.swing.JButton jButtonOpen2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMacro;
    private javax.swing.JLabel jLabelMacro2;
    private javax.swing.JLabel jLabelMacro3;
    private javax.swing.JLabel jLabelOutput;
    private javax.swing.JLabel jLabelOutput1;
    private javax.swing.JLabel jLabelOutput2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTable jRegistradoresTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableMemoria;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JTextField jTextFieldEntrada;
    private javax.swing.JTextField jTextFieldEntrada1;
    private javax.swing.JTextField jTextFieldEntrada2;
    // End of variables declaration//GEN-END:variables
}
