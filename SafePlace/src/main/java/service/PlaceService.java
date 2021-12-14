package wartungsplan.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import wartungsplan.model.Place;

@Service
public class PlaceService extends JdbcDaoSupport implements PlaceRepository {

	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	public PlaceService(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	ArrayList<Place> placeList;
	ArrayList<String> placeNameList;
	
	public List<Place> getPlaceList(){
		
		placeList = new ArrayList<Place>();
		
		String query = "SELECT * FROM gebaeude";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
		for(Map row : rows) {
			Place place = new Place();
			
			place.setTitel((String) row.get("titel"));
			place.setAnmerkung((String) row.get("anmerkung"));
			if((Integer) row.get("benutzt") == 1) {
				place.setBenutzt(true);
			}else {
				place.setBenutzt(false);
			}
			place.setId(((Integer) row.get("idgebaeude")).longValue());
			
			placeList.add(place);
		}
		
		return placeList;
	}

	public List<String> getPlaceNameList()
    {
		placeNameList = new ArrayList<String>();
    	String query = "SELECT name FROM device";
    	List<Map<String, Object>> zeilen =getJdbcTemplate().queryForList(query);
    	for(Map zeile : zeilen)
    	{
    		placeNameList.add((String) zeile.get("name"));
    	}
    	return placeNameList;
    }
	
	@Override
	public List<Place> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Place> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Place> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Place getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Place> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Place> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Place entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Place> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Place> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Place> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Place> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
