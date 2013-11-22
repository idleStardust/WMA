package gamepack;

public class RegionClient extends Region{

	public RegionClient(String pDomain) {
		super("cnode",pDomain);
		// TODO Auto-generated constructor stub
	}
	public RegionClient(String pRegion, String pDomain) {
		super("cnode",pRegion,pDomain);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "cnode";
	}
	
	public String toString(){
		return super.toString();
	}
}
