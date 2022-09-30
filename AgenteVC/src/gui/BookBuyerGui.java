/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author punto
 */
import agents.BookBuyerAgent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookBuyerGui extends JFrame {

    private BookBuyerAgent myAgent;

    private JTextField titleField;
    private JButton buscar, cancelar;
    static String book = "";

    public BookBuyerGui(BookBuyerAgent a) {
        super(a.getLocalName());

        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Book title:"));
        titleField = new JTextField(15);
        p.add(titleField);
        buscar = new JButton("Comprar");        
        cancelar = new JButton("Cancelar");
        
        p.add(buscar);
        p.add(cancelar);
        
        buscar.addActionListener(e ->{
            book = titleField.getText().trim();
            Object[] obj = {book};
            myAgent.setArguments(obj);
            myAgent.comprar();
            titleField.setText("");
        });
        
        cancelar.addActionListener(e -> {
            myAgent.cancel();
        });

        getContentPane().add(p);
    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }

}
