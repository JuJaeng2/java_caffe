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
@Table(name = "jSit")
public class Sit {

    @Id
    @Column(name = "s_id")
    private Integer sitId;

    @Column(name = "s_use")
    private Integer sitUse;

    @Column(name = "s_name")
    private String sitName;
}
