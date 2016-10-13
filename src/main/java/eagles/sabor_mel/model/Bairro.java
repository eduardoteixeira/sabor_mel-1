
package eagles.sabor_mel.model;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Table
public class Bairro implements Serializable{
    @Id
    @Column
    @GeneratedValue
    private Long idBairro;
    
    @Column
    private String nome;
    
    @OneToMany(
       mappedBy = "bairro", 
       targetEntity = Endereco.class, 
       fetch = FetchType.LAZY, 
       cascade = CascadeType.ALL)
    private final List<Endereco> enderecos = new ArrayList<Endereco>();
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade", nullable = false)
    private Cidade cidade;
    
    public Bairro(){}
    
    public Bairro(String nome, Cidade cidade){
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Endereco> getEEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }
}
