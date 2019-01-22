package tk.djandjiev.practice.util;

import javax.validation.groups.Default;

/**
 * Класс для спецальных валидационных групп.
 * */
public class View {
  /**
   * Группа валидации, применяемая при сохранении нового объекта.
   * */
  public interface Saveable extends Default {}

  /**
   * Группа валидации, применяемая при обновлении существующего объекта.
   * */
  public interface Updateable extends Default {}
}
