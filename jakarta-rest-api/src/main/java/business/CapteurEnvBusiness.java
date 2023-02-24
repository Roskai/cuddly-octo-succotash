package business;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dao.CapteurEnvDao;
import entities.CapteurEnv;

@Singleton
public class CapteurEnvBusiness {

	@Inject
	private CapteurEnvDao capteurEnvDao;

	public List<CapteurEnv> getAllCapteursEnv() {
		return capteurEnvDao.getAll();
	}

}
