package tk.djandjiev.practice.service.mapper;

import java.util.List;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.djandjiev.practice.model.User;
import tk.djandjiev.practice.to.user.UserTO;

/**
 * Реализация интерфейса MapperFacade.
 * @see tk.djandjiev.practice.service.mapper.MapperFacade
 * */
@Service
public class MapperFacadeImpl implements MapperFacade {
  private final MapperFactory factory;

  @Autowired
  public MapperFacadeImpl(MapperFactory factory) {
    this.factory = factory;
  }

  @Override
  public <S, D> D map(S sourceObject, Class<D> destinationClass) {
    if (sourceObject.getClass().getName().equals(User.class.getName())
        && destinationClass.getName().equals(UserTO.class.getName())) {
      checkIsUser();
    }
    return factory.getMapperFacade().map(sourceObject, destinationClass);
  }

  @Override
  public <S, D> void map(S sourceObject, D destinationObject) {
    if (sourceObject.getClass().getName().equals(UserTO.class.getName())
        && destinationObject.getClass().getName().equals(User.class.getName())) {
      checkIsUser();
    }
    factory.getMapperFacade().map(sourceObject, destinationObject);
  }

  @Override
  public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
    return factory.getMapperFacade().mapAsList(source, destinationClass);
  }

  private <S, D> void checkIsUser() {
    factory.classMap(User.class, UserTO.class)
        .mapNulls(false).mapNullsInReverse(false)
        .field("document.number", "docNumber")
        .field("document.issueDate", "docDate")
        .field("office.id", "officeId")
        .byDefault(MappingDirection.BIDIRECTIONAL)
        .field("country.name", "citizenshipName")
        .field("document.type.name", "docName")
        .field("document.type.code", "docCode")
        .field("country.code", "citizenshipCode")
        .byDefault(MappingDirection.A_TO_B)
        .register();
  }
}
