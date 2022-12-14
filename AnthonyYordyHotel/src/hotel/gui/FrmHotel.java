/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.bo.HabitacionBO;
import hotel.bo.ReservaBO;
import hotel.bo.hotelBO;
import hotel.entities.Empleado;
import hotel.entities.Habitacion;
import hotel.entities.Reserva;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Castro Mesen
 */
public class FrmHotel extends javax.swing.JFrame {
     
    private Habitacion matriz[][];
    private Habitacion h;
    private final JFrame parent;
    private final Empleado e;
    private final int fila;
    private final int columna;
    private final HabitacionBO hbo;
    /**
     * Creates new form Principal
     */
    public FrmHotel(JFrame parent, Empleado e, int fila, int columna) {
        initComponents();
        setLocationRelativeTo(null);
        hbo = new HabitacionBO();
        this.parent = parent;
        this.e = e;
        this.fila = fila ;
        this.columna = columna ;
        crearBotones();
        txtFechaActual.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' y")));
        if (new hotelBO().verHotel() == null) {
            
        }
    }
    
    
    /**
     * Este metodo es el encargado de crear las habitaciones, con un random
     * entre las cantidad de tipos de habitaciones se escoge un numero y se 
     * le asigna un tipo habitacion segun el numero.
     * Este mismo se recorre con la cantidad de habitacines ingresadas al 
     * crear el hotel y las va agregando a la base de datos
     */
    
    private void crearHabitaciones(){
        for (int i = 0; i < fila*columna; i++) {
            int numero = (int) (Math.random() * 5) ;
            Habitacion h = new Habitacion();
            if (numero ==0) {
                h.setTipo("Sencilla");
                h.setCapacidadMin(2);
                h.setCapacidadMax(2);
                h.setPrecioNoche(20000);
            }if (numero ==1) {
                h.setTipo("Doble");
                h.setCapacidadMin(2);
                h.setCapacidadMax(4);
                h.setPrecioNoche(30000);
            }if (numero== 2) {
                h.setTipo("Matrimonial");
                h.setCapacidadMin(2);
                h.setCapacidadMax(2);
                h.setPrecioNoche(35000);
            }if (numero ==3) {
                h.setTipo("Suite Junior");
                h.setCapacidadMin(2);
                h.setCapacidadMax(3);
                h.setPrecioNoche(15000);
            }if (numero == 4) {
                h.setTipo("Suite Doble");
                h.setCapacidadMin(2);
                h.setCapacidadMax(4);
                h.setPrecioNoche(35000);
            }if (numero == 5) {
                h.setTipo("Suite Presidencial");
                h.setCapacidadMin(2);
                h.setCapacidadMax(4);
                h.setPrecioNoche(50000);
            }
            h.setActivo(true);
            h.setDisponible(true);
            new HabitacionBO().insertar(h);
        }
       
    }
    
    /**
     * Se crea el panel y se le van agregando las habitaciones, 
     * se les pone icono de acuerdo al tipo de habitacion que sea
     * despues de cada boton se recorre un ciclo for en el cual estan todas las habitaciones
     * ocupadas y si el id del boton del boton que se obtiene con un spli es igual al id 
     * de una de las habitaciones de esa lista se pinta en rojo ya que estaria ocupada
     */            
            
    public void crearBotones(){
        if (new HabitacionBO().buscar("").isEmpty()) {
            crearHabitaciones();
        }
        
        int numero = 1;
        jPanel.setLayout(new GridLayout(fila, columna));
        LinkedList<Habitacion> hab = hbo.buscar("");
        for(Habitacion h : hab) {
            JButton btn = new JButton("#"+numero);
            numero++;
            btn.setName("btn,"+h.getId());
            int id = Integer.parseInt(btn.getName().split(",")[1]);
            if (h.getTipo().equalsIgnoreCase("Doble")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Doble");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_bed_36px_4.png")));
            }if (h.getTipo().equalsIgnoreCase("Matrimonial")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Matrimonial");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_wedding_36px.png")));
            }if (h.getTipo().equalsIgnoreCase("Sencilla")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Sencilla");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_Empty_Bed_36px.png")));
            }if (h.getTipo().trim().equalsIgnoreCase("Suite Junior")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Suite Junior");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_bed_36px_4.png")));
            }if (h.getTipo().trim().equalsIgnoreCase("Suite Doble")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Suite Doble");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_bed_36px_5.png")));
            }if (h.getTipo().equalsIgnoreCase("Suite Presidencial")) {
                btn.setBackground(Color.GREEN);
                btn.setToolTipText("Suite Presidencial");
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_bedroom_36px.png")));
            }
            for (Reserva r : new ReservaBO().ocupados()) {
                if (id == r.getHabitacion().getId()) {
                    btn.setBackground(Color.RED);
                    
                }
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
        FrmMantReserva frm = new FrmMantReserva(this,id, e);
        frm.pack();
        frm.setVisible(true);
        setVisible(false);
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
        txtFechaActual = new javax.swing.JFormattedTextField();
        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        txtFechaActual.setEditable(false);
        txtFechaActual.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaActual.setBorder(null);
        txtFechaActual.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaActual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL))));
        txtFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActualActionPerformed(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setForeground(new java.awt.Color(153, 153, 153));
        jPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/img/icons8_hotel_star_50px_1.png"))); // NOI18N
        jLabel1.setText("Hotel");

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(765, 765, 765)
                                .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActualActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
        
    
    
   
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtFechaActual;
    // End of variables declaration//GEN-END:variables
}
