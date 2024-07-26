package com.ram0973.booknetwork.feedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
public record FeedbackResponse (
    Double note,
    String comment,
    boolean ownFeedback
) {
}

