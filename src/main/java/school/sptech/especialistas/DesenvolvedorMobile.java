package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {
    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;

    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora) {
        super(nome, qtdHoras, valorHora);
    }

    public DesenvolvedorMobile() {
    }

    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora, String plataforma, Integer horasPrototipacao, String linguagem) {
        super(nome, qtdHoras, valorHora);
        this.plataforma = plataforma;
        this.horasPrototipacao = horasPrototipacao;
        this.linguagem = linguagem;
    }

    public DesenvolvedorMobile(String plataforma, Integer horasPrototipacao, String linguagem) {
        this.plataforma = plataforma;
        this.horasPrototipacao = horasPrototipacao;
        this.linguagem = linguagem;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + 200*horasPrototipacao;
    }
}
