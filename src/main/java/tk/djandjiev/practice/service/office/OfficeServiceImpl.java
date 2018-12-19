package tk.djandjiev.practice.service.office;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.dao.office.OfficeRepository;
import tk.djandjiev.practice.dao.organization.OrganizationRepository;
import tk.djandjiev.practice.model.Office;
import tk.djandjiev.practice.service.mapper.MapperFacade;
import tk.djandjiev.practice.to.office.OfficeRequest;
import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.to.office.SimplifiedOfficeTO;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса OfficeService.
 * @see tk.djandjiev.practice.service.office.OfficeService
 * */
@Service
public class OfficeServiceImpl implements OfficeService {

  private final MapperFacade facade;
  private final OfficeRepository repository;
  private final OrganizationRepository orgRepository;

  @Autowired
  public OfficeServiceImpl(MapperFacade facade,
      OfficeRepository repository,
      OrganizationRepository orgRepository) {
    this.facade = facade;
    this.repository = repository;
    this.orgRepository = orgRepository;
  }

  @Override
  public List<SimplifiedOfficeTO> getAll(OfficeRequest request) {
    return facade.mapAsList(
        repository.getAll(request.getOrgId(),
            request.getName(),
            request.getPhone(),
            request.getIsActive()),
        SimplifiedOfficeTO.class);
  }

  @Override
  public OfficeTO get(Integer id) {
    Office office = repository.get(id);
    return facade.map(office, OfficeTO.class);
  }

  @Override
  @Transactional
  public void save(OfficeTO officeTO) {
    ValidationUtil.notNull(officeTO);
    Office office;
    if (officeTO.getId() == null && officeTO.getOrgId() != null) {
      office = new Office();
      office.setOrganization(orgRepository.get(officeTO.getOrgId()));
    } else {
      office = repository.get(officeTO.getId());
    }
    facade.map(officeTO, office);
    repository.save(office);
  }
}
