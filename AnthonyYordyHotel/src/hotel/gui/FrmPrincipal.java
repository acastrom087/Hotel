/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.bo.HabitacionBO;
import hotel.bo.ReservaBO;
import hotel.entities.Empleado;
import hotel.entities.Habitacion;
import hotel.entities.Reserva;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Castro Mesen
 */
public class FrmPrincipal extends javax.swing.JFrame {
     
    private Habitacion matriz[][];
    private Habitacion h;
    private JFrame parent;
    private Empleado e;
    private int fila2;
    private int columna2;
    private HabitacionBO hbo;
    /**
     * Creates new form Principal
     */
    public FrmPrincipal(JFrame parent, Empleado e) {
        initComponents();
        setLocationRelativeTo(null);
        hbo = new HabitacionBO();
        this.parent = parent;
        this.e = e;
        fila2 = 2;
        columna2 = 2;
        crearBotones();
        txtFechaActual.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' y")));
        
          
    }
    
    
    private LocalDate fechaActual(){
        LocalDate fecha = LocalDate.now();
        return fecha;
    }
    
                
            
    public void crearBotones(){
        int numero = 1;
        jPanel.setLayout(new GridLayout(fila2, columna2));
        LinkedList<Habitacion> hab = hbo.buscar();
        for (Reserva r : new ReservaBO().ocupados()) {
                System.out.println(r.getCliente());
            }
        for(Habitacion h : hab) {
            JButton btn = new JButton("#"+numero);
            numero++;
            btn.setName("btn,"+h.getId());
            int id = Integer.parseInt(btn.getName().split(",")[1]);
            if (h.getTipo().equalsIgnoreCase("Doble")) {
                btn.setBackground(Color.RED);
            }if (h.getTipo().equalsIgnoreCase("Matrimonial")) {
                btn.setBackground(Color.WHITE);
            }if (h.getTipo().equalsIgnoreCase("Sencilla")) {
                btn.setBackground(Color.BLUE);
            }if (h.getTipo().trim().equalsIgnoreCase("Suite Junior")) {
                btn.setBackground(Color.GREEN);
            }if (h.getTipo().trim().equalsIgnoreCase("Suite Doble")) {
                btn.setBackground(Color.ORANGE);
            }if (h.getTipo().equalsIgnoreCase("Suite Presidencial")) {
                btn.setBackground(Color.YELLOW);
            }
            
            
            btn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnactionPerformed(evt, btn);                         
                    }
                });
            jPanel.add(btn);
        }
    }

    public void btnactionPerformed(java.awt.event.ActionEvent evt, JButton btn){
        int id = Integer.parseInt(btn.getName().split(",")[1]);
        FrmReserva frm = new FrmReserva(this,id, e);
        frm.pack();
        frm.setVisible(true);
;    }
    
    public boolean verHabitaciones(){
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (matriz[f][c] == null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void posicion(JButton btn){
        String[] coordenada = btn.getName().split(",");
            int fila = Integer.parseInt(coordenada[0]);
            int columna = Integer.parseInt(coordenada[1]);
        
    }
    
    
    
  
                                        

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel.setLayout(new java.awt.GridLayout(1, 0));

        txtFechaActual.setEditable(false);
        txtFechaActual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL))));
        txtFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActualActionPerformed
    
    public static void main(String[] args) {
        new FrmPrincipal(null, new Empleado()).setVisible(true);
    }
    
   
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JFormattedTextField txtFechaActual;
    // End of variables declaration//GEN-END:variables
}
