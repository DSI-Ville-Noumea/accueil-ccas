package accueilccas.dao;

import java.util.List;

import accueilccas.bean.TypePublic;

public interface TypePublicDAO {
	public TypePublic getTypePublic(int id);
	public List<TypePublic> getListTypePublic();
	public void saveTypePublic(TypePublic typePublic);
	public void reOrderPublic(int[] orderInt);
}
