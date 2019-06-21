package br.com.consultamedica.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory(){
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
			return factory;
		} else {
			return factory;
		}
	}
	
	
	public static void shutDown() {
		if(factory != null) {
			factory.close();
		}
	}

}
