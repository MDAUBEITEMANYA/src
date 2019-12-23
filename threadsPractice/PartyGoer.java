package threadsPractice;


public class PartyGoer {

    private String house;
    private String partyPlace;
    private final Leader leader;


    PartyGoer(String house, Leader leader) {
        this.house = house;
        this.leader = leader;
        partyPlace = "Somewhere";
        leader.getPartyGoers().add(this);
    }

    public synchronized String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public synchronized String getPartyPlace() {
        return partyPlace;
    }

    public synchronized void setPartyPlace(String partyPlace) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        this.partyPlace = partyPlace;
        if (partyPlace.equals(house)) { //this PartyGoer wanna sit at home today
            leader.refuseChilling(this); //so he/she need to tell his/her leader about this purpose
        }
    }
}
