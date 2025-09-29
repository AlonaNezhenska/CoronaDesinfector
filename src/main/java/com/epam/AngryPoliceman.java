package com.epam;


public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("I'll kill you all! Get out of here!");
    }
}