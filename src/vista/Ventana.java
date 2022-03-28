package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private Panel panel = new Panel();
    private Controlador controlador;

    //Objetos de la Vista
    private JButton botonIniciar = new JButton("Iniciar");
    private JButton botonDetener = new JButton("Detener");
    private JButton botonStep = new JButton("Step");
    private JLabel labelMensaje = new JLabel("S.I.");
    private JLabel labelPI = new JLabel("P.I.");
    private JLabel labelModo = new JLabel("Modo:");
    private JTextField mensaje = new JTextField();
    private JComboBox cboModo = new JComboBox();
    private JComboBox cbo1 = new JComboBox();
    private JComboBox cbo2 = new JComboBox();
    private JComboBox cbo3 = new JComboBox();
    private JComboBox cbo4 = new JComboBox();


    public Ventana(){

        this.setSize(620,250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("FlipFlop");
        this.initComponents();
    }

    public void initComponents() {
        //Panel
        this.add(panel);
        this.panel.setBounds(201,10,400,105);
        //Botones
        this.add(botonIniciar);
        this.botonIniciar.setBounds(10,150,100,30);
        this.add(botonDetener);
        this.botonDetener.setBounds(110,150,100,30);
        this.add(botonStep);
        this.botonStep.setBounds(10,180,100,30);
        //Label y JTF Mensaje
        this.add(labelPI);
        this.labelPI.setBounds(200,113,20,30);
        this.add(labelMensaje);
        this.labelMensaje.setBounds(10,80,80,30);
        this.add(mensaje);
        this.mensaje.setBounds(60,80,140,30);
        this.mensaje.setEnabled(false);
        //Cbos
        this.add(cbo1);
        this.cbo1.setBounds(230,113,60,30);
        this.cbo1.setEnabled(false);
        this.add(cbo2);
        this.cbo2.setBounds(290,113,60,30);
        this.cbo2.setEnabled(false);
        this.add(cbo3);
        this.cbo3.setBounds(350,113,60,30);
        this.cbo3.setEnabled(false);
        this.add(cbo4);
        this.cbo4.setBounds(410,113,60,30);
        this.cbo4.setEnabled(false);
        for (int i = 0; i < 2; i++) {
            this.cbo1.addItem(String.valueOf(i));
            this.cbo2.addItem(String.valueOf(i));
            this.cbo3.addItem(String.valueOf(i));
            this.cbo4.addItem(String.valueOf(i));
        }
        this.add(labelModo);
        this.labelModo.setBounds(10,30,60,30);
        this.add(cboModo);
        this.cboModo.setBounds(60,30,100,30);
        this.cboModo.addItem("");
        this.cboModo.addItem("SISO");
        this.cboModo.addItem("SIPO");
        this.cboModo.addItem("PISO");
        this.cboModo.addItem("PIPO");
    }


    public void setController(Controlador c) {
        this.controlador = c;
        this.botonIniciar.addActionListener(c);
        this.botonDetener.addActionListener(c);
        this.botonStep.addActionListener(c);
        this.cboModo.addActionListener(c);
        this.cbo1.addActionListener(c);
        this.cbo2.addActionListener(c);
        this.cbo3.addActionListener(c);
        this.cbo4.addActionListener(c);
    }

    //Getters y Setters


    public Panel getPanel() {
        return panel;
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }

    public JButton getBotonDetener() {
        return botonDetener;
    }

    public JButton getBotonStep() {
        return botonStep;
    }

    public JTextField getMensaje() {
        return mensaje;
    }

    public void setMensasje(String s){
        this.mensaje.setText(s);
    }

    public JComboBox getCboModo() {
        return cboModo;
    }

    public JComboBox getCbo1() {
        return cbo1;
    }

    public JComboBox getCbo2() {
        return cbo2;
    }

    public JComboBox getCbo3() {
        return cbo3;
    }

    public JComboBox getCbo4() {
        return cbo4;
    }
}
