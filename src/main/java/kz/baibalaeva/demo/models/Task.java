package kz.baibalaeva.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    Long id;

    String name;

    String description;

    String deadlineDate;

    boolean isCompleted;
}
