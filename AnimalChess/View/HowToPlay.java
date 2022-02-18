package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*; 

/** 
* Represents a HowToPlay
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class HowToPlay{
    private JPanel pnlInstructions;
    private JPanel pnlTextInstructions;
    private JTextArea texts;
    private JScrollPane scroll;


    /** 
    * Constructs a new HowToPlay object
    *
    * @param strInstructions the game instructions 
    */
    public HowToPlay(String strInstructions){

        pnlInstructions = new JPanel();
        pnlTextInstructions = new JPanel();
        texts = new JTextArea(strInstructions, 25, 60);
        scroll = new JScrollPane(texts,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setUpHowToPlay();
    }


    /** 
    * This function returns the pnlInstructions
    *
    * @return JPanel  the pnlInstructions of a HowToPlay object
    */
    public JPanel getPnlInstructions(){
        return pnlInstructions;
    }


    /** 
    * This function initializes the attributes of a HowToPlay object
    *
    */
    private void setUpHowToPlay(){
        pnlInstructions.setLayout(new BoxLayout(pnlInstructions, BoxLayout.Y_AXIS));
        pnlInstructions.setBorder(new EmptyBorder(new Insets(15,30,50,30)));

        texts.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 17));
        texts.setBackground(GUI.DARK_CYAN);
        texts.setForeground(Color.white);
        texts.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlTextInstructions.add(scroll);
        pnlTextInstructions.setOpaque(false);
        pnlInstructions.add(pnlTextInstructions);

        pnlInstructions.setOpaque(false);
    }


    /** 
    * This function adds a btnBackToMainMenu to the pnlInstructions of a HowToPlay object
    *
    * @param    btnBackToMainMenu       the JButton to be added to the pnlInstructions
    */
    public void updateHowToPlay(JButton btnBackToMainMenu){
        pnlInstructions.add(btnBackToMainMenu);
    }
}