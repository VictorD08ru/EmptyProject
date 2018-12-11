package tk.djandjiev.practice.service.country;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.djandjiev.practice.dao.country.CountryRepository;
import tk.djandjiev.practice.service.mapper.MapperFacade;
import tk.djandjiev.practice.to.CountryTO;

@Service
public class CountryServiceImpl implements CountryService {

  private final CountryRepository repository;
  private final MapperFacade facade;

  @Autowired
  public CountryServiceImpl(CountryRepository repository,
      MapperFacade facade) {
    this.repository = repository;
    this.facade = facade;
  }

  @Override
  public List<CountryTO> getAll() {
    return facade.mapAsList(repository.getAll(), CountryTO.class);
  }
}
