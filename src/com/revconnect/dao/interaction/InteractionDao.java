package com.revconnect.dao.interaction;

import com.revconnect.model.Interaction;

public interface InteractionDao {

    void save(Interaction interaction);

    boolean existsLike(Long userId, Long postId);
}
