package clusters_and_nodes.clusters;

import clusters_and_nodes.Node.Node;

import java.awt.*;
import java.util.ArrayList;

public class Cluster {
    ArrayList<Node> nodes;

    int PosX, PosY, size;
    Color color;

    public Cluster(int x, int y, int size){

        this.PosX = x;
        this.PosY = y;
        this.size = size;
        color = Color.darkGray;
    }




    public Cluster(int posX, int posY, int size, Color color) {
        PosX = posX;
        PosY = posY;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(PosX-size/2, PosY-size/2,size, size);
    }


    public int getPosX() {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }

    public int getSize() { return size; }

    public void setColor(Color color) { this.color = color; }

    public Color getColor() {
        return color;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public void setPosition(ArrayList<Node> nodes) {

        Integer sumX = 0, sumY = 0;
        this.nodes = nodes;
        for (Node n: nodes){
            sumX += n.getPosX();
            sumY += n.getPosY();
        }

        setPosX(sumX/this.nodes.size());
        setPosY(sumY/this.nodes.size());
    }

}
