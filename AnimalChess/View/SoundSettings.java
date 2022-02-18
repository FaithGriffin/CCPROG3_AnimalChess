package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;

/** 
* Represents a SoundSettings
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class SoundSettings{
    private JPanel pnlSoundSettings;
    private JLabel lblInstructionsChooseSound;
    private JButton btnTrack1;
    private JButton btnTrack2;
    private JButton btnTrack3;
    private JButton btnDefaultTrack;


    /** 
    * Constructs a SoundSettings object
    *
    * 
    */ 
    public SoundSettings(){
        pnlSoundSettings = new JPanel();
        lblInstructionsChooseSound = new JLabel("<html>Choose which track would you like to use<br/>as the backgroud music during your stay.</html>", SwingConstants.CENTER);
        btnTrack1 = new JButton("Track 1");
        btnTrack2 = new JButton("Track 2");
        btnTrack3 = new JButton("Track 3");
        btnDefaultTrack = new JButton("Default Track");
        setUpSoundSettings();
    }


    /** 
    * This function returns the pnlSoundSettings
    *
    * @return JPanel  the pnlSoundSettings of a SoundSettings object
    */
    public JPanel getPnlSoundSettings(){
        return pnlSoundSettings;
    }


    /** 
    * This function returns the btnTrack1
    *
    * @return JButton  the btnTrack1 of a SoundSettings object
    */
    public JButton getBtnTrack1(){
        return btnTrack1;
    }


    /** 
    * This function returns the btnTrack2
    *
    * @return JButton  the btnTrack2 of a SoundSettings object
    */
    public JButton getBtnTrack2(){
        return btnTrack2;
    }


    /** 
    * This function returns the btnTrack3
    *
    * @return JButton  the btnTrack3 of a SoundSettings object
    */
    public JButton getBtnTrack3(){
        return btnTrack3;
    }


    /** 
    * This function returns the btnDefaultTrack
    *
    * @return JButton  the btnDefaultTrack of a SoundSettings object
    */
    public JButton getBtnDefaultTrack(){
        return btnDefaultTrack;
    }


    /** 
    * This function initializes the attributes of a SoundSettings object
    *
    */
    private void setUpSoundSettings(){
        pnlSoundSettings.setLayout(new BoxLayout(pnlSoundSettings, BoxLayout.Y_AXIS));
        pnlSoundSettings.setBorder(new EmptyBorder(new Insets(75,30,75,30)));

        lblInstructionsChooseSound.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblInstructionsChooseSound.setBackground(GUI.TEAL);
        lblInstructionsChooseSound.setForeground(Color.white);
        lblInstructionsChooseSound.setUI(new StyledLabelUI(45,50,55,50));
        lblInstructionsChooseSound.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSoundSettings.add(lblInstructionsChooseSound);
        pnlSoundSettings.add(Box.createRigidArea(new Dimension(0, 69)));

        btnTrack1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnTrack1.setBackground(GUI.MEDIUM_VIOLET_RED);
        btnTrack1.setForeground(Color.white);
        btnTrack1.setUI(new StyledButtonUI(10,15,10,15));
        btnTrack1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSoundSettings.add(btnTrack1);
        pnlSoundSettings.add(Box.createRigidArea(new Dimension(0, 10)));

        btnTrack2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnTrack2.setBackground(GUI.MEDIUM_VIOLET_RED);
        btnTrack2.setForeground(Color.white);
        btnTrack2.setUI(new StyledButtonUI(10,15,10,15));
        btnTrack2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSoundSettings.add(btnTrack2);
        pnlSoundSettings.add(Box.createRigidArea(new Dimension(0, 10)));

        btnTrack3.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnTrack3.setBackground(GUI.MEDIUM_VIOLET_RED);
        btnTrack3.setForeground(Color.white);
        btnTrack3.setUI(new StyledButtonUI(10,15,10,15));
        btnTrack3.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSoundSettings.add(btnTrack3);
        pnlSoundSettings.add(Box.createRigidArea(new Dimension(0, 10)));

        btnDefaultTrack.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnDefaultTrack.setBackground(GUI.MEDIUM_VIOLET_RED);
        btnDefaultTrack.setForeground(Color.white);
        btnDefaultTrack.setUI(new StyledButtonUI(10,15,10,15));
        btnDefaultTrack.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSoundSettings.add(btnDefaultTrack);
        pnlSoundSettings.add(Box.createRigidArea(new Dimension(0, 69)));

        pnlSoundSettings.setOpaque(false);
    }


    /** 
    * This function adds a btnBackToMainMenu to the pnlSoundSettings of a SoundSettings object
    *
    * @param btnBackToMainMenu      the JButton to be added to the pnlSoundSettings
    */
    public void updateSoundSettings(JButton btnBackToMainMenu){
        pnlSoundSettings.add(btnBackToMainMenu);
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