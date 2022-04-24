class UndergroundSystem {
    private int id;
    private String stationName;
    private int t;
    HashMap<Integer,Pair<String,Integer>> checkin = new HashMap<>();
    HashMap<Pair<String,String>,int[]> checkout = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.id=id;
        this.stationName=stationName;
        this.t=t;
        checkin.put(id, new Pair<>(stationName,t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> idDetail = checkin.get(id);
        Pair<String,String> station = new Pair<>(idDetail.getKey(),stationName);
        int[] time = checkout.getOrDefault(station,new int[2]);
        time[0]++;
        time[1] = time[1] + t - idDetail.getValue();
        checkout.put(station,time);
        checkin.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        int[] t = checkout.get(new Pair<>(startStation, endStation));
        return (double)t[1]/(double)t[0];
    }
}