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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//Totals panel
public class PanelTotals extends JPanel {

    //-----------------------------------------------------------------
    //Attributes of the user interface
    //-----------------------------------------------------------------

    //Label with cost of calls
    private JLabel costLabel;

    //Label with total calls
    private JLabel numberOfCallsLabel;

    //Label with total minutes
    private JLabel minutesLabel;

    //Label with average
    private JLabel averageCostLabel;
    
    //Text field for cost of call
    private JTextField txtShowCost;
    
    //Text field for number of calls
    private JTextField txtNumberOfCalls;
    
    //Text field for total minutes
    private JTextField txtMinutes;
    
    //Text field for average
    private JTextField txtAverage;

    //-----------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------

    //Panel constructor
    public PanelTotals() {
        setBorder(new TitledBorder("Totals"));
        setLayout(new GridLayout(4, 2));

        //Cost label
        costLabel = new JLabel("Total cost:");
        costLabel.setForeground(Color.BLUE.darker());
        costLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //Number of calls label
        numberOfCallsLabel = new JLabel("Number of total calls:");

        //Number of minutes label
        minutesLabel = new JLabel("Number of total minutes:");

        //Average cost per minute label
        averageCostLabel = new JLabel("Average cost per minute:");
        
        //Cost text field
        txtShowCost = new JTextField(8);
        txtShowCost.setForeground(Color.BLUE.darker());
        txtShowCost.setFont(new Font("Times New Roman", Font.BOLD, 16));
        txtShowCost.setText(formatValue(0));
        txtShowCost.setEditable(false);
        
        //Calls text field
        txtNumberOfCalls = new JTextField(6);
        txtNumberOfCalls.setEditable(false);
        txtNumberOfCalls.setText("0");
        
        //Minutes text field
        txtMinutes = new JTextField(6);
        txtMinutes.setEditable(false);
        txtMinutes.setText("0");
        
        //Average text field
        txtAverage = new JTextField(6);
        txtAverage.setEditable(false);
        txtAverage.setText("N/A");
        
        add(costLabel);
        add(txtShowCost);
        add(numberOfCallsLabel);
        add(txtNumberOfCalls);
        add(minutesLabel);
        add(txtMinutes);
        add(averageCostLabel);
        add(txtAverage);
        
    }

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    /**
     * Actualiza la información.
     * @param pCostTotal Cost total de las llamadas de las tres líneas. pCostTotal>=0.
     * @param pTotalCalls Total número de llamadas. pTotalCalls>=0.
     * @param pTotalMinutes Total número de minutes. pTotalMinutes>=0.
     * @param pCostPromedio Cost promedio por minutes. pCostPromedio>=0.
     */
    public void update(double pCostTotal, int pTotalCalls, int pTotalMinutes, double pCostPromedio)
    {
    	txtShowCost.setText(formatValue(pCostTotal));
    	txtNumberOfCalls.setText(formatValueEntero(pTotalCalls));
    	txtMinutes.setText(formatValueEntero(pTotalMinutes));
        if(!Double.isNaN(pCostPromedio))
        {
        	txtAverage.setText(formatValue(pCostPromedio));
        }
        else
        {
        	txtAverage.setText("N/A");
        }
        
    }

    /**
     * Formatea un valor numérico para presentar en la userInterface. <br>
     * @param pValor Valor numérico a ser formateado. pValor>0.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatValue(double pValor)
    {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("$ ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

    /**
     * Formatea un valor numérico para presentar en la userInterface <br>
     * @param pValor Valor numérico a ser formateado. pValor>0.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatValueEntero(int pValor)
    {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern(" ###,###");
        df.setMinimumFractionDigits(0);
        return df.format(pValor);
    }

}
