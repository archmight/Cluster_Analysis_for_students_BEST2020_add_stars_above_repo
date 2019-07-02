package GeneralPanel;

import clusters_and_nodes.Node.Node;
import clusters_and_nodes.clusters.Cluster;
import com.company.MainUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GeneralClickListener extends MouseAdapter {

    GeneralPanel generalPanel;

    public GeneralClickListener(GeneralPanel generalPanel) {
        super();
        this.generalPanel = generalPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(MainUI.booleanGeneralPanel) {
            generalPanel.addNode(new Node(e.getX(), e.getY(), 15));
        }
        else {
            generalPanel.addCluster(new Cluster(e.getX(), e.getY(), 20));
        }
    }
}
