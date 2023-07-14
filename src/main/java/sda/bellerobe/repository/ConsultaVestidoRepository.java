package sda.bellerobe.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoFiltroRequest;

@Repository
public class ConsultaVestidoRepository implements IConsultaVestidoRepository{

	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<VestidoModel> busquedaVestido(VestidoFiltroRequest filtro) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VestidoModel> cq = cb.createQuery(VestidoModel.class);
		Root<VestidoModel> root = cq.from(VestidoModel.class);
		List<Predicate> predicados = new ArrayList<Predicate>();
		
		if (filtro.getIdTipo() != null) {
			predicados.add(cb.equal(root.get("idTipo"), filtro.getIdTipo()));
		}
		
		if(filtro.getNombreVestido() != null && !filtro.getNombreVestido().isEmpty()) {
			predicados.add(cb.like(root.get("descripción"), "%" + filtro.getNombreVestido() + "%"));
		}
		
		if(filtro.getDescripcion() != null && !filtro.getDescripcion().isEmpty()) {
			predicados.add(cb.like(root.get("descripción"), "%" + filtro.getDescripcion() + "%"));
		}
		
		cq.orderBy(cb.asc(root.get("idTipo")));
		CriteriaQuery<VestidoModel> select = cq.select(root);
		TypedQuery<VestidoModel> typedQuery = em.createQuery(select);
		List<VestidoModel> lista  = typedQuery.getResultList();
		Response<VestidoModel> response = new Response<VestidoModel>();
		
		if(!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		}else {
			response.setMessage("Sin resultados");
			response.setStatus("OK");
		}
		
		return response;
	}
	

}
