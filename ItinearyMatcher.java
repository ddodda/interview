class Main {  
  public static void main(String args[]) { 
    Main ins = new Main();
   ins.run();
  } 

  static List<Flight> flightList = new ArrayList<Flight>();	
	static {
		flightList.add(new Flight("IAD", "SFO", 400, 3000));
		flightList.add(new Flight("IAD", "JFK", 180.50, 1000));
		flightList.add(new Flight("JFK", "SFO", 185, 1500));
		flightList.add(new Flight("IAD", "ORD", 190, 2500));
		flightList.add(new Flight("ORD", "LAX", 20, 2000));
		flightList.add(new Flight("ORD", "SFO", 160, 2000));
		flightList.add(new Flight("ORD", "LAX", 80, 500));
		flightList.add(new Flight("LAX", "SFO", 50, 200));
		flightList.add(new Flight("ORD", "DFW", 150, 200));
		flightList.add(new Flight("JFK", "DFW", 50, 200));
		flightList.add(new Flight("IAD", "LHR", 700, 3500));				
	}
	
  
  private void run(){
     
}


 public List<Leg> getMatchedItinerary(Itinerary itinerary) {
        //create a final new list to capture legs
        List<Leg> matchedItineraryList = new ArrayList<>(0);
        List<Leg> incomingItineraryLegs = itinerary != null ? itinerary.getLegs() : new ArrayList<>(0);


        Leg prevLeg = null;
        boolean lastMatch = false;

        for(Leg leg : incomingItineraryLegs){
            String currentCarrier = leg.getCarrier();
            if(prevLeg == null || !currentCarrier.equals(prevLeg.getCarrier())){
                if(prevLeg != null){
                    matchedItineraryList.add(prevLeg);
                }
                Leg newLeg = new Leg(leg.getOrigin(), leg.getDestination(), leg.getCarrier());
                //matchedItineraryList.add(newLeg);
                prevLeg = newLeg;
            } else {
                prevLeg = new Leg(prevLeg.getOrigin(), leg.getDestination(), leg.getCarrier());


            }

        }

            matchedItineraryList.add(prevLeg);



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

	private final Location origin;
	private final Location destination;
	private final String carrier;
	
	public Leg(Location origin, Location destination, String carrier) {
		this.origin = origin;
		this.destination = destination;
		this.carrier = carrier;
	}
	
	public Location getOrigin() {
		return origin;
	}

	public Location getDestination() {
		return destination;
	}

	public String getCarrier() {
		return carrier;
	}
}
}
