package org.goldfrosch.plugin.constants;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum UserRank {
    RABBIT,
    TURTLE,
    OBSERVER,
    ADMIN;
    private static final Map<String, String> TYPE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(
                    Collectors.toMap(UserRank::name, UserRank::name)));

    public static UserRank of(String type) {
        Optional<String> currentType = Optional.ofNullable(TYPE_MAP.get(type));
        if (currentType.isPresent()) {
            return UserRank.valueOf(TYPE_MAP.get(type));
        }
        return OBSERVER;
    }
}
