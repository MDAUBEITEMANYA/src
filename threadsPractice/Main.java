package threadsPractice;


public class Main {

    public static void main(String[] args) {
        Leader leader = new Leader();
        PartyGoer firstGuy = new PartyGoer("firstGuy's house", leader);
        PartyGoer secondGuy = new PartyGoer("secondGuy's house", leader);
        PartyGoer thirdGuy = new PartyGoer("thirdGuy's house", leader);

        new Thread(new Runnable() {
            @Override
            public void run() {
                firstGuy.setPartyPlace(firstGuy.getHouse()); //in this Thread firstGuy want to stay at home  -> need Leader object
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                leader.printLocations(); //at the same time we want to see all PartyPlaces -> need firstGuy object as well
            }
        }).start();
    }


}
