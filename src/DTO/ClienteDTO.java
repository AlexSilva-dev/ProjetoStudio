
package DTO;

/**
 *
 * @author alex
 */
public class ClienteDTO extends PessoaDTO{

    // Atributos
    private Integer idClient;
    private String numCell = null;

    // Métodos especiais
    public ClienteDTO(String nome, String cpf, String numCell) {
        super(nome, cpf);
        this.numCell = numCell;

    }

    public ClienteDTO() {

    }


    @Override
    public String toString() {
        super.toString();
        String status = super.toString();
        status += " " + this.numCell;
        status = Integer.toString(this.idClient) + " " + status;

        return status;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }


    public String getNumCell() {
        return numCell;
    }

    public void setNumCell(String numCell) {
        this.numCell = numCell;
    }

}
