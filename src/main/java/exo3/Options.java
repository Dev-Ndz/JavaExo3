package exo3;

public class Options {
	String country;
	String commodity;
	String transportMode;
	String measure;
	
	public Options() {
		this.country = "All";
		this.commodity = "All";
		this.transportMode = "All";
		this.measure = "$";
	}
	
    public void setCountry(String country) {
        this.country = country;
    }
    
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }
    
    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }
    
    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
