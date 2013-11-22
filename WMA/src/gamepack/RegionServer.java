package gamepack;

public class RegionServer extends Region{
	private Cazador _cazador;
	
	protected RegionServer(String pDomain) {
		super("snode", pDomain);
		// TODO Auto-generated constructor stub
	}
	
	public RegionServer(String pRegion, String pDomain) {
		super("snode",pRegion,pDomain);
		// TODO Auto-generated constructor stub
	}
	
	public void AssingHunter(Cazador pCazador){
		_cazador = pCazador;
	}
	
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "snode";
	}
	
	public String toString(){
		return super.toString();
	}
	
	public static void main(String[] args) {
		RegionServer node = new RegionServer("533","192.168.1.1");
		System.out.println(node.toString());
	}

}
