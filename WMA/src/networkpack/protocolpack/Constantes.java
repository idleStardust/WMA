package networkpack.protocolpack;

// TODO: Auto-generated Javadoc
/**
 * La Interface Constantes.
 * Proporciona constantes al protocolo de comunicacion.
 */
public interface Constantes {
	
	/** La Constante CORREPONDENCIA_ETIQUETA. Es el nombre que se le asigna a la
	 * etiqueta al enviar un mensaje de accion.*/
	public static final String CORREPONDENCIA_ETIQUETA = "correspondence";
	
	/** La Constante RESPUESTA_ETIQUETA. Nombre de la etiqueta del mensaje 
	 * que confirma la llegada del mensaje.
	 * */
	public static final String RESPUESTA_ETIQUETA = "response";
	
	/** La Constante DELIMITADOR_IZQUIERDO. Es el extremo izquierdo o inicial del mensaje.*/
	public static final String DELIMITADOR_IZQUIERDO = "<";
	
	/** La Constante DELIMITADOR_DERECHO. Es el extremo derecho o final del mensaje.*/
	public static final String DELIMITADOR_DERECHO = "/>";
	
	/** La Constante SEPARADOR_SUBPROTOCOLO. Es el separador del subprotocolo,
	 * este separa las propiedades de un objeto enviado por red
	 * */
	public static final String SEPARADOR_SUBPROTOCOLO = "#";
	
	/** La Constante SEPARADOR_DOMAIN_REGION. Separa el dominio o ip de la region o nodo*/
	public static final String SEPARADOR_DOMAIN_REGION = ":";
	
	/** La Constante ATRIBUTO_ID. Es el atributo id del mensaje.*/
	public static final String ATRIBUTO_ID = "id";
	
	/** La Constante ATRIBUTO_FROM. Es el atributo from (desde) del mensaje.*/
	public static final String ATRIBUTO_FROM = "from";
	
	/** La Constante ATRIBUTO_TYPE. Es el atributo type (tipo) del mensaje.*/
	public static final String ATRIBUTO_TYPE = "type";
	
	/** La Constante ATRIBUTO_ACTION. Es el atributo action (accion) del mensaje.*/
	public static final String ATRIBUTO_ACTION = "action";
	
	/** La Constante ATRIBUTO_DETAILS. Es el atributo details (detalles) del mensaje.*/
	public static final String ATRIBUTO_DETAILS = "details";
	
	/** La Constante ATRIBUTO_TO. Es el atributo to (para) del mensaje.*/
	public static final String ATRIBUTO_TO = "to";
	
	/** La Constante ATRIBUTO_CONTAINS. Es el atributo contains (contiene) del mensaje.*/
	public static final String ATRIBUTO_CONTAINS = "contains";
	
	/** La Constante ATRIBUTO_IDA. Es el atributo ida (id primero) del mensaje.*/
	public static final String ATRIBUTO_IDA = "ida";
	
	/** La Constante ATRIBUTO_IDB. Es el atributo action (accion) del mensaje.*/
	public static final String ATRIBUTO_IDB = "idb";
	
	
	/** La Constante NODO_NORMAL. Es un posible contenido del atributo type
	 * representa un nodo normal.
	 * */
	public static final String NODO_NORMAL = "node";
	
	/** La Constante NODO_CLIENTE. Es un posible contenido del atributo type
	 * representa un nodo cliente.
	 * */
	public static final String NODO_CLIENTE = "cnode";
	
	/** La Constante NODO_SEVER. Es un posible contenido del atributo type
	 * representa un nodo servidor.
	 * */
	public static final String NODO_SEVER = "snode";
	
	/** La Constante CAZA_RECOMPENSAS. Es un posible contenido del atributo contains
	 * representa un colector de puntos o asalta arduinos. 
	 * */
	public static final String CAZA_RECOMPENSAS = "bountyhunter";
	
	/** La Constante ARDUINO. Es un posible contenido del atributo contains
	 * representa un arduino, real o programado.
	 * */
	public static final String ARDUINO = "arduino";
	
	/** La Constante CONECTOR. Es un posible contenido del atributo type
	 * representa una conexion normal entre dos nodos cuales quiera.
	 * */
	public static final String CONECTOR = "linker";
	
	/** La Constante CONECTOR_DE_RED. Es un posible contenido del atributo type
	 * representa una conexion entre un nodo servidor y un nodo cliente.
	 * */
	public static final String CONECTOR_DE_RED = "rlinker";
	
	/** La Constante NULO. Es un posible contenido de casi todos los atributos. representa 
	 * nada o vacio
	 * */
	public static final String NULO = "none";
	
	/** La Constante RE. Significa respuesta.*/
	public static final String RE = "RE:";
	
	/** La Constante ACCION_CREAR. Es un posible contenido del atributo action
	 * representa la accion de crear cualquier objeto que se contenga en el atributo type.
	 * */
	public static final String ACCION_CREAR = "create";
	
	/** La Constante ACCION_DESTRUIR. Es un posible contenido del atributo action
	 * representa la accion de destruir cualquier objeto que se contenga en el atributo type.
	 * */
	public static final String ACCION_DESTRUIR = "destroy";
	
	/** La Constante ACCION_CONECTAR. Es un posible contenido del atributo action
	 * representa la accion de unir dos nodos.*/
	public static final String ACCION_CONECTAR = "connect";
	
	/** La Constante ACCION_CONECTAR_POR_RED. Es un posible contenido del atributo action
	 * representa la accion de unir bidirecionalmente un nodo servidor 
	 * y un nodo cliente.
	 * */
	public static final String ACCION_CONECTAR_POR_RED = "rconnect";
	
	/** La Constante ACCION_DESCONECTAR_POR_RED. Es un posible contenido del atributo action
	 * representa la accion de destruir la conexion por red de un nodo cliente y uno servidor.*/
	public static final String ACCION_DESCONECTAR_POR_RED = "rdisconnect";
	
	/** La Constante ACCION_LLAMAR_CAZA_RECOMPENSAS. Es un posible contenido del atributo action
	 * representa la accion de llamar un casa recompensas a su dominio hogar.*/
	public static final String ACCION_LLAMAR_CAZA_RECOMPENSAS = "call";
	
	/** La Constante ACCION_ASIGNAR_MISION. Es un posible contenido del atributo action
	 * representa la accion de asignar una nueva mision al cazarrecompenzas.*/
	public static final String ACCION_ASIGNAR_MISION = "mission";
	
	/** La Constante ACCION_COLECCIONAR_PUNTOS. Es un posible contenido del atributo action
	 * representa la accion de recolectar los puntos de los cazarrecompenzas de un dominio.*/
	public static final String ACCION_COLECCIONAR_PUNTOS = "collect";
	
	/** La Constante ACCION_VISITAR_NODO. Es un posible contenido del atributo action
	 * representa la accion que se le asigna a un cazarrecompenzas de visitar un nodo.*/
	public static final String ACCION_VISITAR_NODO = "visit";
	
	/** La Constante ACCION_CONCLUIR_JUEGO. Es un posible contenido del atributo action
	 * representa la accion que termina la partida. */
	public static final String ACCION_CONCLUIR_JUEGO = "halt";
}
