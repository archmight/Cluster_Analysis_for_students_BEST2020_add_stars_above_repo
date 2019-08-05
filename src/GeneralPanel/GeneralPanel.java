package GeneralPanel;

import clusters_and_nodes.Node.Node;
import clusters_and_nodes.clusters.Cluster;
import Metrics.Metrics;
import com.company.MainUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GeneralPanel extends JPanel {

    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Cluster> clusters = new ArrayList<>();
    int StepNumber = 0;

    public void addNode(Node node) {
        nodes.add(node);
        this.repaint();
    }

    public void addCluster(Cluster cluster) {
        clusters.add(cluster);
        this.repaint();
    }


    @Override
    public void paint(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0,0,480,480);
        for(Node n : nodes) {
            n.draw(g);
        }
        for (Cluster c: clusters) {
            c.draw(g);
        }
    }

    public void stepLesson() {
        if(StepNumber == 0) {
            Random rand = new Random();
            for (Cluster c: clusters) {
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                c.setColor(new Color(r,g,b));
            }
        }

        double length = 0;
        double templength;
        for (Node n : nodes) {
            length = Metrics.chooseMetric(n.getPosX(),n.getPosY(),clusters.get(0).getPosX(),clusters.get(0).getPosY(), MainUI.booleanMetrics);
            n.setCluster(clusters.get(0));
            templength = length;
            for (Cluster c : clusters) {
                templength = Metrics.chooseMetric(n.getPosX(),n.getPosY(),c.getPosX(),c.getPosY(), MainUI.booleanMetrics);
                if(templength < length){
                    n.setCluster(c);
                    length = templength;
                }
            }
        }

        for (Cluster c : clusters){
            ArrayList<Node> tmpnodes = new ArrayList<>();
            for (Node n: nodes){
                if(n.getCluster().getColor() == c.getColor())
                tmpnodes.add(n);
            }
            c.setPosition(tmpnodes);
        }
        this.repaint();

        ++StepNumber;
    }
}
