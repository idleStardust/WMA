package networkpack.protocolpack;

import facadepack.FacadeProtocol;

public class Encoder {
	private static Encoder _singletonEncoder = new Encoder();
	public Encoder(){}
	public String _from = "a";
	public String _to = "b";
	public static Encoder getInstance(){
		return _singletonEncoder;
	}
	
	public String EncoderCorrespondence(String pId,String pTipo, String pAccion,String pDetails){
		System.out.println("<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + pId +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ pTipo+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+pAccion+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ pDetails+	
				
				"/>");
		return "<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + pId +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ pTipo+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+pAccion+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ pDetails+	
				
				"/>";
	}
	public static void main(String[] args) {
		Encoder.getInstance().EncoderCorrespondence("ed", "node@222", "create", "Domain:192.168.1.1");	
	}
	
	public String crearNodo(String pContenido){
		String msg ="<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + "nuevoNodo" +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ Constantes.NODO_NORMAL+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+Constantes.ACCION_CREAR+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ pContenido+
				"/>";
		return msg;
		
	}
	
	public String borrarNodo(String pContenido){
		String msg ="<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + "borrarNodo" +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ Constantes.NODO_NORMAL+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+Constantes.ACCION_DESTRUIR+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ pContenido+
				"/>";
		
		return msg;
		
	}
	
	
	public String conectarNodos(String conector1, String conector2, String idLinker){
		String msg ="<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + "conectarNodos" +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ Constantes.CONECTOR+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+Constantes.ACCION_CONECTAR+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ idLinker+
				Constantes.ATRIBUTO_IDA+ "="+ conector1+
				Constantes.ATRIBUTO_IDB+ "="+ conector2+
				
				"/>";
		return msg;
		
	}
	
	public String conectarNodosconex(String conector1, String conector2, String idLinker){
		String msg ="<" + 
				Constantes.CORREPONDENCIA_ETIQUETA + "%"+
				Constantes.ATRIBUTO_ID + "=" + "conectarNodosconex" +"%"+
				Constantes.ATRIBUTO_FROM + "=" + _from +"%"+
				Constantes.ATRIBUTO_TO+ "=" + _to+"%"+
				Constantes.ATRIBUTO_TYPE+ "="+ Constantes.CONECTOR_DE_RED+"%"+
				Constantes.ATRIBUTO_ACTION+ "="+Constantes.ACCION_CONECTAR_POR_RED+"%"+
				Constantes.ATRIBUTO_DETAILS+ "="+ idLinker+
				Constantes.ATRIBUTO_IDA+ "="+ conector1+
				Constantes.ATRIBUTO_IDB+ "="+ conector2+
				
				"/>";
		return msg;
		
	}
	
	
	
	
	
	
	
	
}

