package sori.prt.aorb.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.rest.core.annotation.RestResource;
import sori.prt.aorb.domain.enums.ItemType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="post")
@NoArgsConstructor
@Getter
@Setter
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private String title;

    private String itemA;

    private String itemB;

    private ItemType itemType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private Set<Tag> tags;

    @Formula("(select count(1) from comment c where c.post_id = id)")
    private int totalCommentCount;

    @Formula("(select count(1) from item_vote pv where pv.select_item = 2 and pv.post_id = id )")
    private int totalItemAVoteCount;

    @Formula("(select count(1) from item_vote pv where pv.select_item = 1 and pv.post_id = id )")
    private int totalItemBVoteCount;

}
