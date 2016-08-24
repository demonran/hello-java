package com.helloworld.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileChooser extends JFrame implements ActionListener{  
    JButton open=null;  
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {  
    	
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	
        new FileChooser();  
    }  
    public FileChooser(){  
        open=new JButton("open");  
        this.add(open);  
        this.setBounds(400, 200, 100, 100);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        open.addActionListener(this);  
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        JFileChooser jfc=new JFileChooser();  
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
        jfc.showDialog(new JLabel(), "选择");  
        File file=jfc.getSelectedFile();  
        if(file.isDirectory()){  
            System.out.println("文件夹:"+file.getAbsolutePath());  
        }else if(file.isFile()){  
            System.out.println("文件:"+file.getAbsolutePath());  
        }  
        System.out.println(jfc.getSelectedFile().getName());  
          
    }  
  
}  