package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vo.JPAUtil;
import vo.Usuario;

public class UsuarioDAO {

	EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//guardar usuario
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
	}
	
	//editar usuario
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
	}
	
	//buscar usuario
	public Usuario buscar(Long id) {
		Usuario usuario= new Usuario();
		usuario=entity.find(Usuario.class, id);
		//JPAUtil.shutdown();
		return usuario;
	}
	
	
	public void eliminar(Long id) {
		Usuario usuario=new Usuario();
		usuario=entity.find(Usuario.class, id);
		entity.getTransaction().begin();
		entity.remove(usuario);
		entity.getTransaction().commit();

	}
	
	//buscar todos los usuarios
	public List<Usuario> obtenerUsuario() {
		List<Usuario> listaUsuario= new ArrayList<>();
		
		Query q=entity.createQuery("SELECT u from Usuario u");
		listaUsuario=q.getResultList();
		
		return listaUsuario;
	}
}
