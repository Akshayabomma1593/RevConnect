package com.revconnect.service.interaction;

import com.revconnect.dao.interaction.InteractionDao;
import com.revconnect.dao.interaction.InteractionDaoImpl;
import com.revconnect.model.Interaction;
import com.revconnect.model.InteractionType;

public class InteractionServiceImpl implements InteractionService {

    private final InteractionDao interactionDao = new InteractionDaoImpl();

    @Override
    public void likePost(Long userId, Long postId) {

        if (interactionDao.existsLike(userId, postId)) {
            return;
        }

        Interaction interaction = new Interaction();
        interaction.setUserId(userId);
        interaction.setPostId(postId);
        interaction.setType(InteractionType.LIKE);

        interactionDao.save(interaction);
    }

    @Override
    public void commentPost(Long userId, Long postId, String comment) {

        Interaction interaction = new Interaction();
        interaction.setUserId(userId);
        interaction.setPostId(postId);
        interaction.setType(InteractionType.COMMENT);
        interaction.setComment(comment);

        interactionDao.save(interaction);
    }
}
