package networkpack.protocolpack;

import facadepack.FacadeProtocol;
import managerpack.MainManager;

public class Decoder {
	private static Decoder _singletonDecoder = new Decoder();
	FacadeProtocol facadeprotoc= new FacadeProtocol().getInstance();
	public Decoder(){}
	
	
	
	public static Decoder getInstance(){
		return _singletonDecoder;
	}

	
	public void Decode(String pMensaje){
		System.out.println("Mensaje a decodificar"+pMensaje);
		String[] msg_recieve=pMensaje.split("%");
		String [] decodificar_msg= msg_verif(msg_recieve);
		facadeprotoc.recibirMensaje(decodificar_msg);
		
		if (decodificar_msg!=null){
			if(decodificar_msg[5].equals(Constantes.ACCION_CREAR)){
				facadeprotoc.crearNodo(decodificar_msg);
			}
			
			else if(decodificar_msg[5].equals(Constantes.ACCION_DESTRUIR)){
				facadeprotoc.borrarNodo(decodificar_msg);
			}
			
			else if(decodificar_msg[5].equals(Constantes.ACCION_CONECTAR)){
				facadeprotoc.conectarNodos(decodificar_msg);
			}
			
			else if(decodificar_msg[5].equals(Constantes.ACCION_CONECTAR_POR_RED)){
				facadeprotoc.conectarNodoConexion(decodificar_msg);
			}
			else if(decodificar_msg[5].equals(Constantes.ACCION_DESCONECTAR_POR_RED)){
				facadeprotoc.desconectarNodoConexion(decodificar_msg);
			}
			else if(decodificar_msg[5].equals(Constantes.ACCION_ASIGNAR_MISION)){
				facadeprotoc.nuevaMission(decodificar_msg);
			}
			else if(decodificar_msg[5].equals(Constantes.ACCION_LLAMAR_CAZA_RECOMPENSAS)){
				facadeprotoc.nuevaMission(decodificar_msg);
			}
			
			
		}
		for(int x=0;x<decodificar_msg.length;x++){
			//System.out.println("elemento "+  x + "  " + a[x]  );
		}

	}


	


	public String[] msg_verif(String[] toverif){	
		if(toverif.length<7 ||toverif.length>9){
			System.out.println("Mensaje erroneo");
			return null;
		}
		else if (Constantes.CORREPONDENCIA_ETIQUETA.equals(toverif[0].replaceAll("<", ""))){
			
			toverif[0]=Constantes.CORREPONDENCIA_ETIQUETA;
			String tmp = toverif[1];
			if (tmp.contains(Constantes.ATRIBUTO_ID)){
				toverif[1]=tmp.replace(Constantes.ATRIBUTO_ID + "=", "");
				tmp = toverif[2];
				
				if(tmp.contains(Constantes.ATRIBUTO_FROM)){
					toverif[2]=tmp.replace(Constantes.ATRIBUTO_FROM + "=", "");
					tmp = toverif[3];
					if(tmp.contains(Constantes.ATRIBUTO_TO)){
						toverif[3]=tmp.replace(Constantes.ATRIBUTO_TO + "=", "");
						tmp = toverif[4];
						if(tmp.contains(Constantes.ATRIBUTO_TYPE)){
							toverif[4]=tmp.replace(Constantes.ATRIBUTO_TYPE + "=", "");							
							tmp = toverif[5];
							if(tmp.contains(Constantes.ATRIBUTO_ACTION)){
								toverif[5]=tmp.replace(Constantes.ATRIBUTO_ACTION + "=", "");
								tmp = toverif[6];
								if(tmp.contains(Constantes.ATRIBUTO_CONTAINS)){
									toverif[6]=tmp.replace(Constantes.ATRIBUTO_CONTAINS + "=", "");
									tmp = toverif[7];
									if(tmp.contains(Constantes.ATRIBUTO_DETAILS)){
										toverif[7]=tmp.replace(Constantes.ATRIBUTO_DETAILS + "=", "").replaceFirst("/>", "");
										return toverif;
									}
								}			
								else if(tmp.contains(Constantes.ATRIBUTO_DETAILS)){
									
									toverif[6]=tmp.replace(Constantes.ATRIBUTO_DETAILS + "=", "").replaceFirst("/>", "");
									if(toverif.length==9){
										tmp = toverif[7].replace("/>", "");
										if(tmp.contains(Constantes.ATRIBUTO_IDA)){
											toverif[7]=tmp.replace(Constantes.ATRIBUTO_IDA + "=", "");
											tmp = toverif[8];
											if(tmp.contains(Constantes.ATRIBUTO_IDB)){
												toverif[8]=tmp.replace(Constantes.ATRIBUTO_IDB + "=", "");
												return toverif;
											}
										}
									}
									else return toverif;
								}
							}	
						}
					}
				}
			}
		}
		return null;
	}
}

