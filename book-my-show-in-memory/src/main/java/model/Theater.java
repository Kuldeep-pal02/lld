package model;

import lombok.Data;

import java.util.List;

@Data
public class Theater {
    int id;
    int location;
    String cityId;
    List<Screen> screenList;

}
