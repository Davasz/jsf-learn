package erp.repository;

import erp.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SchemaGeneration {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJsfPU");
        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class)
                .getResultList();

        System.out.println(lista);

        em.close();
        emf.close();
    }
}
