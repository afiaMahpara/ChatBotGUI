/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.Random;

public class MessageHandler {

    String casualConvoMsg[][][] = {
        { //sctript 1:
            {"hi", "hello", "hey"},},
        { // Script 2:
            {"what"}, {"you"}, {"like"}},
        { // Script 3:
            {"you"}, {"from"}},
        {// Script 4:
            {"your", "how"}, {"age", "old"}},
        {// Script 5:
            {"your"}, {"name"}},
        {// Script 6:
            {"how"}, {"you"}},
        {// Script 7:
            {"who", "what"}, {"are"}, {"you"}},
        {// Script 8:
            {"tell"}, {"joke"}},
        {// Task 1:
            {"##"}, {"help"}},
        {// Task 2:
            {"##"}, {"gettime"}},
        {// Task 3:
            {"##"}, {"os"}},
        {// Task 4:
            {"##"}, {"domath"}},
        {// Task 5:
            {"##"}, {"shutdown"}},
        {// Task 6:
            {"##"}, {"restart"}},
        {// Task 7:
            {"##"}, {"createfolder"}},
        {// Task 8:
            {"##"}, {"createfile"}},
        {// Task 9:
            {"##"}, {"diskclean"}},
        {// Task 10:
            {"##"}, {"setreminder"}},};

    String casualConvoReply[][] = {
        //Reply 1
        {"Hi", "Hello", "Hola", "Hey"},
        //Reply 2
        {"Questions !!", "Silicon!", "Electricity", "I wont tell :p"},
        //Reply 3
        {"I come from a place beyond time and space", "I live in CPU", "Very boring Question", "Even I dont know"},
        //Reply 4
        {"Age is just a number.", "0 years Old", "I was born yesterday", "e^i(pie)+1"},
        //Reply 5
        {"I am called many names", "My name is JASPER", "JASPER", "I decide to hide it now"},
        //Reply 6
        {"I'm doing great, thanks for asking!", "I am fine", "I am okay", "I am a fine i am never fine"},
        //Reply 7
        {"I am your personal assistant", "A virtual Assistant", "A personal AI assistant", "You know better than me"},
        //Reply 7
        {"My father got the heart of a lion and lifetime ban at zoo", "Parallel Lines have so much in common. Its a shame they will never meet.", "A computer once beat me at chess, but it was no match for me at kick boxing.", "I love asking kids what they want to be when they grow up because i am still looking for ideas."}
    };

    String exceptionCase[] = {"I dont understand", "Ask something else", "sorry?press help", "??"};

    public MessageHandler() {
    }

    public String checkMessage(String msg) {
        msg = msg.toLowerCase();

        int flag3 = 0;
        int save = -1;
        for (int i = 0; i < casualConvoMsg.length; i++) {
            int flag2 = 0;
            for (int j = 0; j < casualConvoMsg[i].length; j++) {
                int flag = 0;
                for (int k = 0; k < casualConvoMsg[i][j].length; k++) {
                    if (msg.contains(casualConvoMsg[i][j][k])) {
                        flag = 1;
                    }
                }
                if (flag > 0) {
                    flag2 += 1;
                }
            }
            if (flag2 == casualConvoMsg[i].length) {
                flag3 = 1;
                save = i;
            }
        }

        if (flag3 == 1) {

            if (save < casualConvoReply.length) {

                NewJFrame.sendmsg.setText("");
                return casualConvoReply[save][new Random().nextInt(4)];

            } else {
                TaskHandler t = new TaskHandler();

                String s = NewJFrame.sendmsg.getText();
                NewJFrame.sendmsg.setText("");
                try {
                    return t.handleTask(save, casualConvoReply.length, s);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        }
        System.out.println(save);
        NewJFrame.sendmsg.setText("");
        return exceptionCase[new Random().nextInt(4)];

    }

}

