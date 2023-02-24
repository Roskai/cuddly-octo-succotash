package dao;

import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import entities.CapteurEnv;

@Singleton
public class CapteurEnvDao {

	private static List<CapteurEnv> capteursEnv = new ArrayList<>(); 

	public List<CapteurEnv> getAll() {
		return Collections.unmodifiableList(capteursEnv);
	}

	public void create(CapteurEnv entity) {
		capteursEnv.add(entity);
	}


}
