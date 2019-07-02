package clusters_and_nodes.Node;

import clusters_and_nodes.clusters.Cluster;

import java.awt.*;

public class Node {
    Cluster cluster;

    int PosX, PosY, size;
    Color color;

    public Node(int x, int y, int size){

        this.PosX = x;
        this.PosY = y;
        this.size = size;
        color = Color.lightGray;
    }

    public Node(int posX, int posY, int size, Color color) {
        PosX = posX;
        PosY = posY;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(PosX-size/2, PosY-size/2,size, size);
    }

    public Cluster getCluster() {
        return cluster;
    }

    public int getPosX() {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }

    public int getSize() { return size; }

    public void setColor(Color color) { this.color = color; }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
        setColor(cluster.getColor());
    }
}
