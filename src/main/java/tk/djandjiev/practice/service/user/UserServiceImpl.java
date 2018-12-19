package tk.djandjiev.practice.service.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.dao.country.CountryRepository;
import tk.djandjiev.practice.dao.doctype.DocTypeRepository;
import tk.djandjiev.practice.dao.document.DocumentRepository;
import tk.djandjiev.practice.dao.office.OfficeRepository;
import tk.djandjiev.practice.dao.user.UserRepository;
import tk.djandjiev.practice.model.Document;
import tk.djandjiev.practice.model.User;
import tk.djandjiev.practice.service.mapper.MapperFacade;
import tk.djandjiev.practice.to.user.SimplifiedUserTO;
import tk.djandjiev.practice.to.user.UserRequest;
import tk.djandjiev.practice.to.user.UserTO;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса UserService.
 * @see tk.djandjiev.practice.service.user.UserService
 * */
@Service
public class UserServiceImpl implements UserService {

  private final CountryRepository countryRepository;
  private final DocTypeRepository docTypeRepository;
  private final DocumentRepository documentRepository;
  private final MapperFacade facade;
  private final OfficeRepository officeRepository;
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(CountryRepository countryRepository,
      DocumentRepository documentRepository,
      DocTypeRepository docTypeRepository, MapperFacade facade,
      OfficeRepository officeRepository, UserRepository userRepository) {
    this.countryRepository = countryRepository;
    this.documentRepository = documentRepository;
    this.docTypeRepository = docTypeRepository;
    this.facade = facade;
    this.officeRepository = officeRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<SimplifiedUserTO> getAll(UserRequest request) {
    return facade.mapAsList(
        userRepository.getAll(request.getOfficeId(),
            request.getFirstName(),
            request.getLastName(),
            request.getMiddleName(),
            request.getPosition(),
            request.getDocCode(),
            request.getCitizenshipCode()),
        SimplifiedUserTO.class);
  }

  @Override
  @Transactional(readOnly = true)
  public UserTO get(Integer id) {
    return facade.map(userRepository.get(id), UserTO.class);
  }

  @Override
  @Transactional
  public void save(UserTO userTO) {
    User user;
    ValidationUtil.notNull(userTO);
    if (userTO.getId() == null && userTO.getOfficeId() != null) {
      user = new User();
      user.setOffice(officeRepository.get(userTO.getOfficeId()));
      user.setDocument(new Document());
    } else {
      user = userRepository.get(userTO.getId());
      if (userTO.getDocCode() != null && userTO.getDocNumber() != null) {
        Document doc = documentRepository.getByCodeAndNumber(userTO.getDocCode(),
            userTO.getDocNumber());
        if (doc == null) {
          doc = new Document();
        }
        user.setDocument(doc);
      }
    }

    if (userTO.getDocCode() != null) {
      user.getDocument().setType(docTypeRepository.getByCode(userTO.getDocCode()));
    }

    if (userTO.getCitizenshipCode() != null) {
      user.setCountry(countryRepository.getByCode(userTO.getCitizenshipCode()));
    } else {
      user.setCountry(null);
    }

    facade.map(userTO, user);
    if (user.getDocument() == null
        || user.getDocument().getType() == null
        || user.getDocument().getType().getCode() == null) {
      user.setDocument(null);
    }

    userRepository.save(user);
  }
}
