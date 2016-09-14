package db;

import Interfaces.DAO;
import model.Clienti;
import model.Facturi;
import model.Furnizori;

public class DAOFactory {

	public DAO<Clienti> createClientiDAO()
	{
		return new ClientiDAOMySQL_impl();
	}
	
	DAO<Facturi> createFacturiDAO()
	{
		return new FacturiDAOMySQL_Impl();
	}

	DAO<Furnizori> createFurnizoriDAO()
	{
		return new FurnizoriDAOMySQL_Impl();
	}
	
}

