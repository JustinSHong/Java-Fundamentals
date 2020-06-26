package com.example.awtSample;

// awt - Abstract Window Toolkit
    // provides everything we need to create a GUI
    // we know we can find all classes and methods we need here
    // changes are bundled and deployed together

// * - import all class interfaces and static objects from AWT class

// package names are enforced and updated when copy/pasting
// can create a package at the same time a class is made

import java.awt.*;
import java.awt.event.WindowAdapter; // java.awt.event is different from java.awt
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("by Justin Hong", 60, 100);
    }
}
