/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quizapplication;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Surface
 */
public class QuizTest extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1,now =0;
    int m[] = new int[10];
    
    public QuizTest() throws HeadlessException{
    }
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds (30, 40, 450, 20);
        radioButtons[0].setBounds (50, 80,450, 20);
        radioButtons[1].setBounds (50, 110, 200, 20);
        radioButtons [2].setBounds (50, 140, 200, 20);
        radioButtons [3].setBounds (50,170, 200, 20);
        btnNext.setBounds (100, 240, 100, 30);
        btnResult.setBounds (270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation (250, 100);
        setVisible (true);
        setSize(600,350);
    }
    
    void setData(){
        radioButtons[4].setSelected(true);
        if (current==0) {
        label.setText("Question 1 • 7+3 = ");
        radioButtons[0].setText("4");
        radioButtons[1].setText ("10");
        radioButtons[2].setText("5");
        radioButtons [3].setText ("11");
        }
        if (current==1) {
        label.setText("Question 2 • 8+6 = ");
        radioButtons[0].setText("10");
        radioButtons[1].setText ("24");
        radioButtons[2].setText("13");
        radioButtons [3].setText ("14");
        }
        if (current==2) {
        label.setText("Question 3 • 9+3 = ");
        radioButtons[0].setText("7");
        radioButtons[1].setText ("11");
        radioButtons[2].setText("12");
        radioButtons [3].setText ("10");
        }
        if (current==3) {
        label.setText("Question 4 • 4+5 = ");
        radioButtons[0].setText("2");
        radioButtons[1].setText ("20");
        radioButtons[2].setText("10");
        radioButtons [3].setText ("9");
        }
        if (current==4) {
        label.setText("Question 5 • 2+8 = ");
        radioButtons[0].setText("10");
        radioButtons[1].setText ("17");
        radioButtons[2].setText("16");
        radioButtons [3].setText ("12");
        }
        if (current==5) {
        label.setText("Question 6 • 1+1 = ");
        radioButtons[0].setText("2");
        radioButtons[1].setText ("1");
        radioButtons[2].setText("3");
        radioButtons [3].setText ("4");
        }
        if (current==6) {
        label.setText("Question 7 • 4+9 = ");
        radioButtons[0].setText("7");
        radioButtons[1].setText ("15");
        radioButtons[2].setText("13");
        radioButtons [3].setText ("8");
        }
        if (current==7) {
        label.setText("Question 8 • 5+6 = ");
        radioButtons[0].setText("12");
        radioButtons[1].setText ("11");
        radioButtons[2].setText("2");
        radioButtons [3].setText ("1");
        }
        if (current==8) {
        label.setText("Question 9 • 9+9 = ");
        radioButtons[0].setText("18");
        radioButtons[1].setText ("17");
        radioButtons[2].setText("19");
        radioButtons [3].setText ("20");
        }
        if (current==9) {
        label.setText("Question 10 • 3+8 = ");
        radioButtons[0].setText("4");
        radioButtons[1].setText ("6");
        radioButtons[2].setText("11");
        radioButtons [3].setText ("12");
        }
        label.setBounds (30, 40, 450, 20);
        for (int i=0, j=0; i<=90; i+=30, j++ ) {
            radioButtons[j].setBounds(50, 80+i, 200, 20);
        }
    }
    
    boolean checkAns () {
        if (current==0){
            return (radioButtons[1].isSelected () );
        }
        if (current==1){
            return (radioButtons[3].isSelected () );
        }
        if (current==2){
            return (radioButtons[2].isSelected () );
        }
        if (current==3){
            return (radioButtons[3].isSelected () );
        }
        if (current==4){
            return (radioButtons[0].isSelected () );
        }
        if (current==5){
            return (radioButtons[0].isSelected () );
        }
        if (current==6){
            return (radioButtons[2].isSelected () );
        }
        if (current==7){
            return (radioButtons[1].isSelected () );
        }
        if (current==8){
            return (radioButtons[0].isSelected () );
        }
        if (current==9){
            return (radioButtons[2].isSelected () );
        }
        return false;
    }
    
    public static void main(String[] args) {
        new QuizTest("Simple Quiz App");
    }    

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () ==btnNext) {
            if (checkAns())
                count = count +1;
            current++;
            setData();
            if (current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText ("Result");
            }
        }
        if(e.getActionCommand ().equals("Result")) {
            if (checkAns())
                count = count +1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers are "+count);
            System.exit(0);
        }
    }
}
