import java.util.ArrayList;
import java.util.List;
public class Matcher {  
	public static void main(String args[]) throws Exception { 
		Matcher ins = new Matcher();
		ins.run();
	} 

	static Itinerary itinerary = new Itinerary();
	static {
		itinerary.addLeg(new Leg("IAD", "LHR", "AA"));
		itinerary.addLeg(new Leg("LHR", "DCA", "AA"));
		itinerary.addLeg(new Leg("DCA", "FLL", "AF"));
		itinerary.addLeg(new Leg("FLL", "MCT", "AA"));
		itinerary.addLeg(new Leg("MCT", "ATL", "AA"));
	}

	private void run() throws Exception{
		List<Leg> matchedLegs = this.getMatchedItinerary(itinerary);
	     if(matchedLegs.size() != 3) {
	    	 throw new Exception("Matching Logic is incorrect");
	     }
	     
	     
		System.out.println(matchedLegs);
	}

	//Implement the matching logic
	public List<Leg> getMatchedItinerary(Itinerary itinerary) {
		//create a final new list to capture leg
		return matchedItineraryList;
	}

	static class Itinerary {

		private final List<Leg> legs;

		public Itinerary() {
			this.legs = new ArrayList<>();
		}

		public void addLeg(Leg leg){
			legs.add(leg);
		}

		public List<Leg> getLegs() {
			return legs;
		}

	}
	static class Leg {

		@Override
		public String toString() {
			return "Leg [origin=" + origin + ", destination=" + destination + ", carrier=" + carrier + "]";
		}

		private final String origin;
		private final String destination;
		private final String carrier;

		public Leg(String origin, String destination, String carrier) {
			this.origin = origin;
			this.destination = destination;
			this.carrier = carrier;
		}

		public String getOrigin() {
			return origin;
		}

		public String getDestination() {
			return destination;
		}

		public String getCarrier() {
			return carrier;
		}
	}
}
