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

import wartungsplan.model.Device;

@Service
public class DeviceService extends JdbcDaoSupport implements DeviceRepository {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	public DeviceService(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	ArrayList<Device> deviceList;
	ArrayList<String> deviceNameList;
	ArrayList<String> deviceIdList;
	
	public List<Device> getDeviceList(){
		
		deviceList = new ArrayList<Device>();
		
		String query = "SELECT * FROM device";
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
		for(Map row : rows) {
			Device device = new Device();
			
			device.setTyp((String) row.get("type"));
			device.setBemerkung((String) row.get("bemerkung"));
			device.setName((String) row.get("name"));
			device.setGarantiedauer((Integer) row.get("garantiedauer"));
			device.setGekauftAm((String) df.format(row.get("gekauftam")));
			device.setGekauftBei((String) row.get("gekauftbei"));
			device.setRechnungPath((String) row.get("rechnungpath"));
			if((Integer) row.get("benutzt") == 1) {
				device.setBenutzt(true);
			}else {
				device.setBenutzt(false);
			}
			device.setId(((Integer) row.get("iddevice")).longValue());
			
			deviceList.add(device);
		}
		
		return deviceList;
	}
	
	public List<String> getDeviceNameList()
    {
    	deviceNameList = new ArrayList<String>();
    	String query = "SELECT name FROM device";
    	List<Map<String, Object>> zeilen =getJdbcTemplate().queryForList(query);
    	for(Map zeile : zeilen)
    	{
    		deviceNameList.add((String) zeile.get("name"));
    	}
    	return deviceNameList;
    }
	
	public List<String> getDeviceIdList()
    {
    	deviceIdList = new ArrayList<String>();
    	String query = "SELECT id FROM device";
    	List<Map<String, Object>> zeilen =getJdbcTemplate().queryForList(query);
    	for(Map zeile : zeilen)
    	{
    		deviceIdList.add((String) zeile.get("iddevice"));
    	}
    	return deviceIdList;
    }

	@Override
	public List<Device> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Device> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Device> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Device getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Device> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Device> findById(Long id) {
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
	public void delete(Device entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Device> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Device> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Device> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Device> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
