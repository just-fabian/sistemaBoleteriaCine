package UserGUI;

import Cine.Cine;
import ComponentesCine.Pelicula;
import ComponentesCine.Peliculas;
import Servicios.ExhibicionPelicula;
import utils.Constantes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarPeliculas extends JFrame {

    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonContinuar;
    public static javax.swing.JComboBox<String> jComboBoxHora;
    public static javax.swing.JComboBox<String> jComboBoxPeliculas;
    private JLabel jLabel1;
    private JLabel jLabel19;
    private JLabel jLabel13;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelMenores;
    public static javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPrecio2DAdulto;
    private javax.swing.JLabel jLabelPrecio2DNiños;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JRadioButton jRadioButtonEfectivo;
    public static javax.swing.JRadioButton jRadioButtonTCredito;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosAdultos;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosNiños;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosViejos;
    public static javax.swing.JToggleButton jToggleButtonEncender;
    public ArrayList horarios = new ArrayList();
    public ArrayList imagenesPeliculas = new ArrayList();

    public MostrarPeliculas() {
        initComponents();
        super.setTitle("Menu");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        jLabelMenores.setVisible(false);
        Desactivados();
    }

    void Encender() {
        Constantes.init();
        if (jToggleButtonEncender.isSelected()) {

            Cine cinePOOI = new Cine("POOI", 7);

            for (Pelicula pelicula : Peliculas.getPeliculas()) {
                cinePOOI.aniadirPelicula(pelicula);
            }

            ArrayList<String> nombresPeliculas = new ArrayList<>();

            for (Pelicula pelicula : cinePOOI.peliculas) {
                nombresPeliculas.add(pelicula.getNombre().toLowerCase());
                imagenesPeliculas.add(pelicula.getImage());
            }

            for (Pelicula pelicula : cinePOOI.peliculas) {
                for (ExhibicionPelicula exhibicionPelicula : pelicula.getExhibicionesPelicula()) {
                    horarios.add(exhibicionPelicula.getHorario());
                }
            }
            jComboBoxPeliculas.setEnabled(true);
            jComboBoxHora.setEnabled(true);
            AgregarBoxNombrePelicula(nombresPeliculas);
            jToggleButtonEncender.setText("Apagar");
        } else {
            jComboBoxPeliculas.setEnabled(false);
            jComboBoxHora.setEnabled(false);
            limpiar();
            Desactivados();
            jToggleButtonEncender.setText("Encender");
        }
    }

    void Desactivados() {
        jComboBoxPeliculas.setEnabled(false);
        jComboBoxHora.setEnabled(false);
        jRadioButtonEfectivo.setEnabled(false);
        jRadioButtonTCredito.setEnabled(false);
        jTextFieldCantidadDeBoletosAdultos.setEnabled(false);
        jTextFieldCantidadDeBoletosNiños.setEnabled(false);
        jButtonContinuar.setEnabled(false);
    }

    void Activar() {
        jRadioButtonEfectivo.setEnabled(true);
        jRadioButtonTCredito.setEnabled(true);
        jTextFieldCantidadDeBoletosAdultos.setEnabled(true);
        jTextFieldCantidadDeBoletosNiños.setEnabled(true);
        jButtonContinuar.setEnabled(true);
    }

    void AgregarBoxNombrePelicula(ArrayList nombresPeliculas) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        for (Object nombrePelicula : nombresPeliculas) {
            modelo.addElement(nombrePelicula);
        }
        jComboBoxPeliculas.setModel(modelo);

    }

    void seleccionPelicula() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2 || combo == 3 || combo == 4 || combo == 5 || combo == 6 || combo == 7) {
            Activar();
            MenoresEdad();
        } else {
            jRadioButtonEfectivo.setEnabled(false);
            jRadioButtonTCredito.setEnabled(false);
            jTextFieldCantidadDeBoletosAdultos.setEnabled(false);
            jTextFieldCantidadDeBoletosNiños.setEnabled(false);
            jButtonContinuar.setEnabled(false);
        }
    }

    public void caratulas() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 0) {
            ImageIcon i = new ImageIcon("");
            jLabelPelicula.setIcon(i);
            jComboBoxHora.setEnabled(false);
        } else {
            jComboBoxHora.setEnabled(true);
            LimCantidad();
            ImageIcon i = new ImageIcon((Image) imagenesPeliculas.get(combo - 1));
            jLabelPelicula.setIcon(i);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            modelo.addElement("Seleccione");
            String str = String.valueOf(horarios.get(combo - 1));
            modelo.addElement(str);
            jComboBoxHora.setModel(modelo);
        }
    }

    void LimCantidad() {
        jTextFieldCantidadDeBoletosAdultos.setText("");
        jTextFieldCantidadDeBoletosNiños.setText("");
    }

    void limpiar() {
        ImageIcon i = new ImageIcon("");
        jLabelPelicula.setIcon(i);
        jTextFieldCantidadDeBoletosAdultos.setText("");
        buttonGroup1.clearSelection();
        jComboBoxPeliculas.removeAllItems();
        jComboBoxHora.removeAllItems();
    }

    void MenoresEdad() {
        int combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2) {
            jLabelMenores.setVisible(true);
            jTextFieldCantidadDeBoletosNiños.setVisible(false);
            jLabelMenores.setText("No apta para menores de edad");
        }
        if (combo == 3 || combo == 4 || combo == 5 || combo == 6 || combo == 7) {
            jTextFieldCantidadDeBoletosNiños.setVisible(true);
            jLabelMenores.setVisible(false);
        }
    }


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jPanel7 = new JPanel();
        jComboBoxPeliculas = new JComboBox<>();
        jToggleButtonEncender = new JToggleButton();
        jLabel2 = new JLabel();
        jComboBoxHora = new JComboBox<>();
        jLabel3 = new JLabel();
        jPanel1 = new JPanel();
        jLabelPrecio2DAdulto = new JLabel();
        jLabel4 = new JLabel();
        jLabel8 = new JLabel();
        jLabelPrecio2DNiños = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel19 = new JLabel();
        jLabel13 = new JLabel();
        jTextFieldCantidadDeBoletosAdultos = new JTextField();
        jTextFieldCantidadDeBoletosViejos = new JTextField();
        jLabel7 = new JLabel();
        jPanel5 = new JPanel();
        jRadioButtonEfectivo = new JRadioButton();
        jRadioButtonTCredito = new JRadioButton();
        jButtonContinuar = new JButton();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jTextFieldCantidadDeBoletosNiños = new JTextField();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabelMenores = new JLabel();
        jLabelPelicula = new JLabel();
        jLabel5 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new Color(180, 207, 176));

        jLabel1.setFont(new Font("Ubuntu Condensed", 0, 18));
        jLabel1.setText("Bievenido:");
        jPanel3.add(jLabel1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new Color(240, 233, 210));

        jComboBoxPeliculas.setBackground(new Color(240, 233, 210));
        jComboBoxPeliculas.setFont(new Font("Ubuntu Condensed", 0, 14));
        jComboBoxPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeliculasActionPerformed(evt);
            }
        });

        jToggleButtonEncender.setText("Encender");
        jToggleButtonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEncenderActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel2.setText("Peliculas");

        jComboBoxHora.setBackground(new Color(230, 221, 196));

        jLabel3.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel3.setText("Hora");

        jPanel1.setBackground(new Color(230, 221, 196));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabelPrecio2DAdulto.setFont(new Font("Ubuntu Condensed", 0, 14));
        jLabelPrecio2DAdulto.setText("40");

        jLabel4.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel4.setText("Precios Adultos");

        jLabel8.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel8.setText("Precios Niños");

        jLabel19.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel19.setText("Precios Viejos");

        jLabelPrecio2DNiños.setFont(new Font("Ubuntu Condensed", 0, 14));
        jLabelPrecio2DNiños.setText("40");

        jLabel11.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel11.setText("Adultos");

        jLabel13.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel13.setText("Viejos");

        jLabel12.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel12.setText("Cantidad:");

        jTextFieldCantidadDeBoletosAdultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosAdultosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel7.setText("Forma de pago");

        jPanel5.setBackground(new java.awt.Color(230, 221, 196));

        buttonGroup1.add(jRadioButtonEfectivo);
        jRadioButtonEfectivo.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14));
        jRadioButtonEfectivo.setText("Efectivo");

        buttonGroup1.add(jRadioButtonTCredito);
        jRadioButtonTCredito.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14));
        jRadioButtonTCredito.setText("Tarjeta de crédito");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jRadioButtonEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jRadioButtonTCredito)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jRadioButtonEfectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonTCredito)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonContinuar.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jButtonContinuar.setText("Continuar");
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new Font("Ubuntu Condensed", 0, 14));
        jLabel16.setText("2D");

        jLabel17.setText("Bs");

        jLabel18.setText("Bs");

        jLabel14.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel14.setText("Boletos");

        jLabel15.setFont(new Font("Ubuntu Condensed", 1, 14));
        jLabel15.setText("Niños");

        jLabelMenores.setText("jLabel6");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(176, 176, 176)
                                                .addComponent(jLabel8)
                                                .addGap(74, 74, 74)
                                                .addComponent(jLabel14))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButtonContinuar)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel4)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel7)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel16)
                                                                                .addGap(37, 37, 37)
                                                                                .addComponent(jLabel17)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabelPrecio2DAdulto))))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(71, 71, 71)
                                                                        .addComponent(jLabel18)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabelPrecio2DNiños)
                                                                        .addGap(64, 64, 64))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel12)
                                                                        .addGap(45, 45, 45)))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel11))
                                                        .addGap(29, 29, 29)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabelMenores)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jLabel15))
                                                        .addGap(37, 37, 37))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabelPrecio2DAdulto)
                                                .addComponent(jLabel16))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabelPrecio2DNiños)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel15)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelMenores))
                                        ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButtonContinuar))
                                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabelPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("CINE POOI");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel2)))
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jLabel3)))
                                                .addGap(122, 122, 122)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                                                .addComponent(jToggleButtonEncender))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jToggleButtonEncender)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void jToggleButtonEncenderActionPerformed(java.awt.event.ActionEvent evt) {
        Encender();
    }

    private void jComboBoxPeliculasActionPerformed(java.awt.event.ActionEvent evt) {
        seleccionPelicula();
        caratulas();
    }

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {
    }


    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBoxPeliculas.getSelectedIndex() == 0 || jComboBoxHora.getSelectedIndex() == 0 || jTextFieldCantidadDeBoletosAdultos.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Todavía hacen falta datos por completar", "Complete datos", JOptionPane.WARNING_MESSAGE);
        } else {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    private void jTextFieldCantidadDeBoletosAdultosActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Linux".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarPeliculas().setVisible(true);
            }
        });
    }
}
