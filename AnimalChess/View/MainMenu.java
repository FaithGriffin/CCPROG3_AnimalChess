package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;

/** 
* Represents a MainMenu
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class MainMenu{
    private JPanel pnlMainMenu;
    private JLabel lblMenu;
    private JButton btnStartGame;
    private JButton btnHowToPlay;
    private JButton btnSoundSettings;
    private JButton btnExitGame;


    /** 
    * Constructs a new MainMenu object
    *
    * 
    */ 
    public MainMenu(){
        pnlMainMenu = new JPanel();
        lblMenu = new JLabel("Main Menu");
        btnStartGame = new JButton("Start Game");
        btnHowToPlay = new JButton("How to Play");
        btnSoundSettings = new JButton("Sound Settings");
        btnExitGame = new JButton("Exit Game");
        setUpMainMenu();
    }


    /** 
    * This function returns the pnlMainMenu
    *
    * @return JPanel  the pnlMainMenu of a MainMenu object
    */
    public JPanel getPnlMainMenu(){
        return pnlMainMenu;
    }


    /** 
    * This function returns btnStartGame
    *
    * @return JButton  the btnStartGame of a MainMenu object
    */
    public JButton getBtnStartGame(){
        return btnStartGame;
    }


    /** 
    * This function returns btnHowToPlay
    *
    * @return JButton  the btnHowToPlay of a MainMenu object
    */
    public JButton getBtnHowToPlay(){
        return btnHowToPlay;
    }


    /** 
    * This function returns btnSoundSettings
    *
    * @return JButton  the btnSoundSettings of a MainMenu object
    */
    public JButton getBtnSoundSettings(){
        return btnSoundSettings;
    }


    /** 
    * This function returns btnExitGame
    *
    * @return JButton  the btnExitGame of a MainMenu object
    */
    public JButton getBtnExitButton(){
        return btnExitGame;
    }


    /** 
    * This function initializes the attributes of a MainMenu object
    *
    */
    private void setUpMainMenu(){
        pnlMainMenu.setLayout(new BoxLayout(pnlMainMenu, BoxLayout.Y_AXIS)); 
        pnlMainMenu.setBorder(new EmptyBorder(new Insets(138, 300, 138, 300)));

        lblMenu.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,30));
        lblMenu.setBackground(GUI.DARK_ORANGE);
        lblMenu.setForeground(Color.white);
        lblMenu.setUI(new StyledLabelUI(15,20,15,20));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMainMenu.add(lblMenu);
        pnlMainMenu.add(Box.createRigidArea(new Dimension(0, 69)));

        btnStartGame.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnStartGame.setBackground(GUI.GOLDEN_ROD);
        btnStartGame.setForeground(Color.white);
        btnStartGame.setUI(new StyledButtonUI(20,100,20,100));
        btnStartGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMainMenu.add(btnStartGame);
        pnlMainMenu.add(Box.createRigidArea(new Dimension(0, 20)));

        btnHowToPlay.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnHowToPlay.setBackground(GUI.GOLDEN_ROD);
        btnHowToPlay.setForeground(Color.white);
        btnHowToPlay.setUI(new StyledButtonUI(20,100,20,100));
        btnHowToPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMainMenu.add(btnHowToPlay);
        pnlMainMenu.add(Box.createRigidArea(new Dimension(0, 20)));

        btnSoundSettings.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnSoundSettings.setBackground(GUI.GOLDEN_ROD);
        btnSoundSettings.setForeground(Color.white);
        btnSoundSettings.setUI(new StyledButtonUI(20,90,20,90));
        btnSoundSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMainMenu.add(btnSoundSettings);
        pnlMainMenu.add(Box.createRigidArea(new Dimension(0, 20)));

        btnExitGame.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnExitGame.setBackground(GUI.GOLDEN_ROD);
        btnExitGame.setForeground(Color.white);
        btnExitGame.setUI(new StyledButtonUI(20,110,20,110));
        btnExitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlMainMenu.add(btnExitGame);

        pnlMainMenu.setOpaque(false);
        pnlMainMenu.setVisible(true);
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