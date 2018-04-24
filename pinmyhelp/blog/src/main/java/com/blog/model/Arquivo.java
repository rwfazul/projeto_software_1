package com.blog.model;
// Generated 14/04/2018 22:35:48 by Hibernate Tools 4.3.1

import com.blog.model.data.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Arquivo generated by hbm2java
 */
@Entity(name="Arquivo")
@Table(name="arquivo" ,catalog="blog")
public class Arquivo  extends Model {

    private Post post;
    private String nome;
    private String descr;

    public Arquivo() {
        super();
    }

    public Arquivo(Post post, String nome) {
        super();
        this.post = post;
        this.nome = nome;
    }
    
    public Arquivo(Post post, String nome, String descr) {
       super();
       this.post = post;
       this.nome = nome;
       this.descr = descr;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    public Post getPost() {
        return this.post;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }

    
    @Column(name="nome", nullable=false, length=20)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="descr")
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }


}


