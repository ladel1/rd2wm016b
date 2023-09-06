package revisions.bll;

import java.util.List;

import revisions.bo.Client;

public class ClientManager {
	// Singleton classic
	
	private static ClientManager instance;
	
	private ClientManager() {}
	
	public static ClientManager getInstance() {
		if(instance == null) {
			instance = new ClientManager();
		}
		return instance;
	}
	// fin singleton
	
	// la logique metier
	
	public List<Client> getClients(){
		return List.of(
				
				new Client(1, "Sarah", "Duval", "Rennes"),
				new Client(1, "Gaelle", "Dupont", "Paris"),
				new Client(1, "Hugo", "De lor", "Quimper")
				);
	}

}
