public class Destino {

    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private Double avaliacaoMedia;
    private Integer numeroAvaliacoes;

    public Destino(Long id, String nome, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.avaliacaoMedia = 0.0;
        this.numeroAvaliacoes = 0;
    }

    public void adicionarAvaliacao(int nota) {
        this.numeroAvaliacoes++;
        this.avaliacaoMedia = ((this.avaliacaoMedia * (this.numeroAvaliacoes - 1)) + nota) / this.numeroAvaliacoes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(Double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public Integer getNumeroAvaliacoes() {
        return numeroAvaliacoes;
    }

    public void setNumeroAvaliacoes(Integer numeroAvaliacoes) {
        this.numeroAvaliacoes = numeroAvaliacoes;
    }
}
