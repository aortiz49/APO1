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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

//Phone line information panel
public class PanelPhoneLine extends JPanel implements ActionListener {

    //-----------------------------------------------------------------
    //Constants
    //-----------------------------------------------------------------

    // Command to add a call
    private static final String ADD = "ADD";

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------


    private PhoneLineInterface principal;

    // Phone line number
    private int numberLine;

    //-----------------------------------------------------------------
    //Attributes of user interface
    //-----------------------------------------------------------------

    // Image label
    private JLabel imageLabel;

    // Cost label
    private JLabel costLabel;

    // Calls label
    private JLabel numberOfCallsLabel;

    // Minutes label
    private JLabel minutesLabel;
    
    // Number of calls text field
    private JTextField txtNumberOfCalls;
    
    // Number of minutes text field
    private JTextField txtMinutes;

    // Button to add call
    private JButton addBtn;

    //-----------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------

    // Panel constructor
    public PanelPhoneLine(PhoneLineInterface pPrincipal, int pNumberLine) {
        principal = pPrincipal;
        numberLine = pNumberLine;
        setBorder(new TitledBorder("Line " + numberLine));
        setLayout(new GridLayout(2, 1));
        setPreferredSize(new Dimension(260, 220));

        //Image label
        ImageIcon icon = new ImageIcon("data/linea" + numberLine + ".png");
        imageLabel = new JLabel("");
        imageLabel.setIcon(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        //Cost label
        costLabel = new JLabel(formatValue(0));
        costLabel.setForeground(Color.BLUE.darker());
        costLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        costLabel.setHorizontalAlignment(JLabel.CENTER);

        //Number of calls label
        numberOfCallsLabel = new JLabel("Number of calls: ");

        //Number of minutes label
        minutesLabel = new JLabel("Number of minutes: ");

        //Number of calls text field
        txtNumberOfCalls = new JTextField(4);
        txtNumberOfCalls.setEditable(false);
        txtNumberOfCalls.setText("0");
        
        //Number of minutes text field
        txtMinutes = new JTextField(4);
        txtMinutes.setEditable(false);
        txtMinutes.setText("0");
        
        //Button to add call
        addBtn = new JButton("Add call");
        addBtn.setPreferredSize(new Dimension(150, 25));
        addBtn.setActionCommand(ADD);
        addBtn.addActionListener(this);

        //Organization
        JPanel panelData = new JPanel(new GridLayout(4, 1));
        JPanel panelCalls = new JPanel(new BorderLayout());
        JPanel panelMinutes = new JPanel(new BorderLayout());
        
        panelData.setBorder(new EmptyBorder(8, 0, 8, 0));
        panelData.add(costLabel);
        panelData.add(panelCalls);
        panelData.add(panelMinutes);
        panelData.add(addBtn);
  
        panelCalls.add(numberOfCallsLabel, BorderLayout.CENTER);
        panelCalls.add(txtNumberOfCalls, BorderLayout.EAST);
        panelMinutes.add(minutesLabel, BorderLayout.CENTER);
        panelMinutes.add(txtMinutes, BorderLayout.EAST);
        
        add (imageLabel);
        add (panelData);
    }

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    //Updates information
    public void update(double pCostCalls, int pTotalCalls, int pTotalMinutes) {
        costLabel.setText(formatValue(pCostCalls));
        txtNumberOfCalls.setText(formatValueWhole(pTotalCalls));
        txtMinutes.setText(formatValueWhole(pTotalMinutes));
    }

    // Formats value
    private String formatValue(double pValor) {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("$ ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

    // Format value
    private String formatValueWhole(int pValor) {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern(" ###,###");
        df.setMinimumFractionDigits(0);
        return df.format(pValor);
    }

    // Button even manager
    public void actionPerformed(ActionEvent pEvent) {
        if(ADD.equals(pEvent.getActionCommand()))
            principal.addCall(numberLine);
    }

}
