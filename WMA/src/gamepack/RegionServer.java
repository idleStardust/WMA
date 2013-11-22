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
	
	public Cazador resetHunter(){
		Cazador tmp = _cazador;
		_cazador = null;
		return tmp;
	}
	
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "snode";
	}
	
	public String toString(){
		return super.toString();
	}
}
