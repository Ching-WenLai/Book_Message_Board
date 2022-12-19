package com.example.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "Post")
@Getter
@Setter
public class PostModel implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Uid;

    @Column
    private int id_user;

    @NotNull
    @Column(unique = true)
    @NotBlank(message = "標題不可為空")
    private String title;

    @Column
    private int like_number;

    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date create_time;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference
    private UserModel userModel;
}
