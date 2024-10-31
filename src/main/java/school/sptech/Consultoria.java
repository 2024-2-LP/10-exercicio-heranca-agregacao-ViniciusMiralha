package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }


    public Double getTotalSalarios() {
        double totalSalario = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            totalSalario += dev.calcularSalario();
        }
        return totalSalario;
    }


    public Integer qtdDesenvolvedoresMobile() {
        int count = 0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                count++;
            }
        }
        return count;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() >= salario) {
                resultado.add(dev);
            }
        }
        return resultado;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() < menorSalarioDev.calcularSalario()) {
                menorSalarioDev = dev;
            }
        }
        return menorSalarioDev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if ((dev instanceof DesenvolvedorMobile &&
                    ( ((DesenvolvedorMobile) dev).getPlataforma().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorMobile) dev).getLinguagem().equalsIgnoreCase(tecnologia))) ||
                    (dev instanceof DesenvolvedorWeb &&
                            ( ((DesenvolvedorWeb) dev).getFrontend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) dev).getBackend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) dev).getSgbd().equalsIgnoreCase(tecnologia)))) {
                resultado.add(dev);
            }
        }
        return resultado;
    }


    public Double getTotalSalariosPorTecnologia(String tecnologia) {
      double total = 0.0;
      for(Desenvolvedor desenvolvedor : buscarPorTecnologia(tecnologia)){
          total+= desenvolvedor.calcularSalario();
      }
      return total;
    }

}