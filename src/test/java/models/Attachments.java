package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attachments {
    int size;
    String mime;
    String filename;
    String url;
}
