package gamepack;

public abstract class Region implements Comparable<Region>{
	private static int _serial;
	private String _id;
	private String _domain;
	protected Region(String pId,String pDomain) {
		// TODO Auto-generated constructor stub
		_id = pId +"@" +String.format("%03d", _serial);
		_domain = pDomain;
		_serial++;
	}
	protected Region(String pId,String pRegion,String pDomain) {
		// TODO Auto-generated constructor stub
		_id = pId + "@" + pRegion;
		_domain = pDomain;
	}
	
	public String getID(){
		return _id;
	}
	public String getDomain(){
		return _domain;
	}
	public String toString(){
		return "ID:" + getID() + "#" + "Domain:" + _domain;
	}
	public abstract String getTipo();
	
	@Override
	public int compareTo(Region pRegion) {
		if (getID().compareTo(pRegion.getID())< 0){
			return -1;
		}
		else if (getID().compareTo(pRegion.getID()) > 0){
			return 1;
		}
		return 0;
	}
}
