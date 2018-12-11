package tk.djandjiev.practice.service.doctype;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.djandjiev.practice.dao.doctype.DocTypeRepository;
import tk.djandjiev.practice.service.mapper.MapperFacade;
import tk.djandjiev.practice.to.DocTypeTO;

/**
 * Реализация интерфейса DocTypeService.
 * @see tk.djandjiev.practice.service.doctype.DocTypeService
 * */
@Service
public class DocTypeServiceImpl implements DocTypeService {

  private final DocTypeRepository repository;
  private final MapperFacade facade;

  @Autowired
  public DocTypeServiceImpl(DocTypeRepository repository,
      MapperFacade facade) {
    this.repository = repository;
    this.facade = facade;
  }

  @Override
  public List<DocTypeTO> getAll() {
    return facade.mapAsList(repository.getAll(), DocTypeTO.class);
  }
}
