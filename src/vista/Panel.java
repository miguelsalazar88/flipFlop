package vista;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    //Los números guardados en cada instancia del flip flop
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    boolean po = false; //Confirma que haya parallel output

    public Panel(){
        this.setSize(400,110);
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawString("P.O.",0,15);
        g.drawString("S.O.",285,50);

        //Cuadrados
        g.drawRect(30,30,30,30);
        g.drawRect(90,30,30,30);
        g.drawRect(150,30,30,30);
        g.drawRect(210,30,30,30);

        //Lineas conectoras con el Mensaje y los CBOs
        g.drawLine(45,60,45,100);
        g.drawLine(105,60,105,100);
        g.drawLine(165,60,165,100);
        g.drawLine(225,60,225,100);
        g.drawLine(0,85,15,85);
        g.drawLine(15,85,15,45);
        g.drawLine(15,45,30,45);

        //Lineas conectoras entre cuadrados
        g.drawLine(60,45,90,45);
        g.drawLine(120,45,150,45);
        g.drawLine(180,45,210,45);
        g.drawLine(240,45,270,45);

        //Valores de los flip flops
        g.drawString(String.valueOf(num1),41,50);
        g.drawString(String.valueOf(num2),101,50);
        g.drawString(String.valueOf(num3),161,50);
        g.drawString(String.valueOf(num4),221,50);

        //bordes leds
        g.drawOval(40,5,10,10);
        g.drawOval(100,5,10,10);
        g.drawOval(160,5,10,10);
        g.drawOval(220,5,10,10);
        g.drawOval(270,40,10,10);

        if(this.po == true){
            g.setColor(Color.GREEN);

            if(num1==1){
                g.fillOval(40,5,10,10);
            }
            if(num2==1){
                g.fillOval(100,5,10,10);
            }
            if(num3==1){
                g.fillOval(160,5,10,10);
            }
            if(num4==1){
                g.fillOval(220,5,10,10);
            }
        }

        else{
            if(num4==1){
                g.setColor(Color.orange);
                g.fillOval(270,40,10,10);
            }
        }

    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public boolean isPo() {
        return po;
    }

    public void setPo(boolean po) {
        this.po = po;
    }
}
