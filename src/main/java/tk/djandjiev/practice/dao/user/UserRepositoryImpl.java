package tk.djandjiev.practice.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.User;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса UserRepository.
 * @see tk.djandjiev.practice.dao.user.UserRepository
 * */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private EntityManager em;

  @Override
  public List<User> getAll() {
    return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
  }

  @Override
  public User get(Integer id) {
    return em.find(User.class, id);
  }

  @Override
  @Transactional
  public User save(User user) {
    ValidationUtil.notNull(user);
    if (ValidationUtil.isNew(user)) {
      em.persist(user);
      return user;
    } else {
      return em.merge(user);
    }
  }
}
