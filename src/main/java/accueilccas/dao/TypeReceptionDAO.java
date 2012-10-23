package accueilccas.dao;

import java.util.List;

import accueilccas.bean.TypeReception;

public interface TypeReceptionDAO {
	public TypeReception getTypeReception(int id);
	public List<TypeReception> getListTypeReception();
	public void saveTypeReception(TypeReception typeReception);
	public void reOrderTypeReception(int[] orderInt);
}
