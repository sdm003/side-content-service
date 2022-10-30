package ru.test.app.weather.utils.json;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Optional;

/**
 * Кастомный маппинг String к Enum без учета регистра
 */
public class CaseInsensitiveEnumEditor extends PropertyEditorSupport {

    private final Class<? extends Enum> enumType;
    private final String[] enumNames;

    public CaseInsensitiveEnumEditor(Class<?> type) {
        this.enumType = type.asSubclass(Enum.class);
        var values = type.getEnumConstants();
        if (values == null) {
            throw new IllegalArgumentException("Unsupported " + type);
        }
        this.enumNames = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            this.enumNames[i] = ((Enum<?>) values[i]).name();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setAsText(String text) throws IllegalArgumentException {
        Optional.ofNullable(text)
                .filter(StringUtils::isNotEmpty)
                .map(t -> Arrays.stream(enumNames)
                                .filter(n -> n.equalsIgnoreCase(t))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("No enum constant " + enumType.getCanonicalName() + " equals ignore case " + text)))
                .ifPresentOrElse(
                    (n) -> setValue(Enum.valueOf(enumType, n)),
                    () -> setValue(null)
                );
    }

}
