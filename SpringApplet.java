import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SpringApplet extends JApplet {
    public void rysowanieUWspolrzednych(Graphics g){
        //do zadania na bdb
        //rysowanie linii x i y ukladu
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double(0,300 , 800, 300));
        g2.draw(new Line2D.Double(400,0,400,600));
        //rysowanie grotow linii x i y
        int xpoints1[]={400,395,405};
        int ypoints1[]={0,7,7};
        g2.fillPolygon(xpoints1,ypoints1,3);
        int xpoints2[]={800,793,793};
        int ypoints2[]={300,295,305};
        g2.fillPolygon(xpoints2,ypoints2,3);
        //rysowanie podzialki
        for(int i=10;i<800;i=i+10){
            g2.draw(new Line2D.Double(i,297,i,303));
        }
        for(int i=10;i<600;i=i+10){
            g2.draw(new Line2D.Double(397,i,403,i));
        }
    }
    public void init(){
        //wypisywanie w konsoli (program na db)
        //utworzenie wektorow za pomoca konstruktora z parametrami
        Vector2D wektor1 = new Vector2D(3,4);
        Vector2D wektor2 = new Vector2D(-2,1);
        //obliczenie sumy i roznicy wektorow
        Vector2D suma=wektor1.suma(wektor2);
        Vector2D roznica=wektor1.roznica(wektor2);
        //obliczenie wektorow znormalizowanych
        Vector2D norm1 = wektor1.norm();
        Vector2D norm2 = wektor2.norm();
        //obliczenie dlugosci wektorow
        double a = wektor1.dlugosc();
        double b = wektor2.dlugosc();
        //wektor przemnozony przez stala 3
        Vector2D stala = wektor1.iloczyn(3);
        //wyswietlenie informacji
        System.out.println("Utworzone wektory:");
        wektor1.info();
        wektor2.info();
        System.out.println("Suma oraz roznica utworzonych wektorow:");
        suma.info();
        roznica.info();
        System.out.println("Wektory znormalizowane:");
        norm1.info();
        norm2.info();
        System.out.println("Dlugosc wektora 1: "+a);
        System.out.println("Dlugosc wektora 2: "+b);
        System.out.println("Wektor 1 pomnozony przez 3:");
        stala.info();
    }
    public void paint(Graphics g) {
        setSize(800,600);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.black);
        rysowanieUWspolrzednych(g);
        //utworzenie wektorow do rysowania i obliczenia danych o wektorach
        Vector2D wektor1 = new Vector2D(180,70);
        Vector2D wektor2 = new Vector2D(-90,-100);
        Vector2D wektor3 = wektor1.suma(wektor2);
        Vector2D wektor4 = wektor1.roznica(wektor2);
        Vector2D norm1 = wektor1.norm();
        Vector2D norm2 = wektor2.norm();
        Vector2D stala = wektor1.iloczyn(2);
        double a = wektor1.dlugosc();
        double b = wektor2.dlugosc();
        //wspolrzedne poczatka ukladu wspolrzednych, wskazuja gdzie zaczac rysowanie wektorow
        double x0=400;
        double y0=300;
        g2.setPaint(Color.blue);
        g2.drawString("Wektor 1",100,200);
        wektor1.rysowanieWektora(x0,y0,g);
        //gdzie jestem - rysowanie nastepnego wektora od konca poprzedniego
        double x=x0+wektor1.getWspX();
        double y=y0-wektor1.getWspY();
        g2.setPaint(Color.green);
        wektor2.rysowanieWektora(x,y,g);
        g2.drawString("Wektor 2",100,220);
        //rysowanie sumy i roznicy wektorow
        g2.setPaint(Color.cyan);
        g2.drawString("Suma wektorów 1 i 2",440,350);
        wektor3.rysowanieWektora(x0,y0,g);
        g2.setPaint(Color.magenta);
        g2.drawString("Roznica wektorów 1 i 2",440,180);
        wektor4.rysowanieWektora(x0,y0,g);
        //wektory znormalizowane sa male i slabo widoczne na powierzchni apletu, dlatego ich nie rysuje
        //sa jednak uzywane przy rysowaniu grotow
        //rysowanie wektora 1 pomnozonego przez stala
        g2.setPaint(Color.orange);
        g2.drawString("Wektor 1 pomnozony przez dwa",600,230);
        stala.rysowanieWektora(x0,y0,g);
        g2.setPaint(Color.black);
        g2.drawString("Info po kolei o wektorach 1, 2, ich dlugosci, sumie, roznicy,",15,360);
        g2.drawString("wektorach znormalizowanych i wektorze 1 pomnozonym przez 2:",15,380);
        g2.drawString(wektor1.info(1)+" dlugosc: "+wektor1.dlugosc(),15,400);
        g2.drawString(wektor2.info(1)+" dlugosc: "+wektor2.dlugosc(),15,420);
        g2.drawString(wektor3.info(1)+" dlugosc: "+wektor3.dlugosc(),15,440);
        g2.drawString(wektor4.info(1)+" dlugosc: "+wektor4.dlugosc(),15,460);
        g2.drawString(norm1.info(1)+" dlugosc: "+norm1.dlugosc(),15,480);
        g2.drawString(norm2.info(1)+" dlugosc: "+norm2.dlugosc(),15,500);
        g2.drawString(stala.info(1)+" dlugosc: "+stala.dlugosc(),15,520);
    }
}