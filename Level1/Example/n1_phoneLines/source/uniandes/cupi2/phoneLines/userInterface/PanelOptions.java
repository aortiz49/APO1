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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

//Options panel
public class PanelOptions extends JPanel implements ActionListener {

    //-----------------------------------------------------------------
    //Constants
    //-----------------------------------------------------------------

    //Command to reset phone lines
    private static final String RESTART = "RESTART";

    //Option1 command
    private static final String OPTION_1 = "OPTION_1";

    //Option2 command
    private static final String OPTION_2 = "OPTION_2";

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    //Main application window
    private PhoneLineInterface principal;

    //-----------------------------------------------------------------
    //Attributes of user interface
    //-----------------------------------------------------------------

    //Reset button
    private JButton restartBtn;

    //Option1 button
    private JButton option1Btn;

    //Option2 button
    private JButton option2Btn;

    //-----------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------

    //Panel constructor
    public PanelOptions(PhoneLineInterface pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Options"));
        setLayout(new GridLayout(1, 3));

        //Restart
        restartBtn = new JButton("Restart");
        restartBtn.setActionCommand(RESTART);
        restartBtn.addActionListener(this);
        add(restartBtn);

        //Button option1
        option1Btn = new JButton("Option 1");
        option1Btn.setActionCommand(OPTION_1);
        option1Btn.addActionListener(this);
        add(option1Btn);

        //Button option2
        option2Btn = new JButton("Option 2");
        option2Btn.setActionCommand(OPTION_2);
        option2Btn.addActionListener(this);
        add(option2Btn);
    }

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    //Manages button events
    public void actionPerformed(ActionEvent pEvent) {
        if(OPTION_1.equals(pEvent.getActionCommand()))
            principal.reqFuncOption1();

        else if(OPTION_2.equals(pEvent.getActionCommand()))
            principal.reqFuncOption2();

        else if(RESTART.equals(pEvent.getActionCommand()))
            principal.reset();
    }

}
