package org.vamdc.validator.gui;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vamdc.validator.Setting;

/**
 * JDialog that can remember its position on screen
 */
public abstract class PositionMemoryDialog extends JDialog{

	private static final long serialVersionUID = 862006088829415251L;

	private WindowPositionHandler wph;
	
	public PositionMemoryDialog(Frame owner,String name, Setting dialogPosition){
		super(owner,name);
		wph=new WindowPositionHandler(this,dialogPosition);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	protected JPanel panel;
	
	/**
	 * The method that is called on the first setVisible() call,
	 * is used to initialize the main panel of the dialog.
	 * @return
	 */
	protected abstract JPanel lazyInitLayout();
	
	public void setVisible(boolean b){
		if (b && panel==null){
			panel=lazyInitLayout();
			this.setContentPane(panel);
			wph.loadDimensions();
		}
		super.setVisible(b);
	}
	
	public void loadDimensions(){
		wph.loadDimensions();
	}
	
	public void saveDimensions(){
		wph.saveDimensions();
	}
	
}
