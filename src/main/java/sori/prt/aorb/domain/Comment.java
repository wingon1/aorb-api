package sori.prt.aorb.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sori.prt.aorb.domain.enums.ItemType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
@NoArgsConstructor
@Getter
@Setter
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private Long accountId;

    private String contents;

}
