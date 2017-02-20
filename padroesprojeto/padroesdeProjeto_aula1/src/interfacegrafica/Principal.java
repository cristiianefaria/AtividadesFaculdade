package interfacegrafica;

import entidade.Aluno;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.AlunoPO;

public class Principal extends javax.swing.JFrame {

    private ArrayList<Aluno> listaAlunos;
    private DefaultTableModel model;
    private AlunoPO alunoPO;

    public Principal() {
        initComponents();
        alunoPO = new AlunoPO();
        model = (DefaultTableModel) table.getModel();
    }

//    public void preencherTabela(ArrayList<Aluno> listaAlunos) {
//        try {   
//            for(Aluno aluno : listaAlunos){
//                model.addRow(new Object[]{
//                    aluno.getMatricula(),
//                    aluno.getMatricula().getNomeDoCurso(),
//                    aluno.getNome(),
//                    aluno.getDisciplinas()});
//            }
//            
//            listaAlunos.forEach(a -> model.addRow(new Object[]{
//                    a.getMatricula(),
//                    a.getMatricula().getNomeDoCurso(),
//                    a.getNome(),
//                    a.getDisciplinas()}));
//        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo" + erro.getMessage());
//        }
//    }
    public void preencherTabela(Iterator conjunto) {
        try {
      while(conjunto.hasNext()){
                Object[] linha = new Object[4];
                Aluno objetoAluno = (Aluno)conjunto.next();
                linha[0] = objetoAluno.getMatricula();
                linha[1] = objetoAluno.getMatricula().getNomeDoCurso();
                linha[2] = objetoAluno.getNome();
                linha[3] = objetoAluno.getDisciplinas();
                    model.addRow(linha);
                
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo" + erro.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileCh = new javax.swing.JFileChooser();
        btnOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnListarArrayList = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnListarFila = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Curso", "Nome", "Disciplinas"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane2.setViewportView(table);

        btnListarArrayList.setText("Listar ArrayList");
        btnListarArrayList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnListarArrayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarArrayListActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnListarFila.setText("Listar Fila");
        btnListarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOk, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnListarFila)
                                .addGap(32, 32, 32)
                                .addComponent(btnListarArrayList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarArrayList)
                    .addComponent(btnLimpar)
                    .addComponent(btnListarFila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnListarArrayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarArrayListActionPerformed
        JFileChooser abrirArquivo = new JFileChooser();
        int res = abrirArquivo.showOpenDialog(this);

        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = abrirArquivo.getSelectedFile();
                Iterator urlarquivo = alunoPO.listarComArraylist(selectedFile.getAbsolutePath());
                preencherTabela(urlarquivo);
                //preencherTabela(listaAlunos);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btnListarArrayListActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
            model.setNumRows(0);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnListarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFilaActionPerformed
                JFileChooser abrirArquivo = new JFileChooser();
        int res = abrirArquivo.showOpenDialog(this);

        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = abrirArquivo.getSelectedFile();
                Iterator urlarquivo = alunoPO.listarComFila(selectedFile.getAbsolutePath());
                preencherTabela(urlarquivo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btnListarFilaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarArrayList;
    private javax.swing.JButton btnListarFila;
    private javax.swing.JButton btnOk;
    private javax.swing.JFileChooser fileCh;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
