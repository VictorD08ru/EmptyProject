package tk.djandjiev.practice.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import tk.djandjiev.practice.to.CountryTO;
import tk.djandjiev.practice.to.DocTypeTO;

/**
 * Данные справочников для тестирования.
 * */
public class CatalogData {

  //Удостоверения личности
  public static final DocTypeTO DOC_TYPE_TO_03 = new DocTypeTO(
      "Свидетельство о рождении", "03");
  public static final DocTypeTO DOC_TYPE_TO_07 = new DocTypeTO(
      "Военный билет", "07");
  public static final DocTypeTO DOC_TYPE_TO_08 = new DocTypeTO(
      "Временное удостоверение, выданное взамен военного билета", "08");
  public static final DocTypeTO DOC_TYPE_TO_10 = new DocTypeTO(
      "Паспорт иностранного гражданина", "10");
  public static final DocTypeTO DOC_TYPE_TO_11 = new DocTypeTO(
      "Св-во о рассмотрении ходатайства о признании "
          + "лица беженцем на территории РФ по существу", "11");
  public static final DocTypeTO DOC_TYPE_TO_12 = new DocTypeTO(
      "Вид на жительство в Российской Федерации", "12");
  public static final DocTypeTO DOC_TYPE_TO_13 = new DocTypeTO(
      "Удостоверение беженца", "13");
  public static final DocTypeTO DOC_TYPE_TO_15 = new DocTypeTO(
      "Разрешение на временное проживание в Российской Федерации", "15");
  public static final DocTypeTO DOC_TYPE_TO_18 = new DocTypeTO(
      "Свидетельство о предоставлении временного убежища на территории Российской Федерации",
      "18");
  public static final DocTypeTO DOC_TYPE_TO_21 = new DocTypeTO(
      "Паспорт гражданина Российской Федерации", "21");
  public static final DocTypeTO DOC_TYPE_TO_23 = new DocTypeTO(
      "Свидетельство о рождении, выданное уполномоченным органом иностранного государства",
      "23");
  public static final DocTypeTO DOC_TYPE_TO_24 = new DocTypeTO(
      "Удостоверение личности военнослужащего Российской Федерации", "24");
  public static final DocTypeTO DOC_TYPE_TO_91 = new DocTypeTO(
      "Иные документы", "91");

  public static final List<DocTypeTO> DOC_TYPE_TO_LIST;

  //Страны
  public static final CountryTO COUNTRY_TO_643 = new CountryTO(
      "Российская Федерация", "643");
  public static final CountryTO COUNTRY_TO_112 = new CountryTO(
      "Республика Беларусь", "112");
  public static final CountryTO COUNTRY_TO_398 = new CountryTO(
      "Республика Казахстан", "398");
  public static final CountryTO COUNTRY_TO_804 = new CountryTO(
      "Украина", "804");
  public static final CountryTO COUNTRY_TO_417 = new CountryTO(
      "Киргизская Республика", "417");
  public static final CountryTO COUNTRY_TO_156 = new CountryTO(
      "Китайская Народная Республика", "156");
  public static final CountryTO COUNTRY_TO_428 = new CountryTO(
      "Латвийская Республика", "428");
  public static final CountryTO COUNTRY_TO_440 = new CountryTO(
      "Литовская Республика", "440");
  public static final CountryTO COUNTRY_TO_642 = new CountryTO(
      "Румыния", "642");
  public static final CountryTO COUNTRY_TO_616 = new CountryTO(
      "Республика Польша", "616");
  public static final CountryTO COUNTRY_TO_620 = new CountryTO(
      "Португальская Республика", "620");

  public static final List<CountryTO> COUNTRY_TO_LIST;

  static {
    DOC_TYPE_TO_LIST = Arrays.asList(DOC_TYPE_TO_03, DOC_TYPE_TO_07, DOC_TYPE_TO_08, DOC_TYPE_TO_10,
        DOC_TYPE_TO_11, DOC_TYPE_TO_12, DOC_TYPE_TO_13, DOC_TYPE_TO_15, DOC_TYPE_TO_18,
        DOC_TYPE_TO_21, DOC_TYPE_TO_23, DOC_TYPE_TO_24, DOC_TYPE_TO_91);

    COUNTRY_TO_LIST = Arrays.asList(COUNTRY_TO_643, COUNTRY_TO_112, COUNTRY_TO_398, COUNTRY_TO_804,
        COUNTRY_TO_417, COUNTRY_TO_156, COUNTRY_TO_428, COUNTRY_TO_440, COUNTRY_TO_642,
        COUNTRY_TO_616, COUNTRY_TO_620);

    COUNTRY_TO_LIST.sort(Comparator.comparing(CountryTO::getCode));
  }
}
