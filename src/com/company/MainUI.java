package com.company;

import GeneralPanel.GeneralPanel;
import GeneralPanel.GeneralClickListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainUI extends JFrame {

    GeneralPanel generalPanel;
    JRadioButton radioButtonNodes;
    JRadioButton radioButtonCluster;
    JRadioButton radioButtonEuclid;
    JRadioButton radioButtonManhattan;
    BufferedImage image;

    public static boolean booleanGeneralPanel = true;
    public static boolean booleanMetrics = true;

    MainUI(String title) throws IOException {

        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        init();

        super.setSize(700, 540);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frm = super.getSize();
        int xpos = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
        int ypos = (int) (screen.getHeight() / 2 - frm.getWidth() / 2);
        super.setLocation(xpos, ypos);
        super.setVisible(true);
    }

    void init() throws IOException {

        this.setLayout(null);



        image = ImageIO.read(new File("/home/gerdon/IdeaProjects/ClusterAnalysis/src/pics/cluster.png"));


        generalPanel = new GeneralPanel();
        generalPanel.addMouseListener(new GeneralClickListener(generalPanel));


        generalPanel.setBounds(10,10,480,480);

        this.add(generalPanel);

        JPanel ButtonPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 180,30, null);
            }
        };

        JButton Generate = new JButton("Divine step");



        radioButtonNodes = new JRadioButton("add Nodes", true);
        radioButtonCluster = new JRadioButton("add Clusters", false);
        radioButtonEuclid = new JRadioButton("Euclid", true);
        radioButtonManhattan = new JRadioButton("Manhattan", false);



        ButtonGroup addElementsButtonGroup = new ButtonGroup();

        addElementsButtonGroup.add(radioButtonCluster);
        addElementsButtonGroup.add(radioButtonNodes);


        ButtonGroup metricsButtonGroup = new ButtonGroup();
        metricsButtonGroup.add(radioButtonEuclid);
        metricsButtonGroup.add(radioButtonManhattan);



        radioButtonCluster.addActionListener(new isPaintCluster());
        radioButtonNodes.addActionListener(new isPaintNode());
        radioButtonEuclid.addActionListener(new isEuclid());
        radioButtonManhattan.addActionListener(new isManhattan());
        Generate.addActionListener(new isStep());
        ButtonPanel.setLayout(null);



        ButtonPanel.add(Generate);
        Generate.setBounds(0,400,170,30);

        this.add(ButtonPanel);
        ButtonPanel.setBounds(500,10,180,480);
        ButtonPanel.add(radioButtonNodes);
        radioButtonNodes.setBounds(0,200,120,20);
        ButtonPanel.add(radioButtonCluster);
        radioButtonCluster.setBounds(0,230,120,20);

        ButtonPanel.add(radioButtonEuclid);
        radioButtonEuclid.setBounds(0,100,120,20);
        ButtonPanel.add(radioButtonManhattan);
        radioButtonManhattan.setBounds(0,130,120,20);


    }

    class isStep implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            radioButtonNodes.setEnabled(false);
            radioButtonCluster.setEnabled(false);

            generalPanel.stepLesson();
        }
    }

    class isPaintNode implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(booleanGeneralPanel){
                booleanGeneralPanel = false;
            }
            else {
                booleanGeneralPanel = true;
            }
        }
    }

    class isPaintCluster implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!booleanGeneralPanel){
                booleanGeneralPanel = true;
            }
            else {
                booleanGeneralPanel = false;
            }
        }
    }

    class isEuclid implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(booleanMetrics){
                booleanMetrics = false;
            }
            else {
                booleanMetrics = true;
            }
        }
    }

    class isManhattan implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!booleanMetrics){
                booleanMetrics = true;
            }
            else {
                booleanMetrics = false;
            }
        }
    }
}