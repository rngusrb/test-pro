package thminiproject.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "AuthorBookList_table")
@Data
public class AuthorBookList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
