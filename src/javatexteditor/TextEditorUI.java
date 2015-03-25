package javatexteditor;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorUI extends JFrame{
	
	private JTextArea textArea ;
	
	public TextEditorUI(){
		
		//set up JMenuBar
		JMenuBar menuBar = new JMenuBar();
		//add menuBar to Frame
		setJMenuBar(menuBar);
		
		//build the file menu and add it to the frame
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		//build and add menuItem to filemenu
		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		//build and add menuItem to filemenu
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		//build and add menuItem to filemenu
		JMenuItem closeMenuItem = new JMenuItem("Close");
		fileMenu.add(closeMenuItem);
		//add seperator
		fileMenu.addSeparator();
		//build and add menuItem to filemenu
		JMenuItem saveMenuItem = new JMenuItem("Save");
		fileMenu.add(saveMenuItem);
		//build and add menuItem to filemenu
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		fileMenu.add(saveAsMenuItem);
		//add seperator
		fileMenu.addSeparator();
		//build and add menuItem to filemenu
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		
		
		//build the edit menu and add it to the menubar
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		//build and add menuItem to editmenu
		JMenuItem undoMenuItem = new JMenuItem("Undo");
		editMenu.add(undoMenuItem);
		//build and add menuItem to editmenu
		JMenuItem redoMenuItem = new JMenuItem("Redo");
		editMenu.add(redoMenuItem);
		//add seperator
		editMenu.addSeparator();
		//build and add menuItem to editmenu
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		editMenu.add(cutMenuItem);
		//build and add menuItem to editmenu
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		editMenu.add(copyMenuItem);
		//build and add menuItem to editmenu
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(pasteMenuItem);
		//add seperator
		editMenu.addSeparator();
		//build and add menuItem to editmenu
		JMenuItem selectAllMenuItem = new JMenuItem("Select All");
		editMenu.add(selectAllMenuItem);
		
		
		//build the edit menu and add it to the menubar
		JMenu formatMenu = new JMenu("Format");
		menuBar.add(formatMenu);
		//build and add menuItem to formatmenu
		JCheckBoxMenuItem wrapTextMenuItem = new JCheckBoxMenuItem("Wrap Text");
		formatMenu.add(wrapTextMenuItem);
				
		//build and textsize submenu and add it to format menu
		JMenu textSizeMenu = new JMenu("Text Size");
		formatMenu.add(textSizeMenu);
		//add radioButton button menuItem to select Text Area
		JRadioButtonMenuItem smallTextOption = new JRadioButtonMenuItem("Small");
		textSizeMenu.add(smallTextOption);
		//add radioButton button menuItem to select Text Area
		JRadioButtonMenuItem mediumTextOption = new JRadioButtonMenuItem("Medium");
		textSizeMenu.add(mediumTextOption);
		//set medium as selected
		mediumTextOption.setSelected(true);
		//add radioButton button menuItem to select Text Area
		JRadioButtonMenuItem largeTextOption = new JRadioButtonMenuItem("Large");
		textSizeMenu.add(largeTextOption);
		
		//set up and add the text area to a scrollpane
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		//set up pop-Menu on the text area
		final JPopupMenu popup = new JPopupMenu();
		//add cut menu item to popup menu
		JMenuItem cutPopupMenuItem = new JMenuItem("Cut");
		popup.add(cutPopupMenuItem);
		//add copy menu item to popup menu
		JMenuItem copyPopupMenuItem = new JMenuItem("Copy");
		popup.add(copyPopupMenuItem);
		//add cut menu item to popup menu
		JMenuItem pastePopupMenuItem = new JMenuItem("Paste");
		popup.add(pastePopupMenuItem);
		//add seperator on popup
		popup.addSeparator();
		//add cut menu item to popup menu
		JMenuItem selectAllPopupMenuItem = new JMenuItem("Select All");
		popup.add(selectAllPopupMenuItem);
		
		
		//register mouselistener on the text area to show popup menu
		textArea.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
					
				if(e.isPopupTrigger()){
					popup.show(textArea, e.getX(), e.getY());
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e){
				
				if(e.isPopupTrigger()){
					popup.show(textArea, e.getX(), e.getY());
				}
			}
		});
		
		//add some initialization for Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 500);
		setTitle("New Document");
		setVisible(true);
	}
}
