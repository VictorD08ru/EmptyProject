package tk.djandjiev.practice.dao.country;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.Country;

/**
 * Реализация интерфейса CountryRepository.
 * @see tk.djandjiev.practice.dao.country.CountryRepository
 * */
@Repository
@Transactional(readOnly = true)
public class CountryRepositoryImpl implements CountryRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Country> getAll() {
    return em.createNamedQuery(Country.ALL_SORTED, Country.class).getResultList();
  }

  @Override
  public Country getByCode(String code) {
    List<Country> list = em.createNamedQuery(Country.GET_BY_CODE, Country.class)
        .setParameter(1, code).getResultList();
    return DataAccessUtils.singleResult(list);
  }
}
