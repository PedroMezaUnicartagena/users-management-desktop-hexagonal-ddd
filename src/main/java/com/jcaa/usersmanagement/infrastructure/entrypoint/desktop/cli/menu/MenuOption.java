package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.menu;

import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuOption {

  LIST_USERS(1, "List all users"),
  FIND_USER(2, "Find user by ID"),
  CREATE_USER(3, "Create user"),
  UPDATE_USER(4, "Update user"),
  DELETE_USER(5, "Delete user"),
  LOGIN(6, "Login"),
  LIST_PRACTICES(7,  "List all practices"),
  FIND_PRACTICE(8,   "Find practice by ID"),
  CREATE_PRACTICE(9, "Create practice"),
  UPDATE_PRACTICE(10, "Update practice"),
  DELETE_PRACTICE(11, "Delete practice"),
  EXIT(0, "Exit");

  private final int number;
  private final String description;

  public static Optional<MenuOption> fromNumber(final int number) {
    for (final MenuOption option : values()) {
      if (option.number == number) {
        return Optional.of(option);
      }
    }
    return Optional.empty();
  }
}

