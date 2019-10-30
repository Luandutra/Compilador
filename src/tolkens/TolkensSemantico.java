
package tolkens;


public class TolkensSemantico {
    private String tolkensVariaveis;
    private String tkVar;

    public TolkensSemantico (String tolkensSemantico, String tkVar){
        this.tolkensVariaveis = tolkensSemantico;
        this.tkVar = tkVar;
    }
    
    public String getTolkensVariaveis() {
        return tolkensVariaveis;
    }

    public void setTolkensVariaveis(String tolkensVariaveis) {
        this.tolkensVariaveis = tolkensVariaveis;
    }

    public String getTkVar() {
        return tkVar;
    }

    public void setTkVar(String tkVar) {
        this.tkVar = tkVar;
    }
    
    
    
}
