package com.revconnect.dao;

import com.revconnect.model.Interaction;
import com.revconnect.model.PostAnalytics;

public interface InteractionDao {

    void saveInteraction(Interaction interaction);

    PostAnalytics getPostAnalytics(int postId);
}
