package com.epam;



public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;


    public void start(Room room) {
        announcer.announce("Let's start disinfecting, everyone out!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Take a chance and go back");
    }

    private void desinfect(Room room){
        System.out.println("A prayer is read: “Corona, go away!” - The prayer is read, the virus is cast down into hell");
    }
}