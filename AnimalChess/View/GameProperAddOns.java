package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;

/** 
* Represents a GameProperAddOns
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class GameProperAddOns {
    private JPanel pnlNorthDisplay;
    private JLabel lblRScore;
    private JLabel lblBScore; 
    private JLabel lblTeamTurn;
    private JButton btnSoundOnOff;
    private JButton btnQuitGame;
    private JButton btnUndo;
    private JButton btnRedo;


    /** 
    * Constructs a new GameProperAddOns object
    * 
    * 
    */
    public GameProperAddOns(){
        pnlNorthDisplay = new JPanel();
        pnlNorthDisplay.setLayout(new FlowLayout());
        lblRScore = new JLabel();
        lblBScore = new JLabel();
        lblTeamTurn = new JLabel();
        btnSoundOnOff = new JButton("Sound Off");
        btnQuitGame = new JButton("Quit Game");
        btnUndo = new JButton("Undo");
        btnRedo = new JButton("Redo");
        setUpGameProperAddOns();
    }


    /** 
    * This function returns the pnlNorthDisplay
    *
    * @return JPanel  the pnlNorthDisplay of a GameProperAddOns object
    */
    public JPanel getPnlNorthDisplay(){
        return pnlNorthDisplay;
    }


    /** 
    * This function returns the btnSoundOnOff
    *
    * @return JButton  the btnSoundOnOff of a GameProperAddOns object
    */
    public JButton getBtnSoundOnOff(){
        return btnSoundOnOff;
    }


    /** 
    * This function returns the btnQuitGame
    *
    * @return JButton  the btnQuitGame of a GameProperAddOns object
    */
    public JButton getBtnQuitGame(){
        return btnQuitGame;
    }


    /** 
    * This function returns the btnUndo
    *
    * @return JButton  the btnUndo of a GameProperAddOns object
    */
    public JButton getBtnUndo(){
        return btnUndo;
    }


    /** 
    * This function returns the btnRedo
    *
    * @return JButton  the btnRedo of a GameProperAddOns object
    */
    public JButton getBtnRedo(){
        return btnRedo;
    }


    /** 
    * This function initializes the attributes of a GameProperAddOns object
    *
    */
    public void setUpGameProperAddOns(){
        lblBScore.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        lblBScore.setBackground(GUI.SOMEWHAT_BLUE);
        lblBScore.setForeground(Color.white);
        lblBScore.setUI(new StyledLabelUI(5,10,5,10));
        pnlNorthDisplay.add(lblBScore);

        btnRedo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnRedo.setBackground(GUI.SOMEWHAT_BROWN);
        btnRedo.setForeground(Color.white);
        btnRedo.setUI(new StyledButtonUI(5,10,5,10));
        pnlNorthDisplay.add(btnRedo);

        btnQuitGame.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnQuitGame.setBackground(GUI.SOMEWHAT_BROWN);
        btnQuitGame.setForeground(Color.white);
        btnQuitGame.setUI(new StyledButtonUI(5,10,5,10));
        pnlNorthDisplay.add(btnQuitGame);

        lblTeamTurn.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        lblTeamTurn.setBackground(GUI.SOMEWHAT_BROWN);
        lblTeamTurn.setForeground(Color.white);
        lblTeamTurn.setUI(new StyledLabelUI(5,10,5,10));
        pnlNorthDisplay.add(lblTeamTurn);

        btnSoundOnOff.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnSoundOnOff.setBackground(GUI.SOMEWHAT_BROWN);
        btnSoundOnOff.setForeground(Color.white);
        btnSoundOnOff.setUI(new StyledButtonUI(5,10,5,10));
        pnlNorthDisplay.add(btnSoundOnOff);

        btnUndo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnUndo.setBackground(GUI.SOMEWHAT_BROWN);
        btnUndo.setForeground(Color.white);
        btnUndo.setUI(new StyledButtonUI(5,10,5,10));
        pnlNorthDisplay.add(btnUndo);

        lblRScore.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        lblRScore.setBackground(GUI.SOMEWHAT_RED);
        lblRScore.setForeground(Color.white);
        lblRScore.setUI(new StyledLabelUI(5,10,5,10));
        pnlNorthDisplay.add(lblRScore);

        pnlNorthDisplay.setBackground(GUI.SOMEWHAT_YELLOW);
        pnlNorthDisplay.setOpaque(false);
        pnlNorthDisplay.setVisible(true);
    }


    /** 
    * This function updates the pnlNorthDisplay
    *
    * @param strTurn       the String value of the team in turn
    * @param nRScore       the number of kills of Red Team
    * @param nBScore       the number of kills of Blue Team
    */
    public void updateNorthDisplay(String strTurn, int nRScore, int nBScore){
        lblRScore.setText("RED TEAM SCORE: " + nRScore);
        lblBScore.setText("BLUE TEAM SCORE: " + nBScore);
        lblTeamTurn.setText("Turn of " + strTurn + " Team");
    }

    /** 
    * Represents a StyledLabelUI
    *
    * @reference   Walser, P.(2014, May 16). stack overflow. Retrieved 2021, August 27 from https://stackoverflow.com/a/23699047
    */
    private class StyledLabelUI extends BasicLabelUI{
        private int x;
        private int y;
        private int x2;
        private int y2;


        /** 
        * Constructs a new StyledLabelUI
        *
        * 
        */
        public StyledLabelUI(int a, int b, int c, int d){
            x = a;
            y = b;
            x2 = c;
            y2 = d;
        }


        /** 
        * This function overrides the installUI method
        *
        * @param c        the JComponent to be customized
        */
        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            JLabel label = (JLabel) c;
            label.setOpaque(false);
            label.setBorder(new EmptyBorder(x,y,x2,y2));
        }


        /** 
        * This function overrides the paint method
        *
        * @param g       an instance of Graphics
        * @param c       the JComponent to be customized
        */
        @Override
        public void paint (Graphics g, JComponent c) {
            JLabel b = (JLabel) c;
            paintBackground(g, b, 2);
            super.paint(g, c);
        }


        /** 
        * This function paints the background of a JComponent
        *
        * @param g          an instance of Graphics
        * @param c          the JComponent object to be customized
        * @param yOffset    the int value that allows the customization of a JComponent object
        */
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }


    /** 
    * Represents a StyledButtonUI
    *
    * @reference   Walser, P.(2014, May 16). stack overflow. Retrieved 2021, August 27 from https://stackoverflow.com/a/23699047
    */
    private class StyledButtonUI extends BasicButtonUI{
        private int x;
        private int y;
        private int x2;
        private int y2;


        /** 
        * Constructs a new StyledButtonUI
        *
        * 
        */
        public StyledButtonUI(int a, int b, int c, int d){
            x = a;
            y = b;
            x2 = c;
            y2 = d;
        }


        /** 
        * This function overrides the installUI method
        *
        * @param c        the JComponent to be customized
        */
        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(x, y, x2, y2));
        }


        /** 
        * This function overrides the paint method
        *
        * @param g       an instance of Graphics
        * @param c       the JComponent to be customized
        */
        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }


        /** 
        * This function paints the background of a JComponent
        *
        * @param g          an instance of Graphics
        * @param c          the JComponent object to be customized
        * @param yOffset    the int value that allows the customization of a JComponent object
        */
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }
}
