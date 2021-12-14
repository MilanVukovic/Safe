package wartungsplan.service;

import java.sql.Date;
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
import wartungsplan.model.Task;

@Service
public class TaskService extends JdbcDaoSupport implements TaskRepository {

	@Autowired
	private TaskRepository taskRepository;
	
	ArrayList<Task> taskList;
	ArrayList<String> taskNameList;
	
	@Autowired
	public TaskService(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Task> getTaskList(){
		
		taskList = new ArrayList<Task>();
		
		String query = "SELECT * FROM task";
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
		for(Map row : rows) {
			Task task = new Task();
			
			task.setBemerkung((String) row.get("bemerkung"));
			task.setVon((String) df.format(row.get("von")));
			task.setBis((String) df.format(row.get("bis")));
			task.setErinnerung((String) df.format(row.get("erinnerung")));
			task.setIntervall((int) row.get("intervall"));
			task.setFix((String) df.format(row.get("fix")));
			task.setJedem((int) row.get("jedem"));
			task.setGebaeudeid((int) row.get("gebaeude_idgebaeude"));
			task.setDeviceid((int) row.get("device_iddevice"));
			
			taskList.add(task);
		}
		
		return taskList;
	}
	
	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Task> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Task> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Task> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Task> findById(Long id) {
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
	public void delete(Task entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Task> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Task> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Task> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Task> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
}