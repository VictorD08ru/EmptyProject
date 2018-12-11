package tk.djandjiev.practice.service.mapper;

import java.util.List;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return factory.getMapperFacade().map(sourceObject, destinationClass);
  }

  @Override
  public <S, D> void map(S sourceObject, D destinationObject) {
    factory.getMapperFacade().map(sourceObject, destinationObject);
  }

  @Override
  public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
    return factory.getMapperFacade().mapAsList(source, destinationClass);
  }
}
