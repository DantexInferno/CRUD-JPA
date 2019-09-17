package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import vo.Usuario;

@ManagedBean 
@RequestScoped
public class UsuarioBean {
	
	
	
	public String nuevo() {
		Usuario u=new Usuario();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		
		return "nuevo.jsf";
	}
	
	
	public String guardar(Usuario usuario) {
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		usuarioDAO.guardar(usuario);
		
		return "index.jsf";
		
	}
	
	public List<Usuario> ObtenerUsuarios() {
		UsuarioDAO loginDAO=new UsuarioDAO();
		
		 
		 return loginDAO.obtenerUsuario();
	}
	
	
	public String editar(Long id) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		Usuario u=new Usuario();
		u=usuarioDAO.buscar(id);
		System.out.println(u);
		
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		
		return "editar.jsf";
	}
	
	public String eliminar(Long id) {
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		usuarioDAO.eliminar(id);
		System.out.println("eliminado");
		
		
		return "";
		}
	
	
	public String actualizar(Usuario usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		usuarioDAO.editar(usuario);
		
		return "index.jsf";
	}
}
