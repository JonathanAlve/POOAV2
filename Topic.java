import java.util.ArrayList;
import java.util.List;

public class Topic {
    private List<Passageiro> preferenciais;
    private List<Passageiro> normais;
    private int capacidade;
    private int qtdPreferenciais;

    public Topic(int capacidade, int qntPreferenciais) {
    this.capacidade = capacidade;
    this.qtdPreferenciais = qntPreferenciais;
    this.normais = new ArrayList<>();
    this.preferenciais = new ArrayList<>();
    }

    public boolean subir(Passageiro passageiro){
        for (Passageiro p : preferenciais) {
            if (p.getId().equals(passageiro.getId())) {
                return false;
            }
        }
        for (Passageiro p : normais) {
            if (p.getId().equals(passageiro.getId())) {
                return false;
            }
        }
        if (passageiro.isPreferencial()) {
            if(preferenciais.size() < qtdPreferenciais){
                preferenciais.add(passageiro);
                return true;
        }}else if ((normais.size() + preferenciais.size()) < capacidade) {
            normais.add(passageiro);
            return true;
        }return false;
    }

    public boolean descer(String nome){
        for (Passageiro p : preferenciais){
            if(p.getId().equals(nome)){
                preferenciais.remove(p);
                return true;
            }}
        for (Passageiro p : normais){
            if(p.getId().equals(nome)){
                normais.remove(p);
                return true;
            }
        }return false;
    }
        @Override
        public String toString() {
            String resultado = "";

            for (int i = 0; i < qtdPreferenciais; i++) {
                if (i < preferenciais.size()) {
                    resultado += "@" + preferenciais.get(i).getId() + " ";
                } else {
                    resultado += "@ ";
                }
            }

            for (int i = 0; i < (capacidade - qtdPreferenciais); i++) {
                if (i < normais.size()) {
                    resultado += "=" + normais.get(i).getId() + " ";
                } else {
                    resultado += "= ";
                }
            }
            return resultado;
        }

        public boolean isTopicCheia(){
            if(normais.size() + preferenciais.size() >= capacidade){
                return true;
            }else{
                return false;
        }
    }
}
