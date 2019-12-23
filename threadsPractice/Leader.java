package threadsPractice;

import java.util.HashSet;
import java.util.Set;

public class Leader {

    Set<PartyGoer> partyGoers;

    Leader() {
        partyGoers = new HashSet<PartyGoer>();
    }

    public synchronized Set<PartyGoer> getPartyGoers() {
        return partyGoers;
    }

    public synchronized void refuseChilling(PartyGoer partyGoer) {
        partyGoers.remove(partyGoer); //okay then, the person is deleted from Party-goers company today;
    }

    public synchronized void printLocations() {
        for (PartyGoer partyGoer : partyGoers) {
            System.out.println(partyGoer.getPartyPlace());
        }
    }
}
