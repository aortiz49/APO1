/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- phone lines
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.phoneLines.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.phoneLines.mundo.Company;

//Principal window of the application
public class PhoneLineInterface extends JFrame {
    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    //Principal class
    private Company company;

    //Image panel
    private PanelImage panelImage;

    //Totals panel
    private PanelTotals panelTotals;

    //Line panels
    private PanelPhoneLine panelLine1;
    private PanelPhoneLine panelLine2;
    private PanelPhoneLine panelLine3;

    //Options panel
    private PanelOptions panelOptions;

    //-----------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------

    //Interface constructor
    public PhoneLineInterface() {
        //Create a new company
        company = new Company();

        //Construct the form
        //Organize principal panel
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phone line management");

        //Create two panels here
        panelImage = new PanelImage();
        getContentPane().add(panelImage, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridLayout(1, 3));
        panelCenter.add(panelContainer, BorderLayout.CENTER);

        //Add panels to the container
        panelLine1 = new PanelPhoneLine(this, 1);
        panelContainer.add(panelLine1);
        panelLine2 = new PanelPhoneLine(this, 2);
        panelContainer.add(panelLine2);
        panelLine3 = new PanelPhoneLine(this, 3);
        panelContainer.add(panelLine3);

        panelTotals = new PanelTotals();
        panelCenter.add(panelTotals, BorderLayout.SOUTH);

        //Panel extensions
        panelOptions = new PanelOptions(this);
        getContentPane().add(panelOptions, BorderLayout.SOUTH);

        setSize(600, 610);
        setResizable(false);
        setLocationRelativeTo(null);
        ;
    }

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    //Adds a call to a line
    public void addCall(int pNumberLine) {
        String minutes = JOptionPane.showInputDialog(this, "Number of minutes used:", "Add call", JOptionPane.QUESTION_MESSAGE);
        try {
            if(minutes != null) {
                int min = Integer.parseInt(minutes);
                if(min <= 0) {
                    JOptionPane.showMessageDialog(this, "Number of minutes must be > 0", "Add call", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Object[] possibilities = { "Local", "Long Distance", "Cellphone" };
                String type = (String)JOptionPane.showInputDialog(this, "Type of call:", "Type", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Local");
                if(type != null) {
                    if(pNumberLine == 1) {
                        if("Local".equals(type))
                            company.addLocalCallLine1(min);

                        else if("Long Distance".equals(type))
                            company.addLongDistanceLine1(min);

                        else if("Cellphone".equals(type))
                            company.addCellCallLine1(min);

                    }

                    else if(pNumberLine == 2) {
                        if("Local".equals(type))
                            company.addLocalCallLine2(min);

                        else if("Long Distance".equals(type))
                            company.addLongDistanceLine2(min);

                        else if("Cellphone".equals(type))
                            company.addCellCallLine2(min);

                    }
                    else if(pNumberLine == 3) {
                        if("Local".equals(type))
                            company.addLocalCallLine3(min);

                        else if("Long Distance".equals(type))
                            company.addLongDistanceLine3(min);

                        else if("Cellphone".equals(type))
                            company.addCellCallLine3(min);

                    }
                    update();
                }
            }
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of minutes is invalid", "Add call", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Updates interface
    private void update() {
        panelTotals.update(company.getTotalCostOfCalls(), company.getTotalNumberOfCalls(), company.getTotalMinutes(), company.getAverageCostPerMinute());
        panelLine1.update(company.getLine1().getCostOfCalls(), company.getLine1().getNumberOfCalls(), company.getLine1().getNumberOfMinutes());
        panelLine2.update(company.getLine2().getCostOfCalls(), company.getLine2().getNumberOfCalls(), company.getLine2().getNumberOfMinutes());
        panelLine3.update(company.getLine3().getCostOfCalls(), company.getLine3().getNumberOfCalls(), company.getLine3().getNumberOfMinutes());
    }

    //Restarts the phone lines
    public void reset() {
        company.reset();
        update();
    }

    //-----------------------------------------------------------------
    //Extension Points
    //-----------------------------------------------------------------

    //Method for extension 1
    public void reqFuncOption1() {
        String result = company.metodo1();
        update();
        JOptionPane.showMessageDialog(this, result, "Response", JOptionPane.INFORMATION_MESSAGE);
    }

    //Method for extension 1
    public void reqFuncOption2() {
        String result = company.metodo2();
        update();
        JOptionPane.showMessageDialog(this, result, "Response", JOptionPane.INFORMATION_MESSAGE);
    }

    //-----------------------------------------------------------------
    //Main
    //-----------------------------------------------------------------

    //Method that executes the application
    public static void main(String[] pArgs) {
        //Unify interface for Mac y para Windows.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }

        catch(Exception e)
        {
        }

        PhoneLineInterface userInterface = new PhoneLineInterface();
        userInterface.setVisible(true);
    }

}