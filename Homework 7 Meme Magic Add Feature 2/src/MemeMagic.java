import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * MemeMagic Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 */
public class MemeMagic extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;
    
    private User user;
    private GraphicalMeme m1;
    private String caption;
    private String alignment;
    
    private String backgroundImageFilename;

    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;
    private JTextField BackgroundImageText1;
    private JTextField memeCaptionText1;
    private JTextField backgroundImageDescription1;
    private JComboBox memeCB;
    
    
    
    public MemeMagic() {
        this.user = new User();
    }
    
    public MemeMagic(User user) {
        this.user = user;
    }


    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        
        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);
        
        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);


        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());
        
        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));

        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel();
        
        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);
            
        // Button
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        
        
        // Connecting the Button Listener
        backgroundImageButton.setActionCommand("click");
        backgroundImageButton.addActionListener(new OpenButtonListener());
        
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));
        
        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);
       
        //Create a panel that provides input for the BackgroundImage Title
        JPanel backgroundImageTitlePanel = new JPanel();

        //Label
        JLabel backgroundImageTitleLabel = new JLabel("   Title:");
        backgroundImageTitleLabel.setPreferredSize(new Dimension(100,20));
        backgroundImageTitlePanel.add(backgroundImageTitleLabel);
        
        //TextField
        BackgroundImageText1 = new JTextField(30);
        BackgroundImageText1.setPreferredSize(new Dimension(265, 20));
  
        backgroundImageTitlePanel.add(BackgroundImageText1);
        
        // Add the panel about the BackgroundImage Title to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageTitlePanel, BorderLayout.CENTER);
        
        

        //Create a panel that provides input for the BackgroundImage Description
        JPanel backgroundImageDescriptionPanel = new JPanel();

        //Label
        JLabel backgroundImageDescriptionLabel = new JLabel("   Description:");
        backgroundImageDescriptionLabel.setPreferredSize(new Dimension(100,20));
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionLabel);
        
        //TextField
        backgroundImageDescription1 = new JTextField(30); 
        backgroundImageDescription1.setPreferredSize(new Dimension(265, 20));
  
        backgroundImageDescriptionPanel.add(backgroundImageDescription1);
        
        // Add the panel about the BackgroundImage Title to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageDescriptionPanel, BorderLayout.SOUTH);
        
        
        
        

        
        

        

        
        // TODO Complete the Control Panel implementation (with Background Image and Meme panels)
        
        //Create a panel that holds the Meme caption and give it a location
        JPanel memePanel = new JPanel(new BorderLayout());
        memePanel.setBorder(BorderFactory.createTitledBorder("Meme"));
        
        //Create a panel that provides input for the Meme caption
        JPanel memeCaptionPanel = new JPanel();

        //Label
        JLabel memeCaptionLabel = new JLabel("   Caption:");
        memeCaptionLabel.setPreferredSize(new Dimension(85,20));
        memeCaptionPanel.add(memeCaptionLabel);
        
       
        //TextField
        memeCaptionText1 = new JTextField(30); 
        memeCaptionText1.setPreferredSize(new Dimension(265, 20));
        memeCaptionPanel.add(memeCaptionText1);
        
        memePanel.add(memeCaptionPanel, BorderLayout.NORTH);
        
        //Create a panel that holds the ComboBox 
        JPanel memeCBPanel = new JPanel();
        
        //Label 
        JLabel memeCBLabel = new JLabel("Vertical Align:");
        memeCBLabel.setPreferredSize(new Dimension(100,20));
        memeCBPanel.add(memeCBLabel);
        
        //Create a ComboBox 
        String[] options = {"top", "middle", "bottom"};
        memeCB = new JComboBox(options);
        memeCB.setPreferredSize(new Dimension(375, 20));
        memeCBPanel.add(memeCB);
        
        
        memePanel.add(memeCBPanel, BorderLayout.CENTER);
        
        
        //Create a panel that provides a Generate and Save Button
        JPanel memeGenerateSavePanel = new JPanel();

        //Generate Button
        JButton generateButton = new JButton("Generate");
      //Connecting the Button Listener
        generateButton.setActionCommand("click");
        generateButton.addActionListener(new GenerateButtonListener());
        memeGenerateSavePanel.add(generateButton);
        generateButton.setPreferredSize(new Dimension(85, 20));
        
        
        
        
        //Save Button
        JButton saveButton = new JButton("Save");
        memeGenerateSavePanel.add(saveButton);
        saveButton.setPreferredSize(new Dimension(85, 20));
        
        // Connecting the Button Listener
        saveButton.setActionCommand("click");
        saveButton.addActionListener(new SaveButtonListener());
        
        
        
       
        
        
        
        
        // Add the BackgroundImage information panel and meme panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        controlPanel.add(memePanel);
        controlPanel.add(memeGenerateSavePanel, BorderLayout.SOUTH);
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }
    
    
    
    
    	
    
    
    /**
     * ActionListener for the open button.  When the button is pressed, this ActionListener
     * opens a FileChooser, asks the user to choose a JPG image file, then
     * sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose a JPG image file, then
         * sets the field backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
    	 
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Choose a Background Image");
            chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int returnVal = chooser2.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                backgroundImageFileNameLabel.setText(backgroundImageFilename);
            }

        }
    }
    
    private class GenerateButtonListener implements ActionListener {
    	/**
    	 * Action performed operation. Displays the graphicalMeme in the imageDisplayLabel
    	 */
    	@Override
    	public void actionPerformed(ActionEvent evt) {
    		
    		
    		caption = memeCaptionText1.getText();
    	
    		alignment = memeCB.toString();
    		
    		BackgroundImage b = new BackgroundImage(backgroundImageFilename, BackgroundImageText1.getText()
    				, backgroundImageDescription1.getText());
    		m1 = new GraphicalMeme(b, caption, user);
    		m1.setCaptionVerticalAlign(alignment);
    		
    		BufferedImage m;
    		try {
    			m = m1.compileMeme();
			} catch (Exception e) {
				throw new RuntimeException("Sorry, the meme could not be made", e);
				
				
			}
    		
			ImageIcon icon = new ImageIcon(m);
			imageDisplayLabel.setIcon(icon);
    		memeViewPanel.repaint();
    	}
    	
    }
    
    
    
    /**
     * ActionListener for the save button.  When the button is pressed, this ActionListener
     * opens a save FileChooser, asks the user to choose a location and filename, then
     * writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Save Meme");
            chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            int returnVal = chooser2.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String destinationFile = chooser2.getSelectedFile().getAbsolutePath();
                if (!destinationFile.contains(".png"))
                    destinationFile += ".png";
                
                // TODO: Writing an image throws a checked exception that must be handled.
                //       Catch the exceptions and provide the user with an appropriate message
           	// ImageIO.write(m1.compileMeme(), "png", new File(destinationFile));

                
                try {
                	 ImageIO.write(m1.compileMeme(), "png", new File(destinationFile));
                }
				
			
                catch (IOException e) {
					// TODO: handle exception
					throw new RuntimeException("Sorry, the file could not be found, IO",e);
					
            }
                
               
                catch (IllegalArgumentException e1) {
					// TODO: handle exception
                	
					throw new RuntimeException("Sorry, the file could not be found IAE",e1);
            }
                catch (NullPointerException e2) {
					// TODO: handle exception
                	
					throw new RuntimeException("Sorry, the file could not be found NPE",e2);
            }
                
                catch (Exception e3) {
					// TODO: handle exception
                	
					throw new RuntimeException("Sorry, the file could not be found",e3);
            }

        }
    }
    }
}