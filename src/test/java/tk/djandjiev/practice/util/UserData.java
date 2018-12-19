package tk.djandjiev.practice.util;

import java.time.LocalDate;
import tk.djandjiev.practice.to.user.SimplifiedUserTO;
import tk.djandjiev.practice.to.user.UserTO;

public class UserData {

  public static final Integer USER_ID0 = 10000;
  public static final Integer USER_ID1 = 10001;
  public static final Integer USER_ID2 = 10002;
  public static final Integer USER_ID3 = 10003;
  public static final Integer USER_ID4 = 10004;
  public static final Integer USER_ID5 = 10005;
  public static final Integer USER_ID6 = 10006;
  public static final Integer USER_ID7 = 10007;
  public static final Integer USER_ID8 = 10008;
  public static final Integer USER_ID9 = 10009;
  public static final Integer USER_ID10 = 10010;
  public static final Integer USER_ID_NEW = 10011;

  public static final SimplifiedUserTO SIMPLE_USER_0 = new SimplifiedUserTO(USER_ID0,
      "Антон", "Антонов",
      "Антонович", "Генеральный директор");
  public static final SimplifiedUserTO SIMPLE_USER_1 = new SimplifiedUserTO(USER_ID1,
      "Антонина", "Антонова",
      "Антоновна", "Главный бухгалтер");
  public static final SimplifiedUserTO SIMPLE_USER_2 = new SimplifiedUserTO(USER_ID2,
      "Алексей", "Попович",
      "Даниилович", "Коммерческий директор");
  public static final SimplifiedUserTO SIMPLE_USER_3 = new SimplifiedUserTO(USER_ID3,
      "Александр", "Македонский",
      "Александрович", "Курьер");
  public static final SimplifiedUserTO SIMPLE_USER_4 = new SimplifiedUserTO(USER_ID4,
      "Борис", "Борисенко",
      "Борисович", "Генеральный директор");
  public static final SimplifiedUserTO SIMPLE_USER_5 = new SimplifiedUserTO(USER_ID5,
      "Богдан", "Борисенко",
      "Борисович", "Заместитель генерального директора");
  public static final SimplifiedUserTO SIMPLE_USER_6 = new SimplifiedUserTO(USER_ID6,
      "Белла", "Бунина",
      "Борисовна", "Коммерческий директор");
  public static final SimplifiedUserTO SIMPLE_USER_7 = new SimplifiedUserTO(USER_ID7,
      "Валерий", "Леонтьев",
      "Валерьевич", "Генеральный директор");
  public static final SimplifiedUserTO SIMPLE_USER_8 = new SimplifiedUserTO(USER_ID8,
      "Велемир", "Хмарин",
      "Перунович", "Менеджер");
  public static final SimplifiedUserTO SIMPLE_USER_9 = new SimplifiedUserTO(USER_ID9,
      "Галина", "Домовой",
      "Георгиевна", "Генеральный директор");
  public static final SimplifiedUserTO SIMPLE_USER_10 = new SimplifiedUserTO(USER_ID10,
      "Глеб", "Васильев",
      "Васильевич", "Продавец-консультант");

  public static final UserTO USER_TO_0 = new UserTO(USER_ID0,
      "Антон", "Антонов", "Антонович",
      "Генеральный директор", "9151231123",
      "21", "Паспорт гражданина Российской Федерации",
      "7701123123", LocalDate.parse("2000-01-31"),
      "Российская Федерация", "643", true, 10000);
  public static final UserTO USER_TO_1 = new UserTO(USER_ID1,
      "Антонина", "Антонова", "Антоновна",
      "Главный бухгалтер", "9151234567",
      "21", "Паспорт гражданина Российской Федерации",
      "7701123456", LocalDate.parse("2000-02-01"),
      "Российская Федерация", "643", true, 10001);
  public static final UserTO USER_TO_2 = new UserTO(USER_ID2,
      "Алексей", "Попович", "Даниилович",
      "Коммерческий директор", "9151231111",
      "21", "Паспорт гражданина Российской Федерации",
      "7701123111", LocalDate.parse("2000-02-03"),
      "Российская Федерация", "643", true, 10002);
  public static final UserTO USER_TO_3 = new UserTO(USER_ID3,
      "Александр", "Македонский", "Александрович",
      "Курьер", "9157654321",
      "21", "Паспорт гражданина Российской Федерации",
      "7785123321", LocalDate.parse("2000-02-03"),
      "Российская Федерация", "643", true, 10000);
  public static final UserTO USER_TO_4 = new UserTO(USER_ID4,
      "Борис", "Борисенко", "Борисович",
      "Генеральный директор", "9251112233",
      "21", "Паспорт гражданина Российской Федерации",
      "7785123333", LocalDate.parse("2005-02-28"),
      "Российская Федерация", "643", true, 10003);
  public static final UserTO USER_TO_5 = new UserTO(USER_ID5,
      "Богдан", "Борисенко", "Борисович",
      "Заместитель генерального директора", "9251112244",
      "21", "Паспорт гражданина Российской Федерации",
      "7785123344", LocalDate.parse("2005-03-01"),
      "Российская Федерация", "643", true, 10003);
  public static final UserTO USER_TO_6 = new UserTO(USER_ID6,
      "Белла", "Бунина", "Борисовна",
      "Коммерческий директор", "9251112255",
      "21", "Паспорт гражданина Российской Федерации",
      "7785443344", LocalDate.parse("2005-10-01"),
      "Российская Федерация", "643", true, 10003);
  public static final UserTO USER_TO_7 = new UserTO(USER_ID7,
      "Валерий", "Леонтьев", "Валерьевич",
      "Генеральный директор", "9057778899",
      "21", "Паспорт гражданина Российской Федерации",
      "6565111222", LocalDate.parse("1998-02-01"),
      "Российская Федерация", "643", true, 10004);
  public static final UserTO USER_TO_8 = new UserTO(USER_ID8,
      "Велемир", "Хмарин", "Перунович",
      "Менеджер", "9030303123",
      "21", "Паспорт гражданина Российской Федерации",
      "3030222333", LocalDate.parse("2015-12-01"),
      "Российская Федерация", "643", true, 10004);
  public static final UserTO USER_TO_9 = new UserTO(USER_ID9,
      "Галина", "Домовой", "Георгиевна",
      "Генеральный директор", "9115556677",
      "21", "Паспорт гражданина Российской Федерации",
      "2323101010", LocalDate.parse("2010-10-10"),
      "Российская Федерация", "643", true, 10005);
  public static final UserTO USER_TO_10 = new UserTO(USER_ID10,
      "Глеб", "Васильев", "Васильевич",
      "Продавец-консультант", "9138889900",
      "21", "Паспорт гражданина Российской Федерации",
      "2323101101", LocalDate.parse("2012-12-15"),
      "Российская Федерация", "643", true, 10005);

  public static UserTO getCreated() {
    return new UserTO(null, "Иван", "Новиков", "Иванович",
        "PR-менеджер", "9090909090",
        "21", "Паспорт гражданина Российской Федерации",
        "2323202202", LocalDate.parse("2012-06-11"),
        null, "643", true, 10005);
  }

  public static UserTO getCreatedWithNulls() {
    return new UserTO(null, "Иван", "Новиков", null,
        "PR-менеджер", "9090909090",
        null, "Паспорт гражданина Российской Федерации",
        "2323303303", LocalDate.parse("2012-06-11"),
        null, null, null, 10005);
  }

}
