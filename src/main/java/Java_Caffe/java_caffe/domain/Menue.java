package Java_Caffe.java_caffe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "jMenue")
public class Menue {

    @Id
    @Column(name = "m_id")
    private Integer menueId;

    @Column(name = "m_name")
    private String menueName;

    @Column(name = "m_category")
    private String menueCategory;

}
