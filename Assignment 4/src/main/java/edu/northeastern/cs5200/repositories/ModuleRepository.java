//package edu.northeastern.cs5200.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import edu.northeastern.cs5200.models.Module;
// 
//
//public interface ModuleRepository 
//	extends CrudRepository <Module, Integer>{
//	
//	@Query (value = "SELECT module FROM Module module")
//	public List<Module> findAllModules ();
//	
//	@Query ("SELECT module FROM Module module WHERE module.id = :mid")
//	public Module findModuleById (@Param("mid") Integer moduleId);
//}
