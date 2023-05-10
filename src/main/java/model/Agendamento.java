package model;

import java.util.Objects;

/**
 *
 * 
 */
public class Agendamento implements java.io.Serializable{
    private static long serialVersionUID = 1L;

    protected String Nome;
    protected String Descricao;
    protected String Horario;
    protected int IDAgendamento;
    protected String Data;
    protected String Estado;
    protected String Prioridade;
    protected String Tipo;
    

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Email

    /**
     * @return the idade
  
    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the Horario
     */
    public String getHorario() {
        return Horario;
    }

    /**
     * @param Horario the Horario to set
     */
    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    /**
     * @return the IDAgendamento
     */
    public int getIDAgendamento() {
        return IDAgendamento;
    }

    /**
     * @param IDAgendamento the IDAgendamento to set
     */
    public void setIDAgendamento(int IDAgendamento) {
        this.IDAgendamento = IDAgendamento;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Prioridade
     */
    public String getPrioridade() {
        return Prioridade;
    }

    /**
     * @param Prioridade the Prioridade to set
     */
    public void setPrioridade(String Prioridade) {
        this.Prioridade = Prioridade;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the IDCliente
     */

    public Agendamento() {
        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento obj = (Agendamento) o;
        return Objects.equals(IDAgendamento, obj.IDAgendamento) &&
            Objects.equals(Tipo, obj.Tipo) &&
            Objects.equals(Nome, obj.Nome) &&
            Objects.equals(Data, obj.Data) &&
            Objects.equals(Horario, obj.Horario) &&
            Objects.equals(Prioridade, obj.Prioridade) &&
            Objects.equals(Estado, obj.Estado) &&
            Objects.equals(Descricao, obj.Descricao);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Nome);
        hash = 23 * hash + Objects.hashCode(this.Descricao);
        hash = 23 * hash + Objects.hashCode(this.Horario);
        hash = 23 * hash + this.IDAgendamento;
        hash = 23 * hash + Objects.hashCode(this.Data);
        hash = 23 * hash + Objects.hashCode(this.Estado);
        hash = 23 * hash + Objects.hashCode(this.Prioridade);
        hash = 23 * hash + Objects.hashCode(this.Tipo);
        return hash;
    }
}
