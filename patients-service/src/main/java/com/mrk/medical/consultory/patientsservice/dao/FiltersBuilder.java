package com.mrk.medical.consultory.patientsservice.dao;

import com.mrk.medical.consultory.patientsservice.model.PatientModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class FiltersBuilder {

  private static final String PREFIX = "has";

  public Specification<PatientModel> buildSpecification(Map<String, String> filters,
      Specification<PatientModel> currentSpecification)
      throws InvocationTargetException, IllegalAccessException {
    Method[] methods = PatientSpecification.class.getMethods();
    List<Method> methodsList = Arrays.asList(methods);
    Specification<PatientModel> newSpecification = null;
    Integer counter = 0;
    for (Method method : methodsList) {
      String methodName = method.getName();
      Optional<String> match = filters.keySet()
          .stream()
          .filter(filter -> methodName.equalsIgnoreCase(PREFIX + filter))
          .findFirst();

      if (match.isPresent()) {
        Class[] clazzes = method.getParameterTypes();
        newSpecification = (Specification) method.invoke(new PatientSpecification(),
            transformToParamType(filters.get(match.get()), clazzes[0]));
        filters.remove(match.get());
        if (null == currentSpecification) {
          currentSpecification = newSpecification;
          buildSpecification(filters, newSpecification);
        } else {
          currentSpecification.and(newSpecification);
        }
      }
    }
    return currentSpecification;
  }

  private Object transformToParamType(String inputParam, Class clazz) {
    if (clazz == Long.class) {
      return Long.parseLong(inputParam);
    }
    if (clazz == String.class) {
      return String.valueOf(inputParam);
    }
    if (clazz == LocalDateTime.class){
      LocalDateTime dateTime = LocalDateTime.parse(inputParam, DateTimeFormatter.ISO_DATE_TIME);
      return dateTime;
    }
    return null;
  }
}
