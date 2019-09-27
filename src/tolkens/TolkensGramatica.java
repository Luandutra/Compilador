
package tolkens;


public class TolkensGramatica {
    private String tkNome;
    private String tkLexema;
    private int posicaoLinha;
    private int posicaoColuna;

    
    public  TolkensGramatica(String tkNome,String tkLexema, int posicaoLinha, int posicaoColuna){
        this.tkNome = tkNome;
        this.tkLexema = tkLexema;
        this.posicaoLinha = posicaoLinha;
        this.posicaoColuna = posicaoColuna;
    }

    public String getTkNome() {
        return tkNome;
    }

    public void setTkNome(String tkNome) {
        this.tkNome = tkNome;
    }

    public String getTkLexema() {
        return tkLexema;
    }

    public void setTkLexema(String tkLexema) {
        this.tkLexema = tkLexema;
    }

    public int getPosicaoLinha() {
        return posicaoLinha;
    }

    public void setPosicaoLinha(int posicaoLinha) {
        this.posicaoLinha = posicaoLinha;
    }

    public int getPosicaoColuna() {
        return posicaoColuna;
    }

    public void setPosicaoColuna(int posicaoColuna) {
        this.posicaoColuna = posicaoColuna;
    }
}
