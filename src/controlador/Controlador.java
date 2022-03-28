package controlador;

import modelo.Modelo;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Ventana vista;
    private Modelo modelo;
    private final int DELAY = 1000;
    private Timer timer;

    public Controlador(Ventana vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(this.vista.getCboModo().getSelectedIndex()==1 ||
        this.vista.getCboModo().getSelectedIndex()==3){
            if(e.getSource().equals(this.vista.getCbo1())){
                if(this.vista.getCbo1().getSelectedIndex()==0){
                    this.vista.getPanel().setNum1(0);
                    this.vista.getPanel().repaint();
                }
                if(this.vista.getCbo1().getSelectedIndex()==1){
                    this.vista.getPanel().setNum1(1);
                    this.vista.getPanel().repaint();
                }
            }

            if(e.getSource().equals(this.vista.getCbo2())){
                if(this.vista.getCbo2().getSelectedIndex()==0){
                    this.vista.getPanel().setNum2(0);
                    this.vista.getPanel().repaint();
                }
                if(this.vista.getCbo2().getSelectedIndex()==1){
                    this.vista.getPanel().setNum2(1);
                    this.vista.getPanel().repaint();
                }
            }

            if(e.getSource().equals(this.vista.getCbo3())){
                if(this.vista.getCbo3().getSelectedIndex()==0){
                    this.vista.getPanel().setNum3(0);
                    this.vista.getPanel().repaint();
                }
                if(this.vista.getCbo3().getSelectedIndex()==1){
                    this.vista.getPanel().setNum3(1);
                    this.vista.getPanel().repaint();
                }
            }

            if(e.getSource().equals(this.vista.getCbo4())){
                if(this.vista.getCbo4().getSelectedIndex()==0){
                    this.vista.getPanel().setNum4(0);
                    this.vista.getPanel().repaint();
                }
                if(this.vista.getCbo4().getSelectedIndex()==1){
                    this.vista.getPanel().setNum4(1);
                    this.vista.getPanel().repaint();
                }
            }

        }

        //Selección del modo del registro
        if(e.getSource().equals(this.vista.getCboModo())){
            if(this.vista.getCboModo().getSelectedIndex()==1
                || this.vista.getCboModo().getSelectedIndex()==2 ){
                this.vista.getMensaje().setEnabled(true);
                this.vista.getCbo1().setSelectedIndex(0);
                this.vista.getCbo2().setSelectedIndex(0);
                this.vista.getCbo3().setSelectedIndex(0);
                this.vista.getCbo4().setSelectedIndex(0);
                this.vista.getCbo1().setEnabled(false);
                this.vista.getCbo2().setEnabled(false);
                this.vista.getCbo3().setEnabled(false);
                this.vista.getCbo4().setEnabled(false);

            }
            if(this.vista.getCboModo().getSelectedIndex()==3 ||
                    this.vista.getCboModo().getSelectedIndex()==4){
                this.vista.getMensaje().setEnabled(false);
                this.vista.getCbo1().setSelectedIndex(0);
                this.vista.getCbo2().setSelectedIndex(0);
                this.vista.getCbo3().setSelectedIndex(0);
                this.vista.getCbo4().setSelectedIndex(0);
                this.vista.getCbo1().setEnabled(true);
                this.vista.getCbo2().setEnabled(true);
                this.vista.getCbo3().setEnabled(true);
                this.vista.getCbo4().setEnabled(true);
                this.vista.getMensaje().setText("");
            }

            if(this.vista.getCboModo().getSelectedIndex()==2 ||
                this.vista.getCboModo().getSelectedIndex()==4){
                this.vista.getPanel().setPo(true);
            }


        }

        //Botones Start, Step y Stop
        if(e.getSource().equals(this.vista.getBotonIniciar())){

            //Esta parte del código revisa si todos los caracteres de la palabra introducida
            //en el serial input son válidos. Si no lo son, envía un mensaje y no inicia el
            //timer
            boolean esValida = true;
            String mensaje = this.vista.getMensaje().getText();
            for (int i = 0; i < mensaje.length(); i++) {
                if(mensaje.charAt(i) != '0' && mensaje.charAt(i) != '1'){
                    esValida = false;
                    this.vista.getMensaje().setText("");
                    JOptionPane.showMessageDialog(null,"Palabra no válida.");
                    break;
                }
            }
            //Si la palabra introducida es válida, arranca el timer
            if(esValida){
                start();
                timer.start();
            }
        }

        if(e.getSource().equals(this.vista.getBotonDetener())){
            if(timer != null){
                stop();
            }
        }

        if(e.getSource().equals(this.vista.getBotonStep())){
            step();
        }


    }

    public void start(){

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step();
            }
        });
    }

    public void step(){

        if(vista.getMensaje().getText().length()==0){
            vista.getPanel().setNum4(vista.getPanel().getNum3());
            vista.getPanel().setNum3(vista.getPanel().getNum2());
            vista.getPanel().setNum2(vista.getPanel().getNum1());
            vista.getPanel().setNum1(0);
            vista.getPanel().repaint();
        }
        else{
            String mensaje = vista.getMensaje().getText();
            vista.getPanel().setNum4(vista.getPanel().getNum3());
            vista.getPanel().setNum3(vista.getPanel().getNum2());
            vista.getPanel().setNum2(vista.getPanel().getNum1());
            vista.getPanel().setNum1(Integer.parseInt(String.valueOf(mensaje.charAt(0))));
            vista.setMensasje(mensaje.substring(1));
            vista.getPanel().repaint();
        }
    }

    public void stop(){
        timer.stop();
    }
}
