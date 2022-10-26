package com.nantesmatthew.a1902softwaretechexam.common.user.presentation;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;

public interface OnUserSelect {
    void onSelect(User user);
    void onDelete(User user);
}
