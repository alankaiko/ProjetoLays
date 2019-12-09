package br.com.clinica.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.clinica.domain.DicomServidor;
import br.com.clinica.util.HibernateUtil;



public class DicomServidorRepository {
	Session sessao;
	Transaction transacao = null;
	
	
		public void Guardar(DicomServidor servidor){
			sessao = HibernateUtil.getSessionFactory().openSession();
			
			try {
				transacao = sessao.beginTransaction();
				sessao.merge(servidor);
				transacao.commit();
			} catch (RuntimeException e) {
				if (transacao != null)
					transacao.rollback();
				
				System.out.println("Erro no metodo Guardar Servidor repository");
				throw e;
			} finally {
				sessao.close();
			}
		}
		
		
		public void Remover(DicomServidor servidor) {
			sessao = HibernateUtil.getSessionFactory().openSession();
			
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(servidor);
				transacao.commit();
			} catch (RuntimeException e) {
				if (transacao != null)
					transacao.rollback();
				System.out.println("Erro no metodo Remover Servidor repository");
			} finally {
				sessao.close();
			}
		}
		
		
		
		public DicomServidor BuscarPorId(Long id){
			sessao = HibernateUtil.getSessionFactory().openSession();
			DicomServidor servidor = null;
			
			try {
				Query consulta = sessao.getNamedQuery("DicomServidor.buscarPorId");
				consulta.setLong("id", id);
				servidor = (DicomServidor) consulta.uniqueResult();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}		
			return servidor;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<DicomServidor> ListarServidores(){
			sessao = HibernateUtil.getSessionFactory().openSession();
			List<DicomServidor> lista = null;
			
			try {
				Query consulta = sessao.getNamedQuery("DicomServidor.listar");
				lista = consulta.list();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}
			
			return lista;
		}
		
		public DicomServidor BuscarNomeServidor(String hostname){
			sessao = HibernateUtil.getSessionFactory().openSession();
			DicomServidor servidor = null;
			
			try {
				Query consulta = sessao.getNamedQuery("DicomServidor.buscarHostName");
				consulta.setString("hostname", hostname);
				servidor = (DicomServidor) consulta.uniqueResult();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}		
			return servidor;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<DicomServidor> BuscarPeloNomeServidor(String buscarTitulo){
			sessao = HibernateUtil.getSessionFactory().openSession();
			List<DicomServidor> lista = null;
			
			try {
				Query consulta = sessao.getNamedQuery("DicomServidor.buscarPeloNome");
				consulta.setString("buscarTitulo", "%"+buscarTitulo+"%");
				lista = consulta.list();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}
			
			return lista;
		}
	
		
	
}
