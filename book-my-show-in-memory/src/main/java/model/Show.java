package model;

import lombok.Data;

@Data
public class Show {
    int id;
    int theaterId;
    int screenId;

    int movieId;
    int duration;

    int startTime;
    int endTime;

}
