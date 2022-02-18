package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;

/** 
* Represents a SetUpGame
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class SetUpGame{
    private JPanel pnlSetUpGame;
    private JLabel lblPlayer1;
    private JTextField txtfldPlayer1;
    private JLabel lblPlayer2;
    private JTextField txtfldPlayer2;
    private JButton btnDone;
    private JPanel pnlDrawAnimal;
    private JLabel lblInstructions;
    private JLabel lblDrawnAnimal1;
    private JButton btnDrawPlayer1;
    private JLabel lblDrawnAnimal2;
    private JButton btnDrawPlayer2;
    private JButton btnDrawDone;
    private JPanel pnlChooseColor;
    private JLabel lblPlayerToChooseColor;
    private JPanel pnlChooseColorLayer2;
    private JButton btnBlueTeam;
    private JButton btnRedTeam;
    private ImageIcon blue = new ImageIcon("lib/utilities/Bbutton.png");
    private ImageIcon red = new ImageIcon("lib/utilities/Rbutton.png");
    private ImageIcon player1DrawnAnimal;
    private ImageIcon player2DrawnAnimal;


    /** 
    * Constructs a new SetUpGame object
    *
    * 
    */ 
    public SetUpGame(){
        pnlSetUpGame = new JPanel();
        lblPlayer1 = new JLabel("Enter name of Player 1:");
        txtfldPlayer1 = new JTextField();
        lblPlayer2 = new JLabel("Enter name of Player 2:");
        txtfldPlayer2 = new JTextField();
        btnDone = new JButton("Done");
        pnlDrawAnimal = new JPanel();
        lblInstructions = new JLabel("<html>To determine who will move first, the Players need to click \"Draw\" <br/>&emsp;&emsp;&emsp;until one of them Draws an Animal with a higer rank.</html>", SwingConstants.CENTER);
        lblDrawnAnimal1 = new JLabel();
        btnDrawPlayer1 = new JButton();
        lblDrawnAnimal2 = new JLabel();
        btnDrawPlayer2 = new JButton();
        btnDrawDone = new JButton("OK");
        pnlChooseColor = new JPanel();
        lblPlayerToChooseColor = new JLabel();
        pnlChooseColorLayer2 = new JPanel();
        btnBlueTeam = new JButton("B");
        btnRedTeam = new JButton("R");
        setupSetUpGame();
    }


    /** 
    * This function returns the pnlSetUpGame
    *
    * @return JPanel  the pnlSetUpGame of a SetUpGame object
    */
    public JPanel getPnlSetUpGame(){
        return pnlSetUpGame;
    }


    /** 
    * This function returns the txtfldPlayer1
    *
    * @return JTextField  the txtfldPlayer1 of a SetUpGame object
    */
    public JTextField getTxtfldPlayer1(){
        return txtfldPlayer1;
    } 


    /** 
    * This function returns the txtfldPlayer2
    *
    * @return JTextField  the txtfldPlayer2 of a SetUpGame object
    */
    public JTextField getTxtfldPlayer2(){
        return txtfldPlayer2;
    }


    /** 
    * This function returns the btnDone
    *
    * @return JButton   the btnDone of a SetUpGame object
    */
    public JButton getBtnDone(){
        return btnDone;
    }


    /** 
    * This function returns the pnlDrawAnimal
    *
    * @return JPanel  the pnlDrawAnimal of a SetUpGame object
    */
    public JPanel getPnlDrawAnimal(){
        return pnlDrawAnimal;
    }


    /** 
    * This function returns the btnDrawPlayer1
    *
    * @return JButton   the btnDrawPlayer1 of a SetUpGame object
    */
    public JButton getBtnDrawPlayer1(){
        return btnDrawPlayer1;
    }


    /** 
    * This function returns the btnDrawPlayer2
    *
    * @return JButton   the btnDrawPlayer2 of a SetUpGame object
    */
    public JButton getBtnDrawPlayer2(){
        return btnDrawPlayer2;
    }


    /** 
    * This function returns the btnDrawDone
    *
    * @return JButton   the btnDrawDone of a SetUpGame object
    */
    public JButton getBtnDoneDraw(){
        return btnDrawDone;
    }


    /** 
    * This function returns the pnlChooseColor
    *
    * @return JPanel  the pnlChooseColor of a SetUpGame object
    */
    public JPanel getPnlChooseColor(){
        return pnlChooseColor;
    }


    /** 
    * This function returns the btnBlueTeam
    *
    * @return JButton   the btnBlueTeam of a SetUpGame object
    */
    public JButton getBtnBlueTeam(){
        return btnBlueTeam;
    }


    /** 
    * This function returns the btnRedTeam
    *
    * @return JButton   the btnRedTeam of a SetUpGame object
    */
    public JButton getBtnRedTeam(){
        return btnRedTeam;
    }


    /** 
    * This function initializes the attributes of a SetUpGame object
    *
    */
    private void setupSetUpGame(){
        
        pnlSetUpGame.setLayout(new BoxLayout(pnlSetUpGame, BoxLayout.Y_AXIS));
        pnlSetUpGame.setBorder(new EmptyBorder(new Insets(138, 320, 138, 320)));

        lblPlayer1.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblPlayer1.setBackground(GUI.MEDIUM_VIOLET_RED);
        lblPlayer1.setForeground(Color.white);
        lblPlayer1.setUI(new StyledLabelUI(5,10,5,10));
        lblPlayer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSetUpGame.add(lblPlayer1);
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 20)));

        txtfldPlayer1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        txtfldPlayer1.setBackground(GUI.GOLDEN_ROD);
        txtfldPlayer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSetUpGame.add(txtfldPlayer1);
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 69)));

        lblPlayer2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblPlayer2.setBackground(GUI.HOT_PINK);
        lblPlayer2.setForeground(Color.white);
        lblPlayer2.setUI(new StyledLabelUI(5,10,5,10));
        lblPlayer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSetUpGame.add(lblPlayer2);
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 20)));

        txtfldPlayer2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        txtfldPlayer2.setBackground(GUI.GOLDEN_ROD);
        txtfldPlayer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSetUpGame.add(txtfldPlayer2);
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlSetUpGame.add(Box.createRigidArea(new Dimension(0, 69)));

        btnDone.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnDone.setBackground(GUI.TEAL);
        btnDone.setForeground(Color.white);
        btnDone.setUI(new StyledButtonUI(5,10,5,10));
        btnDone.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSetUpGame.add(btnDone);

        pnlSetUpGame.setOpaque(false);
        pnlSetUpGame.setVisible(true);

        pnlDrawAnimal.setLayout(new BoxLayout(pnlDrawAnimal, BoxLayout.Y_AXIS));
        pnlDrawAnimal.setBorder(new EmptyBorder(new Insets(15, 20, 15, 20)));

        lblInstructions.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblInstructions.setBackground(GUI.TEAL);
        lblInstructions.setForeground(Color.white);
        lblInstructions.setUI(new StyledLabelUI(45,50,55,50));
        lblInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlDrawAnimal.add(lblInstructions);
        pnlDrawAnimal.add(Box.createRigidArea(new Dimension(0, 30)));

        lblDrawnAnimal1.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblDrawnAnimal1.setBackground(GUI.ORCHID);
        lblDrawnAnimal1.setForeground(Color.white);
        lblDrawnAnimal1.setUI(new StyledLabelUI(25,30,25,30));
        lblDrawnAnimal1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlDrawAnimal.add(lblDrawnAnimal1);
        pnlDrawAnimal.add(Box.createRigidArea(new Dimension(0, 10)));

        btnDrawPlayer1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnDrawPlayer1.setBackground(GUI.DARK_ORANGE);
        btnDrawPlayer1.setForeground(Color.white);
        btnDrawPlayer1.setUI(new StyledButtonUI(5,10,5,10));
        btnDrawPlayer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlDrawAnimal.add(btnDrawPlayer1);
        pnlDrawAnimal.add(Box.createRigidArea(new Dimension(0, 20)));

        lblDrawnAnimal2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblDrawnAnimal2.setBackground(GUI.HOT_PINK);
        lblDrawnAnimal2.setForeground(Color.white);
        lblDrawnAnimal2.setUI(new StyledLabelUI(25,30,25,30));
        lblDrawnAnimal2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlDrawAnimal.add(lblDrawnAnimal2);
        pnlDrawAnimal.add(Box.createRigidArea(new Dimension(0, 10)));

        btnDrawPlayer2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnDrawPlayer2.setBackground(GUI.DARK_ORANGE);
        btnDrawPlayer2.setForeground(Color.white);
        btnDrawPlayer2.setUI(new StyledButtonUI(5,10,5,10));
        btnDrawPlayer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlDrawAnimal.add(btnDrawPlayer2);
        pnlDrawAnimal.add(Box.createRigidArea(new Dimension(0, 69)));

        btnDrawDone.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnDrawDone.setBackground(GUI.TEAL);
        btnDrawDone.setForeground(Color.white);
        btnDrawDone.setUI(new StyledButtonUI(5,10,5,10));
        btnDrawDone.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDrawDone.setEnabled(false);
        pnlDrawAnimal.add(btnDrawDone);

        pnlDrawAnimal.setOpaque(false);
        pnlDrawAnimal.setVisible(true);

        pnlChooseColor.setLayout(new BoxLayout(pnlChooseColor, BoxLayout.Y_AXIS));
        pnlChooseColor.setBorder(new EmptyBorder(new Insets(138, 200, 138, 200)));

        lblPlayerToChooseColor.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        lblPlayerToChooseColor.setBackground(GUI.ORANGE);
        lblPlayerToChooseColor.setForeground(Color.white);
        lblPlayerToChooseColor.setUI(new StyledLabelUI(15,20,15,20));
        lblPlayerToChooseColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlChooseColor.add(lblPlayerToChooseColor);
        lblPlayerToChooseColor.add(Box.createRigidArea(new Dimension(0, 10)));
        
        pnlChooseColorLayer2.setLayout(new FlowLayout());
        pnlChooseColorLayer2.setPreferredSize(new Dimension(196,196));

        btnBlueTeam.setIcon(blue);
        btnBlueTeam.setIconTextGap(-200);
        btnBlueTeam.setBackground(GUI.TEAL);
        btnBlueTeam.setPreferredSize(new Dimension(228,228));
        btnBlueTeam.setUI(new StyledButtonUI(95,100,95,100));
        btnBlueTeam.setForeground(GUI.SOMEWHAT_BLUE);
        pnlChooseColorLayer2.add(btnBlueTeam);

        btnRedTeam.setIcon(red);
        btnRedTeam.setIconTextGap(-200);
        btnRedTeam.setBackground(GUI.TEAL);
        btnRedTeam.setPreferredSize(new Dimension(228,228));
        btnRedTeam.setForeground(GUI.SOMEWHAT_RED);
        btnRedTeam.setUI(new StyledButtonUI(95,100,95,100));
        pnlChooseColorLayer2.add(btnRedTeam);

        pnlChooseColorLayer2.setOpaque(false);
        pnlChooseColorLayer2.setVisible(true);
        pnlChooseColor.add(pnlChooseColorLayer2);
        pnlChooseColor.setOpaque(false);
        pnlChooseColor.setVisible(true);
    }


    /** 
    * This function sets the btnDrawPLayer1, btnDrawPlayer2, lblDrawAnimal1, and lblDrawAnimal2
    * 
    * @param strName1         the name of player 1
    * @param strName2         the name of player 2
    * @param strAnimal1   the name of the animal that player 1 drew
    * @param strAnimal2   the name of the animal that player 2 drew
    */
    public void updatePnlDrawAnimal(String strName1, String strName2, String strAnimal1, String strAnimal2){
        btnDrawPlayer1.setText(strName1 + ", Draw");
        btnDrawPlayer2.setText(strName2 + ", Draw");
        player1DrawnAnimal = new ImageIcon("lib/Animals/" + strAnimal1 + ".png");
        player2DrawnAnimal = new ImageIcon("lib/Animals/" + strAnimal2 + ".png");
        lblDrawnAnimal1.setIcon(player1DrawnAnimal);
        lblDrawnAnimal2.setIcon(player2DrawnAnimal);
    }


    /** 
    * This function updates the icon of lblDrawAnimal1
    * 
    * @param strAnimal1          filename of an animal's picture
    */
    public void updateLbl1(String strAnimal1){
        
        player1DrawnAnimal = new ImageIcon("lib/Animals/" + strAnimal1 + ".png");
        lblDrawnAnimal1.setIcon(player1DrawnAnimal);
    }


    /** 
    * This function updates the icon of lblDrawAnimal2
    * 
    * @param strAnimal2          filename of an animal's picture
    */
    public void updateLbl2(String strAnimal2){
        player2DrawnAnimal = new ImageIcon("lib/Animals/" + strAnimal2 + ".png");
        lblDrawnAnimal2.setIcon(player2DrawnAnimal);
    }


    /** 
    * This function sets the text of lblPlayerToChooseColor
    * 
    * @param strDrawWinner         the name of the player who won the draw
    */
    public void updatePnlChooseColor(String strDrawWinner){
        lblPlayerToChooseColor.setText(strDrawWinner + ", choose your team's color");
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