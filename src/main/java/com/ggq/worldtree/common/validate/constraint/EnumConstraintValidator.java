package com.ggq.worldtree.common.validate.constraint;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ggq.worldtree.common.validate.annotation.EnumValid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumConstraintValidator implements ConstraintValidator<EnumValid, Object>{

	private List<Object> values = new ArrayList<>();
	
	@Override
	public void initialize(EnumValid enumValidator) {
		Class<?> clz = enumValidator.target();
        Object[] objects = clz.getEnumConstants();
        try {
            Method method = clz.getMethod("getValue");
            if (Objects.isNull(method)) {
                throw new Exception(String.format("枚举对象%s缺少字段名为value的字段",
                    clz.getName()));
            }
            Object value = null;
            for (Object obj : objects) {
                value = method.invoke(obj);
                values.add(value);
            }
        } catch (Exception e) {
            log.error("[处理枚举校验异常]", e);
        }
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		return Objects.isNull(value) || values.contains(value) ? true : false;
	}

}
