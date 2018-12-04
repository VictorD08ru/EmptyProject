package tk.djandjiev.practice.dao.country;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private EntityManager em;

  @Override
  public List<Country> getAll() {
    return em.createNamedQuery(Country.ALL_SORTED, Country.class).getResultList();
  }

  @Override
  public Country get(Integer id) {
    return em.find(Country.class, id);
  }

  @Override
  public Country getByCode(String code) {
    List<Country> list = em.createNamedQuery(Country.BY_CODE, Country.class)
        .setParameter(1, code).getResultList();
    return DataAccessUtils.singleResult(list);
  }
}
