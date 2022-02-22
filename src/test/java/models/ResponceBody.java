package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponceBody<T> {
    boolean status;
    T result;
}
