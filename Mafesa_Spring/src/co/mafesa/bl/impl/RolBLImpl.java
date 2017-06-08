package co.mafesa.bl.impl;

import java.util.List;

import co.mafesa.bl.RolBL;
import co.mafesa.dao.RolDAO;
import co.mafesa.dto.Rol;
import co.mafesa.exception.MyException;

public class RolBLImpl implements RolBL {
	
	private RolDAO rolDAO;
	
	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

	@Override
	public List<Rol> obtener() throws MyException {
		return rolDAO.get();
	}


}
