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

    public void setPartyPlace(String partyPlace) {
        boolean isHouse;
        synchronized (this) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            this.partyPlace = partyPlace;
            isHouse = partyPlace.equals(house);
        }
        if (isHouse) { //this PartyGoer wanna sit at home today
            leader.refuseChilling(this); //so he/she need to tell his/her leader about this purpose
        }
    }
}
