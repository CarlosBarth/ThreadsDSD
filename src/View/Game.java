package View;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Controller.ControllerMap;
import Observer.ObserverGame;

/**
 *
 * @author Barth_Reichert
 */
public class Game extends javax.swing.JFrame implements ObserverGame {
    
    private ControllerMap controlMap;
    
    private static Game instance = null;
    
    public static Game getIntance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    
    private Game() {
        initComponents();
        setLocationRelativeTo(null);
        controlMap = ControllerMap.getIntance();
        controlMap.attachMap(this);
        setResizable(false);
        setTitle("Trabalho DSD Malha Viária");
        controlMap.mapLoad();
        btnEncerrar.setEnabled(false);
        spnVelocidade.setValue(400);
        edtQuantidadeVeiculos.setValue(10);
        spnVelocidadeInsercao.setValue(650);
        controlMap.setCars(10);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtQuantidadeVeiculos = new javax.swing.JSpinner();
        btnConfirmar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnEncerrar = new javax.swing.JButton();
        spnVelocidade = new javax.swing.JSpinner();
        btnConfirmarVelocidade = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spnVelocidadeInsercao = new javax.swing.JSpinner();
        btnConfirmarInsercao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        try {
            txtQtd =(javax.swing.JLabel)java.beans.Beans.instantiate(getClass().getClassLoader(), "View.Game_txtQtdAtual");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        txtQtdAtual = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quantidade de veículos simultâneos ");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnIniciar.setText("Iniciar!");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnEncerrar.setText("Finalizar!");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        btnConfirmarVelocidade.setText("Confirmar");
        btnConfirmarVelocidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarVelocidadeActionPerformed(evt);
            }
        });

        jLabel3.setText("Velocidade do veículo");

        btnConfirmarInsercao.setText("Confirmar");
        btnConfirmarInsercao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarInsercaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Intervalo de  inserção");

        jLabel2.setText("Quantidade de veículos na Via: ");

        jLabel5.setText("Quantidade Max de veículos: ");

        txtQtdAtual.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtQtdAtual.setText("0");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(edtQuantidadeVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtd)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spnVelocidadeInsercao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnConfirmarInsercao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spnVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnConfirmarVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQtdAtual))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtQuantidadeVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar)
                            .addComponent(spnVelocidadeInsercao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirmarInsercao)
                            .addComponent(spnVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmarVelocidade)
                            .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
        controlMap.stop();
    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        controlMap.setCars(Integer.parseInt(edtQuantidadeVeiculos.getValue().toString()));
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        controlMap.start();

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnConfirmarVelocidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVelocidadeActionPerformed
        controlMap.setCarVelocity(Integer.parseInt(spnVelocidade.getValue().toString()));
    }//GEN-LAST:event_btnConfirmarVelocidadeActionPerformed

    private void btnConfirmarInsercaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarInsercaoActionPerformed
        controlMap.setCarInsertion(Integer.parseInt(spnVelocidadeInsercao.getValue().toString()));
    }//GEN-LAST:event_btnConfirmarInsercaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConfirmarInsercao;
    private javax.swing.JButton btnConfirmarVelocidade;
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JSpinner edtQuantidadeVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnVelocidade;
    private javax.swing.JSpinner spnVelocidadeInsercao;
    private javax.swing.JLabel txtQtd;
    private javax.swing.JLabel txtQtdAtual;
    // End of variables declaration//GEN-END:variables

    JLabel imageLabel = new JLabel();
    private ImageIcon grama = new ImageIcon("./assets/gramaold.jpg");
    
    @Override
    public void setTable(int matrix[][], int rows, int collumns) {
        DefaultTableModel model = new DefaultTableModel() {
            
            @Override
            public int getRowCount() {
                return controlMap.getRows();
            }
            
            @Override
            public int getColumnCount() {
                return controlMap.getColumns();
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                try {
                    return paint(rowIndex, columnIndex, matrix);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                    return null;
                }
            }
        };
        
        model.setRowCount(rows);
        model.setColumnCount(collumns);
        jTable1.setRowHeight(40);
        jTable1.setModel(model);
        jTable1.setOpaque(false);
        jTable1.setDefaultRenderer(Object.class, new TableCellRender());
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0, 0));
        
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            column.setHeaderRenderer(renderer);
            column.setPreferredWidth(40);
        }
        
        jTable1.setIntercellSpacing(new Dimension(0, 0));
    }
    
    public ImageIcon paint(int rows, int collumns, int matrix[][]) {
        if (matrix[rows][collumns] == 0) {
            return grama;
        } else {
            return controlMap.getRoad(rows, collumns);
        }
        
    }
    
    @Override
    public void setQtdCars(int value) {
        txtQtd.setText("" + value);
    }
    
    @Override
    public void addQtdCars() {
        int i = Integer.parseInt(txtQtdAtual.getText());
        txtQtdAtual.setText(i + 1 + "");
    }
    
    @Override
    public void decreaseQtdCars() {
        int i = Integer.parseInt(txtQtdAtual.getText());
        txtQtdAtual.setText(i - 1 + "");
    }
    
    @Override
    public void setQtdCarsError() {
        JOptionPane.showMessageDialog(null, "Você não pode informar uma quantidade\nnegativa de veículos", "Error", 2);
        
    }
    
    @Override
    public void rePaint() {
        jTable1.repaint();
    }
    
    @Override
    public void setButton(boolean on) {
        if (on) {
            btnIniciar.setEnabled(false);
            btnEncerrar.setEnabled(true);
        } else {
            btnIniciar.setEnabled(true);
            btnEncerrar.setEnabled(false);
            
        }
        
    }
    
    @Override
    public void velocidadeInvalida() {
        JOptionPane.showMessageDialog(null, "Você não pode informar uma quantidade\nnegativa para a velocidade", "Error", 2);
    }
}
