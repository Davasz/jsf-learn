package erp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;

    @Column(nullable = false, length = 18)
    private String cnpj;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao")
    private Date dataFundacao;

    @ManyToOne
    @JoinColumn(name = "ramo_atividade", nullable = false)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_empresa", length = 30)
    private TipoEmpresa tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                '}';
    }
}
